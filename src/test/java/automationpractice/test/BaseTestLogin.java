package automationpractice.test;

import org.junit.After;
import org.junit.Before;
import automationpractice.data.factory.seleniumfactory.SeleniumFactory;

public class BaseTestLogin {

    SeleniumFactory seleniumFactory = new SeleniumFactory();

    @Before
    public void abrirNavegador() {
        seleniumFactory.initBrowser("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    @After
    public void fecharNavegador() {
        seleniumFactory.tearDown();
    }
}
