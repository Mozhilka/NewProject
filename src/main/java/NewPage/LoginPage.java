package NewPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends Main {

    WebDriver driver;

    @FindBy(id = "prependedInput")
    private WebElement inputlog;

    @FindBy(id = "prependedInput2")
    private WebElement inputpas;

    @FindBy(xpath = "//button[@id='_submit']")
    private WebElement button;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Ввод логина")
    public void sendLogin(String login) {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://crm.geekbrains.space/user/login");
            inputlog.sendKeys(login);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Step("Ввод пароля")
    public void sendPass(String pass) {
        inputpas.sendKeys(pass);
    }

    @Step("Нажатие кнопки войти")
    public void buttonClick() {
        button.click();
    }

}