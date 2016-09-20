package wlt.fox.zhizhihuhu.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.util.LogUtils;

/**
 * Created by wlt on 2016/9/20.
 * E-mail : autumnsassou@163.com
 */
public class WebActivity extends Activity {

    private Activity activity;

    public static final String GANK_URL = "gank_url";

    private String gank_url;

    @BindView(R.id.pb_progress)
    ProgressBar progressBar;
    @BindView(R.id.url_web)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank_web);
        ButterKnife.bind(this);
        activity = this;
        parseIntent();
        setWebView(gank_url);
    }

    public void setWebView(String url){

        LogUtils.d("wan", url);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);// 支持JS
        settings.setBuiltInZoomControls(true);// 显示放大缩小按钮
        settings.setUseWideViewPort(true);// 支持双击放大缩小

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);
                System.out.println("网页开始加载");
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                System.out.println("网页加载结束");
                progressBar.setVisibility(View.GONE);
            }

            /**
             * 所有跳转的链接都在此方法中回调
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                System.out.println("网页title："+title);
                activity.setTitle(title);
                super.onReceivedTitle(view, title);
            }
        });

        webView.loadUrl(url);
    }

    public static Intent newIntent(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(WebActivity.GANK_URL, url);
        return intent;
    }

    /**
     * 得到Intent传递的数据
     */
    private void parseIntent() {
        gank_url = getIntent().getStringExtra(GANK_URL);
    }

}
