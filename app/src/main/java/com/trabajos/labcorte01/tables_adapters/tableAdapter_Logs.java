package com.trabajos.labcorte01.tables_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trabajos.labcorte01.R;
import com.trabajos.labcorte01.list_elements.list_element3;

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
            holder.fecha.setText(element.getFecha());
            holder.usuario.setText(element.getUsuario());
            holder.estado_Sesion.setText(element.getEstadoSesion());
            holder.hora.setText(element.getHora());

        } else {
            return;
        }
    }

    @Override
    public int getItemCount() { //RETORNA EL TAMANO DE LA LISTA
        return lista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreServerLog, fecha, usuario, estado_Sesion, hora;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreServerLog = itemView.findViewById(R.id.txtNameServerLogs);
            fecha = itemView.findViewById(R.id.txtDateLogs);
            usuario = itemView.findViewById(R.id.txtUserLogs);
            estado_Sesion = itemView.findViewById(R.id.txtStateLogs);
            hora = itemView.findViewById(R.id.txtTimeLogs);
        }
    }
}