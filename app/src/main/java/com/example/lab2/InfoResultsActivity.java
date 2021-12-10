package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_results);

        Intent intent = getIntent();
        String season= intent.getStringExtra("season");
        int temperature=intent.getIntExtra("temperature", 70); //if no int value exists then the method returns the default value
        String allergies = intent.getStringExtra("allergies");

        TextView txtSeason = (TextView) findViewById(R.id.txtSeason);
        TextView txtTemperature = (TextView) findViewById(R.id.txtTemp);
        TextView txtAllergies = (TextView) findViewById(R.id.txtAllergies);
        txtSeason.setText("Your favorite season is "+season);
        txtTemperature.setText("Your favorite temperature is "+temperature);

        //Depending on whether the allergies are yes or no determines the output of this textbox
        if(allergies.equals("yes"))
            txtAllergies.setText("Sorry that you have allergies");
        else
            txtAllergies.setText("You don't have allergies");

        Button btnMain = (Button) findViewById(R.id.btnMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMain();
            }
        });
    }

    private void goMain() {
        Intent intent = new Intent(InfoResultsActivity.this, MainMenuActivity.class);
        this.startActivity(intent);
    }

}