package com.rachelrockaway.amrc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar sb = (SeekBar)findViewById(R.id.seekBar);
        SeekBar sb2 = (SeekBar)findViewById(R.id.seekBar2);
        SeekBar sb3 = (SeekBar)findViewById(R.id.seekBar3);
        sb.setMax(120);
        sb.setProgress(30);
        sb.setOnSeekBarChangeListener(this);
        sb2.setMax(107)
        sb2.setProgress(72);
        sb2.setOnSeekBarChangeListener(this);
        sb3.setMax(300);
        sb3.setProgress(120);
        sb3.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar v, int progress, boolean isUser) {
        TextView tv = (TextView)findViewById(R.id.textViewAge);
        tv.setText("Age: " + Integer.toString(progress) + " years");
        TextView tv2 = (TextView)findViewById(R.id.textViewHeight);
        tv2.setText("Height: " + Integer.toString(progress) + " inches");
        TextView tv3 = (TextView)findViewById(R.id.textViewWeight);
        tv3.setText("Weight: " + Integer.toString(progress) + " pounds");
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
    }

}

