#language:pt
@acessar_varios_componentes_html
Funcionalidade: Acessar componentes

  Contexto:
    Dado que o usuário acessou o arquivo Campo de Treinamento

  # Eu não sabia se poderia fazer com esquema do cenário ou não, por isso fiz assim
  # Seria muito mais fácil ter feito com esquema do cenário kk

  Cenário: Validar Campos
    Quando o usuário preencher o campo Nome com a palavra Maken
    E o usuário preencher o campo Sobrenome com a palavra Rosa
    E o usuário marcar o radio button Sexo a opção Masculino
    E o usuário marcar a checkbox de Comida Favorita a opção Pizza
    E o usuário escolher a opção Superior na combo box Escolaridade
    E o usuário selecionar a opção O que eh esporte? na listbox Esportes
    E clicar no botão Cadastrar
    Então a div descNome deve conter a palavra do campo Nome
    E a div descSobrenome deve conter a palavra do campo Sobrenome
    E a div descSexo deve conter o valor marcado no radio button Sexo
    E a div descComida deve conter os valores marcados na checkbox Comida
    E a div descEscolaridade deve conter o valor selecionado na combobox Escolaridade
    E a div descEsportes deve conter o valor selecionado na listbox Esportes
    E a div resultado deve conter a palavra Cadastrado!

  Esquema do Cenário: Validar Campos Obrigatórios
    Quando o usuário <acao> <campo>
    E <pressionar>
    Então deve aparecer um alerta com uma frase informando que o <campo> é obrigatorio
    Exemplos:
    |acao                             |campo        |pressionar                  |
    |Nao digitar nada no campo        |nome         |pressionar o botao cadastrar|
    |Nao digitar nada no campo        |sobrenome    |pressionar o botao cadastrar|
    |Nao marcar opcao no radion button|sexo         |pressionar o botao cadastrar|