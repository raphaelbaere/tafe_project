package automationpractice.page;

import org.openqa.selenium.By;
import automationpractice.data.dto.SignInDTO;

public class AuthenticationPage extends BasePage{
    private static final By btnSignIn =
            By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    private static final By campoEmailCreate =
            By.cssSelector("#email_create");
    private static final By btnCreateAccount =
            By.cssSelector("#SubmitCreate");

    public void irParaPaginaSignInERegistrarUmaContaComEmailValido(SignInDTO signINDTO) {
        clicar(btnSignIn);

        preencherInput(campoEmailCreate, signINDTO.getEmail());

        clicar(btnCreateAccount);
    }

}
