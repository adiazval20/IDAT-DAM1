package edu.idat.materialdesign.entity;

public class Post {
    private int id;
    private String titulo;
    private String subTitulo;
    private int imagen;
    private String mensaje;
    private int icono;

    public Post() {
    }

    public Post(int id, String titulo, String subTitulo, int imagen, String mensaje, int icono) {
        this.id = id;
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.imagen = imagen;
        this.mensaje = mensaje;
        this.icono = icono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
