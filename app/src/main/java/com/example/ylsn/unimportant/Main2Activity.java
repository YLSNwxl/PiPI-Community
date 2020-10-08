package com.example.ylsn.unimportant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends Activity {

    //自定义View
    private CircleMenuLayout mCircleMenuLayout;
    //Item 文本
    private String[] mItemTexts = new String[]{"视频社区","图文社区","文字社区","社区消息","创作发表","个人中心"};
    //Item 图片
    private int[] mItemImgs = new int[]{
            R.drawable.video,
            R.drawable.pic,
            R.drawable.wenzi,
            R.drawable.cm,
            R.drawable.up,
            R.drawable.person
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //自己切换布局文件看效果
        setContentView(R.layout.activity_main2);
        mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs,mItemTexts);

        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                if(pos==4){
                Toast.makeText(Main2Activity.this, mItemTexts[pos], Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main2Activity.this,UpFileActivity.class);
                startActivity(intent);}
                if(pos==0){
                    Toast.makeText(Main2Activity.this, mItemTexts[pos], Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Main2Activity.this,Vide0Activity.class);
                    startActivity(intent);
                }
                if(pos==1){
                    Toast.makeText(Main2Activity.this, mItemTexts[pos], Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Main2Activity.this,UploadActivity.class);
                    startActivity(intent);
                }
                if(pos==2){
                    Toast.makeText(Main2Activity.this, mItemTexts[pos], Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Main2Activity.this,TextActivity.class);
                    startActivity(intent);}
                if(pos==3){
                    Toast.makeText(Main2Activity.this, mItemTexts[pos], Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Main2Activity.this,MessageActivity.class);
                    startActivity(intent);
                }
                if(pos==5){
                    Toast.makeText(Main2Activity.this, mItemTexts[pos], Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Main2Activity.this,PersonActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void itemCenterClick(View view) {
                Toast.makeText(Main2Activity.this, "该功能待实现  ", Toast.LENGTH_LONG).show();
            }
        });
    }
}
