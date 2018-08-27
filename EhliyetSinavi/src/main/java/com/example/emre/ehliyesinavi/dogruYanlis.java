package com.example.emre.ehliyesinavi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dogruYanlis extends AppCompatActivity {

    Button detayliButton;
    int dogru=0,yanlis=0,bos=0;
    TextView dogruB,yanlısB,bosB,durumB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogru_yanlis);

        dogruB=(TextView)findViewById(R.id.dogruButton);
        yanlısB=(TextView)findViewById(R.id.yanlisButton);
        bosB=(TextView)findViewById(R.id.bosButton);
        durumB=(TextView)findViewById(R.id.durum);

        // Geri ActionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        detayliButton=(Button)findViewById(R.id.detayButton);

        detayliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),detayliIncele.class);
                startActivity(intent);
            }
        });


        for(int i=0; i<50; i++)
        {
            if(Questions.isaretlenenler[i]==detayliIncele.cevaplar[i])
            {
                dogru++;
            }
            else if(Questions.isaretlenenler[i]==null)
            {
                bos++;
            }
            else
            {
                yanlis++;
            }
        }
        if(dogru>=35)
        {
            durumB.setText("GEÇTİ");
            durumB.setTextColor(getResources().getColor(R.color.yesil));
        }
        else{
            durumB.setText("KALDI");
            durumB.setTextColor(getResources().getColor(R.color.kırmızı));
        }
        dogruB.setText(dogru+"");
        yanlısB.setText(yanlis+"");
        bosB.setText(bos+"");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home )
        {
            Intent ıntent= new Intent(getApplicationContext(),menu.class);
            startActivity(ıntent);

        }
        return super.onOptionsItemSelected(item);
    }
}
