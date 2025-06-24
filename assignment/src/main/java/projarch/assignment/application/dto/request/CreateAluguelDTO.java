package projarch.assignment.application.dto.request;

import java.util.Date;



public class CreateAluguelDTO{
    private Integer id;
    private Integer periodo;
    private Date dataInicial;
    private Integer cliente;
    private Integer jogo;
    
    
        public CreateAluguelDTO(Integer id, Integer periodo, Date dataInicial, Integer cliente, Integer jogo) {
            this.id = id;
            this.periodo = periodo;
            this.dataInicial = dataInicial;
            this.cliente = cliente;
            this.jogo = jogo;
        }
    
        public Integer getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public Integer getPeriodo() {
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

        public Integer getCliente() {
            return cliente;
        }

        public void setCliente(Integer cliente) {
            this.cliente = cliente;
        }

        public Integer getJogo() {
            return jogo;
        }

        public void setJogo(Integer jogo) {
            this.jogo = jogo;
        }
    
}
