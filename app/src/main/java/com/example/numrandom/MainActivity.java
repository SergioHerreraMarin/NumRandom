package com.example.numrandom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int numIntentos = 0;
    private int minNumIntentos = 100;
    private int numRandom;
    private TextView textIntentos;
    private TextView textResult;
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();

        numRandom = random.nextInt(11);

        Button button = findViewById(R.id.button2);
        Button buttonRanking = findViewById(R.id.buttonRanking);
        EditText inputText = findViewById(R.id.inputText);
        textResult = findViewById(R.id.textresult);
        textIntentos = findViewById(R.id.textIntentos);
        textResult.setMovementMethod(new ScrollingMovementMethod());

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Has adivinado el número").setTitle("CORRECTO").setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resetGame();
                    }
                });

                AlertDialog dialog = builder.create();

                String message = "";
                Editable editable = inputText.getText();
                int userNum = Integer.parseInt(editable.toString());
                inputText.setText("");

                if(userNum < numRandom){
                    message = "El número " + userNum + " es más pequeño";
                }else if(userNum > numRandom){
                    message = "El número " + userNum + " es más grande";
                }else{
                    message = "Acertaste el número!";
                    dialog.show();
                }

                numIntentos++;
                textIntentos.setText("Intentos: " + numIntentos);
                textResult.append(message + "\n");


                Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
                toast.show();


            }
        });


        buttonRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Ranking.class);
                intent.putExtra("minIntentos",minNumIntentos ); //pasar valores
                startActivity(intent);
            }
        });

    }


    private void resetGame(){
        numRandom = random.nextInt(11);
        if(numIntentos < minNumIntentos){
            minNumIntentos = numIntentos;
        }
        numIntentos = 0;
        textIntentos.setText("Intentos: " + numIntentos);
        textResult.setText("");
    }
}