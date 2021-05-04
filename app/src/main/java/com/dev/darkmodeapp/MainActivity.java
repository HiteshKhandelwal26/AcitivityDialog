package com.dev.darkmodeapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ChipGroup chipGroup;

    ArrayList<String> tagList = new ArrayList<>();
    private boolean isChip1, isChip2, isChip3 = false;
    private Chip chip1, chip2, chip3;
    private String chip1Text = "YUV";
    private String chip2Text = "JPEG";
    private String chip3Text = "Both";
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipGroup = (ChipGroup) findViewById(R.id.chipGroup);
        button = (Button) findViewById(R.id.btnClick);
        button.setOnClickListener(this);

        tagList.add(chip1Text);
        tagList.add(chip2Text);
        //tagList.add(chip3Text);
        for (int i = 0; i < tagList.size(); i++) {
            Chip chip = (Chip) getLayoutInflater().inflate(R.layout.item_chip, chipGroup, false);
            chip.setText(tagList.get(i));
            chip.setTextSize(12);
            chipGroup.addView(chip);
        }


        for (int i = 0; i < chipGroup.getChildCount(); i++) {
            chip1 = (Chip) chipGroup.getChildAt(0);
            chip2 = (Chip) chipGroup.getChildAt(1);
            // chip3 = (Chip) chipGroup.getChildAt(2);
        }

        chip1.setOnClickListener(v -> switchChip(1));

        chip2.setOnClickListener(v -> switchChip(2));

        /*chip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchChip(3);
            }
        });*/
    }

    private void switchChip(int chipNum) {
        switch (chipNum) {
            case 1:
                if (!isChip1) {
                    isChip1 = true;
                    selectedChip(chip1, true);
                } else {
                    isChip1 = false;
                    selectedChip(chip1, false);
                }
                break;
            case 2:
                if (!isChip2) {
                    isChip2 = true;
                    selectedChip(chip2, true);
                } else {
                    isChip2 = false;
                    selectedChip(chip2, false);
                }
                break;
          /*  case 3:
                if (!isChip3) {
                    isChip3 = true;
                    selectedChip(chip3, true);
                } else {
                    isChip3 = false;
                    selectedChip(chip3, false);
                }
                break;*/
            default:
                break;
        }
    }

    private void selectedChip(Chip chipType, boolean isSelected) {
        if (isSelected) {
            chipType.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.textColor)));
        } else {
            chipType.setChipBackgroundColor(ColorStateList.valueOf(Color.WHITE));
        }
    }

    @Override
    public void onClick(View view) {
        if (!isChip1 && !isChip2) {
            Toast.makeText(MainActivity.this, "Please select atleast one", Toast.LENGTH_SHORT).show();
        } else {
            if (isChip1 && isChip2) {
                Log.e("chips=", "" + chip1.getText().toString() + "" + chip2.getText().toString());
            } else {
                if (isChip1) {
                    Log.e("chip1=", "" + chip1.getText().toString());
                } else if (isChip2) {
                    Log.e("chip2=", "" + chip2.getText().toString());
                } else {
                    Log.e("No VALUE====", "No VALUE====");
                }
            }
            finish();
        }
    }
}