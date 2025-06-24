package projarch.assignment.application.dto.response;

import java.util.Date;


public class AluguelDTO{
    private int id;
    private int periodo;
    private Date dataInicial;
    private ClienteResponseDTO cliente;
    private JogoDTO jogo;
    
    
        public AluguelDTO(int id, int periodo, Date dataInicial, ClienteResponseDTO cliente, JogoDTO jogo) {
            this.id = id;
            this.periodo = periodo;
            this.dataInicial = dataInicial;
            this.cliente = cliente;
            this.jogo = jogo;
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

        public ClienteResponseDTO getCliente() {
            return cliente;
        }

        public void setCliente(ClienteResponseDTO cliente) {
            this.cliente = cliente;
        }

        public JogoDTO getJogo() {
            return jogo;
        }

        public void setJogo(JogoDTO jogo) {
            this.jogo = jogo;
        }
    
}
