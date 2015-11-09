package com.rachelrockaway.amrc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar sb1 = (SeekBar)findViewById(R.id.seekBar1);
        SeekBar sb2 = (SeekBar)findViewById(R.id.seekBar2);
        SeekBar sb3 = (SeekBar)findViewById(R.id.seekBar3);
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
            tv.setText("Age: " + Integer.toString(progress) + " years");
        }
        if (v.getId() == R.id.seekBar2) {
            TextView tv2 = (TextView) findViewById(R.id.textViewHeight);
            tv2.setText("Height: " + Integer.toString(progress) + " inches");
        }
        if (v.getId() == R.id.seekBar3) {
            TextView tv3 = (TextView) findViewById(R.id.textViewWeight);
            tv3.setText("Weight: " + Integer.toString(progress) + " pounds");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekbar) {
// TODO Auto-generated method stub
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekbar) {
// TODO Auto-generated method stub
    }

}

