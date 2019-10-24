package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {
    EditText emailId,password;
    Button btnSignup;
    Button tvSignup;
    TextView cardInfo;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth =FirebaseAuth.getInstance();
        emailId=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        cardInfo=findViewById(R.id.cardInfo);
        btnSignup=findViewById(R.id.button);
        tvSignup=findViewById(R.id.button2);
        btnSignup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String email= emailId.getText().toString();
                String pwd = password.getText().toString();
                if(email.isEmpty()){
                    emailId.setError("Please enter Email Id");
                    emailId.requestFocus();
                }
                else if(pwd.isEmpty()){
                    password.setError("Please Enter your Password");
                    password.requestFocus();

                }

                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(SignupActivity.this,"Fields Are Empty"
                            ,Toast.LENGTH_SHORT).show();
                }

                else if (!(email.isEmpty()&& pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(SignupActivity.this,"SignUp Unsuccessful Please Try Again"
                                        ,Toast.LENGTH_SHORT).show();
                            }
                            else{
                                startActivity(new Intent(SignupActivity.this,HomeActivity.class));
                            }
                        }
                    });
                }

                else{
                    Toast.makeText(SignupActivity.this,"Error Ocurred"
                            ,Toast.LENGTH_SHORT).show();
                }

            }

        });
        tvSignup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i=  new Intent(SignupActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        cardInfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i= new Intent(SignupActivity.this,cardInfoActivity.class);
                startActivity(i);
            }
        });


    }
    }

