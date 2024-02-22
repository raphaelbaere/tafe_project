package automationpractice.test;

import org.junit.Assert;
import org.junit.Test;
import automationpractice.data.factory.datafaker.NewsletterEmailData;
import automationpractice.page.HomePage;
import automationpractice.utils.Scroll;

public class HomeNewsLetterTest extends BaseTest {

    private HomePage homePage = new HomePage();

    NewsletterEmailData factory = new NewsletterEmailData();

    @Test
    public void validarUmaInscricaoNewsLetterComEmailValido() {
        String response = homePage.enviarEmailNewsletter(factory.getDTOcomEmailValido().getEmail());

        Assert.assertEquals("Newsletter : You have successfully subscribed to this newsletter.", response);
    }

    @Test
    public void validarMensagemDeEmailRepetido() {
        String response = homePage.enviarEmailNewsletter(factory.getDTOcomEmailExistente().getEmail());

        Assert.assertEquals("Newsletter : This email address is already registered.", response);
    }

    @Test
    public void validarMensagemDeEmailInvalido() {
        String response = homePage.enviarEmailNewsletter(factory.getDTOcomEmailVazio().getEmail());

        Assert.assertEquals("Newsletter : Invalid email address.", response);
    }
}
