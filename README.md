# Faculdade — Repositório de Projetos Acadêmicos

Este repositório guarda exercícios, provas e trabalhos feitos ao longo da graduação em **Análise e Desenvolvimento de Sistemas**.  
O conteúdo está organizado por **fases** (2ª, 3ª, 4ª) e por disciplinas, cobrindo desde fundamentos de POO em Java até web com Django, integração com APIs e automação de testes.

> **Aviso:** código histórico (criado há mais de 2 anos), com foco educacional. Pode conter dependências desatualizadas, _workarounds_ de sala de aula e estruturas mínimas. Use como referência/portfólio.

---

## Visão Geral das Pastas

- **aoo-2a-fase/MVC** — Exemplo didático do padrão **MVC** em Java (`Controller`, `Model`, `View`).
- **crud-2a-fase** — CRUD básico com **JDBC** e **DAO** para `Paciente` e `Endereco`.
- **poo-2a-fase** — Coleção de exercícios de **POO**: herança, polimorfismo, interfaces, agregação/associação, IO, JDBC, datas, recursão, exceções, _statics_.  
  - **trabalho_final_poo/gym_manager** — Mini-sistema de academia (cartão/passes, catraca, mensalidades) com regras de negócio e exceções específicas.
- **desenvolvimento-desktop-3a-fase**
  - **Prego** — App desktop em Java com **DAO** e `FabricaConexao`.
  - **ConsumindoCepAPI** — Consumo de API de CEP (cliente REST em Java).
  - **Senac_hibernate** e **Senac_hibernate_att** — CRUDs desktop com **Hibernate** (entidades, DAOs, telas Swing como `Login`, `TelaPrincipal`, etc.).
  - **prova_1** — Versão enxuta de CRUD com Hibernate (clientes/produtos).
- **padroes-com-interface-grafica-3a-fase/SuporteMPT** — Sistema desktop de suporte: **Swing + Hibernate**, DAOs, envio de e-mail (`util/EnviarEmail.java`) e telas de autenticação/atendimento.
- **arq-sist-soft-gest-info-3a-fase/E-Stock** — Projeto de **estoque** com camadas (`dao`, `entidade`) e `HibernateUtil`.
- **desenvolvimento-web-4a-fase**
  - **aulas/** e **exercicios/** — JS básico/DOM/fetch e integração com APIs.
  - **AGENDA (Django)** — Projeto web com `accounts` e `contatos` + `requirements.txt`.
  - **projeto/** (`movies`, `hobbies`) — Exemplos Django (URLs, views, models).
  - **api-pizza**, **menu-hamburguer**, **av_2** — Exercícios front-end/JS.
- **qualidade-e-testes-de-software-3a-fase/Projeto** — Automação de testes com **BDD** em Java (`features`, `stepdefinition`, `TestRunner`, utilitários de componentes).
- **.github/workflows/semantic-release.yml** — Workflow legado de CI (não aplicado a todos os subprojetos).

---

## Tecnologias & Conceitos

- **Java (JDK 8/11+)**: POO, MVC, **DAO**, **JDBC**, **Hibernate**, **Swing**.
- **Python 3**: scripts simples (APIs, logging).
- **JavaScript**: exercícios de DOM, eventos e consumo de APIs.
- **Django (Python)**: projetos web com apps, URLs, views e models.
- **Testes (Java)**: BDD/Cucumber-like (features, steps, runner).

---

## Como Executar (Guia Rápido)

> Cada pasta é um projeto independente. Abaixo, um roteiro genérico por stack.

### Java (Desktop/CRUD/Hibernate)
1. Instale **JDK 8+** (ideal 8 ou 11).
2. Importe o projeto na IDE (IntelliJ/Eclipse). Projetos com `src/main/java` seguem layout Maven; se não houver `pom.xml`, importe como “Existing Sources”.
3. Configure o banco e o **Hibernate** (arquivo `hibernate.cfg.xml`) caso exista.  
   - Ajuste URL do banco, usuário/senha e driver conforme seu ambiente.
4. Procure por classes “_main_” de interface (`Login`, `TelaPrincipal`, `Cadastro*`) e execute.

### Java (Cliente de API)
- Em **ConsumindoCepAPI**, rode as classes `CepRest.java`/`GensonProvider.java` conforme instruções internas do código (endpoints de CEP).

### Django (Python)
```bash
cd desenvolvimento-web-4a-fase/exercicios/AGENDA
python -m venv .venv
# Windows: .venv\Scripts\activate
# Linux/Mac: source .venv/bin/activate
pip install -r requirements.txt
python manage.py migrate
python manage.py runserver
````

Acesse `http://localhost:8000/`.

### JavaScript (exercícios)

* Abra o HTML correspondente (ou crie um HTML simples que importe o `script.js`) em um servidor estático local ou diretamente no navegador.

---

## Status do Projeto

* **Manutenção:** não ativa (código educacional/histórico).
* **Compatibilidade:** dependências podem estar defasadas; ajustes de versões podem ser necessários.
* **Contribuições:** PRs são bem-vindos para correções pequenas (ex.: instruções de build), mas o objetivo é **documentar** o acervo acadêmico.

---

## Estrutura Recomendada de Navegação

1. Comece por **poo-2a-fase** (fundamentos de POO).
2. Avance para **crud-2a-fase** (DAO/JDBC).
3. Explore **desenvolvimento-desktop-3a-fase** e **E-Stock** (Hibernate + Swing).
4. Veja **desenvolvimento-web-4a-fase** (JS/Django).
5. Consulte **qualidade-e-testes-de-software-3a-fase** para noções de testes/BDD.

---

## Licença

Sem licença explícita. Uso livre **apenas para fins educacionais** e consulta.
Se você é autor de alguma parte e deseja créditos/ajustes, abra uma *issue*.

---
