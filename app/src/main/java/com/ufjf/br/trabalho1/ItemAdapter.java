package com.ufjf.br.trabalho1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<String> itens;
    private OnItemListaClickListener listener;

    public interface OnItemListaClickListener {
        void onItemListaClick(View itemListaView, int position);
    }

    public ItemAdapter(List<String> itens) {
        this.itens = itens;
    }
    public void setOnItemListaClickListener(OnItemListaClickListener listener){
        this.listener = listener;
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
        String item = itens.get(position);
        holder.nome.setText(item);

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
                    if (listener!=null){
                        int position =  getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemListaClick(v, position);
                        }
                    }
                }
            });

        }
    }
}
