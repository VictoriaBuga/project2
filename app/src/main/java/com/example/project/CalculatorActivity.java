package com.example.project;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.Stacks.Stacks;
import com.example.project.model.Calculator;
import com.example.project.retrofit.CalculatorApi;
import com.example.project.retrofit.RetrofitService;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalculatorActivity extends AppCompatActivity {

    BottomNavigationView nav;
    Button btn_here;
    EditText height;
    EditText age;
    TextView rezultat;
    FloatingActionButton calcul;
    Dialog dialogAnimated_chart;
    ImageButton img_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().hide();
        nav = findViewById(R.id.bottomNavigationView);
        btn_here = findViewById(R.id.button_here);
        dialogAnimated_chart = new Dialog(this, R.style.dialogstyle);
        dialogAnimated_chart.setContentView(R.layout.activity_chart);
        height = findViewById(R.id.editTextTextPersonName_height);
        age = findViewById(R.id.editTextTextPersonName_age);
        rezultat = findViewById(R.id.textViewPersonName_rezultat);
        calcul = findViewById(R.id.floatingActionButton_calcul);
        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSum();
            }
        });
        img_btn = (ImageButton) dialogAnimated_chart.findViewById(R.id.imageButton_close);
        btn_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initializeComponents();
                dialogAnimated_chart.show();


            }
        });
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogAnimated_chart.dismiss();
            }
        });

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        // Toast.makeText(HomeActivity.this, "Home", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        break;
                    case R.id.calculator:
                        // Toast.makeText(HomeActivity.this, "Menu", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), CalculatorActivity.class));
                        break;

                    case R.id.account:
                        // Toast.makeText(HomeActivity.this, "Menu", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                        break;

                }
                return true;
            }
        });


    }
    private void calculateSum() {
        try {
            int number1 = Integer.parseInt(height.getText().toString());
            int number2 = Integer.parseInt(age.getText().toString());
            int sum = number1 - 10;
            rezultat.setText("Weight:" + sum);
            Stacks.pushToWeightCalculatorStack(sum);
        } catch (NumberFormatException e) {

        }
    }

    private void initializeComponents () {

        RetrofitService retrofitService = new RetrofitService();
        CalculatorApi calculatorApi = retrofitService.getRetrofit().create(CalculatorApi.class);
        btn_here.setOnClickListener(view -> {

            String username_stack =  Stacks.popFromUsernameCalculatorStack();

            int weight = Stacks.popFromWeightCalculatorStack();
            Stacks.pushToWeightCalculatorStack(weight);

            String height_string = height.getText().toString();
            int height = Integer.parseInt(height_string);
            Stacks.pushToAgeStack(height);

            String age_string = age.getText().toString();
            int age = Integer.parseInt(age_string);
            Stacks.pushToAgeStack(age);

            Calculator calculator = new Calculator();
            calculator.setAge(age);
            calculator.setHeight(height);
            calculator.setWeight(weight);
            calculator.setUsername_login(username_stack);
            calculatorApi.save(calculator)

                    .enqueue(new Callback<Calculator>() {
                        @Override
                        public void onResponse(Call<Calculator> call, Response<Calculator> response) {
                            Toast.makeText(CalculatorActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onFailure(Call<Calculator> call, Throwable t) {
                            //Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            // Logger.getLogger(CalculatorActivity.class.getName()).log(Level.SEVERE, "Eroare aparuta", t);
                        }
                    });



        });
    }
}