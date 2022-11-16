package stepdefinition;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import util.Componentes;

public class ComponentesStep {

    Componentes componentes = new Componentes();



    @Dado("que o usuário acessou o arquivo Campo de Treinamento")
    public void que_o_usuário_acessou_o_arquivo_Campo_de_Treinamento() {
        componentes.inicializa();
    }

    @Quando("o usuário digitar batatinha no campo textfield")
    public void o_usuário_digitar_batatinha_no_campo_textfield() {
        // Write code here that turns the phrase above into concrete actions
        componentes.testarTextField();
    }

    @Então("o resultado no campo textfield deve ser batatinha")
    public void o_resultado_no_campo_textfield_deve_ser_batatinha() {
        componentes.validarTextField();
        componentes.fecharNavegador();
    }

    @Quando("o usuário digitar batatinha\nbatatinha no campo textarea")
    public void o_usuário_digitar_batatinha_batatinha_no_campo_textarea() {
        componentes.testarTextArea();
    }

    @Então("o resultado no campo textarea deve ser batatinha\nbatatinha")
    public void o_resultado_no_campo_textarea_deve_ser_batatinha_batatinha() {
        componentes.validarTextArea();
        componentes.fecharNavegador();
    }


    @Quando("o usuário marcar masculino no componente radiobutton")
    public void o_usuário_marcar_masculino_no_componente_radiobutton() {
        componentes.clicarRadioButton();
    }

    @Então("o resultado no radiobutton deve ser masculino")
    public void o_resultado_no_radiobutton_deve_ser_masculino() {
        componentes.validarRadioButton();
        componentes.fecharNavegador();
    }

    @Quando("o usuário marcar frango no componente checkbox")
    public void o_usuário_marcar_frango_no_componente_checkbox() {
        componentes.clicarCheckBox();
    }

    @Então("o resultado no checkbox deve ser frango")
    public void o_resultado_no_checkbox_deve_ser_frango() {
        componentes.validarCheckBox();
        componentes.fecharNavegador();
    }

    @Quando("o usuario visualizar a tela")
    public void o_usuario_visualizar_a_tela() {
        componentes.pegarSelecaoCombobox();
    }

    @Então("devera estar selecionado a primeira opcao")
    public void devera_estar_selecionado_a_primeira_opcao() {
        componentes.validarSelecaoCombobox();
        componentes.fecharNavegador();
    }

    @Quando("o usuário clicar na combobox")
    public void o_usuário_clicar_na_combobox() {
        componentes.clicarCombobox();

    }

    @Então("devera ser visivel {int} opcoes")
    public void devera_ser_visivel_opcoes(Integer int1) {
        componentes.validarQuantidadeCombobox(int1);
        componentes.fecharNavegador();
    }

    @Quando("selecionar a opcao Mestrado")
    public void selecionar_a_opcao_Mestrado() {
        componentes.selecionarMestradoCombobox();
    }

    @Então("devera ser selecionado a opcao mestrado")
    public void devera_ser_selecionado_a_opcao_mestrado() {
        componentes.validarSelecaoMestradoCombobox();
        componentes.fecharNavegador();
    }


}
