package com.trabajos.labcorte01;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class tableAdapter_Seguridad extends RecyclerView.Adapter<tableAdapter_Seguridad.ViewHolder> {

    Context context;
    List<list_element2> lista;


  public tableAdapter_Seguridad( Context context,List<list_element2> table_list){

      this.context = context;
      this.lista = table_list;
  }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        if(lista != null && lista.size()>0){
            list_element2 element = lista.get(position);
            holder.NombreServer.setText(element.getNombreServer());
            holder.NombreEvento.setText(element.getNombreEvento());
            holder.Descripcion.setText(element.getDescripcion());

        }else{
            return;
        }
    }

    @Override
    public int getItemCount() { //RETORNA EL TAMANO DE LA LISTA
        return lista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
      TextView NombreServer,NombreEvento,Descripcion;

      public ViewHolder(@NonNull View itemView){
          super(itemView);
          NombreServer = itemView.findViewById(R.id.NombreServer);
          NombreEvento = itemView.findViewById(R.id.NombreEvento);
          Descripcion = itemView.findViewById(R.id.Descripcion);
      }
    }

}
