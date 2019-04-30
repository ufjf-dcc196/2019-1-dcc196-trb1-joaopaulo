package com.ufjf.br.trabalho1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Disciplina implements Serializable {
    private static List<Disciplina> dataSample = new ArrayList<>();
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

    public String makeDescription() {
        return String.format(Locale.getDefault(),
                "Título: %s \n" +
                        "Carga Horária: %d \n" +
                        "Área: %s \n",
                this.getTitulo(),
                this.getCargaHoraria(),
                this.getArea()
        );
    }

    public static List<Disciplina> getDataSample() {
        if (dataSample.size() == 0) {
            dataSample.add(new Disciplina(60, "Cálculo 1", "Exatas"));
            dataSample.add(new Disciplina(60, "Cálculo 2", "Exatas"));
            dataSample.add(new Disciplina(60, "Cálculo 3", "Exatas"));
            dataSample.add(new Disciplina(30, "Bioestatística", "Saúde"));
            dataSample.add(new Disciplina(60, "Anatommia", "Saúde"));
            dataSample.add(new Disciplina(60, "Introdução a Filosofia", "Humanas"));
            dataSample.add(new Disciplina(60, "Introdução a Sociologia", "Humanas"));
            dataSample.add(new Disciplina(60, "Inglês Avançado", "Línguas"));
            dataSample.add(new Disciplina(60, "Inglês Básico", "Línguas"));
            dataSample.add(new Disciplina(60, "Inglês Intermediário", "Línguas"));
        }
        return dataSample;
    }
}
