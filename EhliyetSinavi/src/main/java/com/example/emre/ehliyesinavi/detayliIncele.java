package com.example.emre.ehliyesinavi;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class detayliIncele extends AppCompatActivity {

   static String[] cevaplar={"D","C","A","B","A","D","C","B","D","B","A","C","B","C","D","A","A","C"
            ,"B","A","D","C","B","C","D","A","C","B","A","D","C","B","D","B","D","A","B","D","D","C","B"
            ,"C","D","A","C","B","A","D","A","C"};

    private Button[] buttons=new Button[50];
    private int temp=0;
    private  TextView soru,a,b,c,d,soruResim;
    private Button buttonA,buttonB,buttonC,buttonD;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detayli_incele);

        int resId=0;

        // Geri ActionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        //Reklam
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);


        buttons[1]=(Button)findViewById(R.id.s_1);
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

        SoruYazdırma(1);

        int backColor=0;

        for (int i=0; i<50; i++)
        {
            if(Questions.isaretlenenler[i]==cevaplar[i])
            {
                buttons[i].setBackground(getResources().getDrawable(R.drawable.yesil_button));
                buttons[i].setText((i+1)+"\n(DOĞRU)");

            }
            else if(Questions.isaretlenenler[i]==null)
            {
                buttons[i].setBackgroundColor(getResources().getColor(R.color.beyaz));
                buttons[i].setText((i+1)+"\n(BOŞ)");
            }
            else
            {
                buttons[i].setBackground(getResources().getDrawable(R.drawable.kirimizi_button));
                buttons[i].setText((i+1)+"\n(YANLIŞ)");
            }
        }


        for(int i=0; i<50; i++)
        {

            final int finalI = i+1;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View view) {

                    SoruYazdırma(finalI);



                }
            });
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void SoruYazdırma(int finalI) {
        soru = (TextView) findViewById(R.id.soru);
        a = (TextView) findViewById(R.id.Atext);
        b = (TextView) findViewById(R.id.Btext);
        c = (TextView) findViewById(R.id.Ctext);
        d = (TextView) findViewById(R.id.Dtext);
        buttonA=(Button)findViewById(R.id.A) ;
        buttonB=(Button)findViewById(R.id.B) ;
        buttonC=(Button)findViewById(R.id.C) ;
        buttonD=(Button)findViewById(R.id.D) ;
        soruResim = (TextView) findViewById(R.id.soruResim);


        String str =Questions.sınavTarihi + (finalI);

        int resId = 0;
        int resId_r = 0;
        int resId_a = 0;
        int resId_b = 0;
        int resId_c = 0;
        int resId_d = 0;

        try {
            resId = R.string.class.getField(str).getInt(null);
            soru.setText(getResources().getText(resId));

            soruResim.setBackground(null);
            if (Questions.resinliSoru[finalI - 1]) {
                resId_r = R.mipmap.class.getField(str).getInt(null);
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
            if (Questions.resimliCevap[finalI - 1]) {
                resId_a = R.mipmap.class.getField(str + "_a").getInt(null);
                a.setBackground(getResources().getDrawable(resId_a));
                resId_b = R.mipmap.class.getField(str + "_b").getInt(null);
                b.setBackground(getResources().getDrawable(resId_b));
                resId_c = R.mipmap.class.getField(str + "_c").getInt(null);
                c.setBackground(getResources().getDrawable(resId_c));
                resId_d = R.mipmap.class.getField(str + "_d").getInt(null);
                d.setBackground(getResources().getDrawable(resId_d));
            } else {
                resId_a = R.string.class.getField(str + "_a").getInt(null);
                a.setText(getResources().getText(resId_a));
                resId_b = R.string.class.getField(str + "_b").getInt(null);
                b.setText(getResources().getText(resId_b));
                resId_c = R.string.class.getField(str + "_c").getInt(null);
                c.setText(getResources().getText(resId_c));
                resId_d = R.string.class.getField(str + "_d").getInt(null);
                d.setText(getResources().getText(resId_d));
            }


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        buttonA.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
        buttonB.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
        buttonC.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
        buttonD.setBackground(getResources().getDrawable(R.drawable.yuvarlak_buton));
        if(Questions.isaretlenenler[finalI-1]=="A")
        {
            buttonA.setBackground(getResources().getDrawable(R.drawable.kirimizi_button));

        }
        else if(Questions.isaretlenenler[finalI-1]=="B")
        {
            buttonB.setBackground(getResources().getDrawable(R.drawable.kirimizi_button));

        }
        else if(Questions.isaretlenenler[finalI-1]=="C")
        {
            buttonC.setBackground(getResources().getDrawable(R.drawable.kirimizi_button));
        }
        else if(Questions.isaretlenenler[finalI-1]=="D")
        {
            buttonD.setBackground(getResources().getDrawable(R.drawable.kirimizi_button));
        }
        else{

        }

        if(cevaplar[finalI-1]=="A")
        {
            buttonA.setBackground(getResources().getDrawable(R.drawable.yesil_button));
        }
        else if (cevaplar[finalI-1]=="B")
        {
            buttonB.setBackground(getResources().getDrawable(R.drawable.yesil_button));
        }
        else if (cevaplar[finalI-1]=="C")
        {
            buttonC.setBackground(getResources().getDrawable(R.drawable.yesil_button));
        }
        else if (cevaplar[finalI-1]=="D")
        {
            buttonD.setBackground(getResources().getDrawable(R.drawable.yesil_button));
        }
        else
        {

        }




    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home )
        {
            Intent ıntent= new Intent(getApplicationContext(),dogruYanlis.class);
            startActivity(ıntent);

        }
        return super.onOptionsItemSelected(item);
    }

}

