package com.example.lab4_q1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnClick;
    ToggleButton toggleBtn;
    View toastLayout;
    ImageView toastImage;
    TextView toastText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnClick = findViewById(R.id.btnClick);
        toggleBtn = findViewById(R.id.toggleBtn);


        btnClick.setOnClickListener(v -> {
                    showToast("Button Clicked", R.drawable.zebra);
                }
        );
        toggleBtn.setOnClickListener(v -> {
            if (toggleBtn.isChecked()) {
                showToast("Toggle ON", R.drawable.panda);
            } else {
                showToast("Toggle OFF", R.drawable.rat);
            }

        });
    }

        private void showToast(String msg, int img){
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast, null);

            toastImage = layout.findViewById(R.id.toastImage);
            toastText = layout.findViewById(R.id.toastText);
            toastText.setText(msg);
            toastImage.setImageResource(img);
            Toast toast = new Toast(MainActivity.this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}