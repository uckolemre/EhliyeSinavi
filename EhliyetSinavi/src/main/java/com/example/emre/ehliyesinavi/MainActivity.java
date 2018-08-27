package com.example.emre.ehliyesinavi;

import android.app.ActionBar;
import android.content.Intent;

import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


public class MainActivity extends ActionBarActivity {

    Button aralik2016,agustos2016,mayis2016,subat2016,subat2017,mayis2017;
    private  String[] tarih_cevap;

    private  AdView adview;



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Soruları ve cevapları
        subat_2017();
        aralik_2016();
        agustos_2016();
        mayis_2016();
        subat_2016();



    }



    public void mayis_2017()
    {
        mayis2017=(Button)findViewById(R.id.mayis2017);

        mayis2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                tarih_cevap=new String[]{"A","B","C","D","C","A","D","B","D","A","B","D","C","C","A","B","A","C","D","C",
                        "A","B","C","D","C","D","D","A","C","A","D","B","A","D","B","A","B","D","C","B","D","C","A","D","B","A ","C ","B","C","B"};
                for(int i=0; i<50; i++)
                {
                    detayliIncele.cevaplar[i]=tarih_cevap[i];
                    Questions.resinliSoru[i]=false;
                    Questions.resimliCevap[i]=false;
                    Questions.isaretlenenler[i]=null;
                }

                Questions.resinliSoru[6]=true;
                Questions.resinliSoru[19]=true;
                Questions.resinliSoru[21]=true;
                Questions.resinliSoru[24]=true;
                Questions.resinliSoru[27]=true;


                Questions.resimliCevap[17]=true;
                Questions.resimliCevap[18]=true;
                Questions.resimliCevap[20]=true;
                Questions.resimliCevap[22]=true;
                Questions.resimliCevap[42]=true;

                Questions.sınavTarihi="subat2017_";
                Questions.count=1;
                Intent gecis=new Intent(getApplicationContext(),Questions.class);
                startActivity(gecis);

            }
        });

    }

    public void subat_2017()
    {
        subat2017=(Button)findViewById(R.id.subat2017);

        subat2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                tarih_cevap=new String[]{"D","C","A","B","C","B","A","A","D","B","C","D","C","B","D","A","A","C","A","B","A","B","C","D","C","D","A","B","C","B","D",
                        "A","D","C","D","B","D","A","B","C","A","D","C","D","C","B","A","C","D","B"};
                for(int i=0; i<50; i++)
                {
                    detayliIncele.cevaplar[i]=tarih_cevap[i];
                    Questions.resinliSoru[i]=false;
                    Questions.resimliCevap[i]=false;
                    Questions.isaretlenenler[i]=null;
                }

                Questions.resinliSoru[6]=true;
                Questions.resinliSoru[19]=true;
                Questions.resinliSoru[21]=true;
                Questions.resinliSoru[24]=true;
                Questions.resinliSoru[27]=true;


                Questions.resimliCevap[17]=true;
                Questions.resimliCevap[18]=true;
                Questions.resimliCevap[20]=true;
                Questions.resimliCevap[22]=true;
                Questions.resimliCevap[42]=true;

                Questions.sınavTarihi="subat2017_";
                Questions.count=1;
                Intent gecis=new Intent(getApplicationContext(),Questions.class);
                startActivity(gecis);

            }
        });

    }

    public void aralik_2016()
    {
        aralik2016=(Button)findViewById(R.id.aralik2016);

        aralik2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarih_cevap=new String[]{"D","C","A","B","A","D","C","B","D","B","A","C","B","C","D","A","A","C"
                        ,"B","A","D","C","B","C","D","A","C","B","A","D","C","B","D","B","D","A","B","D","D","C","B"
                        ,"C","D","A","C","B","A","D","A","C"};
                for(int i=0; i<50; i++)
                {
                    detayliIncele.cevaplar[i]=tarih_cevap[i];
                    Questions.resinliSoru[i]=false;
                    Questions.resimliCevap[i]=false;
                    Questions.isaretlenenler[i]=null;
                }
                Questions.resinliSoru[3]=true;
                Questions.resinliSoru[20]=true;
                Questions.resinliSoru[21]=true;
                Questions.resinliSoru[22]=true;
                Questions.resinliSoru[23]=true;
                Questions.resinliSoru[25]=true;
                Questions.resinliSoru[26]=true;
                Questions.resinliSoru[37]=true;
                Questions.resinliSoru[42]=true;

                Questions.resimliCevap[16]=true;
                Questions.resimliCevap[17]=true;
                Questions.resimliCevap[19]=true;

                Questions.sınavTarihi="aralik2016_";
                Questions.count=1;
                Intent gecis=new Intent(getApplicationContext(),Questions.class);
                startActivity(gecis);
            }
        });

    }

    public void agustos_2016()
    {
        agustos2016=(Button)findViewById(R.id.agustos2016);
        agustos2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarih_cevap=new String[]{"D","C","A","B","C","B","A","D","B","C","A","D","B","D","A","C","D","A","C","B","C","D","A","C","B","D","D","A","B","C","A","B","C","A","D","B","C","D","C","B","D","A","A","B","D","A","C","B","C","A"};
                for(int i=0; i<50; i++)
                {
                    detayliIncele.cevaplar[i]=tarih_cevap[i];
                    Questions.resinliSoru[i]=false;
                    Questions.resimliCevap[i]=false;
                    Questions.isaretlenenler[i]=null;
                }
                Questions.resinliSoru[16]=true;
                Questions.resinliSoru[17]=true;
                Questions.resinliSoru[19]=true;
                Questions.resinliSoru[20]=true;
                Questions.resinliSoru[23]=true;
                Questions.resinliSoru[28]=true;
                Questions.resinliSoru[35]=true;
                Questions.resinliSoru[43]=true;

                Questions.resimliCevap[18]=true;
                Questions.resimliCevap[15]=true;
                Questions.resimliCevap[36]=true;

                Questions.sınavTarihi="agustos2016_";
                Questions.count=1;
                Intent gecis=new Intent(getApplicationContext(),Questions.class);
                startActivity(gecis);
            }
        });
    }

    public void mayis_2016()
    {
        mayis2016=(Button)findViewById(R.id.mayis2016);

        mayis2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarih_cevap=new String[]{"D","B","C","A","B","C","D","C","A","D","A","B","D","C","B","A","D","B","C","A","B","D","A","C","C","B","A","C","B","C","D","A","D","B","A","C","D","A","A","D","B","D","C","B","D","C","A","D","B","A"};
                for(int i=0; i<50; i++)
                {
                    detayliIncele.cevaplar[i]=tarih_cevap[i];
                    Questions.resinliSoru[i]=false;
                    Questions.resimliCevap[i]=false;
                    Questions.isaretlenenler[i]=null;
                }
                Questions.resinliSoru[10]=true;
                Questions.resinliSoru[11]=true;
                Questions.resinliSoru[14]=true;
                Questions.resinliSoru[16]=true;
                Questions.resinliSoru[18]=true;
                Questions.resinliSoru[19]=true;
                Questions.resinliSoru[20]=true;
                Questions.resinliSoru[23]=true;
                Questions.resinliSoru[24]=true;
                Questions.resinliSoru[27]=true;
                Questions.resinliSoru[28]=true;
                Questions.resinliSoru[31]=true;
                Questions.resinliSoru[34]=true;

                Questions.resimliCevap[17]=true;
                Questions.resimliCevap[37]=true;

                Questions.count=1;
                Questions.sınavTarihi="mayis2016_";
                Intent gecis=new Intent(getApplicationContext(),Questions.class);
                startActivity(gecis);
            }
        });
    }

    public void subat_2016()
    {
        subat2016=(Button)findViewById(R.id.subat2016);
        subat2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarih_cevap= new String[]{"B", "D", "A", "D", "C", "B", "A", "D", "C", "D", "D", "C", "D", "A", "D", "C", "C", "A", "B", "C", "B", "D", "A", "B", "A", "B", "A", "A", "D", "A", "B", "C", "D", "D", "C", "B", "C", "B", "A", "C", "D", "B", "A", "B", "C", "D", "B", "C", "B", "A"
                };
                for(int i=0; i<50; i++)
                {
                    detayliIncele.cevaplar[i]=tarih_cevap[i];
                    Questions.resinliSoru[i]=false;
                    Questions.resimliCevap[i]=false;
                    Questions.isaretlenenler[i]=null;
                }
                Questions.resinliSoru[3]=true;
                Questions.resinliSoru[12]=true;
                Questions.resinliSoru[16]=true;
                Questions.resinliSoru[17]=true;
                Questions.resinliSoru[18]=true;
                Questions.resinliSoru[19]=true;
                Questions.resinliSoru[22]=true;
                Questions.resinliSoru[24]=true;
                Questions.resinliSoru[25]=true;
                Questions.resinliSoru[26]=true;
                Questions.resinliSoru[34]=true;
                Questions.resinliSoru[37]=true;
                Questions.resinliSoru[42]=true;

                Questions.resimliCevap[9]=true;
                Questions.resimliCevap[14]=true;
                Questions.resimliCevap[20]=true;

                Questions.count=1;
                Questions.sınavTarihi="subat2016_";
                Intent gecis=new Intent(getApplicationContext(),Questions.class);
                startActivity(gecis);
            }
        });
    }








}
