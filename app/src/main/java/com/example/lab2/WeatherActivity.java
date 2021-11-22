package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class WeatherActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        RadioGroup tempGroup = (RadioGroup) findViewById(R.id.tempGroup);
        tempGroup.setOnCheckedChangeListener(this);
        Button btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(this);
    }

    //Options menu creation and listeners
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuMain:
                Intent intent = new Intent(WeatherActivity.this, MainMenuActivity.class);
                this.startActivity(intent);
                return true;
            case R.id.mnuSettings:
                Toast.makeText(this, R.string.construction, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnuExit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        TextView lblOut = (TextView) findViewById(R.id.lblOut);
        if (checkedId == R.id.btnDegF)
            lblOut.setText(getString(R.string.checkedIDF));
        else if (checkedId == R.id.btnDegC)
            lblOut.setText(getString(R.string.checkedIDC));
        else if (checkedId == R.id.btnDegK)
            lblOut.setText(getString(R.string.checkedIDK));
    }

    @Override
    public void onClick(View v) {

        //Get Resources for radio buttons, text boxes, and labels
        //Declare Variables
        RadioGroup btnGroup = (RadioGroup) findViewById(R.id.tempGroup);
        RadioButton btnFah = (RadioButton) findViewById(R.id.btnDegF);
        RadioButton btnCel = (RadioButton) findViewById(R.id.btnDegC);
        RadioButton btnKel = (RadioButton) findViewById(R.id.btnDegK);
        EditText txtInputTemp = (EditText) findViewById(R.id.plaintextEnterTemp);
        TextView lblOutputDegF = (TextView) findViewById(R.id.textViewFahOut);
        TextView lblOutputDegC = (TextView) findViewById(R.id.textViewCelOut);
        TextView lblOutputDegK = (TextView) findViewById(R.id.textViewKelOut);
        //Convert the input temperature to double
        //String variables to hold concatenated temp values to send to setText()
        double temp;
        String tempF;
        String tempC;
        String tempK;
        //Check if there is any input to parse, to avoid crashing
        try{
            temp = Double.parseDouble(String.valueOf(txtInputTemp.getText()));
        }catch (NumberFormatException e){
            Toast.makeText(this, getString(R.string.weatherError1), Toast.LENGTH_LONG).show();
            return;
        }
        double answer = 0;

        //If the user choose Fahrenheit, convert to Celsius and Kelvin and display in those text boxes
        if(btnFah.isChecked()) {
            tempF = temp + getString(R.string.tempOutputF);
            tempC = (Math.round((temp - 32) * 5 / 9 * 100.0) / 100.0) + getString(R.string.tempOutputC);
            tempK = (Math.round((temp + 459.67) * 5 / 9 * 100.0) / 100.0) + getString(R.string.tempOutputK);
            lblOutputDegF.setText(tempF);
            lblOutputDegC.setText(tempC);
            lblOutputDegK.setText(tempK);
            answer = (temp - 32) * 5 / 9;
        }

        //If the user choose Celsius, convert to Fahrenheit and Kelvin and display in those text boxes
        if(btnCel.isChecked()) {
            tempF = (Math.round(((temp * 9) / 5 + 32) * 100.0) / 100.0) + getString(R.string.tempOutputF);
            tempC = temp + getString(R.string.tempOutputC);
            tempK = (Math.round((temp + 273.15) * 100.0) / 100.0) + getString(R.string.tempOutputK);
            lblOutputDegF.setText(tempF);
            lblOutputDegC.setText(tempC);
            lblOutputDegK.setText(tempK);
            answer = temp;
        }

        //If the user choose Kelvin, convert to Fahrenheit and Celsius and display in those text boxes
        if(btnKel.isChecked()) {
            tempF = (Math.round((temp * 9 / 5 - 459.67) * 100.0) / 100.0) + getString(R.string.tempOutputF);
            tempC = (Math.round((temp - 273.15) * 100.0) / 100.0) + getString(R.string.tempOutputC);
            tempK = temp + getString(R.string.tempOutputK);
            lblOutputDegF.setText(tempF);
            lblOutputDegC.setText(tempC);
            lblOutputDegK.setText(tempK);
            answer = temp-273.15;
        }

        if(btnGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, getString(R.string.weatherError2), Toast.LENGTH_LONG).show();
        }else{
            displayToast(answer);
        }
    }

    private void displayToast(double temperature){
        if(temperature > 50)
            Toast.makeText(this, getString(R.string.tempToastF), Toast.LENGTH_LONG).show();
        else if(temperature > 20)
            Toast.makeText(this, getString(R.string.tempToastC), Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, getString(R.string.tempToastK), Toast.LENGTH_LONG).show();
    }
}
