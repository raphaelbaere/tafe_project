package automationexercises.test;

import automationexercises.data.factory.datafaker.LoginData;
import automationexercises.data.dto.LoginDTO;
import automationexercises.page.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    @Test
    public void validarLoginComDadosValidos(){
        LoginDTO usu = loginData.loginDadosValidos();
        loginPage.preencherCampoEmail(usu.getEmail());
        loginPage.preencherCampoSenha(usu.getSenha());
        loginPage.clicarBtnAcessar();
        String msgm = loginPage.validarTextoBtnAposLogin();
        Assert.assertEquals("Logout", msgm);

    };

    @Test
    public void validarLoginDadosInvalidos() {
        LoginDTO usu = loginData.loginDadosDinamicos();
        loginPage.preencherCampoEmail(usu.getEmail());
        loginPage.preencherCampoSenha(usu.getSenha());
        loginPage.clicarBtnAcessar();
        String msgm = loginPage.validarMsgEmailIncorreto();
        Assert.assertEquals("Your email or password is incorrect!", msgm);
    }

}
