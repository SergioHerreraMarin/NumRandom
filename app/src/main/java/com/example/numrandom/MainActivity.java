package com.example.numrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();

        Random random = new Random();
        Button button = findViewById(R.id.button2);

        final int numRandom = random.nextInt(11);

        EditText inputText = findViewById(R.id.inputText);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String message = "";
                Editable editable = inputText.getText();
                int userNum = Integer.parseInt(editable.toString());

                if(userNum < numRandom){
                    message = "El número es más grande";
                }else if(userNum > numRandom){
                    message = "El número es más pequeño";
                }else{
                    message = "Acertaste el número";
                }

                Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
                toast.show();
            }
        });





    }
}