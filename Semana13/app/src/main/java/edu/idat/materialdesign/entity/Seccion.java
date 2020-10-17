package edu.idat.materialdesign.entity;

public class Seccion {
    private int id;
    private String nombre;
    private int imagenId;
    private String hexColor;
    private String hexBackColor;

    public Seccion() {
    }

    public Seccion(int id, String nombre, int imagenId, String hexColor, String hexBackColor) {
        this.id = id;
        this.nombre = nombre;
        this.imagenId = imagenId;
        this.hexColor = hexColor;
        this.hexBackColor = hexBackColor;
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

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }

    public String getHexBackColor() {
        return hexBackColor;
    }

    public void setHexBackColor(String hexBackColor) {
        this.hexBackColor = hexBackColor;
    }
}
