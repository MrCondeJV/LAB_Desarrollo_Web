package com.trabajos.labcorte01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class tableAdapter_Logs extends RecyclerView.Adapter<tableAdapter_Logs.ViewHolder> {

    Context context;
    List<list_element3> lista;


    public tableAdapter_Logs(Context context, List<list_element3> table_list) {

        this.context = context;
        this.lista = table_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout3, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (lista != null && lista.size() > 0) {
            list_element3 element = lista.get(position);
            holder.nombreServerLog.setText(element.getNombreServerLog());
            holder.fecha_hora.setText(element.getFechaHora());
            holder.usuario.setText(element.getUsuario());
            holder.estado_Sesion.setText(element.getEstadoSesion());

        } else {
            return;
        }
    }

    @Override
    public int getItemCount() { //RETORNA EL TAMANO DE LA LISTA
        return lista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreServerLog, fecha_hora, usuario, estado_Sesion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreServerLog = itemView.findViewById(R.id.nombreServerLog);
            fecha_hora = itemView.findViewById(R.id.fecha_Hora);
            usuario = itemView.findViewById(R.id.usuario);
            estado_Sesion = itemView.findViewById(R.id.estado_Sesion);
        }
    }
}