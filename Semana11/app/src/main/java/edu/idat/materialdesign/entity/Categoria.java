package edu.idat.materialdesign.entity;

public class Categoria {
    private int id;
    private String nombre;
    private int imagenId;

    public Categoria() {
    }

    public Categoria(int id, String nombre, int imagenId) {
        this.id = id;
        this.nombre = nombre;
        this.imagenId = imagenId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
