package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetPasswordActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private Button ResetPassword;
    private EditText resetEmail;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        mAuth=FirebaseAuth.getInstance();

        ResetPassword= (Button) findViewById(R.id.resetPassword);
        resetEmail =(EditText) findViewById(R.id.TypeEmail);

        ResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail=  resetEmail.getText().toString();
                if (TextUtils.isEmpty(userEmail)){
                    Toast.makeText(resetPasswordActivity.this, "Please Enter Valid Email Address", Toast.LENGTH_SHORT).show();
                }

                else{
                    mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(resetPasswordActivity.this, "Check Your Email For Password Reset", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(resetPasswordActivity.this,MainActivity.class));
                            }

                            else{
                                String message= task.getException().getMessage();
                                Toast.makeText(resetPasswordActivity.this, "Error Occured",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
