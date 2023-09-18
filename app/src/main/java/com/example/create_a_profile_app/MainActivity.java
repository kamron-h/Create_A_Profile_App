package com.example.create_a_profile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button profile_button = findViewById(R.id.profile_button);

        TextInputEditText name_input_widget = findViewById(R.id.name_input);
        TextInputEditText age_input_widget = findViewById(R.id.age_input);
        RadioGroup radio_group_widget = findViewById(R.id.radio_group);
        CheckBox checkbox1_widget = findViewById(R.id.checkbox1);
        CheckBox checkbox2_widget = findViewById(R.id.checkbox2);

        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the input data
                String name = name_input_widget.getText().toString();
                String age = age_input_widget.getText().toString();
                int selectedRadioId = radio_group_widget.getCheckedRadioButtonId();
                boolean isCheckedCheckbox1 = checkbox1_widget.isChecked();
                boolean isCheckedCheckbox2 = checkbox2_widget.isChecked();

                // Check if the name and age are empty and provide default values if needed
                if (TextUtils.isEmpty(name)) {
                    name = "Guest"; // Default value if the name is empty
                }
                if (TextUtils.isEmpty(age)) {
                    age = "11"; // Default value if the age is empty
                }

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                // Pass the input data as extras to the intent
                intent.putExtra("name", name);
                intent.putExtra("age", age);
                intent.putExtra("selectedRadioId", selectedRadioId);
                intent.putExtra("isCheckedCheckbox1", isCheckedCheckbox1);
                intent.putExtra("isCheckedCheckbox2", isCheckedCheckbox2);

                startActivity(intent);
            }
        });
    }
}

