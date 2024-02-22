package automationpractice.test;
import org.junit.Assert;
import org.junit.Test;
import automationpractice.data.dto.LoginDTO;
import automationpractice.data.factory.datafaker.LoginData;
import automationpractice.page.LoginPage;

public class LoginTest extends BaseTestLogin {

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    @Test
    public void validarLoginComDadosValidos(){
        LoginDTO usuario = loginData.loginDadosValidos();
        loginPage.preencherCampoEmail(usuario.getEmail());
        loginPage.preencherCampoSenha(usuario.getSenha());
        loginPage.clicarBtnAcessar();
        Assert.assertTrue(loginPage.validarLoginArea());

    };

    @Test
    public void validarLoginDadosInvalidos() {
        LoginDTO usuario = loginData.loginDadosDinamicos();
        loginPage.preencherCampoEmail(usuario.getEmail());
        loginPage.preencherCampoSenha(usuario.getSenha());
        loginPage.clicarBtnAcessar();
        String mensagem = loginPage.validarMsgEmailIncorreto();
        Assert.assertEquals("Authentication failed.", mensagem);
    }

    @Test
    public void validarLoginTodosDadosVazios(){
        LoginDTO usuario = loginData.loginCamposVazios();
        loginPage.preencherCampoEmail(usuario.getEmail());
        loginPage.preencherCampoSenha(usuario.getSenha());
        loginPage.clicarBtnAcessar();
        String mensagem = loginPage.validarMsgEmailIncorreto();
        Assert.assertEquals("An email address required.", mensagem);
    }

    @Test
    public void validarLoginComEmailValidoESenhaVazia(){
        LoginDTO usuario = loginData.loginComEmailValidoSemSenha();
        loginPage.preencherCampoEmail(usuario.getEmail());
        loginPage.preencherCampoSenha(usuario.getSenha());
        loginPage.clicarBtnAcessar();
        String mensagem = loginPage.validarMsgEmailIncorreto();
        Assert.assertEquals("Password is required.", mensagem);
    }

    @Test
    public void validarLoginComEmailInvalido(){
        LoginDTO usuario = loginData.loginEmailInvalido();
        loginPage.preencherCampoEmail(usuario.getEmail());
        loginPage.preencherCampoSenha(usuario.getSenha());
        loginPage.clicarBtnAcessar();
        String mensagem = loginPage.validarMsgEmailIncorreto();
        Assert.assertEquals("Invalid email address.", mensagem);
    }
}
