package com.trabajos.labcorte01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class tableAdapter extends RecyclerView.Adapter<tableAdapter.ViewHolder> {
    Context context;
    List<list_element1> lista;


  public tableAdapter(Context context, List<list_element1> table_list){

      this.context = context;
      this.lista = table_list;
  }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        if(lista != null && lista.size()>0){
            list_element1 element = lista.get(position);
            holder.fecha_inicio.setText(element.getFecha_inicio());
            holder.causa.setText(element.getCausa());
            holder.server.setText(element.getServer());
            holder.solucion.setText(element.getSolucion());
            holder.fecha_fin.setText(element.getFecha_fin());
            holder.indisponibilidad.setText(element.getIndisponibilidad());

        }else{
            return;
        }
    }

    @Override
    public int getItemCount() { //RETORNA EL TAMANO DE LA LISTA
        return lista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
      TextView fecha_inicio,causa,server,solucion,fecha_fin,indisponibilidad;

      public ViewHolder(@NonNull View itemView){
          super(itemView);
          fecha_inicio = itemView.findViewById(R.id.fecha_inicio);
          causa = itemView.findViewById(R.id.causa);
          server = itemView.findViewById(R.id.server);
          solucion = itemView.findViewById(R.id.solucion);
          fecha_fin = itemView.findViewById(R.id.fecha_fin);
          indisponibilidad = itemView.findViewById(R.id.indisponibilidad);
      }
    }



}
