import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.AuthorizationPage;

public class AuthorizationPageAlertButtonCloseTest extends BaseTest {
    private String email;
    private String password;


    @DisplayName("Тест кнопки закрытия окна ошибки Неверный E-Mail или пароль ")
    @Test
    public void alertButtonCloseInvalidEmailPassword() {
        email = "test@protei.com";
        password = "test";
        new AuthorizationPage(driver)
                .emailFieldInput(email)
                .passwordFieldInput(password)
                .enterButtonClick()
                .closeButtonClick()
                .checkAlertButtonCloseInvalidEmailPassword();

    }

    @DisplayName("Тест кнопки закрытия окна ошибки Неверный формат E-Mail")
    @Test
    public void alertButtonCloseEmailFormatError() {
        email = "@";
        password = "test";
        new AuthorizationPage(driver)
                .emailFieldInput(email)
                .passwordFieldInput(password)
                .enterButtonClick()
                .closeButtonClick()
                .checkAlertButtonCloseEmailFormatError();

    }
}