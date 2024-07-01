package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import java.io.File;

public class InputsPage {
    private final By dataEmail = By.id("dataEmail");
    private final By dataName = By.id("dataName");
    private final By dataGender= By.id("dataGender");
    private final By dataGenderFemale= By.cssSelector("#dataGender > option:nth-child(2)");
    private final By dataGenderMale= By.cssSelector("#dataGender > option:nth-child(1)");
    private final By dataCheck11= By.id("dataCheck11");
    private final By dataCheck12= By.id("dataCheck12");
    private final By dataSelect21= By.id("dataSelect21");
    private final By dataSelect22= By.id("dataSelect22");
    private final By dataSelect23= By.id("dataSelect23");
    private final By dataSend= By.id("dataSend");
    private final By successfullyMassage= By.className("uk-modal-content");
    private final By okButton= By.className("uk-modal-close");
    private final By emailInputs= By.xpath(".//tr/td[1]");

    private final By nameInputs= By.xpath(".//tr/td[2]");
    private final By genderInputs= By.xpath(".//tr/td[3]");
    private final By choice_1= By.xpath(".//tr/td[4]");
    private final By choice_2= By.xpath(".//tr/td[5]");
    private final By emailFormatError = By.id("emailFormatError");
    private final By closeButton = By.className("uk-close");
    private final By blankNameError = By.id("blankNameError");
    boolean invisible = false;
    WebDriver driver;

    public InputsPage(WebDriver driver) {
        this.driver = driver;
        File file = new File(getClass().getResource("/qa-test.html").getFile());
        driver.get(String.valueOf(file));
    }
    @Step("Логин пользователя")
    public InputsPage userLogin(String email,String password) {
        new AuthorizationPage(driver)
                .emailFieldInput(email)
                .passwordFieldInput(password)
                .enterButtonClick();
        return this;

    }
    @Step ("Ввод email в анкете")
    public InputsPage dataEmailInput(String emailData) {
        driver.findElement(dataEmail).sendKeys(emailData);
        return this;
    }
    @Step ("Ввод имени в анкете")
    public InputsPage dataNameInput(String name) {
        driver.findElement(dataName).sendKeys(name);
        return this;
    }
    @Step ("Клик по полю Пол")
    public InputsPage dataGenderClick() {
        driver.findElement(dataGender).click();
        return this;
    }
    @Step ("Выбор пола Женский")
    public InputsPage dataGenderFemale() {
        driver.findElement(dataGenderFemale).click();
        return this;
    }
    @Step ("Выбор пола Мужской")
    public InputsPage dataGenderMale() {
        driver.findElement(dataGenderMale).click();
        return this;
    }
    @Step ("Выбор варианта 1.1")
    public InputsPage dataCheck11() {
        driver.findElement(dataCheck11).click();
        return this;
    }
    @Step ("Выбор варианта 1.2")
    public InputsPage dataCheck12() {
        driver.findElement(dataCheck12).click();
        return this;
    }
    @Step ("Выбор варианта 2.1")
    public InputsPage dataSelect21() {
        driver.findElement(dataSelect21).click();
        return this;
    }
    @Step ("Выбор варианта 2.2")
    public InputsPage dataSelect22() {
        driver.findElement(dataSelect22).click();
        return this;
    }
    @Step ("Выбор варианта 2.3")
    public InputsPage dataSelect23() {
        driver.findElement(dataSelect23).click();
        return this;
    }
    @Step ("Клик по кнопке Добавить")
    public InputsPage dataSend() {
        driver.findElement(dataSend).click();
        return this;
    }
    @Step("Проверка сообщения об успешном добавлении в анкету")
    public InputsPage checkSuccessfullyAddData() {
        Assert.assertTrue(driver.findElement(successfullyMassage).isDisplayed());
        return this;
    }
    @Step ("Клик по кнопке Ok")
    public InputsPage okButtonClick() {
        driver.findElement(okButton).click();
        return this;
    }
    @Step("Проверка успешного добавления в анкету email")
    public InputsPage checkSuccessfullyAddEmail(String email) {
        Assert.assertTrue(driver.findElement(emailInputs).isDisplayed());
        Assert.assertEquals(email,driver.findElement(emailInputs).getText());
        return this;
    }
    @Step("Проверка успешного добавления в анкету Имя")
    public InputsPage checkSuccessfullyAddName(String name) {
        Assert.assertTrue(driver.findElement(nameInputs).isDisplayed());
        Assert.assertEquals(name,driver.findElement(nameInputs).getText());
        return this;
    }
    @Step("Проверка успешного добавления в анкету Пол")
    public InputsPage checkSuccessfullyAddGender(String gender) {
        Assert.assertTrue(driver.findElement(genderInputs).isDisplayed());
        Assert.assertEquals(gender,driver.findElement(genderInputs).getText());
        return this;
    }

    @Step("Проверка успешного добавления в анкету Выбор1")
    public InputsPage checkSuccessfullyAddChoice_1(String choice1) {
        Assert.assertTrue(driver.findElement(choice_1).isDisplayed());
        Assert.assertEquals(choice1,driver.findElement(choice_1).getText());
        return this;
    }
    @Step("Проверка успешного добавления в анкету Выбор2")
    public InputsPage checkSuccessfullyAddChoice_2(String choice2) {
        Assert.assertTrue(driver.findElement(choice_2).isDisplayed());
        Assert.assertEquals(choice2,driver.findElement(choice_2).getText());
        return this;
    }
    @Step("Проверка сообщения об ошибке при вводе email не в формате")
    public InputsPage checkUnSuccessfullyInputMassageEmailFormatError() {
        Assert.assertTrue(driver.findElement(emailFormatError).isDisplayed());
        return this;
    }
    @Step("Проверка сообщения об ошибке пусое поле Имя")
    public InputsPage checkUnSuccessfullyInputMassageNameIsEmpty() {
        Assert.assertTrue(driver.findElement(blankNameError).isDisplayed());
        return this;
    }
    @Step("Нажатие на кнопку закрыть в сообщении об ошибке")
    public InputsPage closeButtonClick() {
        driver.findElement(closeButton).click();
        return this;
    }
    @Step("Проверка действия кнопки Закрыть в окне ошибки Неверный формат E-Mail")
    public InputsPage checkAlertButtonCloseEmailFormatError() {
        try {
            driver.findElement(emailFormatError);
        } catch (NoSuchElementException exception) {
            invisible = true;
        }
        Assert.assertTrue(invisible);
        return this;
    }
    @Step("Проверка действия кнопки Закрыть в окне ошибки Поле имя не может быть пустым")
    public InputsPage checkAlertButtonCloseBlankNameError() {
        try {
            driver.findElement(blankNameError);
        } catch (NoSuchElementException exception) {
            invisible = true;
        }
        Assert.assertTrue(invisible);
        return this;
    }
    @Step("Проверка действия кнопки Ok в окне Данные добавлены")
    public InputsPage checkCloseWindowByClickOkButton() {
        try {
            driver.findElement(successfullyMassage);
        } catch (NoSuchElementException exception) {
            invisible = true;
        }
        Assert.assertTrue(invisible);
        return this;
    }
}
