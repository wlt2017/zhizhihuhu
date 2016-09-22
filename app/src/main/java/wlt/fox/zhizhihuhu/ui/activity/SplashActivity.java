package wlt.fox.zhizhihuhu.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.ui.base.BasePresentter;
import wlt.fox.zhizhihuhu.ui.base.MVPBaseActivity;

public class SplashActivity extends MVPBaseActivity {

    //动画持续时间,单位ms
    private static final int AnimTime = 2000;

    @BindView(R.id.iv)
    ImageView iv;

    private Handler mHandler;

    @Override
    protected BasePresentter createPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        startAnimAndGoToMain();
    }

    //开启动画，动画结束跳转到主界面
    private void startAnimAndGoToMain() {
        ScaleAnimation scaleAnimation =
                new ScaleAnimation(1,2,1,2,
                        Animation.RELATIVE_TO_SELF,0.5f,
                        Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(AnimTime);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                goToMainActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        iv.startAnimation(scaleAnimation);
    }

    private void goToMainActivity() {
        finish();
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
