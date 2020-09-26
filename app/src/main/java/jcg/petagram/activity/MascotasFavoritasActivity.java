package jcg.petagram.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jcg.petagram.pojo.Mascota;
import jcg.petagram.adapter.MascotaAdaptador;
import jcg.petagram.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MascotasFavoritasActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listaMascotas = findViewById(R.id.rvMascotasFavoritasActivity);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;

        switch (item.getItemId()){
            case R.id.mContacto:
                intent = new Intent(this, FormularioActivity.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                intent = new Intent(this, BiografiaAutorActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Cerdo", R.drawable.cerdo, 1));
        mascotas.add(new Mascota("Conejo", R.drawable.conejo, 2));
        mascotas.add(new Mascota("Elefante", R.drawable.elefante, 3));
        mascotas.add(new Mascota("Gallo", R.drawable.gallo, 4));
        mascotas.add(new Mascota("Gato", R.drawable.gato, 5));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);

    }

    public void clickIrAMascotasFavoritas(View target) {
    }
}