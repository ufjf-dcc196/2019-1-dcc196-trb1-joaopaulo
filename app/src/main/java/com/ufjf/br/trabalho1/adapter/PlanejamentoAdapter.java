package com.ufjf.br.trabalho1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ufjf.br.trabalho1.model.Planejamento;
import com.ufjf.br.trabalho1.R;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

public class PlanejamentoAdapter extends RecyclerView.Adapter<PlanejamentoAdapter.ViewHolder> implements Serializable {
    private List<Planejamento> itens;
    private OnItemListaClickListener listener;

    public void editPlanejamento(Planejamento planejamento) {
        Integer index = this.itens.indexOf(planejamento);
        if(index >-1){
            this.itens.remove(index);
            this.itens.add(index,planejamento);
        }
    }

    public interface OnItemListaClickListener {
        void onItemListaClick(View itemListaView, int position);
    }

    public PlanejamentoAdapter(List<Planejamento> itens) {
        this.itens = itens;
    }

    public void setOnItemListaClickListener(OnItemListaClickListener listener) {
        this.listener = listener;
    }

    public void addPlanejamento(Planejamento planejamento){
        this.itens.add(planejamento);
        notifyItemInserted(getItemCount());
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.itemlista_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Planejamento item = itens.get(position);
        holder.nome.setText(item.makeDescription());

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemListaClick(v, position);
                        }
                    }
                }
            });

        }
    }
}
