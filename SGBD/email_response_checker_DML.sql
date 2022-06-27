-- =================== Selecionando o Banco de dados ====================
use email_response_checker;

-- =================== Adicionando pessoas ==============================
insert into pessoas (nm_pessoa, cpf_pessoa, cargo_pessoa, matricula_pessoa)
values 	("Maken da Rosa", 45147854771, "Estagiário de TI", 1427);

insert into pessoas (nm_pessoa, cpf_pessoa, cargo_pessoa, matricula_pessoa)
values 	("Eduardo Silva", 78412414521, "Gerente da qualidade", 0236),
		("Alex Rocha", 78451242110, "Analista Fiscal", 2101),
        ("Renata Holanda", 88524112410, "Analista Fiscal", 1201),
        ("Luana Silveira", 25123265985, "Gerente Administrativo", 0123),
        ("Leandro Almeida", 14254569874, "Analista Contabil", 7845),
        ("Carlos Eduardo", 78421457411, "Gerente de TI", 3215),
        ("Fernando Albuquerque", 45179366587, "Diretor Executivo", 6666),
        ("Eraldo Rodrigues", 33315420666, "Diretor Geral", 0666);
select * from pessoas;

-- =================== Adicionando Emails ===============================
insert into enderecos_email (endereco_email, senha_email, departamento, id_pessoa)
values 	("administrativo@teste.com", "&abc*", "Administrativo", 5),
		("fiscal01@teste.com", "&sxf#", "Fiscal", 3),
        ("ti@teste.com", "&jgm@", "TI", 7),
        ("direcaoex@teste.com", "&esd%", "Direcao", 8),
        ("direcaoge@teste.com", "&sxz$", "Direcao", 9),
        ("fiscal02@teste.com", "&idk*", "Fiscal", 4),
        ("qualidade@teste.com", "&kfm!", "Qualidade", 2),
        ("contabil01@teste.com", "&dsb%", "Contabil", 6);
insert into enderecos_email (endereco_email, senha_email, departamento)
values ("rh@teste.com", "&hgn$", "RH");
select * from enderecos_email;

-- ==================== Adicionando exceções ==============================
insert into remetente_excecoes (excecao)
values 	("gov.br"),
		("ctc@exemplo.com"),
        ("@cloud"),
        ("testes");
select * from remetente_excecoes;

-- ==================== Adicionando a data ===============================
insert into ultima_data (dia)
values ("2022-06-28");
select * from ultima_data;

-- ==================== Adicionando mensagens inbox ======================
insert into mensagens_inbox (body, remet, dest, assunto)
values 	("Boa tarde gostaria de falar sobre o desenvolvimento do sistema de monitoramento de emails, por favor responder!", "ruan@nada.com.br", "ti@teste.com", "Monitoramento"),
		("Bom dia, recebi a resposta!", "amazon@exemplo.com", "direcaoge@teste.com", "re: arquivamento"),
        ("Alteração na senha do email! clique aqui se não foi você", "magazineluiza@aaaa.com", "ti@teste.com", "Alteração de senha"),
        ("Esse email é apenas para confirmação de leitura, não responda!", "noreply@teste.com", "fiscal01@teste.com", "não responda!"),
        ("Boa tarde queria requerir os documentos da demissão do Marcos", "Cuclan@teste.com.br", "fiscal02@teste.com", "Demissão"),
        ("Preciso das cópias do emails dos colaboradores o quanto antes for possível", "carh@teste.com", "ti@teste.com", "backup emails"),
        ("Fernando sua encomenda esta a caminho", "magalu@exemplo.com", "direcaoex@teste.com", "Status encomenda"),
        ("Preciso do relatório da revisão dos documentos enviados pela amazon ontem", "Cuclan@teste.com.br", "fiscal02@teste.com", "Revisão de documentos");
insert into mensagens_inbox (remet, dest, assunto)
values 	("Kling@teste.com", "fiscal02@teste.com", "Re: análise de documentos"),
		("cliente@teste.com", "fiscal01@teste.com", "Um teste apenas"),
        ("cuclan@teste.com", "ti@teste.com", "altos e baixos");
insert into mensagens_inbox (remet, dest)
values 	("ITC@teste.com", "fiscal01@teste.com"),
		("ITC@teste.com", "fiscal02@teste.com"),
        ("ITC@teste.com", "administrativo@teste.com"),
        ("ITC@teste.com", "rh@teste.com"),
        ("ITC@teste.com", "contabil01@teste.com");
insert into mensagens_inbox (remet, dest, assunto)
values ("Colarhst", "fiscal01@teste.com, fiscal02@teste.com", "fiscalização");
select * from mensagens_inbox;

-- ==================== Adicionando mensagens residuos ======================
insert into mensagens_residuos (remet, dest)
values 	("ITC@teste.com", "fiscal02@teste.com"),
		("ITC@teste.com", "fiscal02@teste.com"),
        ("ITC@teste.com", "rh@teste.com"),
        ("ITC@teste.com", "fiscal01@teste.com"),
        ("ITC@teste.com", "contabil01@teste.com");
select * from mensagens_residuos;

-- ==================== Associando mensagens da inbox com enderecos ==============
insert into mensagens_inbox_endereco (id_endereco, id_msg_inbox)
values 	(3, 1),
		(5, 2),
        (3, 3),
        (2, 4),
        (6, 5),
        (3, 6),
        (4, 7),
        (6, 8),
        (6, 9),
        (2, 10),
        (3, 11),
        (2, 12),
        (6, 13),
        (1, 14),
        (9, 15),
        (8, 16),
        (2, 17),
        (6, 17);
select * from mensagens_inbox_endereco;

-- ==================== Associando mensagens do residuos com enderecos ==============
insert into mensagens_residuos_endereco (id_endereco, id_msg_residuos)
values 	(6, 1),
		(6, 2),
        (9, 3),
        (2, 4),
        (8, 5);
select * from mensagens_residuos;
