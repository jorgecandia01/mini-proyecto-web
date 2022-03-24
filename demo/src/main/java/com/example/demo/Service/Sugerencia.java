package com.example.demo.Service;

public class Sugerencia{
    private int id;
    private String cuerpo;


    public Sugerencia(int id, String cuerpo) {
        this.id = id;
        this.cuerpo = cuerpo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Sugerencia{" +
                "id=" + id +
                ", cuerpo='" + cuerpo + '\'' +
                '}';
    }
}