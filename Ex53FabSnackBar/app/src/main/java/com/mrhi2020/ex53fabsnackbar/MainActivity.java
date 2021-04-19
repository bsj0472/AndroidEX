package com.mrhi2020.ex53fabsnackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickFAB(View view) {
        //Toast.makeText(this, "fab", Toast.LENGTH_SHORT).show();
        //토스트를 개량한 클래스
        Snackbar snackbar= Snackbar.make(view, "This is Snackbar", BaseTransientBottomBar.LENGTH_INDEFINITE);
        snackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click OK", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }

    public void clickBtn(View view) {
        CoordinatorLayout container= findViewById(R.id.snackbar_container);
        Snackbar.make(container,"Hello android", Snackbar.LENGTH_LONG).show();
    }
}