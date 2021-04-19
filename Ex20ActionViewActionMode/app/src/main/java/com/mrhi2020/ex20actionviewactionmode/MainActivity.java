package com.mrhi2020.ex20actionviewactionmode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText actionViewEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);

        //ActionView 를 가지고 있는 MenuItem 객체 참조
        MenuItem item= menu.findItem(R.id.menu_action);
        View v= item.getActionView();
        actionViewEt= v.findViewById(R.id.actionview_et);

        // EditText 의 소프트키패드 중에서
        // 작성 완료버튼(Search모양 버튼)을 클릭하는 것을
        // 듣는 리스너 생성 및 설정
        actionViewEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                //키패드에서 누른 키가 어떤 키인지...를
                //가지고 있는 변수 : 2번째 파라미터값
                if( actionId == EditorInfo.IME_ACTION_SEARCH ){
                    String msg= actionViewEt.getText().toString();
                    Toast.makeText(MainActivity.this, ""+msg, Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });





        return super.onCreateOptionsMenu(menu);
    }

    public void clickBtn(View view) {
        //액션모드 시작하기 : 액션바위치에 메뉴가 보여짐
        this.startActionMode(new ActionMode.Callback() {
            //처음 액션바 위치에 액션모드 메뉴를 만들때 1번 호출됨
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                //액션모드 메뉴를 만드는 방법은 옵션메뉴 만들기와 동일
                mode.getMenuInflater().inflate(R.menu.actionmode, menu);

                //액션모드에 추가로 줄 수 있는 설정들
                mode.setTitle("actionmode");
                mode.setSubtitle("this is actionmode");

                //리턴의 true 여야만 액션모드가 발동함.
                return true;
            }

            //매번 액션모드 메뉴가 발동할 때마다 실행
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            //액션모드의 메뉴아이템을 클릭했을 때...
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (  item.getItemId()  ){
                    case R.id.menu_aa:
                        Toast.makeText(MainActivity.this, "aaa", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu_bb:
                        Toast.makeText(MainActivity.this, "bbb", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu_cc:
                        Toast.makeText(MainActivity.this, "ccc", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }

            //액션모드 메뉴가 종료될때 실행...
            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}