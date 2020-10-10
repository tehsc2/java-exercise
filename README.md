# Passo 1: Git

Faça o clone do projeto git e abra o seu terminal na raiz do projeto

# Passo 2: Cassandra

Com o docker instalado, rode o comando para criar a imagem do cassandra

docker run -p 9042:9042 --rm --name cassandra -d cassandra:3.11

Para acessar o seu cluster:

docker exec -i -t cassandra bash -c 'cqlsh 172.17.0.2'

Crie o seguinte KeySpace: 

CREATE KEYSPACE project WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

Entre nele:

USE project;

Crie a tabela:

CREATE TABLE product(
   id UUID PRIMARY KEY,
   name text,
   description text,
   brand text,
   price decimal
   );
   
   Insira o index para a coluna name:
   
      CREATE INDEX ON project.product (name);

Subindo a Aplicação via docker: (Na raiz do projeto)

mvn clean install

docker build . -t product:1.0

Se você quer ver se criou, use o docker images

Para subir a aplicação:

docker run -p 8080:8080 product:1.0

Agora é só chamar os endpoints

   



