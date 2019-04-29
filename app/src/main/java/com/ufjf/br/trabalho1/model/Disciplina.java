package com.ufjf.br.trabalho1.model;

import java.io.Serializable;
import java.util.Locale;

public class Disciplina implements Serializable {

    private int cargaHoraria;
    private String titulo;
    private String area;

    public Disciplina(int cargaHoraria, String titulo, String area) {
        this.cargaHoraria = cargaHoraria;
        this.titulo = titulo;
        this.area = area;
    }

    public Disciplina() {
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String makeDescription(){
        return String.format(Locale.getDefault(),
                "Título: %d \n" +
                        "Carga Horária: %s \n" +
                        "Área: %.2f \n",
                this.getTitulo(),
                this.getCargaHoraria(),
                this.getArea()
        );
    }
}
