import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.InputsPage;

import static constans.Data.VALID_AUTHORIZATION_EMAIL;
import static constans.Data.VALID_AUTHORIZATION_PASSWORD;

public class InputsPageEndToEndTest extends BaseTest {

    @DisplayName("Тест заполнения анкеты: Муж 1.1 1.2-да 2.1-да")
    @Test
    public void checkAddDataMaleChoice1Choice2Select1(){
        new InputsPage(driver)
                .userLogin(VALID_AUTHORIZATION_EMAIL, VALID_AUTHORIZATION_PASSWORD)
                .dataEmailInput("test1@ya.ru")
                .dataNameInput("Тест")
                .dataCheck11()
                .dataCheck12()
                .dataSelect21()
                .dataSend()
                .okButtonClick()
                .checkSuccessfullyAddEmail("test1@ya.ru")
                .checkSuccessfullyAddName("Тест")
                .checkSuccessfullyAddGender("Мужской")
                .checkSuccessfullyAddChoice_1("1.1, 1.2")
                .checkSuccessfullyAddChoice_2("2.1");
    }
    @DisplayName("Тест заполнения анкеты: Жен 1.1-да 2.2-да")
    @Test
    public void checkAddDataFemaleChoice1Select2(){
        new InputsPage(driver)
                .userLogin(VALID_AUTHORIZATION_EMAIL, VALID_AUTHORIZATION_PASSWORD)
                .dataEmailInput("test1@ya.ru")
                .dataNameInput("Тест")
                .dataGenderClick()
                .dataGenderFemale()
                .dataCheck11()
                .dataSelect22()
                .dataSend()
                .okButtonClick()
                .checkSuccessfullyAddEmail("test1@ya.ru")
                .checkSuccessfullyAddName("Тест")
                .checkSuccessfullyAddGender("Женский")
                .checkSuccessfullyAddChoice_1("1.1")
                .checkSuccessfullyAddChoice_2("2.2");
    }
    @DisplayName("Тест заполнения анкеты: Муж 1.2-да 2.3-да")
    @Test
    public void checkAddDataMaleChoice2Select3(){
        new InputsPage(driver)
                .userLogin(VALID_AUTHORIZATION_EMAIL, VALID_AUTHORIZATION_PASSWORD)
                .dataEmailInput("test1@ya.ru")
                .dataNameInput("Тест")
                .dataGenderClick()
                .dataGenderFemale()
                .dataGenderClick()
                .dataGenderMale()
                .dataCheck12()
                .dataSelect23()
                .dataSend()
                .okButtonClick()
                .checkSuccessfullyAddEmail("test1@ya.ru")
                .checkSuccessfullyAddName("Тест")
                .checkSuccessfullyAddGender("Мужской")
                .checkSuccessfullyAddChoice_1("1.2")
                .checkSuccessfullyAddChoice_2("2.3");
    }
    @DisplayName("Тест заполнения анкеты: Жен Нет Последний выбранный селект")
    @Test
    public void checkAddDataFemaleNoChoiceSelectLast(){
        new InputsPage(driver)
                .userLogin(VALID_AUTHORIZATION_EMAIL, VALID_AUTHORIZATION_PASSWORD)
                .dataEmailInput("test1@ya.ru")
                .dataNameInput("Тест")
                .dataGenderClick()
                .dataGenderFemale()
                .dataSelect21()
                .dataSelect23()
                .dataSelect22()
                .dataSend()
                .okButtonClick()
                .checkSuccessfullyAddEmail("test1@ya.ru")
                .checkSuccessfullyAddName("Тест")
                .checkSuccessfullyAddGender("Женский")
                .checkSuccessfullyAddChoice_1("Нет")
                .checkSuccessfullyAddChoice_2("2.2");
    }
}
