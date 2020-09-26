package jcg.petagram.pojo;

public class Foto {

    public int foto;
    public int cantidadDeMeGusta;

    public Foto(int foto, int cantidadDeMeGusta) {
        this.foto = foto;
        this.cantidadDeMeGusta = cantidadDeMeGusta;
    }

    public Foto(int foto) {
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public int getCantidadDeMeGusta() {
        return cantidadDeMeGusta;
    }
}
