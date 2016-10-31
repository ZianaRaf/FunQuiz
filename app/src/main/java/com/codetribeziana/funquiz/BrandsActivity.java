package com.codetribeziana.funquiz;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ParseException;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.*;
import android.support.v7.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.security.AccessController.getContext;

public class BrandsActivity extends AppCompatActivity
{
    int score = 0;
    int i=0;
    int o=0;
    int count=0;

    int startCount=0;
    int endCount=4;

    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_brands);


        TextView textViewTopic = (TextView) findViewById(R.id.topic_Text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.title_font));
        textViewTopic.setTypeface(typeface);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            String chosenTopic = extras.getString(getResources().getString(R.string.topic_string));
            textViewTopic.setText(" " + chosenTopic);
            if (chosenTopic.equalsIgnoreCase(getResources().getString(R.string.topic_slogan)))
            {
                openSloganCard();
            }else if(chosenTopic.equalsIgnoreCase(getResources().getString(R.string.topic_Odd)))
            {
                openOddOneOutCard();
            }
        }

    }


    public void openSloganCard()
    {
        ArrayList<String> taglines = new ArrayList<>();
        taglines.add(getResources().getString(R.string.facebook_question));
        taglines.add(getResources().getString(R.string.apple_question));
        taglines.add(getResources().getString(R.string.playstation_question));
        taglines.add(getResources().getString(R.string.google_question));
        taglines.add(getResources().getString(R.string.standard_question));

        final int questionsLength = taglines.size();

        /**
         *Answers for the tagline Questions**/
        final ArrayList<String> taglinesAnswers = new ArrayList<>();
        taglinesAnswers.add(getResources().getString(R.string.DSTV));
        taglinesAnswers.add(getResources().getString(R.string.Whatsapp));
        taglinesAnswers.add(getResources().getString(R.string.Facebook));//answer
        taglinesAnswers.add(getResources().getString(R.string.Mxit));
        taglinesAnswers.add(getResources().getString(R.string.Snapchat));
        taglinesAnswers.add(getResources().getString(R.string.Apple));//answer
        taglinesAnswers.add(getResources().getString(R.string.Intel));
        taglinesAnswers.add(getResources().getString(R.string.Tesla));


        taglinesAnswers.add(getResources().getString(R.string.playstation));//answer
        taglinesAnswers.add(getResources().getString(R.string.Candy_crush));
        taglinesAnswers.add(getResources().getString(R.string.Amazon));
        taglinesAnswers.add(getResources().getString(R.string.EA));

        taglinesAnswers.add(getResources().getString(R.string.CIA));
        taglinesAnswers.add(getResources().getString(R.string.Palantir));
        taglinesAnswers.add(getResources().getString(R.string.Xiaomi));
        taglinesAnswers.add(getResources().getString(R.string.Google));//Answer

        taglinesAnswers.add(getResources().getString(R.string.Transnet));
        taglinesAnswers.add(getResources().getString(R.string.standard));//answer
        taglinesAnswers.add(getResources().getString(R.string.Gautrain));
        taglinesAnswers.add(getResources().getString(R.string.BMW));


        int index = 0;
        int qnum = 0;

        LinearLayout innerView = (LinearLayout) findViewById(R.id.QuizContainer);
        innerView.setScrollContainer(true);
        innerView.setBackgroundColor(Color.WHITE);
        innerView.setPadding(8, 8, 8, 8);

        for (qnum = 1; qnum <=5; qnum++)
        {
            final String slogan = taglines.get(index);
            TextView textViewSlogan = new TextView(this);
            textViewSlogan.setText(slogan);//Question
            textViewSlogan.setTextColor(Color.rgb(48, 63, 159));//
            textViewSlogan.setTextSize(16);
            textViewSlogan.setPadding(8, 8, 0, 0);
            innerView.addView(textViewSlogan);




            // create radio button

            RadioGroup radioGroup = new RadioGroup(this);
            radioGroup.setOrientation(RadioGroup.VERTICAL);
            radioGroup.setPadding(16, 8, 0, 8);

            for (i = startCount; i < endCount; i++)
            {
                final RadioButton[] radioButtons = new RadioButton[endCount];
                radioButtons[i] = new RadioButton(this);
                radioGroup.addView(radioButtons[i]);
                radioButtons[i].setText(taglinesAnswers.get(i));
                radioButtons[i].setTextColor(Color.DKGRAY);
                //radioButtons[i].setId(i);


                startCount++;
            }

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId)
                {
                    RadioButton radioButton = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                    String selectedOption = radioButton.getText().toString();

                    if (selectedOption.equals(getResources().getString(R.string.Apple)))
                    {
                        count += 1;
                        score = score + 1;
                        //Toast.makeText(BrandsActivity.this, "+1", Toast.LENGTH_SHORT).show();

                    }
                    else if (selectedOption.equals(getResources().getString(R.string.Facebook)))
                    {
                        count += 1;
                        score = score + 1;
                        //Toast.makeText(BrandsActivity.this, "+1", Toast.LENGTH_SHORT).show();

                    }
                    else if (selectedOption.equals(getResources().getString(R.string.playstation)))
                    {
                        count += 1;
                        score = score + 1;
                        //Toast.makeText(BrandsActivity.this, "+1" , Toast.LENGTH_SHORT).show();

                    }
                    else if (selectedOption.equals(getResources().getString(R.string.Google)))
                    {
                        count += 1;
                        score = score + 1;
                        //Toast.makeText(BrandsActivity.this, "+1" , Toast.LENGTH_SHORT).show();

                    }
                    else if (selectedOption.equals(getResources().getString(R.string.standard)))
                    {
                        count += 1;
                        score = score + 1;
                        //Toast.makeText(BrandsActivity.this, "+1" , Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        score += 0;
                        count += 1;
                    }
                    Toast.makeText(BrandsActivity.this, count + "/5", Toast.LENGTH_SHORT).show();
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
            innerView.addView(radioGroup);
            innerView.setAlpha(0.9f);
            endCount += 4;
            index++;
        }

   }

    public void openOddOneOutCard()
    {
        Resources resources=getResources();
        ArrayList<String> oddOptions = new ArrayList<>();
        oddOptions.add(getString(R.string.vw));
        oddOptions.add(getString(R.string.BMW_ooo));
        oddOptions.add(getString(R.string.Volvo));
        oddOptions.add(getString(R.string.merc));

        oddOptions.add(getString(R.string.polo));
        oddOptions.add(getString(R.string.jetta));
        oddOptions.add(getString(R.string.golf));
        oddOptions.add(getString(R.string.Cclass));

        oddOptions.add(getString(R.string.Trey));
        oddOptions.add(getString(R.string.Kobe));
        oddOptions.add(getString(R.string.michael));
        oddOptions.add(getString(R.string.Russel));

        oddOptions.add(getString(R.string.dubai));
        oddOptions.add(getString(R.string.india));
        oddOptions.add(getString(R.string.dhabi));
        oddOptions.add(getString(R.string.saudi));

        oddOptions.add(getString(R.string.nest));
        oddOptions.add(getString(R.string.nest));
        oddOptions.add(getString(R.string.note));
        oddOptions.add(getString(R.string.pixel));




        int o = 0;
        int ou=0;

        LinearLayout innerView = (LinearLayout)findViewById(R.id.QuizContainer);
        innerView.setBackgroundColor(Color.TRANSPARENT);


        for(ou=1; ou<=5;ou++)
        {
            TextView textViewOdd = new TextView(this);
            textViewOdd.setText(""+ou);//Divider
            textViewOdd.setTextColor(Color.WHITE);//rgb(48, 63, 159)
            textViewOdd.setTextSize(8);
            textViewOdd.setPadding(8, 8, 0, 4);
            innerView.addView(textViewOdd);

            RadioGroup radioGroup = new RadioGroup(this);
            radioGroup.setOrientation(RadioGroup.VERTICAL);
            radioGroup.setPadding(16, 8, 0, 8);
            final CardView cardView = new CardView(this);

            for (o = startCount; o < endCount; o++)
            {
                final RadioButton[] radioButtons = new RadioButton[endCount];
                radioButtons[o] = new RadioButton(this);
                radioGroup.addView(radioButtons[o]);
                radioButtons[o].setText(oddOptions.get(o));
                radioButtons[o].setTextColor(Color.DKGRAY);
                //radioButtons[i].setId(i);


                startCount++;
            }

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId)
                {
                    RadioButton radioButton = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                    String selectedOption = radioButton.getText().toString();

                    if (selectedOption.equals(getResources().getString(R.string.Volvo)))
                    {
                        count += 1;
                        score = score + 1;
                        //Toast.makeText(BrandsActivity.this, "Selected"+selectedOption, Toast.LENGTH_SHORT).show();

                    }
                    else if (selectedOption.equals(getResources().getString(R.string.Cclass)))
                    {
                        count += 1;
                        score = score + 1;
                        //Toast.makeText(BrandsActivity.this, "+1", Toast.LENGTH_SHORT).show();

                    }
                    else if (selectedOption.equals(getResources().getString(R.string.michael)))
                    {
                        count += 1;
                        score = score + 1;
                        //Toast.makeText(BrandsActivity.this, "+1" , Toast.LENGTH_SHORT).show();

                    }
                    else if (selectedOption.equals(getResources().getString(R.string.india)))
                    {
                        count += 1;
                        score = score + 1;
                        //Toast.makeText(BrandsActivity.this, "+1" , Toast.LENGTH_SHORT).show();

                    }
                    else if (selectedOption.equals(getResources().getString(R.string.note)))
                    {
                        count += 1;
                        score = score + 1;
                        //Toast.makeText(BrandsActivity.this, "+1" , Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        score += 0;
                        count += 1;
                    }

                    Toast.makeText(BrandsActivity.this, count + "/5", Toast.LENGTH_SHORT).show();
                    for (int r = 0; r < group.getChildCount(); r++)
                    {
                        group.getChildAt(r).setEnabled(false);
                        cardView.setAlpha(0.3f);

                    }
                    if (count >= 5)
                    {
                        scoreCard();
                    }

                }


            });



            cardView.addView(radioGroup);//Cardview for options
            innerView.addView(cardView);
            innerView.setAlpha(0.9f);
            endCount += 4;
        }//OddOuterLoop

    }




    public void scoreCard()
    {

        if (count < 5)
        {

                //DO NOTHING
        }
        else
        {
           // Toast.makeText(this, "You got " + score+" out of 5" , Toast.LENGTH_LONG).show();



            AlertDialog ad = new AlertDialog.Builder(BrandsActivity.this)
                    .setMessage(score+" "+getResources().getString(R.string.correct_answer)).setIconAttribute(R.attr.closeIcon)
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


