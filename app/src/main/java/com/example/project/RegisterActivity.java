package com.example.project;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.Stacks.Stacks;
import com.example.project.model.Users;
import com.example.project.retrofit.RetrofitService;
import com.example.project.retrofit.UsersApi;
import com.example.project.Stacks.Stacks;
import com.example.project.model.Users;
import com.example.project.retrofit.RetrofitService;
import com.example.project.retrofit.UsersApi;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {
    TextInputEditText username_input;
    EditText password_input, repassword_input;
    EditText email_input;

    TextInputEditText username1;
    EditText  password1, repassword1, email1;
    TextView login;
    DBHelper DB;
    Button register;

    ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        login = findViewById(R.id.alreadyHaveAccount);
        getSupportActionBar().hide();

        username1=findViewById(R.id.inputUsername);
        password1=findViewById(R.id.inputPassword);
        repassword1=findViewById(R.id.inputConfirmPassword);
        email1=findViewById(R.id.inputEmail);
        register=findViewById(R.id.btnregister);
        imageView1=findViewById(R.id.imageView8);
        imageView2=findViewById(R.id.imageView9);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        DB = new DBHelper(this);
        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                initializeComponents();

            }});
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repassword1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });

        /*imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                repassword1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

            }
        });*/
        // password1.setTransformationMethod(PasswordTransformationMethod.getInstance());
        // repassword1.setTransformationMethod(PasswordTransformationMethod.getInstance());


    }
    private void insertLocal()
    {
        Boolean checkuser = DB.checkusername(username1.getText().toString());

        if(TextUtils.isEmpty(username1.getText().toString()) || TextUtils.isEmpty(email1.getText().toString()) || TextUtils.isEmpty(password1.getText().toString()) || TextUtils.isEmpty(repassword1.getText().toString()))
        {
            Toast.makeText(RegisterActivity.this, "All fields Required", Toast.LENGTH_SHORT).show();
        }
        else
        //               else Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
        {
            if(password1.getText().toString().equals(repassword1.getText().toString()))
            {

                if(checkuser == false)
                {
                    Boolean insert = DB.insertData(username1.getText().toString(), email1.getText().toString(), password1.getText().toString());
                    if(insert == true)
                    {
                      /* Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, HomeActivity.class));*/
                    }
                    else  Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
                else  Toast.makeText(RegisterActivity.this, "That username’s been taken. I guess great minds really do think alike.", Toast.LENGTH_SHORT).show();
            }
            else  Toast.makeText(RegisterActivity.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
        }
    }

    private void initializeComponents () {
        username_input = findViewById(R.id.inputUsername);
        email_input = findViewById(R.id.inputEmail);
        password_input = findViewById(R.id.inputPassword);
        repassword_input = findViewById(R.id.inputConfirmPassword);
        register = findViewById(R.id.btnregister);
        RetrofitService retrofitService = new RetrofitService();
        UsersApi usersApi = retrofitService.getRetrofit().create(UsersApi.class);
        register.setOnClickListener(view -> {
            String username = username_input.getText().toString();
            Stacks.pushToUsernameStack(username);
            Stacks.pushToUsernameCalculatorStack(username);
            Stacks.pushToUsernameRateUsStack(username);
            String email = email_input.getText().toString();
            String password = password_input.getText().toString();
            String repassword = repassword_input.getText().toString();
            Users user = new Users();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setRepassword(repassword);
            insertLocal();
            usersApi.save(user)

                    .enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {

                            Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                        }
                        @Override
                        public void onFailure(Call<Users> call, Throwable t) {
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                               //Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                          //  Logger.getLogger(RegisterActivity.class.getName()).log(Level.SEVERE, "Eroare aparuta", t);
                        }
                    });

        });
    }

}