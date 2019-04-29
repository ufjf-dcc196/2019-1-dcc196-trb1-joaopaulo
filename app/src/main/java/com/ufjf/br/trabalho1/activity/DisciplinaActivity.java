package com.ufjf.br.trabalho1.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ufjf.br.trabalho1.model.Disciplina;


public class DisciplinaActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamento);
        Button botaoSalvarDisciplina = findViewById(R.id.buttonSalvarDisciplina);
        botaoSalvarDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTitulo = findViewById(R.id.edt_Titulo);
                EditText editHoras = findViewById(R.id.edt_horas);
                EditText editArea = findViewById(R.id.edt_Area);
                String titulo = editTitulo.getText().toString();
                String area = editArea.getText().toString();
                Integer horas = Integer.parseInt(editHoras.getText().toString());
                Disciplina disciplina = new Disciplina(horas, titulo, area);
                Intent intent = new Intent();
                intent.putExtra("disciplina", disciplina);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
