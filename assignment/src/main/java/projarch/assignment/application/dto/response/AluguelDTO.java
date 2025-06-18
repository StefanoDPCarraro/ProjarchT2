package projarch.assignment.application.dto.response;

import java.util.Date;
import java.util.List;


public class AluguelDTO{
    private int id;
        private int periodo;
        private Date dataInicial;
        private List<JogoDTO> jogos;
    
    
        protected AluguelDTO(int codigo, int periodo, Date dataInicial, List<JogoDTO> jogos) {
            this.id = id;
            this.periodo = periodo;
            this.dataInicial = dataInicial;
            this.jogos = jogos;
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
    
        public List<JogoDTO> getJogos() {
            return jogos;
        }
    
        public void setJogos(List<JogoDTO> jogos) {
            this.jogos = jogos;
        }
}
