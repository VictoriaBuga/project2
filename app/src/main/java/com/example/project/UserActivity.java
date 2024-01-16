package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.Stacks.Stacks;
import com.example.project.model.UsersDetails;
import com.example.project.retrofit.RetrofitService;
import com.example.project.retrofit.UsersDetailsApi;
import com.example.project.Stacks.Stacks;
import com.example.project.model.UsersDetails;
import com.example.project.retrofit.RetrofitService;
import com.example.project.retrofit.UsersDetailsApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    BottomNavigationView nav;
    EditText username_input;
    EditText email_input;
    EditText phone_input;
    EditText name_input;
    EditText age_input;
    EditText country_input;
    EditText weight_input;
    EditText height_input;
    EditText gender_input;
    TextView username_tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        getSupportActionBar().hide();
        btn = findViewById(R.id.button);
        nav=findViewById(R.id.bottomNavigationView);
        username_tv = findViewById(R.id.editTextTextPersonName);
        String username = Stacks.peekUsernameStack();
        username_tv.setText(username);
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
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
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                initializeComponents();
            }});
    }

    private void initializeComponents () {
        username_input = findViewById(R.id.editText_username);
        email_input = findViewById(R.id.editText_email);
        phone_input = findViewById(R.id.editText_phone);
        name_input = findViewById(R.id.editText_name);
        age_input = findViewById(R.id.editText_age);
        country_input = findViewById(R.id.editText_country);
        weight_input = findViewById(R.id.editText_weight);
        height_input = findViewById(R.id.editText_height);
        gender_input = findViewById(R.id.editText_gender);

        RetrofitService retrofitService = new RetrofitService();
        UsersDetailsApi usersDetailsApi = retrofitService.getRetrofit().create(UsersDetailsApi.class);
        btn.setOnClickListener(view -> {
            String username = username_input.getText().toString();
            Stacks.pushToUsernameStack(username);

            String email = email_input.getText().toString();
            Stacks.pushToEmailStack(email);

            String phone = phone_input.getText().toString();
            Stacks.pushToPhoneStack(phone);

            String name = name_input.getText().toString();
            Stacks.pushToNameStack(name);

            String age_string = age_input.getText().toString();
            int age = Integer.parseInt(age_string);
            Stacks.pushToAgeStack(age);

            String country = country_input.getText().toString();
            Stacks.pushToCountryStack(country);

            String weight_string = weight_input.getText().toString();
            int weight = Integer.parseInt(weight_string);
            Stacks.pushToWeightStack(weight);

            String gender = gender_input.getText().toString();
            Stacks.pushToGenderStack(gender);

            String height_string = height_input.getText().toString();
            int height = Integer.parseInt(height_string);
            Stacks.pushToHeightStack(height);

            UsersDetails usersDetails = new UsersDetails();
            usersDetails.setName_user(name);
            usersDetails.setAge(age);
            usersDetails.setCountry(country);
            usersDetails.setEmail_login(email);
            usersDetails.setGender(gender);
            usersDetails.setHeight(height);
            usersDetails.setPhone(phone);
            usersDetails.setWeight(weight);
            //usersDetails.setUsername_login(username);
            usersDetailsApi.save(usersDetails)

                    .enqueue(new Callback<UsersDetails>() {
                        @Override
                        public void onResponse(Call<UsersDetails> call, Response<UsersDetails> response) {

                            Toast.makeText(UserActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onFailure(Call<UsersDetails> call, Throwable t) {
                              Toast.makeText(
                                      UserActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(UserActivity.class.getName()).log(Level.SEVERE, "Eroare aparuta", t);
                        }
                    });



        });
    }
}
