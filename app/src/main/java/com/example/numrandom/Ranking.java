package com.example.numrandom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {

    private TextView minIntentosText;
    private int minNumIntentos;
    private Button buttonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        minIntentosText = findViewById(R.id.textViewMinIntentos);
        minIntentosText.setText("");

        ordenarRanking(MainActivity.recordsList);

        for(Record record : MainActivity.recordsList){
            minIntentosText.append(record.getUserName() + ": " + record.getPoints() + "\n");
        }

        buttonVolver = findViewById(R.id.buttonVolver);

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Ranking.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }

    private void ordenarRanking(ArrayList<Record> list){

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size() - 1; j++){

                if(list.get(j).getPoints() > list.get(j + 1).getPoints()){
                    Record record = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, record);
                }
            }
        }

    }


}