package com.example.gymdiary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.vishnusivadas.advanced_httpurlconnection.PutData;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity{

    private FirebaseAuth mAuth;
    private TextView username,password,email;
    private ProgressBar progressBar;
    private MaterialButton regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mAuth = FirebaseAuth.getInstance();




         username =  findViewById(R.id.username);
         password =  findViewById(R.id.password);
         email =  findViewById(R.id.email);
         progressBar =  findViewById(R.id.progress);
         regbtn =  findViewById(R.id.regbtnrredirect);



         regbtn.setOnClickListener(view -> {
             if(username.getText().toString().trim().isEmpty()){
                 username.setError("pseudo requis !");
                 username.requestFocus();
                 return;
             }

             if(password.getText().toString().trim().isEmpty()){
                 password.setError("mdp requis !");
                 password.requestFocus();
                 return;
             }

             if(email.getText().toString().trim().isEmpty()){
                 email.setError("email requis !");
                 email.requestFocus();
                 return;
             }
             if(Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()){
                 email.setError("veuillez entrer un mail valide");
                 email.requestFocus();
                 return;
             }
             if(password.getText().toString().trim().length() < 6 ){
                 password.setError("longueur Minimum de 6 chars svp...");
                 password.requestFocus();
                 return;
             }

             progressBar.setVisibility(View.VISIBLE);
             mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(),password.getText().toString().trim())
                     .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                             if(task.isSuccessful()){
                                 User user = new User(username.getText().toString().trim(),email.getText().toString().trim(),new ArrayList<>());

                                 FirebaseDatabase.getInstance("https://gymdiary-9aa40-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users")
                                         .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                         .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                             @Override
                                             public void onComplete(@NonNull @NotNull Task<Void> task) {


                                                 if(task.isSuccessful()){

                                                     Toast.makeText(Register.this,"Utilisateur a été inscrit avec succés",Toast.LENGTH_LONG).show();
                                                     progressBar.setVisibility(View.GONE);
                                                     startActivity(new Intent(getApplicationContext(),Login.class));
                                                     finish();
                                                 }else {
                                                     Toast.makeText(Register.this,"Erreur dans l'inscription, veuillez réesayer",Toast.LENGTH_LONG).show();
                                                     progressBar.setVisibility(View.GONE);
                                                 }
                                             }
                                         });
                             }else{
                                 Toast.makeText(Register.this,"Erreur dans l'inscription, veuillez réesayer",Toast.LENGTH_LONG).show();
                                 progressBar.setVisibility(View.GONE);
                             }
                         }
                     });

         });



    }
}



