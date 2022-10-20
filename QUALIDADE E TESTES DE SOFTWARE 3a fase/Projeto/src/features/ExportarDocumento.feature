#language:pt
Funcionalidade: Exportar Documento PDF
  Contexto:
    Dado que o usuário tem acesso ao sistema

    #R01 História A e B
  Esquema do Cenario: Validar opção de exportação
    Quando o usuário estiver na modal do sistema
    Entao deverá estar visível a opção de exportar o arquivo como <formato>
    Exemplos:
    |formato|
    |PDF    |
    |ZIP    |

    #R02 História A e B
  Esquema do Cenario: Validar local de salvamento
    - A responsabilidade de garantir que o destino escolhido permita gravação é do próprio usuário
    Quando ele utilizar a opção de exportar o arquivo <formato>
    Então o sistema operacional deverá disponibilizar uma forma para o usuário escolher onde quer salvar o arquivo
    Exemplos:
    |formato|
    |PDF    |
    |ZIP    |

    #R03 e R04 História A e B e R08 da História 2
    Esquema do Cenario: Validar arquivos
    Quando ele tentar exportar algum arquivo <arquivo> com a opção de exportar <formato>
    Entao deverá ser exibida uma mensagem de que o sistema não irá baixar os arquivos
    E será exibida uma mensagem informando o problema
    E <acao>
    Exemplos:
    |arquivo|formato|acao|
    |indisponivel, corrompido ou em formato diferente de PDF|PDF|cabera ao usuario aceitar ou nao a exportacao|
    |indisponivel ou corrompido                             |ZIP|o sistema devera baixar os arquivos corrompidos/indisponiveis em formato TXT|

      #R05 História A e B
    Esquema do Cenario: Validar exportação de vários documentos
      Dado que há mais de um arquvio disponível para exportação na árvore de documentos apresentada
      Quando o usuário pressionar para exportar os arquivos no formato <formato>
      Entao os arquivos deverão <exportar>
      Exemplos:
      |formato|exportar|
      |PDF    |ser unificados em um unico documento|
      |ZIP    |ser exportados separadamente        |

      #R06 História A e B
    Esquema do Cenario: Validar início do download
      Dado que tenha arquivos válidos disponíveis para download
      Quando ele pressionar para iniciar o processo de exportação do arquivo <formato>
      Entao deverá ser exibida um aviso de que o processo não podera ser cancelado após iniciado
      E cabe ao usuário verificar a conclusão do procedimento
      E caso haja interrupção que seja relativo ao ambiente local, ou servidor, o usuário deverá refazer o procedimento
      Exemplos:
      |formato|
      |PDF    |
      |ZIP    |

      #R07 História A e B
    Esquema do Cenario: Validar formato
      Dado que o usuário tem acesso ao sistema
      Quando o usuário fizer a exportação de algum arquivo válido
      Então o documento exportado deverá estar no formato <formato>
      Exemplos:
      |formato|
      |PDF    |
      |ZIP    |
