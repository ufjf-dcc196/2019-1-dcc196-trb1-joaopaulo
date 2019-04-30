package com.ufjf.br.trabalho1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ufjf.br.trabalho1.R;
import com.ufjf.br.trabalho1.model.Planejamento;

public class EditarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_planejamento);
        Bundle bundle = getIntent().getExtras();
        Planejamento planejamento = (Planejamento) bundle.get("planejamento");
        Button botaoSalvarPlanejamento = findViewById(R.id.buttonSalvarPlanejamento);
        EditText editAno = findViewById(R.id.edt_Ano);
        EditText editSemestre = findViewById(R.id.edt_Semestre);
        EditText editPercDiscCurs = findViewById(R.id.edt_PorcetagemDisciplinaCursadas);
        EditText editTotalHComp = findViewById(R.id.edt_totalHorasComputadas);
        EditText editPercHAtv = findViewById(R.id.edt_PorcetagemHorasAtividades);
        editAno.setText(planejamento.getAno());
        editSemestre.setText(planejamento.getSemestre());
        editPercDiscCurs.setText(planejamento.getPorcentagemDisciplinaCursadas().toString());
        editTotalHComp.setText(planejamento.getTotalHorasComputadas().toString());
        editPercHAtv.setText(planejamento.getPorcentagemHoras().toString());
        botaoSalvarPlanejamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editAno = findViewById(R.id.edt_Ano);
                EditText editSemestre = findViewById(R.id.edt_Semestre);
                EditText editPercDiscCurs = findViewById(R.id.edt_PorcetagemDisciplinaCursadas);
                EditText editTotalHComp = findViewById(R.id.edt_totalHorasComputadas);
                EditText editPercHAtv = findViewById(R.id.edt_PorcetagemHorasAtividades);
                Integer ano = Integer.parseInt(editAno.getText().toString());
                String semestre = editSemestre.getText().toString();
                Double percDiscCurs = Double.parseDouble(editPercDiscCurs.getText().toString());
                Double totalHComp = Double.parseDouble(editTotalHComp.getText().toString());
                Double percHAtv = Double.parseDouble(editPercHAtv.getText().toString());
                Planejamento planejamento = new Planejamento(ano, semestre, percDiscCurs, totalHComp, percDiscCurs);
                Intent intent = new Intent();
                intent.putExtra("planejamento", planejamento);
                setResult(Activity.RESULT_OK, intent);
                finish();

            }
        });


    }
}
