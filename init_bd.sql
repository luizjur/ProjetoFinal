/* criando tabelas */

 

create table itmn880_pdv(
  id int not null auto_increment,
  numero_ponto int not null,
  nome varchar(100) not null,
  endereco varchar(100) not null,
  telefone varchar(20) not null,
  constraint pk_id primary key (id)
);

 

create table itmn880_solic(
   num_seq int not null auto_increment,
   nome_tecnico varchar(100) not null,
   operadora varchar(50) not null,
   telefone varchar(20) not null,
   doc varchar(20) not null,
   data date,
   hora time,
   pdv_id int not null,
   constraint pk_num_seq primary key (num_seq),
   constraint fk_id foreign key (pdv_id) references itmn880_pdv (id)
);


Tabela de Usuario
login-racf
Nome
senha
email


