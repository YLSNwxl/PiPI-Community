package com.example.ylsn.unimportant;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ylsn.unimportant.bean.MessageBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vide0Activity extends AppCompatActivity {
    private List<MessageBean> txList = new ArrayList<>();//一个全局的链表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        initTxs();//下面的初始化方法
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyceler);//找到RecyclerView控件
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//布局管理器
        recyclerView.setLayoutManager(layoutManager);
        MessageBeanAdapter adapter = new MessageBeanAdapter(txList);//适配器对象
        recyclerView.setAdapter(adapter);//设置适配器为上面的对象
    }

    private void initTxs() {
        //初始化方法，为了能够创造出具体的子项
        for (int x = 0; x < 12; x++) {
            //嫌少？多来几次循环
            Random hh=new Random();
            int f=hh.nextInt(4)+51;
            MessageBean a = new MessageBean("file:///android_asset/hah9.html","http:/118.89.236.56:5000/api/Uploadvideo/file?Vid="+f);
            txList.add(a);//加入到链表

        }
    }
}
