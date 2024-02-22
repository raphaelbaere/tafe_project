package automationpractice.test;

import org.junit.Assert;
import org.junit.Test;
import automationpractice.data.dto.SignInDTO;
import automationpractice.data.factory.datafaker.SignInData;
import automationpractice.page.AuthenticationPage;
import automationpractice.page.SignInPage;

import java.util.ArrayList;


public class SignInTest extends BaseTest{
    SignInData signInData = new SignInData();
    SignInPage signInPage = new SignInPage();
    AuthenticationPage authenticationPage = new AuthenticationPage();

    @Test
    public void validarRegistroComDadosValidos(){
        SignInDTO signInDTO = signInData.signInDadosValidosDinamicos();
        authenticationPage.irParaPaginaSignInERegistrarUmaContaComEmailValido(signInDTO);
        ArrayList<String> mensagens = signInPage.registrarUsuarioValido(signInDTO);

        Assert.assertEquals("Your account has been created.", mensagens.get(0));
        Assert.assertEquals(signInDTO.getFirstName() + " " + signInDTO.getLastName(), mensagens.get(1));
    };

    @Test
    public void validarRegistroComEmailInvalido(){
        SignInDTO signInDTO = signInData.signInDadosValidosDinamicos();
        authenticationPage.irParaPaginaSignInERegistrarUmaContaComEmailValido(signInDTO);
        String mensagem = signInPage.registrarUsuarioInvalido(signInDTO);

        Assert.assertEquals("email is invalid.", mensagem);
    };
}
