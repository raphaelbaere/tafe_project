package automationexercises.page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final By campoEmail =
            By.cssSelector("input[data-qa=\"login-email\"]");


    private static final By campoSenha =
            By.cssSelector("[data-qa=\"login-password\"]");

    private static final By btnAcessar =
            By.cssSelector("#form div div div.col-sm-4.col-sm-offset-1 div form > button");

    private static final By textMsgBtn =
            By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4)");

    private static final By msgEmailIncorreto =
            By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > p");

    public void preencherCampoEmail(String email) {
        preencherInput(campoEmail, email);
    }

    public void preencherCampoSenha(String senha) {
        preencherInput(campoSenha, senha);
    }

    public void clicarBtnAcessar() {
        clicar(btnAcessar);
    }

    public String validarTextoBtnAposLogin() {
        return lerTexto(textMsgBtn);
    }

    public String validarMsgEmailIncorreto() {
        return lerTexto(msgEmailIncorreto);
    }

    public String fazerLogin(String email, String senha) {
        preencherInput(campoEmail, email);
        preencherInput(campoSenha, senha);
        clicar(btnAcessar);
        return lerTexto(textMsgBtn);
    }

    public String loginEmailIncorreto(String email, String senha) {
        preencherInput(campoEmail, email);
        preencherInput(campoSenha, senha);
        clicar(btnAcessar);
        return lerTexto(msgEmailIncorreto);
    }
}
