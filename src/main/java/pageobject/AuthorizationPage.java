package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.io.File;
import java.time.Duration;


public class AuthorizationPage {

    private final By emailField = By.id("loginEmail");
    private final By passwordField = By.id("loginPassword");
    private final By enterButton = By.id("authButton");
    private final By inputsPage = By.id("inputsPage");
    private final By invalidEmailPassword = By.id("invalidEmailPassword");
    private final By emailFormatError = By.id("emailFormatError");
    private final By closeButton = By.className("uk-close");
    boolean invisible = false;
    WebDriver driver;


    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        File file = new File(getClass().getResource("/qa-test.html").getFile());
        driver.get(String.valueOf(file));
    }

    @Step("Ввод email")
    public AuthorizationPage emailFieldInput(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("Ввод пароля")
    public AuthorizationPage passwordFieldInput(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Клик по кнопке Вход")
    public AuthorizationPage enterButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterButton));
        driver.findElement(enterButton).click();
        return this;
    }

    @Step("Проверка успешной авторизации по кнопке Вход")
    public AuthorizationPage checkSuccessfullyAuthorizationByClickEnterButton() {
        Assert.assertTrue(driver.findElement(inputsPage).isDisplayed());
        return this;
    }

    @Step("Проверка сообщения об ошибке при неправильном вводе email или пароля")
    public AuthorizationPage checkUnSuccessfullyAuthorizationMassageWrongEmailOrPass() {
        Assert.assertTrue(driver.findElement(invalidEmailPassword).isDisplayed());
        return this;
    }

    @Step("Проверка сообщения об ошибке при вводе email не в формате")
    public AuthorizationPage checkUnSuccessfullyAuthorizationMassageEmailFormatError() {
        Assert.assertTrue(driver.findElement(emailFormatError).isDisplayed());
        return this;
    }

    @Step("Нажатие на кнопку закрыть в сообщении об ошибке")
    public AuthorizationPage closeButtonClick() {
        driver.findElement(closeButton).click();
        return this;
    }

    @Step("Проверка действия кнопки Закрыть в окне ошибки Неверный E-Mail или пароль ")
    public AuthorizationPage checkAlertButtonCloseInvalidEmailPassword() {
        try {
            driver.findElement(invalidEmailPassword);
        } catch (NoSuchElementException exception) {
            invisible = true;
        }
        Assert.assertTrue(invisible);
        return this;
    }

    @Step("Проверка действия кнопки Закрыть в окне ошибки Неверный формат E-Mail")
    public AuthorizationPage checkAlertButtonCloseEmailFormatError() {
        try {
            driver.findElement(emailFormatError);
        } catch (NoSuchElementException exception) {
            invisible = true;
        }
        Assert.assertTrue(invisible);
        return this;
    }
}
