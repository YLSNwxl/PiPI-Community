package com.example.ylsn.unimportant;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

public class RegistActivity extends AppCompatActivity {
   private Button regist;
   private Button back;
    private char result;
    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch(msg.what){
                case 0:
                    if (result == '1') {
                        String str0 = "注册成功！";
                        showDialog(str0);

                    } else {
                        String str1 = "该账号已经被注册！";
                        showDialog(str1);
                    }
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        back=(Button)findViewById(R.id.button_login);
        regist=(Button)findViewById(R.id.button_register);
    }
    public void onClick(View view){
        if(view==back){
            Intent login_to_main = new Intent(RegistActivity.this, LoginActivity.class);
            startActivity(login_to_main);
        }
        if(view==regist){
            userRegister();
        }
    }
    public boolean userRegister() {
        new Thread() {
            public void run() {
                try {
                    EditText accout = (EditText) findViewById(R.id.et_username);
                    EditText pwd = (EditText) findViewById(R.id.et_password);
                    EditText email = (EditText) findViewById(R.id.et_email);
                    String Userid = accout.getText().toString();
                    String Userpwd = pwd.getText().toString();
                    String Nickname = email.getText().toString();
                    BufferedReader reader = null;
                    JSONObject userJSON = new JSONObject();
                    userJSON.put("userid",Userid );
                    userJSON.put("userpwd", Userpwd);
                    userJSON.put("nickname", Nickname);
                    String content = String.valueOf(userJSON);
                    String url = "http://118.89.236.56:5000/api/Users/Create";
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
