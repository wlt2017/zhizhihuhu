package wlt.fox.zhizhihuhu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.senab.photoview.PhotoViewAttacher;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.ui.base.BasePresentter;
import wlt.fox.zhizhihuhu.ui.base.MVPBaseActivity;

/**
 * Created by wlt on 2016/9/20.
 * E-mail : autumnsassou@163.com
 */
public class PictureActivity extends MVPBaseActivity {

    public static final String IMG_URL = "img_url";
    public static final String IMG_DESC = "img_desc";
    public static final String TRANSIT_PIC = "picture";

    private String img_url;
    private String img_desc;

    @BindView(R.id.iv_meizhi_pic)
    ImageView iv_meizhi_pic;

    @OnClick(R.id.save_img)
    void saveImg() {saveImage();}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        ButterKnife.bind(this);
        parseIntent();
        Glide.with(this).load(img_url).centerCrop().into(iv_meizhi_pic);
        new PhotoViewAttacher(iv_meizhi_pic);
    }

    private void saveImage() {
        Toast.makeText(PictureActivity.this,"保存成功~",Toast.LENGTH_SHORT).show();
    }

    public static Intent newIntent(Context context, String url, String desc){
        Intent intent = new Intent(context,PictureActivity.class);
        intent.putExtra(PictureActivity.IMG_URL,url);
        intent.putExtra(PictureActivity.IMG_DESC,desc);
        return intent;
    }

    private void parseIntent(){
        img_url = getIntent().getStringExtra(IMG_URL);
        img_desc = getIntent().getStringExtra(IMG_DESC);
    }

    @Override
    protected BasePresentter createPresenter() {
        return null;
    }
}
