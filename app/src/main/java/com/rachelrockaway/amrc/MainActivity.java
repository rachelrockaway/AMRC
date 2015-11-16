package com.rachelrockaway.amrc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import info.hoang8f.android.segmented.SegmentedGroup;


public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    double maleWeightConstant = 6.23;
    double maleHeightConstant = 12.7;
    double maleAgeConstant = 6.8;
    double maleCalcConstant = 66;

    double femaleWeightConstant = 4.35;
    double femaleHeightConstant = 4.7;
    double femaleAgeConstant = 4.7;
    double femaleCalcConstant = 655;

    double weightCalc = 100.0;
    double heightCalc = 100.0;
    double ageCalc = 50;

    double sedentaryConstant = 1.2;
    double lightConstant = 1.375;
    double veryConstant = 1.725;
    double extraConstant = 1.9;

    Double userActiveMetabolicRate = 1000.00;

    public Double calculateBasalMetabolicRate() {

        if ( ( (RadioButton) findViewById(R.id.button21) ).isChecked() ) {
            weightCalc = maleWeightConstant * (double)(((SeekBar) findViewById(R.id.seekBar3)).getProgress());
            heightCalc = maleHeightConstant * (double)(((SeekBar) findViewById(R.id.seekBar2)).getProgress());
            ageCalc = maleAgeConstant * (double)(((SeekBar) findViewById(R.id.seekBar1)).getProgress());
        return (maleCalcConstant + weightCalc + heightCalc - ageCalc);
     }
        else {
            weightCalc = femaleWeightConstant * (double)(((SeekBar) findViewById(R.id.seekBar3)).getProgress());
            heightCalc = femaleHeightConstant * (double)(((SeekBar) findViewById(R.id.seekBar2)).getProgress());
            ageCalc = femaleAgeConstant * (double)(((SeekBar) findViewById(R.id.seekBar1)).getProgress());
       return (femaleCalcConstant + weightCalc + heightCalc - ageCalc);
      
        }
    }
    
    public Double calculateActiveMetabolicRate() {

        info.hoang8f.android.segmented.SegmentedGroup segmented3 = (info.hoang8f.android.segmented.SegmentedGroup) findViewById(R.id.segmented3);
        switch (segmented3.getCheckedRadioButtonId()) {
            case (R.id.button24):
                userActiveMetabolicRate = calculateBasalMetabolicRate() * sedentaryConstant;
                break;
            case (R.id.button25):
                userActiveMetabolicRate = calculateBasalMetabolicRate() * lightConstant;
                break;
            case (R.id.button26):
                userActiveMetabolicRate = calculateBasalMetabolicRate() * veryConstant;
                break;
            case (R.id.button27):
                userActiveMetabolicRate = calculateBasalMetabolicRate() * extraConstant;
                break;
        }
        TextView tv = (TextView) findViewById(R.id.textViewAMRCTotal);
        tv.setText(Integer.toString(userActiveMetabolicRate.intValue()));
        return userActiveMetabolicRate;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar sb1 = (SeekBar)findViewById(R.id.seekBar1);
        SeekBar sb2 = (SeekBar)findViewById(R.id.seekBar2);
        SeekBar sb3 = (SeekBar)findViewById(R.id.seekBar3);
        TextView tv4 = (TextView) findViewById(R.id.textViewAMRCTotal);
        tv4.setText("1649");
        sb1.setMax(120);
        sb1.setProgress(30);
        sb1.setOnSeekBarChangeListener(this);
        sb2.setMax(107);
        sb2.setProgress(72);
        sb2.setOnSeekBarChangeListener(this);
        sb3.setMax(300);
        sb3.setProgress(120);
        sb3.setOnSeekBarChangeListener(this);

        info.hoang8f.android.segmented.SegmentedGroup segmented2 = (info.hoang8f.android.segmented.SegmentedGroup)findViewById(R.id.segmented2);
        segmented2.setTintColor(android.graphics.Color.parseColor("#FFFFFF"), android.graphics.Color.parseColor("#FF7B07B2"));
        info.hoang8f.android.segmented.SegmentedGroup segmented3 = (info.hoang8f.android.segmented.SegmentedGroup)findViewById(R.id.segmented3);
        segmented3.setTintColor(android.graphics.Color.parseColor("#FFFFFF"), android.graphics.Color.parseColor("#FF7B07B2"));
    }

    @Override
    public void onProgressChanged(SeekBar v, int progress, boolean isUser) {

        if (v.getId() == R.id.seekBar1) {
            TextView tv = (TextView) findViewById(R.id.textViewAge);
            tv.setText("Age " + Integer.toString(progress) + " years");
        }
        if (v.getId() == R.id.seekBar2) {
            TextView tv2 = (TextView) findViewById(R.id.textViewHeight);
            tv2.setText("Height " + Integer.toString(progress) + " inches");
        }
        if (v.getId() == R.id.seekBar3) {
            TextView tv3 = (TextView) findViewById(R.id.textViewWeight);
            tv3.setText("Weight " + Integer.toString(progress) + " pounds");
        }
        calculateActiveMetabolicRate();
    }


        @Override
    public void onStartTrackingTouch(SeekBar seekbar) {
// TODO Auto-generated method stub
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekbar) {
// TODO Auto-generated method stub
    }

    public void sendMessage(android.view.View view) {
        calculateActiveMetabolicRate();
    }


}

