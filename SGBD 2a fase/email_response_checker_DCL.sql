use email_response_checker;

-- =================== Criando o usuário 'gerente' =======================
create user 'gerente'@'localhost' identified by "!#gerentes111#!";
select * from mysql.user;
show grants for 'gerente'@'localhost';

-- =================== Adicionando privilégios ========================
grant insert, select, update, delete on email_response_checker.remetente_excecoes 
to 'gerente'@'localhost';
grant insert, select, update on email_response_checker.mensagens_residuos 
to 'gerente'@'localhost';
grant select, update, delete on email_response_checker.mensagens_inbox 
to 'gerente'@'localhost';
grant update, select on email_response_checker.ultima_data
to 'gerente'@'localhost';
grant insert, select on email_response_checker.relatorio_mensagens_inbox
to 'gerente'@'localhost';
grant insert, select on email_response_checker.relatorio_nao_respondidas
to 'gerente'@'localhost';
grant insert, select on email_response_checker.relatorio_mensagens_residuos
to 'gerente'@'localhost';
grant select on email_response_checker.mensagens_inbox_endereco
to 'gerente'@'localhost';
grant select on email_response_checker.enderecos_email
to 'gerente'@'localhost';
grant select on email_response_checker.mensagens_residuos_endereco
to 'gerente'@'localhost';
	