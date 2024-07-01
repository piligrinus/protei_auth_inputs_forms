import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.InputsPage;
import static constans.Data.VALID_AUTHORIZATION_EMAIL;
import static constans.Data.VALID_AUTHORIZATION_PASSWORD;

public class InputsPageOkButtonTest extends BaseTest  {

    @DisplayName("Проверка открытия и закрытия окна Данные добавлены по нажатию кнопки Ок")
    @Test
    public void checkSuccessfullyMassageWindowTest(){
        new InputsPage(driver)
                .userLogin(VALID_AUTHORIZATION_EMAIL, VALID_AUTHORIZATION_PASSWORD)
                .dataEmailInput("test1@ya.ru")
                .dataNameInput("Тест")
                .dataSend()
                .checkSuccessfullyAddData()
                .okButtonClick()
                .checkCloseWindowByClickOkButton();

    }

}
