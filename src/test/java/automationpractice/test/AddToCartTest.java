package automationpractice.test;

import org.junit.Test;
import automationpractice.data.factory.datafaker.LoginData;
import automationpractice.page.*;

public class AddToCartTest extends BaseTest {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    SummaryCartPage summaryCartPage = new SummaryCartPage();
    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    @Test
    public void validarAdicionarUmProdutoAoCarrinhoComSucesso() {
        homePage.clicarBotaoCategoriaWomen();
        homePage.selecionarProdutoNaCategoriaWomen();
        productPage.adicionarProdutoAoCarrinho();
        productPage.clicarIrParaSumarioDoCarrinho();
        summaryCartPage.fecharCarrinhoCompras();
    }
    @Test
    public void validarMensagemAdicionarProdutoAoCarrinhoSemEstoque() {
        homePage.clicarBotaoCategoriaWomen();
        homePage.selecionarProdutoNaCategoriaWomen();
        productPage.validarMensagemProdutoForaDeEstoque();
    }
}
