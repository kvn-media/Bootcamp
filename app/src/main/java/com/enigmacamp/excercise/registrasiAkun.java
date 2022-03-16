package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registrasiAkun extends AppCompatActivity {

    EditText editEmail, editPassword, editPassword2;
    Button tombolKirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_akun);

        editEmail = (EditText) findViewById(R.id.editTextEmail);
        editPassword = (EditText) findViewById(R.id.editTextPassword);
        editPassword2 = (EditText) findViewById(R.id.editTextPassword2);

        tombolKirim = (Button) findViewById(R.id.buttonKirim);
        tombolKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                String password2 = editPassword2.getText().toString();

                if (email.trim().equals("")) {
                    Toast.makeText(getApplication(), "Email harus di isi",
                            Toast.LENGTH_SHORT).show();
                    editEmail.requestFocus();
                    return;
                }

                if (password.trim().length() < 6) {
                    Toast.makeText(getApplication(), "Password harus > 5 karakter",
                            Toast.LENGTH_SHORT).show();
                    editPassword.requestFocus();
                    return;
                }

                if (password2.trim().length() < 6) {
                    Toast.makeText(getApplication(), "Password harus > 5 karakter",
                            Toast.LENGTH_SHORT).show();
                    editPassword2.requestFocus();
                    return;
                }

                if (!password.equals(password2)) {
                    Toast.makeText(getApplication(), "Kedua password harus sama",
                            Toast.LENGTH_SHORT).show();
                    editPassword.requestFocus();
                    return;
                }

                else
                    Toast.makeText(getApplication(),
                            "Yup! Registrasi sudah dilakukan",
                            Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}