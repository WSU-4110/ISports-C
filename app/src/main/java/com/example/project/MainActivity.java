package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.facebook.FacebookSdk;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
   private EditText emailId, password;
    private Button btnSignin;
    private Button tvSignin;
    private Button Facebook;
    private FirebaseAuth mFirebaseAuth;
    private TextView forgotPassword;
    private CheckBox mCheckBoxRemember;
    private SharedPreferences mPrefs;
    private static final String PREFS_NAME= "PrefsFile";

    private CheckBox showPassword;

    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editText);
        Facebook = findViewById(R.id.login_button);
        password = findViewById(R.id.editText2);
        btnSignin = findViewById(R.id.button);
        tvSignin = findViewById(R.id.button2);
        forgotPassword= findViewById(R.id.forgotPassword);
        mCheckBoxRemember= (CheckBox)findViewById(R.id.checkBoxRememberMe);
        showPassword=(CheckBox)findViewById(R.id.checkShowPassword);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(MainActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                }
            }
        };

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("Please enter Email Id");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please Enter your Password");
                    password.requestFocus();

                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields Are Empty"
                            , Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login Error, please Login Again"
                                        , Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intToHome = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Error Ocurred"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignup = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intSignup);
            }
        });


        Facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
            }

        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, resetPasswordActivity.class);
                startActivity(i);
            }





        });
        mPrefs= getSharedPreferences(PREFS_NAME, MODE_PRIVATE);



        if (mCheckBoxRemember.isChecked()){
            Boolean boolIsChecked= mCheckBoxRemember.isChecked();
            SharedPreferences.Editor editor= mPrefs.edit();
            editor.putString("pref_name",emailId.getText().toString());
            editor.putString("pref_pass",password.getText().toString());
            editor.putBoolean("pref_check",boolIsChecked);
            editor.apply();
            Toast.makeText(getApplicationContext(), "Settings Have been Saved", Toast.LENGTH_SHORT).show();
        }
        else{
            mPrefs.edit().clear().apply();
        }

        emailId.getText().clear();
        password.getText().clear();


        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }

                else{
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }
        });

    }


    private void getPreferencesData(){
        SharedPreferences sp=getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        if(sp.contains("pref_name")){
            String u=sp.getString("pref_name","not found");
            emailId.setText(u.toString());

        }


        if(sp.contains("pref_pass")){
            String p=sp.getString("pref_pass","not found");
            password.setText(p.toString());
        }

        if(sp.contains("pref_check")){
            Boolean b=sp.getBoolean("pref_check", false);
            mCheckBoxRemember.setChecked(b);
        }

        };




            @Override
            protected void onStart() {
                super.onStart();
                mFirebaseAuth.addAuthStateListener(mAuthStateListener);
            }


    }




