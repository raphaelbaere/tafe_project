package automationpractice.test;

import org.junit.Assert;
import org.junit.Test;
import automationpractice.data.dto.ContactDTO;
import automationpractice.data.factory.datafaker.ContactData;
import automationpractice.page.ContactPage;

public class ContactTest extends BaseTest {

    ContactPage contactPage = new ContactPage();

    ContactData contactData = new ContactData();

    @Test
    public void validarMensagemDeContatoComDadosValidos() {
        ContactDTO usu = contactData.contatoComDadosValido();
        String msgmTituloContact = contactPage.validarPaginaContact();
        Assert.assertEquals("CUSTOMER SERVICE - CONTACT US", msgmTituloContact);
        String msgmSucesso = contactPage.mandarMensagemDeContato(usu.getEmail(), usu.getMsg());
        Assert.assertEquals("Your message has been successfully sent to our team.", msgmSucesso);
    }

    @Test
    public void validarMensagemDeContatoComMensagemVazia() {
        ContactDTO usu = contactData.contatoComMensagemInvalida();
        String msgmTituloContact = contactPage.validarPaginaContact();
        Assert.assertEquals("CUSTOMER SERVICE - CONTACT US", msgmTituloContact);
        String msgmContatoVazio = contactPage.mensagemDeContatoVazia(usu.getEmail(), usu.getMsg());
        Assert.assertEquals("The message cannot be blank.", msgmContatoVazio);
    }

    @Test
    public void validarMensagemDeContatoComEmailInvalido() {
        ContactDTO usu = contactData.contatoComEmailInvalido();
        String msgmTituloContact = contactPage.validarPaginaContact();
        Assert.assertEquals("CUSTOMER SERVICE - CONTACT US", msgmTituloContact);
        String msgmEmailInvalido = contactPage.mensagemDeContatoEmailInvalido(usu.getEmail(), usu.getMsg());
        Assert.assertEquals("Invalid email address.", msgmEmailInvalido);
    }

    @Test
    public void validarMensagemDeContatoAssuntoNaoSelecionado() {
        ContactDTO usu = contactData.contatoComDadosValido();
        String msgmTituloContact = contactPage.validarPaginaContact();
        Assert.assertEquals("CUSTOMER SERVICE - CONTACT US", msgmTituloContact);
        String msgmAssuntoNaoSelecionado = contactPage.mensagemDeContatoAssuntoInvalido(usu.getEmail(), usu.getMsg());
        Assert.assertEquals("Please select a subject from the list provided.", msgmAssuntoNaoSelecionado);
    }

}
