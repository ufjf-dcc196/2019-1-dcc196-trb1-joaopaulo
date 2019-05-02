package com.ufjf.br.trabalho1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Planejamento implements Serializable {
    private static List<Planejamento> dataSample = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();
    private Integer idPlanejamento;
    private Integer ano;
    private String semestre;
    private Double porcentagemHoras;
    private Double totalHorasComputadas;
    private Double porcentagemDisciplinaCursadas;

    public Planejamento(int ano, String semestre, Double porcentagemHoras, Double totalHorasComputadas, Double porcentagemDisciplinaCursadas) {
        this.ano = ano;
        this.semestre = semestre;
        this.porcentagemHoras = porcentagemHoras;
        this.totalHorasComputadas = totalHorasComputadas;
        this.porcentagemDisciplinaCursadas = porcentagemDisciplinaCursadas;
    }

    public Planejamento(Integer idPlanejamento, Integer ano, String semestre, Double porcentagemHoras, Double totalHorasComputadas, Double porcentagemDisciplinaCursadas) {
        this.idPlanejamento = idPlanejamento;
        this.ano = ano;
        this.semestre = semestre;
        this.porcentagemHoras = porcentagemHoras;
        this.totalHorasComputadas = totalHorasComputadas;
        this.porcentagemDisciplinaCursadas = porcentagemDisciplinaCursadas;
    }

    public static List<Planejamento> getDataSample() {
        if (dataSample.size() == 0) {
            for (int i = 0; i < 10; i++) {
                dataSample.add(new Planejamento(i, 2019, "Semestre 2019-1", (double) (7 * i), (double) (100 * i), (double) (5 * i)));
            }
        }
        return dataSample;
    }

    public Planejamento() {
    }

    public static void setDataSample(List<Planejamento> dataSample) {
        Planejamento.dataSample = dataSample;
    }

    public static List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public static void setDisciplinas(List<Disciplina> disciplinas) {
        Planejamento.disciplinas = disciplinas;
    }

    public Integer getIdPlanejamento() {
        return idPlanejamento;
    }

    public void setIdPlanejamento(Integer idPlanejamento) {
        this.idPlanejamento = idPlanejamento;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Double getPorcentagemHoras() {
        return porcentagemHoras;
    }

    public void setPorcentagemHoras(Double porcentagemHoras) {
        this.porcentagemHoras = porcentagemHoras;
    }

    public Double getTotalHorasComputadas() {
        return totalHorasComputadas;
    }

    public void setTotalHorasComputadas(Double totalHorasComputadas) {
        this.totalHorasComputadas = totalHorasComputadas;
    }

    public Double getPorcentagemDisciplinaCursadas() {
        return porcentagemDisciplinaCursadas;
    }

    public void setPorcentagemDisciplinaCursadas(Double porcentagemDisciplinaCursadas) {
        this.porcentagemDisciplinaCursadas = porcentagemDisciplinaCursadas;
    }

    public String makeDescription() {
        return String.format(Locale.getDefault(),
                "Id: %d\n" +
                        "Ano: %d \n" +
                        "Semestre: %s \n" +
                        "Perc Horas Atividades: %.2f \n" +
                        "Total de Horas Computadas: %.2f\n" +
                        "Perc Parciais Disciplinas Cursadas: %.2f", this.idPlanejamento,
                this.getAno(),
                this.getSemestre(),
                this.getPorcentagemHoras(),
                this.getTotalHorasComputadas(),
                this.getPorcentagemDisciplinaCursadas()
        );
    }
}

