# Atividade 03 - Integração PostgreSql, Eclipse, Maven e Spark

## Problema
Problema
Esta tarefa consiste na criação de um formulário em HTML, que:
* Criam uma classe Principal contendo um menu com as opções Listar, Inserir, Excluir, Atualizar e Sair para acessar as funções CRUD da DAO.
* Seja integrado com o Spark Java Framework.

## Detalhes técnicos
![Image](https://github.com/user-attachments/assets/6abe8764-fe36-4996-ae9a-6aff5469dc7a)

Execute o maven:

```bash
mvn clean install
mvn clean compile exec:java -Dexec.mainClass="com.bancosimulador.Main"
```

Exemplo de tabela SQL:

```bash
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
    nascimento DATE NOT NULL,
    agencia VARCHAR(4) NOT NULL,
    conta VARCHAR(10) NOT NULL,
    senha VARCHAR(100) NOT NULL
);
```

Utilização de **docker** no **console da Google Cloud**:

```bash
docker pull postgres
sudo apt update && sudo apt-get install postgresql postgresql-contrib
sudo su postgres
psql
```
**OBS:** na Cloud a interface gráfica do **phppgadmin** pode ser acessado por uma conexão SSH, já que as instâncias virtuais tem IP's privados e não possuem externos IPv4. O problema pode ser resolvido com IPv6 também, ou pela compra de uma VM para sair do carácter ephemeral da nuvem.

**Aluna**: Izabel Oliveira da Paz Chaves - CC (PUC MINAS) 2025.1, TI2



