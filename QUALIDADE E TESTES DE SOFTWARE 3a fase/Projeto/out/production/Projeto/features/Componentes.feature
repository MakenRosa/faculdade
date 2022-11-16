#language:pt
@acessar_varios_componentes_html
Funcionalidade: Acessar componentes

  Contexto:
    Dado que o usuário acessou o arquivo Campo de Treinamento

  Esquema do Cenário: Validar campos textfield e textarea
  Quando o usuário digitar <frase> no campo <campo>
  Então o resultado no campo <campo> deve ser <frase>
  Exemplos:
  |frase               |campo    |
  |batatinha           |textfield|
  |batatinha\nbatatinha|textarea |

  Esquema do Cenário: Validar campos radiobutton e checkbox
  Quando o usuário marcar <marcacao> no componente <componente>
  Então o resultado no <componente> deve ser <marcacao>
  Exemplos:
  |marcacao |componente  |
  |masculino|radiobutton |
  |frango   |checkbox    |

  Esquema do Cenário: Validar combobox
    Quando <acao>
    Então <resposta>
    Exemplos:
    |acao                        |resposta                                  |
    |o usuario visualizar a tela |devera estar selecionado a primeira opcao |
    |o usuário clicar na combobox|devera ser visivel 8 opcoes               |
    |selecionar a opcao Mestrado |devera ser selecionado a opcao mestrado   |
