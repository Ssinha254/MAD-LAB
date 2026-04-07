package com.example.lab7_q2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView menuIcon, mainImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        menuIcon = findViewById(R.id.menuIcon);
        mainImage = findViewById(R.id.mainImage);
        menuIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, menuIcon);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(item ->{
                    if(item.getItemId() == R.id.image1){
                        mainImage.setImageResource(R.drawable.image1);
                        Toast.makeText(MainActivity.this,"Image 1", Toast.LENGTH_SHORT);
                        return true;
                    }
                    if (item.getItemId() == R.id.image2) {

                        mainImage.setImageResource(R.drawable.image2);
                        Toast.makeText(MainActivity.this,"Image-2", Toast.LENGTH_SHORT);
                        return true;
                    }
                    return false;
                });
                popupMenu.show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}