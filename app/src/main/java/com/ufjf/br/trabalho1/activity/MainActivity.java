package com.ufjf.br.trabalho1.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ufjf.br.trabalho1.model.Planejamento;
import com.ufjf.br.trabalho1.R;
import com.ufjf.br.trabalho1.adapter.PlanejamentoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_PLANEJAMENTO = 1;
    private PlanejamentoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Planejamento> itens = Planejamento.getDataSample();
        final RecyclerView rv = findViewById(R.id.recyclerView);
        this.adapter = new PlanejamentoAdapter(itens);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter.setOnItemListaClickListener(new PlanejamentoAdapter.OnItemListaClickListener() {
            @Override
            public void onItemListaClick(View itemView, int position) {
                Toast.makeText(MainActivity.this, itens.get(position).makeDescription(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,DetalheActivity.class);
                intent.putExtra("planejamento",itens.get(position));
                startActivity(intent);
            }
        });
        Button botaoPlanejamento = findViewById(R.id.buttonCadastrar);
        botaoPlanejamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlanejamentoActivity.class);
                startActivityForResult(intent, MainActivity.REQUEST_PLANEJAMENTO);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == MainActivity.REQUEST_PLANEJAMENTO) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    Planejamento planejamento = (Planejamento) bundle.get("planejamento");
                    adapter.addPlanejamento(planejamento);
                    Toast.makeText(this,"Cadastro realizado com sucesso",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
