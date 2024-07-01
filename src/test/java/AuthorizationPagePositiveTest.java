import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.AuthorizationPage;
import io.qameta.allure.junit4.DisplayName;

import static constans.Data.VALID_AUTHORIZATION_EMAIL;
import static constans.Data.VALID_AUTHORIZATION_PASSWORD;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class AuthorizationPagePositiveTest extends BaseTest {
    private final String email;
    private final String password;

    public AuthorizationPagePositiveTest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {VALID_AUTHORIZATION_EMAIL, VALID_AUTHORIZATION_PASSWORD}

        };
    }

    @DisplayName("Тест успешной авторизации пользователя ")
    @Test
    public void checkSuccessfullyAuthorization() {
        new AuthorizationPage(driver)
                .emailFieldInput(email)
                .passwordFieldInput(password)
                .enterButtonClick()
                .checkSuccessfullyAuthorizationByClickEnterButton();

    }

}