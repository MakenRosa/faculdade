show fields from cfg;
insert into cfg(idCfg, dia) values  (2, "2022-06-02"), (3, "2022-06-01"), (4, "2022-05-31"), (5, "2022-05-30"), (9, "2022-05-29"); 
insert into cfg(idCfg, excepts) values (6, "departamento"), ("7", "yahoo"), (8, "testes"), (10, "diretor");
select * from cfg;

show fields from enderecos;

show fields from pessoas;

insert into pessoas(nmPessoa, cpfPessoa, cargoPessoa, matriculaPessoa) values("Leonardo", 123456789, "gerente", "005");
insert into pessoas(nmPessoa, cpfPessoa, cargoPessoa, matriculaPessoa) values("Daniel", 731913417, "Auxiliar Pessoal", "024");
update enderecos set endereco = "TI@exemplo.com" where nmPessoa = "Maken";
insert into enderecos(eKey, eInbox, eSetor, idPessoa, endereco) values ("senha", "INBOX", "Administrativo", 3, "teste@exemplo.com");
insert into enderecos(eKey, eInbox, eSetor, idPessoa, endereco) values ("outrasenha", "INBOX", "Fiscal", 5, "DF@exemplo.com");
insert into enderecos(eKey, eInbox, eSetor, idPessoa, endereco) values ("another key!", "INBOX", "Pessoal", 6, "DP@exemplo.com");
select p.nmPessoa, p.idPessoa, p.cargoPessoa, e.endereco from pessoas p, enderecos e where p.idPessoa = e.idPessoa;
