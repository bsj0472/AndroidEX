package com.mrhi2020.ex66locationtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //LBS(Location Base Service :위치기반서비스)

    //위치정보를 관리하는 관리자 객체
    LocationManager locationManager;

    TextView tvBestProvider;
    TextView tvMyLocation;
    TextView tvAutoMyLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBestProvider = findViewById(R.id.tv_best);
        tvMyLocation = findViewById(R.id.tv_mylocation);
        tvAutoMyLocation= findViewById(R.id.tv_automylocation);

        //위치정보 관리자 소환
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //디바이스에서 위치정보를 제공하고 장치 여러개
        //이런것들을 위치정보 제공자(Location Provider) 라고 부름
        // 1. gps(인공위성) : 가장정확도 높음, 무료, 실내불가, 베터리소모량 높음
        // 2. network(wify, 3g, lte) : 중간 정확도, 유료or무료, 어디서나 가능, 베터리소모량 중간
        // 3. passive : 다른 앱의 마지막 위치정보를 통해서 위치 얻어오는 방식, 정확도 가장 낮음, 사용빈도 거의 없음.

        //위치정보 제공자 중에 최고의 제공자 판별요청
        //최고자의 제공자를 판별하기 위한 기준(criteria) 객체
        Criteria criteria = new Criteria();
        criteria.setCostAllowed(true); //비용지불을 감수할지 여부
        criteria.setAccuracy(Criteria.NO_REQUIREMENT);//정확도를 요하는가?
        criteria.setPowerRequirement(Criteria.NO_REQUIREMENT);//베터리 소모량
        criteria.setAltitudeRequired(true);//고도에 대한 위치정보 필요한가?

        String bestProvider = locationManager.getBestProvider(criteria, true);
        tvBestProvider.setText(bestProvider);
        //베스트 프로바이터 정보를 얻으려면 위치정보사용에 대한 허가(permission) 받아야 함.

        //단, 위치정보제공에 대한 퍼미션은 동적 퍼미션 : 앱을 설치할때 사용자 동의를 얻는 것이 아니라 사용할 때 동의를 구하는 방식
        //마시멜로우(api23버전)부터 동적퍼미션 필요
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //퍼미션을 받았는지 확인
            int checkResult = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
            if (checkResult == PackageManager.PERMISSION_DENIED) {//거절되어있는가?
                //사용자에게 퍼미션 허용하도록 할 수 있는 다이얼로그 화면을 보여주기!
                // 단, 이 다이얼로그는 개발자가 만드는 것이 아니고 이미 이 모양이 다
                // 설계되어 있는 새로운 액티비티(다이얼로그 모양을 가진)를 보여주면 됨.
                // 액티비티클래스에 이 퍼미션요청 다이얼로그를 보여주도록 요청하는 메소드가 존재함
                String[] permissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
                requestPermissions(permissions, 0);
            }
        }

    }//onCreate method..

    //requestPermissions()를 통해 보여진 다이얼로그의 선택이 완료되면 자동으로 실행되는 메소드
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 0:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "위치정보제공에 동의하셨습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "위치정보 사용 불가", Toast.LENGTH_SHORT).show();
                    finish();//앱을 종료
                }
                break;
        }
    }

    public void clickBtn(View view) {

        //명시적으로 퍼미션 체크...안되어 있다면 아래 작업을 하지마!!!
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        //현재 내 위치 얻어오기
        Location location = null;

        if (locationManager.isProviderEnabled("gps")) {
            location = locationManager.getLastKnownLocation("gps");
        }else if(locationManager.isProviderEnabled("network")){
            location = locationManager.getLastKnownLocation("network");
        }

        if(location==null){
            tvMyLocation.setText("내 위치 못 찾겠어!!");
        }else{
            //위도, 경도 얻어오기
            double latitude= location.getLatitude();
            double longitude= location.getLongitude();

            tvMyLocation.setText(latitude+" , "+longitude);
        }

    }


    public void clickBtn2(View view) {
        //명시적으로 퍼미션 체크...안되어 있다면 아래 작업을 하지마!!!
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        //내 위치 실시간 얻기
        if(locationManager.isProviderEnabled("gps")){
            locationManager.requestLocationUpdates("gps", 5000, 2, locationListener);
        }else if(locationManager.isProviderEnabled("network")){
            locationManager.requestLocationUpdates("network", 5000, 2, locationListener);
        }
    }

    // 반경에 들어가 적이 있는가?
    boolean wasEnter= false;

    //멤버변수 영역에 위치정보 갱신을 듣는 리스너
    LocationListener locationListener= new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {

            double latitude= location.getLatitude();
            double longitude= location.getLongitude();

            tvAutoMyLocation.setText(latitude+" , "+ longitude);

            //특정 지점에 들어갔을 때 이벤트 발생 /////
            // 왕십리역 좌표 : 37.5612919,127.0375806

            // 내 위치(lat, lng)와 왕십리역 사이의 실제거리(m)
            float[] result= new float[3]; //거리계산 결과를 저장할 배열객체
            Location.distanceBetween(latitude, longitude, 37.5612919, 127.0375806, result);

            //result[0]에 두 좌표사이의 m거리가 계산되어 저장되어 있음.
            if(result[0]<50){ //두 좌표 사이 거리가 50m 이내인가?
                //이벤트를 알리는 다이얼로그 보이기
                if(wasEnter==false){
                    new AlertDialog.Builder(MainActivity.this).setMessage("축하합니다. 이벤트 달성!!").setPositiveButton("OK", null).create().show();
                    wasEnter= true;
                }
            }else{
                wasEnter= false;
            }


        }
    };

    public void clickBtn3(View view) {
        //내 위치 자동 갱신 제거
        locationManager.removeUpdates(locationListener);
    }
}//MainActivity class...