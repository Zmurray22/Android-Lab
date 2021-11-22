package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MyDrawingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_drawing);
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
                Intent intent = new Intent(MyDrawingActivity.this, MainMenuActivity.class);
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
}