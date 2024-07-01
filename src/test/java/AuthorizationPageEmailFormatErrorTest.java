import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.AuthorizationPage;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class AuthorizationPageEmailFormatErrorTest extends BaseTest {
    private final String email;
    private final String password;

    public AuthorizationPageEmailFormatErrorTest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"","test"},
                {"",""},
                {"testprotey.ru","test"}

        };
    }
    @DisplayName("Тест неуспешной авторизации пользователя с ошибкой:Неверный формат E-Mail ")
    @Test
    public void checkUnSuccessfullyAuthorizationEmailFormatError() {
        new AuthorizationPage(driver)
                .emailFieldInput(email)
                .passwordFieldInput(password)
                .enterButtonClick()
                .checkUnSuccessfullyAuthorizationMassageEmailFormatError();

    }

}