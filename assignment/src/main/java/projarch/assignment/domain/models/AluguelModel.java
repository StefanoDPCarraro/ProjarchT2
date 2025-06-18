package projarch.assignment.domain.models;

import java.util.Date;
import java.util.List;

public class AluguelModel {
    private int id;
    private int periodo;
    private Date dataInicial;
    //private List<JogoModel> jogos;


    public AluguelModel(int codigo, int periodo, Date dataInicial) {
        this.id = id;
        this.periodo = periodo;
        this.dataInicial = dataInicial;
        //this.jogos = jogos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

   /*  public List<JogoModel> getJogos() {
        return jogos;
    }

    public void setJogos(List<JogoModel> jogos) {
        this.jogos = jogos;
    }*/



}
