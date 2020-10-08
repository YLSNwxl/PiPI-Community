package com.example.ylsn.unimportant.bean;

import com.example.ylsn.unimportant.CommentExpandableListView;

/**
 * Created by YLSN on 2020/9/8.
 */

public class MessageBean {
    private String name;
    private String name1;
    public MessageBean(String name,String name1) {//构造方法，用以赋值
        this.name = name;
        this.name1=name1;
    }

    public String getName() {//获得Name的值
        return name;
    }
    public String getName1() {//获得Name的值
        return name1;
    }
}
