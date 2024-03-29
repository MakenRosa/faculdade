/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.api;

import br.com.senac.entidade.Endereco;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

/**
 *
 * @author maken.rosa
 */
public class CepRest {

    private final Client client;
    private final WebResource webResource;

    public CepRest() {
        ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
        client = Client.create(clientConfig);
        client.addFilter(new LoggingFilter(System.out));
        webResource = client.resource("https://viacep.com.br/ws/");
    }

    public Endereco pesquisaCep(String cep) {
        return webResource.path(cep).path("/json").get(Endereco.class);
    }
}
