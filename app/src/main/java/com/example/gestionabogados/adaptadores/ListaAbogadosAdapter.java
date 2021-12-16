package com.example.gestionabogados.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionabogados.R;
import com.example.gestionabogados.VerAbogado;
import com.example.gestionabogados.modelo.Abogado;

import java.util.ArrayList;

public class ListaAbogadosAdapter extends RecyclerView.Adapter<ListaAbogadosAdapter.ContactoViewRegistro> {

    ArrayList<Abogado> listaAbogados;

    public ListaAbogadosAdapter(ArrayList<Abogado> listaAbogados) {
        this.listaAbogados = listaAbogados;
    }

    @NonNull
    @Override
    public ListaAbogadosAdapter.ContactoViewRegistro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_abogado, null, false);
        return new ContactoViewRegistro(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAbogadosAdapter.ContactoViewRegistro holder, int position) {
        holder.viewIdentificacion.setText(String.valueOf(listaAbogados.get(position).getIdentificacion()));
        holder.viewNombre.setText(listaAbogados.get(position).getNombre());
        holder.viewEspecializacion.setText(listaAbogados.get(position).getEspecializacion());
        holder.viewCorreo.setText(listaAbogados.get(position).getEmail());
        holder.viewCosto.setText(String.valueOf(listaAbogados.get(position).getCostoh()));
    }

    @Override
    public int getItemCount() {
        return listaAbogados.size();
    }

    public class ContactoViewRegistro extends RecyclerView.ViewHolder {

        TextView viewIdentificacion, viewEspecializacion, viewNombre, viewCorreo, viewCosto;

        public ContactoViewRegistro(@NonNull View itemView) {
            super(itemView);
            viewIdentificacion = itemView.findViewById(R.id.viewIdentificacion);
            viewEspecializacion = itemView.findViewById(R.id.viewEspecializacion);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);
            viewCosto = itemView.findViewById(R.id.viewCosto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, VerAbogado.class);
                    intent.putExtra("id", listaAbogados.get(getAdapterPosition()).getIdentificacion());
                    context.startActivity(intent);
                }
            });
        }
    }
}