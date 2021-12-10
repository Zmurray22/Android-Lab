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
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Add a listener to the button to take you to the temp converter
        Button btnWeather= findViewById(R.id.btnWeather);
        btnWeather.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              goWeather();
                                          }
                                      }
        );

        //Add a listener to the button to take you to the image activity
        Button btnDraw= findViewById(R.id.btnDraw);
        btnDraw.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              goDraw();
                                          }
                                      }
        );

        //Add a listener to the button to take you to the image activity
        Button btnTic = findViewById(R.id.btnTicTacToe);
        btnTic.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           goTicTacToe();
                                       }
                                   }
        );

        Button btnInfo=(Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           goInfo();
                                       }
                                   }
        );

        Button btnPic=(Button) findViewById(R.id.btnTakePic);
        btnPic.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           goTakePic();
                                       }
                                   }
        );

        Button btnSong=(Button) findViewById(R.id.btnFavSong);
        btnSong.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           goSong();
                                       }
                                   }
        );

        //TODO: add listeners for other buttons
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
        //TODO: refactor to if statements for Gradle 8.0
        switch (item.getItemId()) {
            case R.id.mnuMain:
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

    private void goWeather() {
        Intent intent = new Intent(MainMenuActivity.this, WeatherActivity.class);
        this.startActivity(intent);
    }

    private void goDraw() {
        Intent intent = new Intent(MainMenuActivity.this, MyDrawingActivity.class);
        this.startActivity(intent);
    }

    //TODO: intents for other buttons
    /*goInfo*/
    private void goTicTacToe(){
        Intent intent = new Intent(MainMenuActivity.this, TicTacToeActivity.class);
        this.startActivity(intent);
    }

    private void goInfo() {
        Intent intent = new Intent(MainMenuActivity.this, InfoPageActivity.class);
        this.startActivity(intent);
    }

    private void goTakePic(){
        Intent intent = new Intent(MainMenuActivity.this, TakePictureActivity.class);
        this.startActivity(intent);
    }

    private void goSong(){
        Intent intent = new Intent(MainMenuActivity.this, SongActivity.class);
        this.startActivity(intent);
    }

}