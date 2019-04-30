package com.ufjf.br.trabalho1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ufjf.br.trabalho1.R;
import com.ufjf.br.trabalho1.adapter.DisciplinaAdapter;
import com.ufjf.br.trabalho1.model.Disciplina;

import java.util.List;

public class DetalheActivity extends AppCompatActivity {

    public static final int REQUEST_DISCIPLINA = 1;
    private DisciplinaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Disciplina> itens = Disciplina.getDataSample();
        final RecyclerView rv = findViewById(R.id.recyclerView);
        this.adapter = new DisciplinaAdapter(itens);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter.setOnItemListaClickListener(new DisciplinaAdapter.OnItemListaClickListener() {
            @Override
            public void onItemListaClick(View itemView, int position) {
                Toast.makeText(DetalheActivity.this, itens.get(position).makeDescription(), Toast.LENGTH_SHORT).show();
            }
        });
        Button botaoNovaDisciplina = findViewById(R.id.buttonAdicionarDisciplina);
        botaoNovaDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalheActivity.this, DisciplinaActivity.class);
                startActivityForResult(intent, DetalheActivity.REQUEST_DISCIPLINA);
            }
        });

        Button botaoDetalhes = findViewById(R.id.buttonDetalhes);

//        botaoDetalhes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DetalheActivity.this, DisciplinaActivity.class);
//                startActivityForResult(intent, DetalheActivity.REQUEST_DISCIPLINA);
//            }
//        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == DetalheActivity.REQUEST_DISCIPLINA) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    Disciplina disciplina = (Disciplina) bundle.get("disciplina");
                    adapter.addDisciplina(disciplina);
                    Toast.makeText(this,"Cadastro realizado com sucesso",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    
}
