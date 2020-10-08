package com.example.ylsn.unimportant;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.ylsn.unimportant.LoginActivity.userid;

public class PersonActivity extends AppCompatActivity {
    private TextView name;
    private TextView tofile;
    private ImageView img1;
    private ImageView img5;
    private View view1, view2, view3;
    private ViewPager viewPager;  //对应的viewPager

    private List<View> viewList;//view数组
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
       name=(TextView)findViewById(R.id.userName);
        name.setText(userid);
        tofile=(TextView)findViewById(R.id.toFile);
        img1=(ImageView)findViewById(R.id.img1);
        img5=(ImageView)findViewById(R.id.img5);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        LayoutInflater inflater=getLayoutInflater();
        view1 = inflater.inflate(R.layout.page1, null);
        view2 = inflater.inflate(R.layout.page2,null);
        view3 = inflater.inflate(R.layout.page3, null);

        viewList = new ArrayList<>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));


                return viewList.get(position);
            }
        };


        viewPager.setAdapter(pagerAdapter);

    }
    public void onClick(View view) {
        if(view==tofile) {
            Intent intent = new Intent(PersonActivity.this, UpFileActivity.class);
            startActivity(intent);
            Toast.makeText(this, "创作中心", Toast.LENGTH_LONG).show();
        }
        if(view==img1){
            Intent intent=new Intent(PersonActivity.this,MyloveActivity.class);
            startActivity(intent);
            Toast.makeText(this, "我的关注", Toast.LENGTH_LONG).show();
        }
        if(view==img5){
            Intent intent = new Intent(PersonActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "退出登录", Toast.LENGTH_LONG).show();
        }
    }
}
