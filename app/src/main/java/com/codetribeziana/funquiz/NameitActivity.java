package com.codetribeziana.funquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;

public class NameitActivity extends AppCompatActivity
{
    int score = 0;
    int i=0;
    int o=0;
    int count=0;

    int startCount=0;
    int endCount=4;
    RadioGroup radioGroupApple,radioGroupGoogol,radioGroupLambo,radioGroupMacD,radioGroupTwit;
    RadioButton radioButton;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);



        //ViewCompat.setElevation(myCard1, 5);
        setContentView(R.layout.activity_nameit);

            radioGroupApple = (RadioGroup) findViewById(R.id.rgApple);
        radioGroupGoogol = (RadioGroup) findViewById(R.id.rgGoogol);
        radioGroupLambo = (RadioGroup) findViewById(R.id.rgLambo);
        radioGroupMacD = (RadioGroup) findViewById(R.id.rgMacD);
        radioGroupTwit = (RadioGroup) findViewById(R.id.rgTwitter);


        TextView textViewTopic = (TextView) findViewById(R.id.topic_Text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.title_font));
        textViewTopic.setTypeface(typeface);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            String chosenTopic = getResources().getString(R.string.topic_nameit);
            textViewTopic.setText(" " + chosenTopic);
            openNameitCard();

        }else{ Toast.makeText(this,"Nothing to show, please return home.",Toast.LENGTH_LONG).show();}


    }




    public void openNameitCard()
    {

        int o = 0;
        int ou=0;





            radioGroupApple.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId)
                {
                    radioButton = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                    String selectedOption = radioButton.getText().toString();
                    String apple=getResources().getString(R.string.apple_2r);
                    if (selectedOption.equals(apple))
                    {
                        count += 1;
                        score = score + 1;
                        Toast.makeText(NameitActivity.this, "Selected " + selectedOption, Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        score += 0;
                        count += 1;
                    }
                    Toast.makeText(NameitActivity.this, count + "/5", Toast.LENGTH_SHORT).show();
                    for (int r = 0; r < group.getChildCount(); r++)
                    {
                        group.getChildAt(r).setEnabled(false);

                    }
                    if (count >= 5)
                    {
                        scoreCard();
                    }


                }


            });

        radioGroupTwit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioButton = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                String selectedOption = radioButton.getText().toString();
                String twitter=getResources().getString(R.string.twit_3r);
                if (selectedOption.equals(twitter))
                {
                    count += 1;
                    score = score + 1;
                    Toast.makeText(NameitActivity.this, "Selected " + selectedOption, Toast.LENGTH_SHORT).show();

                }
                else
                {
                    score += 0;
                    count += 1;
                }
                Toast.makeText(NameitActivity.this, count + "/5", Toast.LENGTH_SHORT).show();
                for (int r = 0; r < group.getChildCount(); r++)
                {
                    group.getChildAt(r).setEnabled(false);


                }
                if (count >= 5)
                {
                    scoreCard();
                }


            }


        });

        radioGroupLambo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioButton = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                String selectedOption = radioButton.getText().toString();
                String lambo=getResources().getString(R.string.lambo_2r);
                if (selectedOption.equals(lambo))
                {
                    count += 1;
                    score = score + 1;
                    Toast.makeText(NameitActivity.this, "Selected " + selectedOption, Toast.LENGTH_SHORT).show();

                }
                else
                {
                    score += 0;
                    count += 1;
                }
                Toast.makeText(NameitActivity.this, count + "/5", Toast.LENGTH_SHORT).show();
                for (int r = 0; r < group.getChildCount(); r++)
                {
                    group.getChildAt(r).setEnabled(false);


                }
                if (count >= 5)
                {
                    scoreCard();
                }


            }


        });

        radioGroupGoogol.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioButton = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                String selectedOption = radioButton.getText().toString();
                String googol=getResources().getString(R.string.goog_3r);
                if (selectedOption.equals(googol))
                {
                    count += 1;
                    score = score + 1;
                    Toast.makeText(NameitActivity.this, "Selected " + selectedOption, Toast.LENGTH_SHORT).show();

                }
                else
                {
                    score += 0;
                    count += 1;
                }
                Toast.makeText(NameitActivity.this, count + "/5", Toast.LENGTH_SHORT).show();
                for (int r = 0; r < group.getChildCount(); r++)
                {
                    group.getChildAt(r).setEnabled(false);
                    ;

                }
                if (count >= 5)
                {
                    scoreCard();
                }


            }


        });

        radioGroupMacD.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioButton = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                String selectedOption = radioButton.getText().toString();
                String macd=getResources().getString(R.string.mcD_3r);
                if (selectedOption.equals(macd))
                {
                    count += 1;
                    score = score + 1;
                    Toast.makeText(NameitActivity.this, "Selected " + selectedOption, Toast.LENGTH_SHORT).show();

                }
                else
                {
                    score += 0;
                    count += 1;
                }
                Toast.makeText(NameitActivity.this, count + "/5", Toast.LENGTH_SHORT).show();
                for (int r = 0; r < group.getChildCount(); r++)
                {
                    group.getChildAt(r).setEnabled(false);

                }
                if (count >= 5)
                {
                    scoreCard();
                }


            }


        });



    }//end name it








    public void scoreCard()
    {

        if (count < 5)
        {


        }
        else
        {
            //Toast.makeText(this, "You got " + score+" out of 5" , Toast.LENGTH_LONG).show();

        //TextView scoreView = new TextView(this);
            //scoreView.setText(score);
           // scoreView.setTextSize(24);
            //scoreView.setTypeface(Typeface.SANS_SERIF);
            //scoreView.setTextColor(Color.CYAN);

        AlertDialog ad = new AlertDialog.Builder(NameitActivity.this)
                .setMessage(score+getResources().getString(R.string.correct_answer)).setIconAttribute(R.attr.closeIcon)
                .setTitle(getResources().getString(R.string.score_text))
                .setCancelable(false)
                .setNeutralButton(getResources().getString(R.string.dialog_confirm),new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }

                })
                .create();
            ad.show();



    }



    }

}


