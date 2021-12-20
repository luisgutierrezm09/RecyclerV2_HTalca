package com.example.recyclerv2_htalca;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder>{
    public ArrayList<Contacto> contactos;
    public Adaptador(ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta, parent, false);
        return new ViewHolder(view).enlaceAdaptador(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.foto.setImageResource(R.drawable.ic_launcher_background);
        holder.titulo.setText(contactos.get(position).GetNombre());
        holder.texto.setText(contactos.get(position).GetTelefono());
        holder.contacto = contactos.get(position);

        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.foto.getContext(), "asdf", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView titulo, texto;
        private Button botonNumero, botonEliminar;
        private Contacto contacto;
        private Adaptador adaptador;

        public ViewHolder(View itemView){
            super(itemView);

            foto = itemView.findViewById(R.id.foto);
            titulo = itemView.findViewById(R.id.titulo);
            texto = itemView.findViewById(R.id.texto);
            botonNumero = itemView.findViewById(R.id.botonNumeros);
            botonEliminar = itemView.findViewById(R.id.botonEliminar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "El contacto tiene "+contacto.numerosRandom.size()+" números secretos", Toast.LENGTH_LONG).show();
                }
            });

            botonNumero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String textoNumero = "";

                    for(int i = 0; i < contacto.numerosRandom.size(); i++){
                        textoNumero += contacto.numerosRandom.get(i)+" - ";
                    }

                    Toast.makeText(view.getContext(), "Números secretos: "+textoNumero, Toast.LENGTH_LONG).show();
                }
            });

            botonEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adaptador.contactos.remove(getAdapterPosition());
                    adaptador.notifyItemRemoved(getAdapterPosition());
                    adaptador.notifyItemRangeChanged(getAdapterPosition(), adaptador.contactos.size());
                }
            });

        }

        public ViewHolder enlaceAdaptador(Adaptador a){
            this.adaptador = a;
            return this;
        }
    }

}
