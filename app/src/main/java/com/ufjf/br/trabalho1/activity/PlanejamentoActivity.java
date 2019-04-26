package com.ufjf.br.trabalho1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ufjf.br.trabalho1.R;

public class PlanejamentoActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamento);
        Button botaoSalvarPlanejamento = findViewById(R.id.buttonSalvarPlanejamento);
        botaoSalvarPlanejamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editAno = findViewById(R.id.edt_Ano);
                EditText editSemestre = findViewById(R.id.edt_Semestre);
                EditText editPercDiscCurs = findViewById(R.id.edt_PorcetagemDisciplinaCursadas);
                EditText editTotalHComp = findViewById(R.id.edt_totalHorasComputadas);
                EditText editPercHAtv = findViewById(R.id.edt_PorcetagemHorasAtividades);
                Integer ano = Integer.parseInt(editAno.getText().toString());

            }
        });

    }
}
