package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TakePictureActivity extends AppCompatActivity {
    private static final int IMAGE_CAPTURE_CODE = 1;
    private ImageView imageView;
    private Button  btnPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);

        imageView = findViewById(R.id.imgFavoriteItem);
        btnPic = findViewById(R.id.btnTakePic);

        btnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create an implicit intent to take a picture
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Call startActivityForResult to send the intent
                try {
                    startActivityForResult(intent, IMAGE_CAPTURE_CODE);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(TakePictureActivity.this, "Camera error", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
// If request succeeded, get thumbnail from the return intent
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_CAPTURE_CODE && resultCode == RESULT_OK) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bp);
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
        }
    }
}