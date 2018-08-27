package com.example.emre.ehliyesinavi;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Questions extends AppCompatActivity {

    static String[] isaretlenenler=new String[50];
    static boolean[] resinliSoru=new boolean[50];
    static boolean[] resimliCevap=new boolean[50];
    static String sınavTarihi="aralik2016_";
    private AdView adview;

    static int count=1;
    Button next,previous,soruButton;
    TextView soru,a,b,c,d;
    Button aButton,bButton,cButton,dButton;
    TextView soruResim;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);


        // Geri ActionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        next= (Button) findViewById(R.id.sonrakiButton);
        previous=(Button)findViewById(R.id.gerButton);
        soruButton=(Button)findViewById(R.id.soruButton);

        aButton=(Button)findViewById(R.id.A);
        bButton=(Button)findViewById(R.id.B);
        cButton=(Button)findViewById(R.id.C);
        dButton=(Button)findViewById(R.id.D);

        //Reklam
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        if(count==1)
        {
            secileSoru();
            previous.setVisibility(View.GONE);

        }
        SoruYazdırma();
        secileSoru();



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                next.setSelected(true);


                previous.setVisibility(View.VISIBLE);
                count++;
                SoruYazdırma();
                secileSoru();
                if(count==50)
                {
                    next.setVisibility(View.INVISIBLE);
                }

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.VISIBLE);
                count--;
                SoruYazdırma();
                secileSoru();
                if(count==1)
                {
                    previous.setVisibility(View.INVISIBLE);
                }
            }
        });

        soruButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),menu.class);
                startActivity(intent);
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void SoruYazdırma()
    {
        soru= (TextView) findViewById(R.id.soru);
        a= (TextView) findViewById(R.id.Atext);
        b= (TextView) findViewById(R.id.Btext);
        c= (TextView) findViewById(R.id.Ctext);
        d= (TextView) findViewById(R.id.Dtext);
        soruResim=(TextView)findViewById(R.id.soruResim);


        String str=sınavTarihi+count;

        int resId= 0;
        int resId_r=0;
        int resId_a= 0;
        int resId_b= 0;
        int resId_c= 0;
        int resId_d= 0;

        try {
            resId =R.string.class.getField(str).getInt(null);
            soru.setText(getResources().getText(resId));

            soruResim.setBackground(null);
            if(resinliSoru[count-1])
            {
                resId_r=R.mipmap.class.getField(str).getInt(null);
                soruResim.setBackground(getResources().getDrawable(resId_r));
            }
            a.setBackground(null);
            b.setBackground(null);
            c.setBackground(null);
            d.setBackground(null);
            a.setText(null);
            b.setText(null);
            c.setText(null);
            d.setText(null);
            if(resimliCevap[count-1])
            {
                resId_a =R.mipmap.class.getField(str+"_a").getInt(null);
                a.setBackground(getResources().getDrawable(resId_a));
                resId_b =R.mipmap.class.getField(str+"_b").getInt(null);
                b.setBackground(getResources().getDrawable(resId_b));
                resId_c =R.mipmap.class.getField(str+"_c").getInt(null);
                c.setBackground(getResources().getDrawable(resId_c));
                resId_d =R.mipmap.class.getField(str+"_d").getInt(null);
                d.setBackground(getResources().getDrawable(resId_d));
            }
            else{
                resId_a =R.string.class.getField(str+"_a").getInt(null);
                a.setText(getResources().getText(resId_a));
                resId_b =R.string.class.getField(str+"_b").getInt(null);
                b.setText(getResources().getText(resId_b));
                resId_c =R.string.class.getField(str+"_c").getInt(null);
                c.setText(getResources().getText(resId_c));
                resId_d =R.string.class.getField(str+"_d").getInt(null);
                d.setText(getResources().getText(resId_d));
            }


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }




        if(isaretlenenler[count-1]=="A")
        {
            aButton.setBackground(getResources().getDrawable(R.drawable.sari_button));
            bButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            cButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            dButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
        }
        else if(isaretlenenler[count-1]=="B")
        {
            aButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            bButton.setBackground(getResources().getDrawable(R.drawable.sari_button));
            cButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            dButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
        }
        else if(isaretlenenler[count-1]=="C")
        {
            aButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            bButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            cButton.setBackground(getResources().getDrawable(R.drawable.sari_button));
            dButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
        }
        else if(isaretlenenler[count-1]=="D")
        {
            aButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            bButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            cButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            dButton.setBackground(getResources().getDrawable(R.drawable.sari_button));
        }
        else{
            aButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            bButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            cButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            dButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
        }

    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void secileSoru()
    {

        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isaretlenenler[count-1]="A";
                aButton.setBackground(getResources().getDrawable(R.drawable.sari_button));

                    bButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
                    cButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
                    dButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            }
        });

        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bButton.setBackground(getResources().getDrawable(R.drawable.sari_button));
                isaretlenenler[count-1]="B";

                    aButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
                    cButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
                    dButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));

            }
        });

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cButton.setBackground(getResources().getDrawable(R.drawable.sari_button));
                isaretlenenler[count-1]="C";

                    bButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
                    aButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
                    dButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
            }
        });
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dButton.setBackground(getResources().getDrawable(R.drawable.sari_button));
                isaretlenenler[count-1]="D";

                    bButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
                    cButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
                    aButton.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home )
        {
            Intent ıntent= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(ıntent);

        }
        return super.onOptionsItemSelected(item);
    }

}



