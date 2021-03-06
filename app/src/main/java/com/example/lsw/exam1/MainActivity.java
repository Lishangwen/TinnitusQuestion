package com.example.lsw.exam1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String DB_PATH="/data/data/com.example.lsw.exam1/databases/";
        String DB_NAME="tinnitus_question.db";
        if((new File(DB_PATH+DB_NAME).exists())==false)
        {
            File dir=new File(DB_PATH);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            try
            {
                InputStream is = getBaseContext().getAssets().open(DB_NAME);
                OutputStream os=new FileOutputStream(DB_PATH+DB_NAME);
                byte[] buffer=new byte[1024];
                int length;
                while((length=is.read(buffer))>0)
                {
                    os.write(buffer,0,length);

                }
                os.flush();
                os.close();
                is.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }


        Button btn_teq=(Button)findViewById(R.id.button_teq);
        Button btn_da=(Button)findViewById(R.id.button_da);
        btn_teq.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent_teq=new Intent(MainActivity.this,TeqActivity.class);
                startActivity(intent_teq);
            }
        });

        btn_da.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_da=new Intent(MainActivity.this,DaActivity.class);
                startActivity(intent_da);
            }
        });
    }


}
