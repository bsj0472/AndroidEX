package com.mrhi2020.test7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Uri> uris= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {
        //Intent intent= new Intent(Intent.ACTION_PICK);
        Intent intent= new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==10 && resultCode==RESULT_OK){
            ClipData clipData= data.getClipData();
            if(clipData !=null ){
                int count= clipData.getItemCount();
                Toast.makeText(this, ""+count, Toast.LENGTH_SHORT).show();

                for(int i=0; i<count; i++){
                    ClipData.Item item= clipData.getItemAt(i);
                    Uri uri= item.getUri();
                    uris.add(uri);               

                }


            }
        }
    }
}