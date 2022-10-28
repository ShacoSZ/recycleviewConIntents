package com.example.californication.adaptadores;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.californication.R;
import com.example.californication.modelos.persona;

import java.util.List;

public class personaadaptador extends RecyclerView.Adapter<personaadaptador.viewholder>
{
    public personaadaptador(List<persona> lp) {
        this.lp = lp;
    }

    List<persona> lp;

    @NonNull
    @Override
    public personaadaptador.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdesign,parent,false);


        return new viewholder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull personaadaptador.viewholder holder, int position) {
        holder.setData(lp.get(position));
    }

    @Override
    public int getItemCount() {
        return lp.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtNombre;
        TextView txtTelefono;
        TextView txtaction;
        persona personaholder;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtNombre=itemView.findViewById(R.id.txtnombre);
            txtTelefono=itemView.findViewById(R.id.txttelefono);
            txtaction=itemView.findViewById(R.id.txtaction);

            txtaction.setOnClickListener(this::intents);
            txtNombre.setOnClickListener(this::onClick);
            txtTelefono.setOnClickListener(this::llamar);
        }
        public void setData(persona p)
        {
            personaholder=p;
            txtNombre.setText(personaholder.getNombre());
            txtTelefono.setText(personaholder.getTelefono());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),personaholder.getNombre(),Toast.LENGTH_SHORT).show();
        }
        public void llamar(View v){
            Intent llamada=new Intent((Intent.ACTION_DIAL),Uri.parse("tel:"+personaholder.getTelefono()));
            v.getContext().startActivity(llamada);
        }
        public void intents(View v){
            Intent intents = personaholder.getAction();
            v.getContext().startActivities(new Intent[]{intents});
        }
    }
}
