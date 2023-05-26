package util;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Componentes {
    private WebDriver driver;
    private Select select;

    private Alert alert;

    public void inicializa(){
        String chromeDriver = System.getProperty("user.dir") + "/Driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///" + System.getProperty("user.dir") + "/Driver/componentes.html");
    }

    public void testarTextFieldNome() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Maken");
    }

    public void testarTextFieldSobrenome() {
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Rosa");
    }
    public void clicarRadioButtonMasculino() {
        driver.findElement(By.id("elementosForm:sexo:0")).click();
    }

    public void clicarCheckBoxPizza() {
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
    }

    public void selecionarComboboxSuperior(){
        select = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
        select.selectByValue("superior");
    }

    public void clicarListboxEsporte(){
        select = new Select(driver.findElement(By.id("elementosForm:esportes")));
        select.selectByValue("nada");
    }

    public void clicarBotaoCadastrar() {
        driver.findElement(By.id("elementosForm:cadastrar")).click();
    }

    public void validarTextFieldNome() {
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().contains(driver.findElement(By.id("elementosForm:nome")).getAttribute("value")));
    }

    public void validarTextFieldSobrenome() {
        Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().contains(driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value")));
    }

    public void validarRadioButtonMasculino() {
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected() && driver.findElement(By.id("descSexo")).getText().contains("Masculino"));
    }

    public void validarCheckBoxPizza() {
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected() && driver.findElement(By.id("descComida")).getText().contains("Pizza"));
    }

    public void validarComboboxSuperior(){
        select = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
        Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().contains(select.getFirstSelectedOption().getText().toLowerCase()));
    }

    public void validarListbox() {
        select = new Select(driver.findElement(By.id("elementosForm:esportes")));
        Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().contains(select.getFirstSelectedOption().getText()));
    }

    public void validarBotaoCadastrar() {
        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Cadastrado!"));
    }

    public void fecharNavegador() {
        driver.quit();
    }

    public void validarNomeObrigatorio(){
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Nome eh obrigatorio");
        alert.accept();
    }

    public void validarSobrenomeObrigatorio(){
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Sobrenome eh obrigatorio");
        alert.accept();
    }

    public void validarSexoObrigatorio(){
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Sexo eh obrigatorio");
        alert.accept();
    }
}
