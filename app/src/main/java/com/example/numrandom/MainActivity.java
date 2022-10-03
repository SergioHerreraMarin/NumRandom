package com.example.numrandom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Record> recordsList = new ArrayList<Record>();
    private int numIntentos = 0;
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

        Button buttonEnviar = findViewById(R.id.buttonEnviar);
        Button buttonRanking = findViewById(R.id.buttonRanking);
        EditText inputText = findViewById(R.id.inputText);
        textResult = findViewById(R.id.textresult);
        textIntentos = findViewById(R.id.textIntentos);
        textResult.setMovementMethod(new ScrollingMovementMethod());

        buttonEnviar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertaAcertado = new AlertDialog.Builder(MainActivity.this);
                alertaAcertado.setMessage("Has adivinado el número").setTitle("CORRECTO").setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        saveRanking();
                    }
                });

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
                    alertaAcertado.show();
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
                startActivity(intent);
            }
        });

    }


    private void resetGame(){
        numRandom = random.nextInt(11);
        numIntentos = 0;
        textIntentos.setText("Intentos: " + numIntentos);
        textResult.setText("");
    }


    private void saveRanking(){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("SAVE RANKING");
        alert.setMessage("¿Quieres introducir la puntuación?");
        EditText inputName = new EditText(this);
        alert.setView(inputName);

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Record userRecord =  new Record(inputName.getText().toString(), numIntentos);
                recordsList.add(userRecord);
                resetGame();
            }
        });

        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetGame();
            }
        });

        alert.show();
    }

}