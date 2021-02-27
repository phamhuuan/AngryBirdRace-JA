package com.example.angrybirdrace;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
	TextView pigPoint, play;
	CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
	SeekBar seekBar1, seekBar2, seekBar3, seekBar4, seekBar5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pigPoint = findViewById(R.id.totalPig);
		play = findViewById(R.id.play);
		checkBox1 = findViewById(R.id.checkBox1);
		checkBox2 = findViewById(R.id.checkBox2);
		checkBox3 = findViewById(R.id.checkBox3);
		checkBox4 = findViewById(R.id.checkBox4);
		checkBox5 = findViewById(R.id.checkBox5);
		seekBar1 = findViewById(R.id.seekBar1);
		seekBar2 = findViewById(R.id.seekBar2);
		seekBar3 = findViewById(R.id.seekBar3);
		seekBar4 = findViewById(R.id.seekBar4);
		seekBar5 = findViewById(R.id.seekBar5);
		seekBar1.setEnabled(false);
		seekBar2.setEnabled(false);
		seekBar3.setEnabled(false);
		seekBar4.setEnabled(false);
		seekBar5.setEnabled(false);

		CountDownTimer countDownTimer = new CountDownTimer(600000, 300) {
			void resetPosition() {
				seekBar1.setProgress(0);
				seekBar2.setProgress(0);
				seekBar3.setProgress(0);
				seekBar4.setProgress(0);
				seekBar5.setProgress(0);
			}

			@Override
			public void onTick(long millisUntilFinished) {
				Random random = new Random();
				seekBar1.setProgress(seekBar1.getProgress() + random.nextInt(100));
				seekBar2.setProgress(seekBar2.getProgress() + random.nextInt(100));
				seekBar3.setProgress(seekBar3.getProgress() + random.nextInt(100));
				seekBar4.setProgress(seekBar4.getProgress() + random.nextInt(100));
				seekBar5.setProgress(seekBar5.getProgress() + random.nextInt(100));

				if (seekBar1.getProgress() >= seekBar1.getMax()) {
					resetPosition();
					play.setVisibility(View.VISIBLE);
					Toast.makeText(MainActivity.this, "Red win", Toast.LENGTH_SHORT).show();
					if (checkBox1.isChecked()) {
						Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
						pigPoint.setText(String.valueOf(Integer.parseInt((String) pigPoint.getText()) + 10));
					} else {
						Toast.makeText(MainActivity.this, "You lose", Toast.LENGTH_SHORT).show();
						pigPoint.setText(String.valueOf(Integer.parseInt((String) pigPoint.getText()) - 10));
					}
					checkBox1.setEnabled(true);
					checkBox2.setEnabled(true);
					checkBox3.setEnabled(true);
					checkBox4.setEnabled(true);
					checkBox5.setEnabled(true);
					this.cancel();
				}
				if (seekBar2.getProgress() >= seekBar2.getMax()) {
					resetPosition();
					play.setVisibility(View.VISIBLE);
					Toast.makeText(MainActivity.this, "Yellow win", Toast.LENGTH_SHORT).show();
					if (checkBox2.isChecked()) {
						Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
						pigPoint.setText(String.valueOf(Integer.parseInt((String) pigPoint.getText()) + 10));
					} else {
						Toast.makeText(MainActivity.this, "You lose", Toast.LENGTH_SHORT).show();
						pigPoint.setText(String.valueOf(Integer.parseInt((String) pigPoint.getText()) - 10));
					}
					checkBox1.setEnabled(true);
					checkBox2.setEnabled(true);
					checkBox3.setEnabled(true);
					checkBox4.setEnabled(true);
					checkBox5.setEnabled(true);
					this.cancel();
				}
				if (seekBar3.getProgress() >= seekBar3.getMax()) {
					resetPosition();
					play.setVisibility(View.VISIBLE);
					Toast.makeText(MainActivity.this, "Black win", Toast.LENGTH_SHORT).show();
					if (checkBox3.isChecked()) {
						Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
						pigPoint.setText(String.valueOf(Integer.parseInt((String) pigPoint.getText()) + 10));
					} else {
						Toast.makeText(MainActivity.this, "You lose", Toast.LENGTH_SHORT).show();
						pigPoint.setText(String.valueOf(Integer.parseInt((String) pigPoint.getText()) - 10));
					}
					checkBox1.setEnabled(true);
					checkBox2.setEnabled(true);
					checkBox3.setEnabled(true);
					checkBox4.setEnabled(true);
					checkBox5.setEnabled(true);
					this.cancel();
				}
				if (seekBar4.getProgress() >= seekBar4.getMax()) {
					resetPosition();
					play.setVisibility(View.VISIBLE);
					Toast.makeText(MainActivity.this, "Green win", Toast.LENGTH_SHORT).show();
					if (checkBox4.isChecked()) {
						Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
						pigPoint.setText(String.valueOf(Integer.parseInt((String) pigPoint.getText()) + 10));
					} else {
						Toast.makeText(MainActivity.this, "You lose", Toast.LENGTH_SHORT).show();
						pigPoint.setText(String.valueOf(Integer.parseInt((String) pigPoint.getText()) - 10));
					}
					checkBox1.setEnabled(true);
					checkBox2.setEnabled(true);
					checkBox3.setEnabled(true);
					checkBox4.setEnabled(true);
					checkBox5.setEnabled(true);
					this.cancel();
				}
				if (seekBar5.getProgress() >= seekBar5.getMax()) {
					resetPosition();
					play.setVisibility(View.VISIBLE);
					Toast.makeText(MainActivity.this, "Blue win", Toast.LENGTH_SHORT).show();
					if (checkBox5.isChecked()) {
						Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
						pigPoint.setText(String.valueOf(Integer.parseInt((String) pigPoint.getText()) + 10));
					} else {
						Toast.makeText(MainActivity.this, "You lose", Toast.LENGTH_SHORT).show();
						pigPoint.setText(String.valueOf(Integer.parseInt((String) pigPoint.getText()) - 10));
					}
					checkBox1.setEnabled(true);
					checkBox2.setEnabled(true);
					checkBox3.setEnabled(true);
					checkBox4.setEnabled(true);
					checkBox5.setEnabled(true);
					this.cancel();
				}
			}

			@Override
			public void onFinish() {

			}
		};
		
		play.setOnClickListener(view -> {
			if (!checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked() && !checkBox4.isChecked() && !checkBox5.isChecked()) {
				Toast.makeText(this, "You must bet one bird", Toast.LENGTH_SHORT).show();
			} else {
				countDownTimer.start();
				checkBox1.setClickable(false);
				checkBox2.setClickable(false);
				checkBox3.setClickable(false);
				checkBox4.setClickable(false);
				checkBox5.setClickable(false);
				play.setVisibility(View.INVISIBLE);
			}
		});

		checkBox1.setOnCheckedChangeListener((buttonView, isChecked) -> {
			if (isChecked) {
				checkBox2.setChecked(false);
				checkBox3.setChecked(false);
				checkBox4.setChecked(false);
				checkBox5.setChecked(false);
			}
		});
		checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
			if (isChecked) {
				checkBox1.setChecked(false);
				checkBox3.setChecked(false);
				checkBox4.setChecked(false);
				checkBox5.setChecked(false);
			}
		});
		checkBox3.setOnCheckedChangeListener((buttonView, isChecked) -> {
			if (isChecked) {
				checkBox2.setChecked(false);
				checkBox1.setChecked(false);
				checkBox4.setChecked(false);
				checkBox5.setChecked(false);
			}
		});
		checkBox4.setOnCheckedChangeListener((buttonView, isChecked) -> {
			if (isChecked) {
				checkBox2.setChecked(false);
				checkBox3.setChecked(false);
				checkBox1.setChecked(false);
				checkBox5.setChecked(false);
			}
		});
		checkBox5.setOnCheckedChangeListener((buttonView, isChecked) -> {
			if (isChecked) {
				checkBox2.setChecked(false);
				checkBox3.setChecked(false);
				checkBox4.setChecked(false);
				checkBox1.setChecked(false);
			}
		});
	}
}