package projarch.assignment.domain.models;

import java.util.Date;

public class AluguelModel {
    private int id;
    private int periodo;
    private Date dataInicial;
    private Cliente cliente;
    private JogoModel jogo;


    public AluguelModel(int id, int periodo, Date dataInicial, Integer cliente, Integer jogo) {
        this.id = id;
        this.periodo = periodo;
        this.dataInicial = dataInicial;
        this.jogo = jogo;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public JogoModel getJogo() {
        return jogo;
    }

    public void setJogo(JogoModel jogo) {
        this.jogo = jogo;
    }

    public double calculaValorFinalAluguel(){
        double valorAluguelPorDia = jogo.calcularValorAluguel();

        if (cliente instanceof Individual) {
            if (periodo < 7) {
                return valorAluguelPorDia * periodo * 0.90; 
            } else if (periodo >= 7 && periodo <= 14) {
                return valorAluguelPorDia * periodo * 0.80; 
            } else {
                return valorAluguelPorDia * periodo * 0.75; 
            }
        }

        if (cliente instanceof Empresarial) {
            if (jogo instanceof JogoEletronicoModel) {
                return valorAluguelPorDia * periodo; 
            } else if (jogo instanceof JogoMesaModel) {
                return valorAluguelPorDia * periodo * 0.85; 
            }
        }
        
        return 0;
    }
    

}
