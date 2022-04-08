package com.example.gymdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import org.jetbrains.annotations.NotNull;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView email,password;
    private MaterialButton loginbtn,regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();


         email =  findViewById(R.id.email);
         password =  findViewById(R.id.password);
         loginbtn = findViewById(R.id.loginbtn);
         regbtn = findViewById(R.id.regbtn);



        //redirection pour inscription
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);



            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().isEmpty()){
                    email.setError("pseudo requis !");
                    email.requestFocus();
                    return;
                }

                if(password.getText().toString().trim().isEmpty()){
                    password.setError("mdp requis !");
                    password.requestFocus();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email.getText().toString().trim(),password.getText().toString().trim())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            startActivity(new Intent(Login.this,MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(Login.this,"Connexion échouée",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });



    }
}
