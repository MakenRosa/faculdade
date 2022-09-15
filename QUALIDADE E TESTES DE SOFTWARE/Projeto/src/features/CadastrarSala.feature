#language:pt
  Funcionalidade: Cadastrar sala

    # O campo sala deve ser obrigatório;
  Cenario: Validar campo obrigatório
    - O campo Sala é obrigatório.
    Dado que o usuário está logado no sistema
    Quando o usuário acessar a modal Cadastrar Sala
    Então no campo Sala deve conter um asterisco
