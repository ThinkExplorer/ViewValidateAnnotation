package com.example.administrator.viewvalidateannotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import validate.ContentMatch;
import validate.TextRequired;
import validate.TextLength;
import validate.ValidationCallbackListener;
import validate.ValidationType;
import validate.ValidationUtil;

public class MainActivity extends AppCompatActivity implements ValidationCallbackListener,View.OnClickListener {

    @TextRequired(sequence = 1,error_text = "密码不能为空")
    @TextLength(min_length = 6,max_length = 15,error_text = "输入的密码长度不符合要求，应是6-15个字符之间")
    @ContentMatch(compare_target_id = R.id.et_confirm_password,compare_error_text = "密码与确认密码不一致")
    private EditText et_password;

    @TextRequired(sequence = 0,error_text = "用户名不能为空!")
    private EditText et_username;

    @TextRequired(sequence = 2,error_text = "确认密码不能为空")
    private EditText et_confirm_password;

    @TextRequired(sequence = 3,error_text = "电话号码不能为空")
    @ContentMatch(text_regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9])|(16[6]))\\d{8}$",match_error_text = "输入的号码格式不正确!")
    private EditText et_phone;

    private Button btn_login;
    private ValidationUtil validationUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        validationUtil = new ValidationUtil(this);
    }

    private void initUI(){
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_confirm_password = findViewById(R.id.et_confirm_password);
        et_phone = findViewById(R.id.et_phone);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_login:
                validationUtil.doValidate();
                break;
        }
    }

    @Override
    public void success() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failed(ValidationType type, String text, View target) {
        switch (type){
            case NotEmpty:
                Toast.makeText(this,"非空验证:"+text,Toast.LENGTH_SHORT).show();
                break;
            case TextLength:
                Toast.makeText(this,"长度限制:"+text,Toast.LENGTH_SHORT).show();
                break;
            case ContentMatch:
                Toast.makeText(this,"内容验证:"+text,Toast.LENGTH_SHORT).show();
                break;
            case InitialAnalyse:
                Toast.makeText(this,"表单验证框架初始化异常，请检查配置。:"+text,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
