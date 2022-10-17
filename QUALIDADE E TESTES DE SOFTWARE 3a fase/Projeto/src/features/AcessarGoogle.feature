#language:pt
  Funcionalidade: Acessar site Senac Faculdade palhoça
    Contexto:
      Dado que o usuário está com o navegador aberto

      Cenario: Acessar página do google
        Quando acessar a url www.google.com
        Então a página do google deve ser apresentada

      Cenario: Acessar site da Faculdade Senac
        Dado que o usuário acessou a url www.google.com
        E pesquisou porFaculdade Senac
        Quando clicar no link Senac Santa Catarina
        Então o site da Faculdade Senac deve ser aberto