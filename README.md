## 🚀 Projeto Backend Java Spring + MySQL

Primeiramente, precisa ter instalado [Docker](https://www.docker.com/) para buildar a imagem do banco de dados, [Java LTS 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) para rodar o código e [Maven](https://maven.apache.org/) como gerenciador de dependências.

## ▶️ Como rodar localmente
1. **Clone o repositório**

```bash
git clone https://github.com/StefanoDPCarraro/ProjarchT2.git
cd ProjarchT2
```

2. **Caminhe até ver a pasta src do Spring**

```bash
cd assignment
```

3. **Rode o docker**

```bash
docker compose up --build
```

4. **Abra outro terminal e caminhe até a src novamente**

```bash
cd assignment
```

5. **Rode o Java Spring**

```bash
mvn spring-boot:run
```

