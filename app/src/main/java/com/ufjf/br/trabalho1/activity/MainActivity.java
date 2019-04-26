package com.ufjf.br.trabalho1.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ufjf.br.trabalho1.model.Planejamento;
import com.ufjf.br.trabalho1.R;
import com.ufjf.br.trabalho1.adapter.PlanejamentoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_PLANEJAMENTO = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Planejamento> itens = Planejamento.getDataSample();
        final RecyclerView rv = findViewById(R.id.recyclerView);
        PlanejamentoAdapter adapter = new PlanejamentoAdapter(itens);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemListaClickListener(new PlanejamentoAdapter.OnItemListaClickListener() {
            @Override
            public void onItemListaClick(View itemView, int position) {
                Toast.makeText(MainActivity.this, itens.get(position).makeDescription(), Toast.LENGTH_SHORT).show();
            }
        });
        Button botaoPlanejamento = findViewById(R.id.buttonCadastrar);
        botaoPlanejamento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PlanejamentoActivity.class);
                startActivityForResult(intent,MainActivity.REQUEST_PLANEJAMENTO);
            }
        });


    }
}
