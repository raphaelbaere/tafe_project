package automationexercises.data.factory.datafaker;

import automationexercises.data.dto.LoginDTO;
import automationexercises.utils.DataFakerGenerator;

public class LoginData {

    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public LoginDTO loginDadosValidos() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("vs@gmail.com");
        loginDTO.setSenha("123456");
        return loginDTO;
    }

    public LoginDTO loginDadosDinamicos() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(dataFakerGenerator.emailFaker());
        loginDTO.setSenha(dataFakerGenerator.senhaFaker());
        return loginDTO;
    }
}
