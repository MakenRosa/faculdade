-- ====================== selects simples ====================
select * from pessoas;
select * from enderecos_email;
select * from mensagens_inbox;
select * from mensagens_inbox_endereco;
select * from mensagens_residuos;
select * from mensagens_residuos_endereco;
select * from relatorio_nao_respondidas;
select * from relatorio_mensagens_inbox;
select * from relatorio_mensagens_residuos;
select * from ultima_data;
select * from remetente_excecoes;

-- ===================== selects avançados ======================
select en.endereco_email, mi.*
from mensagens_inbox mi, mensagens_inbox_endereco mie, enderecos_email en
where mi.id_msg_inbox = mie.id_msg_inbox and mie.id_endereco = en.id_endereco;

select mi.*
from mensagens_inbox mi, mensagens_inbox_endereco mie, enderecos_email en
where mi.id_msg_inbox = mie.id_msg_inbox and mie.id_endereco = en.id_endereco and en.departamento = "Fiscal";

select mr.*
from mensagens_residuos mr, relatorio_mensagens_residuos rmr, relatorio_nao_respondidas rnr
where mr.id_msg_residuos = rmr.id_msg_residuos and rmr.id_relatorio = 2;
