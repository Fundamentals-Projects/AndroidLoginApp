package com.omug.android_login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView welcomeName;
    ListView prodListView;
    Button logout;
    public static List<Product> prodList = new ArrayList<>();
    public static int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prodList.clear();
        fillProducts();

        welcomeName = findViewById(R.id.txtUsername);
        prodListView = findViewById(R.id.lvProducts);
        logout = findViewById(R.id.btnLogOut);
        String clientName=getClient(LoginActivity.userNameNext,LoginActivity.clientList);
        welcomeName.setText(clientName);

        prodListView.setAdapter(new ProductAdapter(this, prodList));

        prodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index=position;
                Intent intent=new Intent(MainActivity.this,DescriptionActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }
        });

    }

    private void fillProducts() {
        prodList.add(new Product("Instapot", 78.99, R.mipmap.intapot, "This is a InstaPot", 10));
        prodList.add(new Product("AirFryer", 78.99, R.mipmap.airfryer, "This is a AirFryer", 5));
        prodList.add(new Product("Bags", 2.99, R.mipmap.bags, "This is a bunch of Bags", 9));
        prodList.add(new Product("Blender", 28.99, R.mipmap.blender, "This is a Blender", 7));
        prodList.add(new Product("Brita", 28.99, R.mipmap.brita, "This is a Brita", 8));
        prodList.add(new Product("Cupcakes Silicone", 2.99, R.mipmap.cupcakes, "This is a Cupcakes Silicone", 10));
        prodList.add(new Product("Pod Coffee Maker", 60.99, R.mipmap.podcofee, "This is a Pod Coffee Maker", 4));
        prodList.add(new Product("Salad Dryer", 1.99, R.mipmap.saladdryer, "This is a Salad Dryer", 2));
        prodList.add(new Product("Salad Spinner", 3.99, R.mipmap.spinner, "This is a Salad Spinner", 7));
        prodList.add(new Product("Toast Maker", 18.99, R.mipmap.toaste, "This is a Toast Maker", 8));
        prodList.add(new Product("Vacuum Cleaner", 40.50, R.mipmap.vacum, "This is a Vacuum Cleaner", 9));
    }

    public String getClient(String user,ArrayList<Client>clnts)
    {
        for(Client cln:clnts)
            if(cln.getUsername().equalsIgnoreCase(user))
                return cln.getName();
        return null;
    }
}