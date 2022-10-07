package com.example.numrandom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
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

        //Crear tabla
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.FILL_PARENT));
        tableLayout.setColumnStretchable(2, true);
        //Cabecera
        TableRow cabecera = new TableRow(this);
        cabecera.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tableLayout.addView(cabecera);

        String cabeceras[] = { "Jugador", "Intentos"};
        for (int i = 0; i < cabeceras.length; i++)
        {
            TextView columna = new TextView(this);
            columna.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            columna.setText(cabeceras[i]);
            columna.setTextColor(Color.parseColor("#005500"));
            columna.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26);
            columna.setGravity(Gravity.CENTER_HORIZONTAL);
            columna.setPadding(5, 5, 5, 5);
            cabecera.addView(columna);
        }

        setContentView(tableLayout);



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