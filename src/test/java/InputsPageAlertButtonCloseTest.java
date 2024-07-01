import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.InputsPage;
import static constans.Data.VALID_AUTHORIZATION_EMAIL;
import static constans.Data.VALID_AUTHORIZATION_PASSWORD;


public class InputsPageAlertButtonCloseTest extends BaseTest {


    @DisplayName("Тест кнопки закрытия окна ошибки Неверный формат E-Mail ")
    @Test
    public void alertButtonCloseInvalidEmail() {

        new InputsPage(driver)
                .userLogin(VALID_AUTHORIZATION_EMAIL, VALID_AUTHORIZATION_PASSWORD)
                .dataEmailInput("test.ru")
                .dataNameInput("Test")
                .dataSend()
                .closeButtonClick()
                .checkAlertButtonCloseEmailFormatError();

    }

    @DisplayName("Тест кнопки закрытия окна ошибки Поле Имя не может быть пустым")
    @Test
    public void alertButtonCloseBlankNameError() {
        new InputsPage(driver)
                .userLogin(VALID_AUTHORIZATION_EMAIL, VALID_AUTHORIZATION_PASSWORD)
                .dataEmailInput("test@ya.ru")
                .dataNameInput("")
                .dataSend()
                .closeButtonClick()
                .checkAlertButtonCloseBlankNameError();

    }
}
