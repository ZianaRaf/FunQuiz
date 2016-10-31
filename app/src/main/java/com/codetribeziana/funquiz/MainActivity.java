package com.codetribeziana.funquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] oddOneOutCarBrands = new String[4];

        TextView textView = (TextView) findViewById(R.id.logoText);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/segoeuil.ttf");
        textView.setTypeface(typeface);

        Button buttonBrands = (Button) findViewById(R.id.btnBrands);
        Button buttonOddOneOut = (Button) findViewById(R.id.btnBrands);
        Button buttonNameIt = (Button) findViewById(R.id.btnBrands);


    }


    public void buttonClicked(View v)
    {
        switch (v.getId())
        {

            case R.id.btnBrands:
                String topic = getResources().getString(R.string.topic_slogan);

                Intent nextWindow = new Intent(MainActivity.this, BrandsActivity.class);
                nextWindow.putExtra("Topic", topic);
                startActivity(nextWindow);
                Toast.makeText(getBaseContext(), topic, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnOddOneOut:
                 topic = getResources().getString(R.string.topic_Odd);

                Intent intent = new Intent(MainActivity.this, BrandsActivity.class);
                intent.putExtra("Topic", topic);
                startActivity(intent);
                Toast.makeText(getBaseContext(), topic, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnNameIt:
                topic = getResources().getString(R.string.topic_nameit);

                Intent nameIntent = new Intent(MainActivity.this, NameitActivity.class);
                nameIntent.putExtra("Topic", topic);
                startActivity(nameIntent);
                Toast.makeText(getBaseContext(), topic, Toast.LENGTH_SHORT).show();
                break;



            default:
            {
                Toast.makeText(getBaseContext(), "unknown", Toast.LENGTH_SHORT).show();

            }
        }


    }


}
