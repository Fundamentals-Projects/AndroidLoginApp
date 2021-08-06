package com.omug.android_login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {
    Button back, addCar;
    ImageView bigImage;
    TextView title, description, qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        back = findViewById(R.id.btnBackMain);
        bigImage = findViewById(R.id.bigImgPrd);
        description = findViewById(R.id.txtDescription);
        title = findViewById(R.id.txtProductName);
        qty = findViewById(R.id.txtQty);
        addCar = findViewById(R.id.btnAddCar);

        title.setText(MainActivity.prodList.get(MainActivity.index).getProductName());
        bigImage.setImageResource(MainActivity.prodList.get(MainActivity.index).getImage());
        description.setText(MainActivity.prodList.get(MainActivity.index).getDescription());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DescriptionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}