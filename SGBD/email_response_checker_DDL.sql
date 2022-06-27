-- ========================= Criando banco de dados ========================
create database email_response_checker;

-- ========================= Selecionando banco de dados ===================
use email_response_checker;

-- ========================= Criando as tabelas do banco de dados =========
create table pessoas(
					id_pessoa INT(4) primary key not null unique auto_increment,
                    nm_pessoa VARCHAR(45) not null,
                    cpf_pessoa BIGINT unique not null,
                    cargo_pessoa VARCHAR(30) not null,
                    matricula_pessoa INT unique not null);
                    
create table enderecos_email(
					id_endereco INT primary key unique not null auto_increment,
                    endereco_email VARCHAR(40) not null unique,
                    senha_email VARCHAR(12) not null,
                    departamento VARCHAR(15) not null,
                    id_pessoa INT(4));
                    
create table mensagens_inbox(
					id_msg_inbox INT primary key not null unique auto_increment,
                    body VARCHAR(1000),
                    remet VARCHAR(40) not null,
                    dest VARCHAR(256) not null,
                    assunto VARCHAR(160));
                    
 create table mensagens_residuos(
					id_msg_residuos INT primary key not null unique auto_increment,
                    body VARCHAR(1000),
                    remet VARCHAR(40) not null,
                    dest VARCHAR(256) not null,
                    assunto VARCHAR(160));
                    
create table relatorio_nao_respondidas(
					id_relatorio INT primary key not null unique auto_increment,
                    dt_hr_relatorio DATETIME not null,
                    user_relatorio VARCHAR(20) not null,
                    descricao_relatorio VARCHAR(110) not null);
                    
-- Tabelas sem relações:
create table remetente_excecoes(
					id_excecao INT primary key unique not null auto_increment,
                    excecao VARCHAR(40) not null unique);

create table ultima_data(
					id_data INT primary key not null unique auto_increment,
                    dia DATE unique not null);

-- Tabelas de relacionamento :
create table mensagens_inbox_endereco(
					id_endereco_msg_inbox INT primary key unique not null auto_increment,
                    id_endereco INT not null,
                    id_msg_inbox INT not null,
                    constraint fk_inbox_endereco foreign key (id_endereco) references enderecos_email(id_endereco),
                    constraint fk_endereco_inbox foreign key (id_msg_inbox) references mensagens_inbox(id_msg_inbox));

create table mensagens_residuos_endereco(
					id_endereco_msg_residuos INT primary key unique not null auto_increment,
                    id_endereco INT not null,
                    id_msg_residuos INT not null,
                    constraint fk_residuos_endereco foreign key (id_endereco) references enderecos_email(id_endereco),
                    constraint fk_endereco_residuos foreign key (id_msg_residuos) references mensagens_residuos(id_msg_residuos));

create table relatorio_mensagens_inbox(
					id_relatorio_inbox INT primary key not null unique auto_increment,
                    id_relatorio INT not null,
                    id_msg_inbox INT not null,
                    constraint fk_relatorio_inbox foreign key (id_relatorio) references relatorio_nao_respondidas(id_relatorio),
                    constraint fk_inbox_relatorio foreign key (id_msg_inbox) references mensagens_inbox(id_msg_inbox));

create table relatorio_mensagens_residuos(
					id_relatorio_residuos INT primary key not null unique auto_increment,
                    id_relatorio INT not null,
                    id_msg_residuos INT not null,
                    constraint fk_relatorio_residuos foreign key (id_relatorio) references relatorio_nao_respondidas(id_relatorio),
                    constraint fk_residuos_relatorio foreign key (id_msg_residuos) references mensagens_residuos(id_msg_residuos));

-- ====================================== Criando relacionamento: ================================
alter table enderecos_email
add foreign key (id_pessoa) references pessoas(id_pessoa);
