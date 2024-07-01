import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.InputsPage;

import static constans.Data.VALID_AUTHORIZATION_EMAIL;
import static constans.Data.VALID_AUTHORIZATION_PASSWORD;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class InputsPageBlankNameErrorTest extends BaseTest {
    private final String email;
    private final String name;

    public InputsPageBlankNameErrorTest(String email, String name) {
        this.email = email;
        this.name = name;
    }

    @Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"test1@ya.ru", ""},
                {"test1@ya.ru", " "}

        };
    }

    @DisplayName("Тест неуспешного заполнения анкеты с ошибкой:Поле имя не может быть пустым")
    @Test
    public void checkUnSuccessfullyAddDataEmailFormatError() {
        new InputsPage(driver)
                .userLogin(VALID_AUTHORIZATION_EMAIL, VALID_AUTHORIZATION_PASSWORD)
                .dataEmailInput(email)
                .dataNameInput(name)
                .dataSend()
                .checkAlertButtonCloseBlankNameError();

    }

}