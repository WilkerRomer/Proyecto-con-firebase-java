package com.example.proyectofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registrarse extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText Correo;
    private EditText Contrasena;
    private EditText ContrasenaConfir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth = FirebaseAuth.getInstance();
        Correo = findViewById(R.id.Correo);
        Contrasena = findViewById(R.id.password);
        ContrasenaConfir = findViewById(R.id.Confir_passsword);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void RegistroUsuario(View ver){

        if (Contrasena.getText().toString().equals(ContrasenaConfir.getText().toString())){

            mAuth.createUserWithEmailAndPassword(Correo.getText().toString().trim(), Contrasena.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(getApplicationContext(), "Usuario Creado.", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i);
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                               // updateUI(null);
                            }

                            // ...
                        }
                    });

        }else{
            Toast.makeText(this, "La segunda contraseña no coinside con la primera", Toast.LENGTH_SHORT).show();
        }


    }
}