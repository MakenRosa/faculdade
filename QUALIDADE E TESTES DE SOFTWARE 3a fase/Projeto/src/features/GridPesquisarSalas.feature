#language:pt
Funcionalidade: Grid de Pesquisar Salas
  Contexto:
    Dado que o usuário está logado no sistema
    E o usuário está na modal de Pesquisar Salas

    Cenário: Validar elementos da inteface
      Quando o usuário estiver na modal inicial de pesquisar salas
      Entao Deve ser exibido o botão de Pesquisa no canto superior esquerdo
      E abaixo do botão de Pesquisa deve haver o campo Sala para digitar o nomde da sala que será pesquisada
      E deve haver uma opção de adicionar que abrirá a modal CadastrarSala

    Esquema do Cenario: Validar Pesquisa de Salas
      - O único campo de pesquisa de sala deve ser o campo "nome"
      - A mensagem de sala não cadastrada deve ser "A sala [nomeDaSala] não está cadastrada"
      Quando o usuário digitar um nome <existe> de sala cadastrada
      E pressionar o botão pesquisar
      Então o sistema deverá mostrar <resultado>
      Exemplos:
      |existe     | resultado|
      |existente  | todas as salas que contem o nome pesquisado|
      |inexistente| uma mensagem de feedback de que não há sala com esse nome cadastrado|

    Esquema do Cenario: Validar grid de salas
      - A grid de salas deverá ter 3 colunas: Sala, Descrição e Alterar
      Quando pesquisar uma sala cadastrada
      Então a Coluna <coluna> deverá <resultado>
      E a Coluna <coluna> não deverá poder ser redimensionada
      E as linhas da grid devem ter cores alternadas para facilitar a visualização
      Exemplos:
      | coluna      | resultado |
      | Sala        | Deverá ter a lista de salas que o usuário tem acesso|
      | Descrição   | Deverá ter a descrição da sala                      |
      | Alterar     | Deverá ter dois botões, um para Editar e outro para Excluir a sala|

    Cenário: Validar Tooltip Descrição
      - Os textos de descrição que excederem o limite deverão conter reticências no final excedente
      Dado que o usuário pesquisou uma sala em que o campo Descrição exceda o limite da coluna
      Quando o usuário posicionar o mouse sobre o texto da Descrição
      Então o sistema deverá mostrar um tooltip com todo o texto da Descrição

    Cenário: Validar paginação de salas
      - Deverá aparecer somente 3 páginas
      Quando o usuário pesquisar o nome de salas cadastradas
      Então o sistema deverá mostrar a quantidade todal de salas
      E qual página atual do usuário
      E em cada página deve aparecer por padrão 10 registros de salas
      E deverá ter opções para trocar as páginas
      E caso não haja salas cadastradas essas opções de troca de páginas devem ser desabilitadas

    Esquema do Cenario: Validar alteração de quantidade de registros
      - 10 deve estar como padrão de quantidade de registros por página
      Quando o usuário pesquisar por uma sala cadastrada
      Então deverá haver uma opção para alterar a quantidade de registros por sala para <quantidade>
      Exemplos:
      |quantidade|
      | 5        |
      | 10       |
      | 15       |


