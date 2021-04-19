package com.mrhi2020.ex94webapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv= findViewById(R.id.wv);

        //기본적으로 WebView는 Javascript 실행을 허용하지 않음.
        //웹뷰 설정객체를 통해 JS사용을 허용하도록 변경설정
        WebSettings settings= wv.getSettings();
        settings.setJavaScriptEnabled(true);

        //필수 설정값 2가지 더
        //1. 새로운 웹문서가 열릴때 기존 웹뷰가 아니라 새로운 웹뷰에서
        //열리도록 기본 설정되어 있음. <a>연결할 때 에어발생
        //그래서 현재 웹뷰에 페이지가 로드되도록 설정
        wv.setWebViewClient( new WebViewClient() );

        //2. alert(), comfirm() 와 같은 팝업기능 사용하도록..
        wv.setWebChromeClient( new WebChromeClient() );



        //웹뷰가 보여줄 웹문서(.html) 로드하기
        //웹앱 또는 하이브리드 앱은 네이티브앱처럼 오프라인상태에서도
        //동작해야 하는 경우가 많아 html문서를 프로젝트안에 위치시킴
        wv.loadUrl("file:///android_asset/index.html");
    }
}