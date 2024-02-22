package automationpractice.test;

import automationpractice.data.factory.seleniumfactory.SeleniumFactory;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    SeleniumFactory seleniumFactory = new SeleniumFactory();

    @Before
    public void abrirNavegador() {
        seleniumFactory.initBrowser("http://www.automationpractice.pl/index.php");
    }

    @After
    public void fecharNavegador() {
        seleniumFactory.tearDown();
    }
}
