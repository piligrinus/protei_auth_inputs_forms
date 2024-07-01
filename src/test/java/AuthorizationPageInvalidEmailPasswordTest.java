import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.AuthorizationPage;
import io.qameta.allure.junit4.DisplayName;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class AuthorizationPageInvalidEmailPasswordTest extends BaseTest {
    private final String email;
    private final String password;

    public AuthorizationPageInvalidEmailPasswordTest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"test@protei.ru", "Test"},
                {"test@protei.ru", ""},
                {"test@protey.ru", "test"},
                {"1@2.com", " test"}

        };
    }

    @DisplayName("Тест неуспешной авторизации пользователя с ошибкой Неверный E-Mail или пароль ")
    @Test
    public void checkUnSuccessfullyAuthorizationWrongEmailAndPass() {
        new AuthorizationPage(driver)
                .emailFieldInput(email)
                .passwordFieldInput(password)
                .enterButtonClick()
                .checkUnSuccessfullyAuthorizationMassageWrongEmailOrPass();

    }

}