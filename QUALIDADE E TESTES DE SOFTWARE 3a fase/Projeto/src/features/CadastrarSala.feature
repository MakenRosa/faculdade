#language:pt
Funcionalidade: Cadastrar sala

  Contexto:
    Dado que o usuário está logado no sistema
    E que o usuário acessou a modal Cadastrar Sala

  Cenario: Validar campo obrigatório
  - O campo Sala é obrigatório.
    Quando o usuário acessar a modal Cadastrar Sala
    Então no campo Sala deve conter um asterisco

  Esquema do Cenario: Validar máximo de caracteres no campo Descrição
    - Máximo de 500 caracteres no campo Descrição
    Quando o usuário digitar <quantidade> caracteres no campo Descrição
    Então o sistema deverá <resultado>
    Exemplos:
    |quantidade |resultado|
    |499        |permitir o cadastro do campo Descrição|
    |500        |permitir o cadastro do campo Descrição|
    |501        |informar uma mensagem de erro de caracteres máximo atingido|

  Cenario: Validar salas duplicadas
  - "Não é possível cadastrar a sala. Já existe uma sala cadastradacom o mesmo nome. Altere o nome e tente novamente"
    Dado que o usuário digitou o nome de uma sala já existente
    Quando o usuário tentar salvar a sala
    Então deverá informar uma mensagem de feedback informando que sala já está cadastrada

  Cenario: Validar mensagem de salvamento
    Dado que o usuário digitou todas as informações da sala corretamente
    Quando o usuário pressionar o botão de salvamento
    Então deverá ser exibida uma mensagem de feedback informando o salvamento
    E a sala deverá estar visível na listagem de salas do grid de pesquisar salas

  Cenario: Validar cancelamento de cadastro
    Quando o usuário pressionar o botão de cancelamento de cadastro
    Então o sistema deverá limpar os valores de todos os campos
    E cancelar o cadastro da sala
