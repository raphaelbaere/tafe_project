package automationpractice.test;

import org.junit.Assert;
import org.junit.Test;
import automationpractice.data.dto.SearchDTO;
import automationpractice.data.factory.datafaker.SearchData;
import automationpractice.page.SearchPage;

public class SearchTest extends BaseTest {

    SearchPage searchPage = new SearchPage();
    SearchData searchData = new SearchData();

    @Test
    public void validaSearchComProdutoValido(){
        searchPage.enviarProdutoNoSearch(searchData.produtoValido().getNome());
        String nomeDoProduto = searchPage.validarNomeDoProdutoBuscado();
        Assert.assertEquals("Printed Dress", nomeDoProduto);
    }

    @Test
    public void validaSearchComProdutoInvalido(){
        SearchDTO produtoNomeInvalido = searchData.produtoInvalido();
        searchPage.enviarProdutoNoSearch(produtoNomeInvalido.getNome());
        String mensagem = searchPage.validarMensagemDeNaoEncontrado();
        Assert.assertEquals("No results were found for your search \"" + produtoNomeInvalido.getNome() + "\"", mensagem);
    }

    @Test
    public void validaSearchComProdutoComNomeErros(){
        searchPage.enviarProdutoNoSearch(searchData.produtoComNomeProximo().getNome());
        String nomeDoProduto = searchPage.validarNomeDoProdutoBuscado();
        Assert.assertEquals("Printed Dress", nomeDoProduto);
    }





}
