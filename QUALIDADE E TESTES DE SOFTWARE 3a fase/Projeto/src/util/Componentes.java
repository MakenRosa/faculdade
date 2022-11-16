package util;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Componentes {
    private WebDriver driver;
    private Select select;

    public void inicializa(){
        String chromeDriver = System.getProperty("user.dir") + "/Driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///" + System.getProperty("user.dir") + "/Driver/componentes.html");
    }

    public void testarTextField() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("batatinha");
    }

    public void testarTextArea() {
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("batatinha\n" +
                                                                                    "batatinha");
    }

    public void validarTextField() {
        Assert.assertEquals("batatinha", driver.findElement(By.id("elementosForm:nome"))
                .getAttribute("value"));
    }

    public void validarTextArea() {
        Assert.assertEquals("batatinha\nbatatinha", driver.findElement(By.id("elementosForm:sugestoes"))
                .getAttribute("value"));
    }

    public void clicarRadioButton() {
        driver.findElement(By.id("elementosForm:sexo:0")).click();
    }

    public void validarRadioButton() {
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
    }

    public void clicarCheckBox() {
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
    }

    public void validarCheckBox() {
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
    }

    public void clicarCombobox(){
        driver.findElement(By.id("elementosForm:escolaridade")).click();
    }

    public void validarQuantidadeCombobox(int qtd) {
        pegarSelecaoCombobox();
        Assert.assertEquals(select.getOptions().size(), qtd);
    }

    public void selecionarMestradoCombobox(){
        pegarSelecaoCombobox();
        select.selectByValue("mestrado");
    }

    public void validarSelecaoMestradoCombobox(){
        pegarSelecaoCombobox();
        Assert.assertEquals("Mestrado", select.getFirstSelectedOption().getText());
    }

    public void pegarSelecaoCombobox() {
        select = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
    }

    public void validarSelecaoCombobox(){
        Assert.assertEquals("1o grau incompleto", select.getFirstSelectedOption().getText());

    }

    public void fecharNavegador() {
        driver.quit();
    }
}
