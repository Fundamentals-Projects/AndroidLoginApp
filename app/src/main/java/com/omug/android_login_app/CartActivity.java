package com.omug.android_login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class CartActivity extends AppCompatActivity {
    ListView cartListView;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        back =findViewById(R.id.btnBack);
        cartListView = findViewById(R.id.lvShoppingCart);
        cartListView.setAdapter(new CartAdapter(this, DescriptionActivity.cartList));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(CartActivity.this, DescriptionActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}