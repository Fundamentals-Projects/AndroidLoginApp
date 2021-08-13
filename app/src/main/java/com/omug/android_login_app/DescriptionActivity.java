package com.omug.android_login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {
    Button back, addCar, more, less, goToCar;
    ImageView bigImage;
    TextView title, description, qty, txtQuantityAvailable;
    public static List<Cart> cartList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        bigImage = findViewById(R.id.bigImgPrd);
        description = findViewById(R.id.txtDescription);
        title = findViewById(R.id.txtProductName);
        qty = findViewById(R.id.txtQty);
        txtQuantityAvailable = findViewById(R.id.textQtyAvailable);
        back = findViewById(R.id.btnBackMain);
        addCar = findViewById(R.id.btnAddCar);
        more = findViewById(R.id.btnMore);
        less = findViewById(R.id.btnLess);
        goToCar = findViewById(R.id.btnCart);

        title.setText(MainActivity.prodList.get(MainActivity.index).getProductName());
        bigImage.setImageResource(MainActivity.prodList.get(MainActivity.index).getImage());
        description.setText(MainActivity.prodList.get(MainActivity.index).getDescription());
        txtQuantityAvailable.setText("Cantidades disponibles " +String.valueOf(MainActivity.prodList.get(MainActivity.index).getQuantity()));

        back.setOnClickListener(new ButtonEvents());
        addCar.setOnClickListener(new ButtonEvents());
        more.setOnClickListener(new ButtonEvents());
        less.setOnClickListener(new ButtonEvents());
        goToCar.setOnClickListener(new ButtonEvents());

    }

    private class ButtonEvents implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int qtyNum = Integer.parseInt(qty.getText().toString());
            switch (v.getId()) {
                case R.id.btnBackMain:
                    Intent descIntent = new Intent(DescriptionActivity.this, MainActivity.class);
                    startActivity(descIntent);
                    break;
                case R.id.btnCart:
                    Intent cartIntent = new Intent(DescriptionActivity.this, CartActivity.class);
                    startActivity(cartIntent);
                    break;
                case R.id.btnMore:
                    if (qtyNum >= 0 && qtyNum <= 9)
                        qtyNum++;
                    qty.setText(String.valueOf(qtyNum));
                    break;
                case R.id.btnLess:
                    if (qtyNum >= 1)
                        qtyNum--;
                    qty.setText(String.valueOf(qtyNum));
                    break;
                case R.id.btnAddCar:
                    if (qtyNum == 0) {
                        Toast.makeText(getBaseContext(), "You must indicate a quantity", Toast.LENGTH_LONG).show();
                    } else {
                        Product product = MainActivity.prodList.get(MainActivity.index);
                        Cart cart = findProduct(product.getProductName());
                        if (null != cart) {
                            int qtyTemp = cart.getQty();
                            if((qtyNum + qtyTemp) > product.getQuantity()){
                                Toast.makeText(getBaseContext(), "no hay suficiente", Toast.LENGTH_LONG).show();
                            }else{
                                cartList.remove(cart);
                                cartList.add(new Cart(MainActivity.prodList.get(MainActivity.index), qtyNum + qtyTemp));
                            }
                        } else {
                            if((qtyNum) > product.getQuantity()){
                                Toast.makeText(getBaseContext(), "no hay suficiente", Toast.LENGTH_LONG).show();
                            }else{
                                cartList.add(new Cart(MainActivity.prodList.get(MainActivity.index), qtyNum));
                            }
                        }
                    }
                    break;
            }
        }
    }

    private Cart findProduct(String productName) {
        for (Cart cart : cartList) {
            if (cart.getProduct().getProductName().equalsIgnoreCase(productName))
                return cart;
        }
        return null;
    }
}