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

    @Quando("o usuário preencher o campo Nome com a palavra Maken")
    public void o_usuário_preencher_o_campo_Nome_com_a_palavra_Maken() {
        // Write code here that turns the phrase above into concrete actions
        componentes.testarTextFieldNome();
    }

    @Quando("o usuário preencher o campo Sobrenome com a palavra Rosa")
    public void o_usuário_preencher_o_campo_Sobrenome_com_a_palavra_Rosa() {
        componentes.testarTextFieldSobrenome();
    }

    @Quando("o usuário marcar o radio button Sexo a opção Masculino")
    public void o_usuário_marcar_o_radio_button_Sexo_a_opção_Masculino() {
        componentes.clicarRadioButtonMasculino();
    }

    @Quando("o usuário marcar a checkbox de Comida Favorita a opção Pizza")
    public void o_usuário_marcar_a_checkbox_de_Comida_Favorita_a_opção_Pizza() {
        componentes.clicarCheckBoxPizza();
    }

    @Quando("o usuário escolher a opção Superior na combo box Escolaridade")
    public void o_usuário_escolher_a_opção_Superior_na_combo_box_Escolaridade() {
        componentes.selecionarComboboxSuperior();
    }

    @Quando("o usuário selecionar a opção O que eh esporte? na listbox Esportes")
    public void o_usuário_selecionar_a_opção_O_que_eh_esporte_na_listbox_Esportes() {
        componentes.clicarListboxEsporte();
    }

    @Quando("clicar no botão Cadastrar")
    public void clicar_no_botão_Cadastrar() {
        componentes.clicarBotaoCadastrar();
    }


    @Então("a div descNome deve conter a palavra do campo Nome")
    public void a_div_descNome_deve_conter_a_palavra_do_campo_Nome() {
        componentes.validarTextFieldNome();
    }

    @Então("a div descSobrenome deve conter a palavra do campo Sobrenome")
    public void a_div_descSobrenome_deve_conter_a_palavra_do_campo_Sobrenome() {
        componentes.validarTextFieldSobrenome();
    }

    @Então("a div descSexo deve conter o valor marcado no radio button Sexo")
    public void a_div_descSexo_deve_conter_o_valor_marcado_no_radio_button_Sexo() {
        componentes.validarRadioButtonMasculino();
    }

    @Então("a div descComida deve conter os valores marcados na checkbox Comida")
    public void a_div_descComida_deve_conter_os_valores_marcados_na_checkbox_Comida() {
        componentes.validarCheckBoxPizza();
    }

    @Então("a div descEscolaridade deve conter o valor selecionado na combobox Escolaridade")
    public void a_div_descEscolaridade_deve_conter_o_valor_selecionado_na_combobox_Escolaridade() {
        componentes.validarComboboxSuperior();
    }

    @Então("a div descEsportes deve conter o valor selecionado na listbox Esportes")
    public void a_div_descEsportes_deve_conter_o_valor_selecionado_na_listbox_Esportes() {
        componentes.validarListbox();
    }

    @Então("a div resultado deve conter a palavra Cadastrado!")
    public void a_div_resultado_deve_conter_a_palavra_Cadastrado() {
        componentes.validarBotaoCadastrar();
        componentes.fecharNavegador();
    }

    @Quando("o usuário Nao digitar nada no campo nome")
    public void o_usuário_Nao_digitar_nada_no_campo_nome() {
    }

    @Quando("pressionar o botao cadastrar")
    public void pressionar_o_botao_cadastrar() {
        componentes.clicarBotaoCadastrar();
    }

    @Então("deve aparecer um alerta com uma frase informando que o nome é obrigatorio")
    public void deve_aparecer_um_alerta_com_uma_frase_informando_que_o_nome_é_obrigatorio() {
        componentes.validarNomeObrigatorio();
    }

    @Quando("o usuário Nao digitar nada no campo sobrenome")
    public void o_usuário_Nao_digitar_nada_no_campo_sobrenome() {
        componentes.testarTextFieldNome();
    }

    @Então("deve aparecer um alerta com uma frase informando que o sobrenome é obrigatorio")
    public void deve_aparecer_um_alerta_com_uma_frase_informando_que_o_sobrenome_é_obrigatorio() {
        componentes.validarSobrenomeObrigatorio();
    }

    @Quando("o usuário Nao marcar opcao no radion button sexo")
    public void o_usuário_Nao_marcar_opcao_no_radion_button_sexo() {
        componentes.testarTextFieldNome();
        componentes.testarTextFieldSobrenome();
    }

    @Então("deve aparecer um alerta com uma frase informando que o sexo é obrigatorio")
    public void deve_aparecer_um_alerta_com_uma_frase_informando_que_o_sexo_é_obrigatorio() {
        componentes.validarSexoObrigatorio();
    }
}
