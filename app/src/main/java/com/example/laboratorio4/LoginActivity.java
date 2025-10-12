package com.example.laboratorio4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editUsuario, editContrasena;
    Button btnIngresar, btnIngresarSinCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsuario = findViewById(R.id.editUsuario);
        editContrasena = findViewById(R.id.editContrasena);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresarSinCuenta = findViewById(R.id.btnIngresarSinCuenta);

        btnIngresar.setOnClickListener(v -> startMain());
        btnIngresarSinCuenta.setOnClickListener(v -> startMain());
    }

    private void startMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
