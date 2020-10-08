package com.example.ylsn.unimportant;

import android.app.AlertDialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    static public boolean butflag=true;

    static public String userid;
    private String userpwd;
    private Button login;
    private Button regist;
    private char result;
    private boolean tag;
    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch(msg.what){
                case 0:
                    if (result == '1') {

                        Intent login_to_main = new Intent(LoginActivity.this, Main2Activity.class);
                        startActivity(login_to_main);
                    } else {
                        String str1 = "登录失败,请确保账号密码都正确！";
                        showDialog(str1);
                    }
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button)findViewById(R.id.button_login);
        regist=(Button)findViewById(R.id.button_register);
    }
   public void onClick(View view){
       if(view==login) {
           userLogin();
       }
       if(view==regist){
           Intent login_to_register = new Intent(LoginActivity.this, RegistActivity.class);
           startActivity(login_to_register);
       }
   }
    public boolean userLogin() {
        new Thread() {
            public void run() {
                try {
                    EditText Userid0=(EditText)findViewById(R.id.et_username);
                    EditText Userpwd0=(EditText)findViewById(R.id.et_password);
                    userid=Userid0.getText().toString();
                    userpwd=Userpwd0.getText().toString();
                    JSONObject jsonObj=new JSONObject();
                    jsonObj.put("userid",userid);
                    jsonObj.put("userpwd",userpwd);
                    BufferedReader reader = null;
                    String content = String.valueOf(jsonObj);
                    String url = "http://118.89.236.56:5000/api/Users/Login";
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.setUseCaches(false);
                    connection.setRequestProperty("Connection", "Keep-Alive");
                    connection.setRequestProperty("Charset", "UTF-8");
                    // 设置文件类型:
                    connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    OutputStream os = connection.getOutputStream();
                    os.write(content.getBytes());
                    os.flush();
                    os.close();
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    JSONObject obj=new JSONObject(reader.readLine());
                    result=obj.getString("status").charAt(0);
                    handler.sendEmptyMessage(0);
                } catch (
                        Exception e)
                {
                }
            }
        }.start();
        return true;
    }
    private void showDialog(String str){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.people);
        builder.setTitle("温馨提示");
        builder.setMessage(str);
        builder.setPositiveButton("我知道了",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
