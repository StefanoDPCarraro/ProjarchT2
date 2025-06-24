package projarch.assignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import projarch.assignment.domain.enums.EnumTipoEletronico;
import projarch.assignment.domain.enums.EnumTipoMesa;
import projarch.assignment.infra.database.IJpaRepository.IAluguelJpaRepository;
import projarch.assignment.infra.database.IJpaRepository.IClienteJpaRepository;
import projarch.assignment.infra.database.IJpaRepository.IJogoJpaRepository;
import projarch.assignment.infra.database.entity.Aluguel;
import projarch.assignment.infra.database.entity.ClienteEntity;
import projarch.assignment.infra.database.entity.EmpresarialEntity;
import projarch.assignment.infra.database.entity.IndividualEntity;
import projarch.assignment.infra.database.entity.JogoEletronico;
import projarch.assignment.infra.database.entity.JogoMesa;

@Component
public class DataLoader implements CommandLineRunner {
    private final IJogoJpaRepository jogoJpaRepository;
    private final IAluguelJpaRepository aluguelJpaRepository;
    private final IClienteJpaRepository clienteJpaRepository;

    public DataLoader(IJogoJpaRepository jogoRepository, IAluguelJpaRepository aluguelJpaRepository, IClienteJpaRepository clienteJpaRepository) {
        this.jogoJpaRepository = jogoRepository;
        this.aluguelJpaRepository = aluguelJpaRepository;
        this.clienteJpaRepository = clienteJpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        aluguelJpaRepository.deleteAll();
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

        clienteJpaRepository.deleteAll();

        ClienteEntity c1 = new EmpresarialEntity(1, "Empresa Alpha", "Rua A, 100", "Emp Alpha", "12345678000123");
        ClienteEntity c2 = new EmpresarialEntity(2, "Empresa Beta", "Rua B, 200", "Emp Beta", "23456789000134");
        ClienteEntity c3 = new EmpresarialEntity(3, "Empresa Gamma", "Rua C, 300", "Emp Gamma", "34567890100145");
        ClienteEntity c4 = new IndividualEntity(4, "João Silva", "Rua D, 400", "12345678901");
        ClienteEntity c5 = new IndividualEntity(5, "Maria Oliveira", "Rua E, 500", "98765432100");

        clienteJpaRepository.save(c1);
        clienteJpaRepository.save(c2);
        clienteJpaRepository.save(c3);
        clienteJpaRepository.save(c4);
        clienteJpaRepository.save(c5);


        Aluguel aluguel1 = new Aluguel();
        aluguel1.setDataInicial(null);
        aluguel1.setPeriodo(1);
        aluguel1.setCliente(c1);
        aluguelJpaRepository.save(aluguel1);

        Aluguel aluguel2 = new Aluguel();
        aluguel2.setDataInicial(null);
        aluguel2.setPeriodo(2);
        aluguel2.setCliente(c3);
        aluguelJpaRepository.save(aluguel2);

        Aluguel aluguel3 = new Aluguel();
        aluguel3.setDataInicial(null);
        aluguel3.setPeriodo(3);
        aluguel3.setCliente(c5);
        aluguelJpaRepository.save(aluguel3);

        System.out.println("Dados de ALUGUEIS iniciais carregados com sucesso!");
    }

}
