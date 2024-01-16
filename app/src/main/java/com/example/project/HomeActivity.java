package com.example.project;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.Stacks.Stacks;
import com.example.project.model.RateUs;
import com.example.project.model.Tasks;
import com.example.project.retrofit.RateUsApi;
import com.example.project.retrofit.RetrofitService;
import com.example.project.retrofit.TasksApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView nav;
    Dialog dialogAnimated_calendar;
    ImageButton img_btn;
    TextView username_tv;
    ImageButton img_btn_close;
    Button btn_save;
    SeekBar seekBar_water;
    SeekBar seekBar_sleep;
    SeekBar seekBar_meals;
    SeekBar seekBar_showers;
    SeekBar seekBar_snacks;
    ImageButton img_btn_save;
    String string_water;
    int int_water;

    String string_hours_sleep;
    int int_hours_sleep;

    String string_meals_number;
    int int_meals_number;

    String string_shower;
    int int_shower;

    String string_snacks;
    int int_snacks;

    String userrname;
    CalendarView calendarView;
    Date calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();/*
        dialogAnimated_calendar = new Dialog(this, R.style.dialogstyle);
        dialogAnimated_calendar.setContentView(R.layout.activity_calendar);*/
        seekBar_water = findViewById(R.id.seekBar_water);
        seekBar_sleep = findViewById(R.id.seekBar_sleep);
        seekBar_meals = findViewById(R.id.seekBar_meals);
        seekBar_showers = findViewById(R.id.seekBar_showers);
        seekBar_snacks = findViewById(R.id.seekBar_snacks);
        img_btn_save = findViewById(R.id.imageButton_save);
        username_tv = findViewById(R.id.editTextTextPersonName);
        String username = Stacks.peekUsernameStack();
        username_tv.setText(username);
       /* img_btn_close = (ImageButton)dialogAnimated_calendar.findViewById(R.id.imageButton_close);*/
/*
        img_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialogAnimated_calendar.show();
            }
        });
*/


        seekBar_water.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                string_water = String.valueOf(progress);
                int_water = Integer.parseInt(string_water);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBar_sleep.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                string_hours_sleep = String.valueOf(progress);
                int_hours_sleep = Integer.parseInt(string_hours_sleep);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_snacks.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                string_snacks = String.valueOf(progress);
                int_snacks = Integer.parseInt(string_snacks);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_showers.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                string_shower = String.valueOf(progress);
                int_shower = Integer.parseInt(string_shower);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_meals.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                string_meals_number = String.valueOf(progress);
                int_meals_number = Integer.parseInt(string_meals_number);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        img_btn_save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                RetrofitService retrofitService = new RetrofitService();
                TasksApi tasksApi = retrofitService.getRetrofit().create(TasksApi.class);

                Tasks tasks = new Tasks();
                tasks.setWater_liters(int_water);
                tasks.setUsername(username);
                tasks.setHours_sleep(int_hours_sleep);
                tasks.setShowers(int_shower);
                tasks.setSnacks(int_snacks);
                tasks.setMeals_number(int_meals_number);
                tasksApi.save(tasks)

                        .enqueue(new Callback<Tasks>() {
                            @Override
                            public void onResponse(Call<Tasks> call, Response<Tasks> response) {

                                Toast.makeText(HomeActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onFailure(Call<Tasks> call, Throwable t) {
                                /*Toast.makeText(
                                        AccountActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(AccountActivity.class.getName()).log(Level.SEVERE, "Eroare aparuta", t);*/
                            }
                        });
            }
        });

       /* img_btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialogAnimated_calendar.dismiss();
            }
        });*/
        nav=findViewById(R.id.bottomNavigationView);
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

    }
}