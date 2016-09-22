package wlt.fox.zhizhihuhu.util.nightmodel;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import wlt.fox.zhizhihuhu.util.nightmodel.attr.Attr;
import wlt.fox.zhizhihuhu.util.nightmodel.attr.AttrView;
import wlt.fox.zhizhihuhu.util.nightmodel.utils.AttrUtils;
import wlt.fox.zhizhihuhu.util.nightmodel.utils.PersistenceUtils;

/**
 * Created by like on 16/7/20.
 */
public class NightModelManager {

    private boolean modelChanged = false;

    private SparseArrayCompat<List<AttrView>> attrViewMaps = new SparseArrayCompat<>();

    private static final Map<String, Constructor<? extends View>> sConstructorMap
            = new ArrayMap<>();
    private final Object[] mConstructorArgs = new Object[2];
    private static final Class<?>[] sConstructorSignature = new Class[]{
            Context.class, AttributeSet.class};

    /**
     * ths method should be called in Application onCreate method
     *
     * @param context
     */
    public void init(Context context) {
        boolean isNightModel = PersistenceUtils.isNightModel(context);
        AppCompatDelegate.setDefaultNightMode(isNightModel ?
                AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
    }

    /**
     * this method should be called in Activity onCreate method,
     * and before method super.onCreate(savedInstanceState);
     *
     * @param activity
     */
    public void attach(AppCompatActivity activity) {

        if (activity.getDelegate() instanceof LayoutInflaterFactory) {
            LayoutInflaterFactory originInflaterFactory = (LayoutInflaterFactory) activity.getDelegate();
            LayoutInflaterFactory proxyInflaterFactory = (LayoutInflaterFactory) Proxy.newProxyInstance(
                    originInflaterFactory.getClass().getClassLoader(),
                    new Class[]{LayoutInflaterFactory.class},
                    new InflaterHandler(originInflaterFactory, activity));

            LayoutInflater layoutInflater = LayoutInflater.from(activity);
            LayoutInflaterCompat.setFactory(layoutInflater, proxyInflaterFactory);
        }
    }

    /**
     * this method should be called in Activity onDestroy method
     * @param activity
     */
    public void detach(AppCompatActivity activity) {
        attrViewMaps.remove(activity.hashCode());
    }

    public boolean isCurrentNightModel(Context context) {
        return PersistenceUtils.isNightModel(context);
    }

    public void applyNightModel(AppCompatActivity activity){
        invokeResources(activity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        activity.getDelegate().applyDayNight();
        applyNewModel();
        PersistenceUtils.setNightModel(activity.getApplicationContext(), true);
    }

    public void applyDayModel(AppCompatActivity activity) {
        invokeResources(activity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        activity.getDelegate().applyDayNight();
        applyNewModel();
        PersistenceUtils.setNightModel(activity.getApplicationContext(), false);
    }

    /**
     * it's used for update StateListDrawable, otherwise StateListDrawable
     * will not be updated.
     *
     * @param activity
     */
    private void invokeResources(AppCompatActivity activity) {
        try {
            Field resources = AppCompatActivity.class.getDeclaredField("mResources");
            resources.setAccessible(true);
            resources.set(activity, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void applyNewModel() {
        modelChanged = true;
        int count = attrViewMaps.size();
        for (int i=0; i<count; i++) {
            List<AttrView> attrViews = attrViewMaps.valueAt(i);
            for (AttrView attrView : attrViews) {
                attrView.apply();
            }
        }
    }

    private static class NightModelManagerHolder {
        static NightModelManager instance = new NightModelManager();
    }

    public static NightModelManager getInstance() {
        return NightModelManagerHolder.instance;
    }

    private class InflaterHandler implements InvocationHandler {
        private LayoutInflaterFactory inflaterFactory;
        private AppCompatActivity activity;

        public InflaterHandler(LayoutInflaterFactory inflaterFactory, AppCompatActivity activity) {
            this.inflaterFactory = inflaterFactory;
            this.activity = activity;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(inflaterFactory, args);
            List<Attr> attrs = AttrUtils.getNightModelAttr(args, activity.getResources());
            if (attrs.isEmpty())
                return result;

            if (result == null) {
                result = createViewFromTag((Context)args[2], (String)args[1], (AttributeSet)args[3]);
            }

            if (attrs.size() > 0) {
                AttrView attrView = new AttrView((View) result, attrs);
                putAttrView(attrView, activity.hashCode());

                // if model changed once, should apply once, otherwise, the View will use old style
                if (result != null && modelChanged) {
                    attrView.apply();
                }
            }

            return result;
        }

        private void putAttrView(AttrView attrView, int hashCode) {
            List<AttrView> attrViews;
            if (attrViewMaps.indexOfKey(hashCode) > -1) {
                attrViews = attrViewMaps.get(hashCode);
            } else {
                attrViews = new ArrayList<>();
            }
            attrViews.add(attrView);
            attrViewMaps.put(hashCode, attrViews);
        }

        private View createViewFromTag(Context context, String name, AttributeSet attrs) {
            if (name.equals("view")) {
                name = attrs.getAttributeValue(null, "class");
            }

            try {
                mConstructorArgs[0] = context;
                mConstructorArgs[1] = attrs;

                if (-1 == name.indexOf('.')) {
                    // try the android.widget prefix first...
                    return createView(context, name, "android.widget.");
                } else {
                    return createView(context, name, null);
                }
            } catch (Exception e) {
                // We do not want to catch these, lets return null and let the actual LayoutInflater
                // try
                return null;
            } finally {
                // Don't retain references on context.
                mConstructorArgs[0] = null;
                mConstructorArgs[1] = null;
            }
        }

        private View createView(Context context, String name, String prefix)
                throws ClassNotFoundException, InflateException {
            Constructor<? extends View> constructor = sConstructorMap.get(name);

            try {
                if (constructor == null) {
                    Class<? extends View> clazz = context.getClassLoader().loadClass(
                            prefix != null ? (prefix + name) : name).asSubclass(View.class);

                    constructor = clazz.getConstructor(sConstructorSignature);
                    sConstructorMap.put(name, constructor);
                }
                constructor.setAccessible(true);
                return constructor.newInstance(mConstructorArgs);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
