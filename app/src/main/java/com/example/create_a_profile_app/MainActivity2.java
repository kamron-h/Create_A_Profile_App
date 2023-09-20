package com.example.create_a_profile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Retrieve data passed from MainActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        String selectedOption = intent.getStringExtra("selectedOption");
        boolean isCheckedCheckbox1 = intent.getBooleanExtra("isCheckedCheckbox1", false);
        boolean isCheckedCheckbox2 = intent.getBooleanExtra("isCheckedCheckbox2", false);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.profile_user);

        // Display the data (you can use TextViews or any other UI elements)
        TextView nameTextView = findViewById(R.id.nameTextView);
        nameTextView.setText("Name: " + name);

        TextView ageTextView = findViewById(R.id.ageTextView);
        ageTextView.setText("Age: " + age);

        // Display the selected option or perform any desired action
        TextView selectedOptionTextView = findViewById(R.id.genderTextView);
        selectedOptionTextView.setText("Selected Option: " + selectedOption);

        TextView interestCheckbox = findViewById(R.id.interestCheckboxTextView);
        String checkboxesText = "Interested in : ";
        if (isCheckedCheckbox1) {
            checkboxesText += "Interest 1, ";
        }
        if (isCheckedCheckbox2) {
            checkboxesText += "Interest 2 ";
        }
        interestCheckbox.setText(checkboxesText);

        Button home_button = findViewById(R.id.home_button);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
