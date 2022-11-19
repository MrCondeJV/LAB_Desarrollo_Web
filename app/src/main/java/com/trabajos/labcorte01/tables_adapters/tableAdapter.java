package com.trabajos.labcorte01.tables_adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trabajos.labcorte01.list_elements.List_eventos;
import com.trabajos.labcorte01.R;
import com.trabajos.labcorte01.cruds.Ver_Activity;

import java.util.List;

public class tableAdapter extends RecyclerView.Adapter<tableAdapter.ViewHolder> {
    Context context;
    List<List_eventos> lista;


  public tableAdapter(Context context, List<List_eventos> table_list){

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
            List_eventos element = lista.get(position);
            holder.fecha_inicio.setText(element.getFecha_inicio());
            holder.causa.setText(element.getCausa());
            holder.server.setText(element.getServicioA());
            holder.solucion.setText(element.getDescripcion());
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

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Context context = view.getContext();
                   Intent intent = new Intent(context, Ver_Activity.class);
                   intent.putExtra("ID", lista.get(getAdapterPosition()).getId());
                   context.startActivity(intent);
               }
           });
      }
    }



}
