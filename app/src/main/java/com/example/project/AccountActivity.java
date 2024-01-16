package com.example.project;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.Stacks.Stacks;
import com.example.project.model.RateUs;
import com.example.project.model.UsersDetails;
import com.example.project.retrofit.RateUsApi;
import com.example.project.retrofit.RetrofitService;
import com.example.project.retrofit.UsersDetailsApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountActivity extends AppCompatActivity {

    BottomNavigationView nav;
    TextView textview_user;
    TextView textView_logout;
    TextView username_tv;
    RatingBar ratingBar;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().hide();
        username_tv = findViewById(R.id.editTextTextPersonName);
        String username = Stacks.peekUsernameStack();
        username_tv.setText(username);
        nav=findViewById(R.id.bottomNavigationView);
        ratingBar = findViewById(R.id.ratingBar);
        textview_user=findViewById(R.id.textView_user);
        textView_logout=findViewById(R.id.textView_logout);
        imageButton=findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                int int_rating = Math.round(rating);
                RetrofitService retrofitService = new RetrofitService();
                RateUsApi rateUsApi = retrofitService.getRetrofit().create(RateUsApi.class);
                RateUs rateUs = new RateUs();
                rateUs.setUsername(username);
                /*if(!Stacks.IsUsernameRateUsStackEmpty()) {

                    rateUs.setUsername(username);
                    username_tv.setText(username);}*/

                rateUs.setRating(int_rating);
                rateUsApi.save(rateUs)

                        .enqueue(new Callback<RateUs>() {
                            @Override
                            public void onResponse(Call<RateUs> call, Response<RateUs> response) {

                                Toast.makeText(AccountActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onFailure(Call<RateUs> call, Throwable t) {
                                /*Toast.makeText(
                                        AccountActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(AccountActivity.class.getName()).log(Level.SEVERE, "Eroare aparuta", t);*/
                            }
                        });
            }
        });



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
        textview_user.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(), UserActivity.class));
            }
        });
        textView_logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}