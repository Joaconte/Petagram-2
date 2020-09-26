package jcg.petagram.pojo;

public class Mascota {

    public String nombre;
    public Foto foto;

    public Mascota(String nombre, int foto, int cantidadDeMeGusta) {
        this.nombre = nombre;
        this.foto = new Foto(foto, cantidadDeMeGusta);
    }

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = new Foto(foto);
    }


    public String getNombre() {
        return nombre;
    }

    public int getFoto() {
        return foto.getFoto();
    }

    public int getCantidadDeMeGusta() {
        return foto.getCantidadDeMeGusta();
    }
}
