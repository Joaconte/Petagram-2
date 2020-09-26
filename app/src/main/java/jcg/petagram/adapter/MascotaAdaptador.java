package jcg.petagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jcg.petagram.pojo.Mascota;
import jcg.petagram.R;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        String cantDeMeGusta = Integer.toString(mascota.getCantidadDeMeGusta());
        mascotaViewHolder.tvCantidadDeMeGusta.setText(cantDeMeGusta);
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvCantidadDeMeGusta;

        public MascotaViewHolder(View itemView){
            super(itemView);
            imgFoto             = itemView.findViewById(R.id.imgFoto);
            tvNombre            = itemView.findViewById(R.id.tvNombre);
            tvCantidadDeMeGusta = itemView.findViewById(R.id.tvCantidadDeMeGusta);
        }
    }

}
