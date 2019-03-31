package xyy.com.javatestdemo;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private EditText et1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        et1 = (EditText)findViewById(R.id.et1);
        tv1 = (TextView)findViewById(R.id.tv1);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn1:  //跳转到手机百度首页
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent1);
                break;
            case R.id.btn2: //跳转到阿里图片
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this,alibaba.class);
                startActivity(intent2);
                break;
            case R.id.btn3: //点击后在下方输入框中会显示内容
                tv1.setText("欢迎来到腾讯世界");
                tv1.setTextColor(Color.rgb(255,0,0));
                break;
            case R.id.btn4: //点击按钮拉起快手app
                Intent intent3 = getPackageManager().getLaunchIntentForPackage("com.smile.gifmaker");
                if (intent3 != null){
                    intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent3);
                }
                break;
            case R.id.btn5:
                Toast.makeText(MainActivity.this,"您没有安装头条",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn6:
                String text1 = et1.getText().toString();
                Toast.makeText(MainActivity.this,"您输入的用户名为" + text1,Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(Intent.ACTION_VIEW);
                intent4.setData(Uri.parse("https://www.kuaishou.com"));
                startActivity(intent4);
                break;
        }
    }

}
