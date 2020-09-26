package jcg.petagram.pojo;

import java.util.ArrayList;


public class ListaMascotasFavoritas {

    private static int TAMANIO = 5;
    private int ultimoEnEntrar;
    private ArrayList<Mascota> lista;

    public ListaMascotasFavoritas() {
        ultimoEnEntrar = 0;
        lista = new ArrayList<Mascota>();
    }

    public void agregarMascota(Mascota mascota) {

        if (TAMANIO > lista.size())
            lista.add(mascota);
        else {
            lista.add(ultimoEnEntrar, mascota);
            if (ultimoEnEntrar != TAMANIO)
                ultimoEnEntrar++;
            else
                ultimoEnEntrar = 0;
        }
    }
}