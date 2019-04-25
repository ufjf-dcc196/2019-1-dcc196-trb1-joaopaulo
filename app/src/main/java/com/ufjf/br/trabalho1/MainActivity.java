package com.ufjf.br.trabalho1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<String> itens = new ArrayList<String>(){{
            add("Um");
            add("Dois");
            add("Três");
            add("Quatro");
        }};
        final RecyclerView rv = findViewById(R.id.recyclerView);
        ItemAdapter adapter = new ItemAdapter(Planejamento.getDataSample());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemListaClickListener(new ItemAdapter.OnItemListaClickListener() {
            @Override
            public void onItemListaClick(View itemView, int position) {
                Toast.makeText(MainActivity.this, itens.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
