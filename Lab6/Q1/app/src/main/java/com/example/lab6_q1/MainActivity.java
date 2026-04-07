package com.example.lab6_q1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle, tvContent;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        tvContent = findViewById(R.id.tvContent);
        imageView = findViewById(R.id.imageView);

        tvTitle.setText("XYZ Fitness Center");
        tvContent.setText("Welcome to XYZ Fitness Center.\nSelect a menu option to view details.");
        imageView.setImageResource(R.drawable.fitness_banner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_workout) {
            tvTitle.setText("Workout Plans");
            tvContent.setText(
                    "1. Weight Loss Program\n" +
                            "2. Cardio Training\n" +
                            "3. Strength Training\n" +
                            "4. Muscle Gain Program\n" +
                            "5. Yoga and Flexibility"
            );
            imageView.setImageResource(R.drawable.fitness_banner);
            return true;
        }

        else if (id == R.id.menu_trainers) {
            tvTitle.setText("Our Trainers");
            tvContent.setText(
                    "1. Rahul Sharma - Weight Training Specialist\n" +
                            "2. Neha Verma - Cardio & Aerobics Coach\n" +
                            "3. Aman Singh - Yoga Instructor\n" +
                            "4. Priya Das - Nutrition & Fitness Expert"
            );
            imageView.setImageResource(R.drawable.trainer);
            return true;
        }

        else if (id == R.id.menu_membership) {
            tvTitle.setText("Membership Packages");
            tvContent.setText(
                    "Basic Plan  : Rs. 1000 / month\n" +
                            "Standard Plan: Rs. 2500 / 3 months\n" +
                            "Premium Plan : Rs. 4500 / 6 months\n" +
                            "Annual Plan  : Rs. 8000 / year"
            );
            imageView.setImageResource(R.drawable.fitness_banner);
            return true;
        }

        else if (id == R.id.menu_home) {
            tvTitle.setText("Homepage");
            tvContent.setText(
                    "Welcome to XYZ Fitness Center.\n" +
                            "We provide world-class fitness training, certified trainers, and flexible membership packages."
            );
            imageView.setImageResource(R.drawable.fitness_banner);
            return true;
        }

        else if (id == R.id.menu_about) {
            tvTitle.setText("About Us");
            tvContent.setText(
                    "XYZ Fitness Center is dedicated to helping members achieve their health goals through personalized workouts, expert trainers, and modern fitness equipment."
            );
            imageView.setImageResource(R.drawable.fitness_banner);
            return true;
        }

        else if (id == R.id.menu_contact) {
            tvTitle.setText("Contact Us");
            tvContent.setText(
                    "XYZ Fitness Center\n" +
                            "MG Road, Bengaluru\n" +
                            "Phone: +91 9876543210\n" +
                            "Email: xyzfitness@gmail.com"
            );
            imageView.setImageResource(R.drawable.fitness_banner);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}