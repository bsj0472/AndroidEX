package com.mrhi2020.ex17contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= findViewById(R.id.btn);

        // 액티비티에게 btn 객체를 ContextMenu 로 등록!
        registerForContextMenu(btn);
    }

    //ContextMenu 로 등록된 뷰가 롱~클릭되면
    //콘텍스트메뉴를 만드는 메소드가 자동 발동함
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        // res폴더 안에 menu폴더안에 context.xml파일을
        //만들고 이를 메뉴객체로 부풀려서 객체로 만들기
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.context, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //ContextMenu 의 항목아이템을 선택했을때 자동으로
    //발동하는 콜백메소드
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();
        switch (id){
            case R.id.menu_save:
                Toast.makeText(this, "SAVE", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_delete:
                Toast.makeText(this,"DELETE", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    public void clickBtn(View view) {
        Toast.makeText(this,"clicked", Toast.LENGTH_SHORT).show();
    }
}