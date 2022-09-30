package com.example.numrandom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Ranking extends AppCompatActivity {

    private TextView minIntentosText;
    private int minNumIntentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        minIntentosText = findViewById(R.id.textViewMinIntentos);

        Intent intent = getIntent();
        minNumIntentos = intent.getIntExtra("minIntentos", 0);

        AlertDialog.Builder builder = new AlertDialog.Builder(Ranking.this);
        builder.setMessage("Quieres introducir la puntuación?").setTitle("Ranking").setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                minIntentosText.setText("MinIntentos: " + minNumIntentos);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                minIntentosText.setText("MinIntentos: " + 0);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}