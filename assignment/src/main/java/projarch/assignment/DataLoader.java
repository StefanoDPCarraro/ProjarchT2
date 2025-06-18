package projarch.assignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import projarch.assignment.domain.enums.EnumTipoEletronico;
import projarch.assignment.domain.enums.EnumTipoMesa;
import projarch.assignment.infra.database.IJpaRepository.IAluguelJpaRepository;
import projarch.assignment.infra.database.IJpaRepository.IJogoJpaRepository;
import projarch.assignment.infra.database.entity.Aluguel;
import projarch.assignment.infra.database.entity.JogoEletronico;
import projarch.assignment.infra.database.entity.JogoMesa;

@Component
public class DataLoader implements CommandLineRunner {
    private final IJogoJpaRepository jogoJpaRepository;
    private final IAluguelJpaRepository aluguelJpaRepository;

    public DataLoader(IJogoJpaRepository jogoRepository, IAluguelJpaRepository aluguelJpaRepository) {
        this.jogoJpaRepository = jogoRepository;
        this.aluguelJpaRepository = aluguelJpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        jogoJpaRepository.deleteAll();

        JogoMesa jm1 = new JogoMesa();
        jm1.setTipo(EnumTipoMesa.CARTAS);
        jm1.setNumeroPecas(52);
        jm1.setNome("Baralho");
        jm1.setValorBase(50.70);
        jogoJpaRepository.save(jm1);

        JogoMesa jm2 = new JogoMesa();
        jm2.setTipo(EnumTipoMesa.TABULEIRO);
        jm2.setNumeroPecas(32);
        jm2.setNome("Xadrez");
        jm2.setValorBase(80.90);
        jogoJpaRepository.save(jm2);

        JogoEletronico je1 = new JogoEletronico();
        je1.setTipo(EnumTipoEletronico.SIMULACAO);
        je1.setPlataforma("Playstation");
        je1.setNome("The Sims 4");
        je1.setValorBase(299.90);
        jogoJpaRepository.save(je1);

        JogoEletronico je2 = new JogoEletronico();
        je2.setTipo(EnumTipoEletronico.AVENTURA);
        je2.setPlataforma("Xbox");
        je2.setNome("Indiana Jones");
        je2.setValorBase(79.90);
        jogoJpaRepository.save(je2);

        JogoEletronico je3 = new JogoEletronico();
        je3.setTipo(EnumTipoEletronico.ESTRATEGIA);
        je3.setPlataforma("Windows");
        je3.setNome("Civilization V");
        je3.setValorBase(45);
        jogoJpaRepository.save(je3);

        System.out.println("Dados de jogos iniciais carregados com sucesso!");

        aluguelJpaRepository.deleteAll();

        Aluguel aluguel1 = new Aluguel();
        aluguel1.setDataInicial(null);
        aluguel1.setPeriodo(1);
        aluguel1.setJogo(je1);
        aluguelJpaRepository.save(aluguel1);

        Aluguel aluguel2 = new Aluguel();
        aluguel2.setDataInicial(null);
        aluguel2.setPeriodo(2);
        aluguel2.setJogo(je2);
        aluguelJpaRepository.save(aluguel2);

        Aluguel aluguel3 = new Aluguel();
        aluguel3.setDataInicial(null);
        aluguel3.setPeriodo(3);
        aluguel3.setJogo(je3);
        aluguelJpaRepository.save(aluguel3);

        System.out.println("Dados de ALUGUEIS iniciais carregados com sucesso!");
    }

}
