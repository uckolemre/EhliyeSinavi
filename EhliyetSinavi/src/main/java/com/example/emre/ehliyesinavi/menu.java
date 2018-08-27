package com.example.emre.ehliyesinavi;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {

    private Button[] buttons=new Button[50];
    private int temp=0;
    private Button sonButton;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        int resId=0;

        // Geri ActionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        sonButton=(Button)findViewById(R.id.sonuclandırButton);


        for (int i=0; i<50; i++)
        {
            temp=i+1;
            try {
                resId =R.id.class.getField("s_"+temp).getInt(null);
                buttons[i]=(Button)findViewById(resId);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

         String temp=null;
        for(int i=0; i<50; i++)
        {

            if(Questions.isaretlenenler[i]!=null)
            {

              //  buttons[i].setBackgroundColor(getResources().getColor(R.color.sarı));

                buttons[i].setBackground(getResources().getDrawable(R.drawable.menu_secilen_soru));


            }
            else{

                buttons[i].setBackground(getResources().getDrawable(R.drawable.menu_bos_soru));


            }

        }

        for(int i=0; i<50; i++)
        {

            final int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent=new Intent(getApplicationContext(),Questions.class);
                    Questions.count=Integer.parseInt(buttons[finalI].getText().toString());
                    startActivity(intent);
                    finish();

                }
            });
        }

        sonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),dogruYanlis.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home )
        {
            Intent ıntent= new Intent(getApplicationContext(),Questions.class);
            startActivity(ıntent);

        }
        return super.onOptionsItemSelected(item);
    }



}
