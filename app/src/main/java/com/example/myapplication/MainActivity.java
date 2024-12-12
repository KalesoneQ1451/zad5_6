package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button like;
    private Button delete;
    private Button zapisz;
    private Button pokaz;
    private TextView polub;
    private EditText mail;
    private EditText pass;
    private EditText repass;
    private TextView emails;
    private int count = 0;
    private String lastMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        like = findViewById(R.id.przcisk1);
        delete = findViewById(R.id.przcisk2);
        zapisz = findViewById(R.id.zapisz);
        pokaz = findViewById(R.id.pokaz);
        polub = findViewById(R.id.polub);
        mail = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);
        repass = findViewById(R.id.repass);
        emails = findViewById(R.id.emails);

        like.setOnClickListener(view ->{
            count++;
            polub.setText(count + " polubień");
        });
        delete.setOnClickListener(view ->{
            if (count > 0 ){
                count--;
            }
            polub.setText(count + " polubień");
        });
        String sprawdzMail = mail.getText().toString().trim();
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(sprawdzMail).matches()){
            emails.setText("Nie prawidłowy adres email");
        } else if (pass != repass) {
            emails.setText("Hasła się różnią");
        } else {
            emails.setText("Zarejestrowano " + mail);
            lastMail = sprawdzMail;
        }
        pokaz.setOnClickListener(view -> {
            emails.setText(lastMail);
        });
    }
}