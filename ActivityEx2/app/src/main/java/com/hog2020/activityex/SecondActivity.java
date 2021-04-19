package com.hog2020.activityex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText etname;
    EditText etnic;
    EditText ettitle;
    TextView tv;
    EditText ettext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ettext=findViewById(R.id.et_text);
        etname=findViewById(R.id.et_name);
        etnic=findViewById(R.id.et_nic_name);
        ettitle=findViewById(R.id.et_title);

        tv=findViewById(R.id.tv_count);



        ettext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tv.setText(s.length()+"/500");


            }
        });


    }

    public void clickBtn1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("정말 취소 하시겠습니까?");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SecondActivity.this, "확인", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SecondActivity.this, "취소", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog =builder.create();
        alertDialog.show();


    }



    public void clickBtn2(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("저장 하시겠습니까?");
        builder.setPositiveButton("완료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SecondActivity.this, "완료", Toast.LENGTH_SHORT).show();

                String name= etname.getText().toString();
                String nic =etnic.getText().toString();
                String title= ettitle.getText().toString();
                String text=ettext.getText().toString();

                Intent intent =  getIntent();
                intent.putExtra("name",name);
                intent.putExtra("nic",nic);
                intent.putExtra("title",title);
                intent.putExtra("text",text);

                setResult(RESULT_OK,intent);
                finish();
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SecondActivity.this, "취소", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }
}