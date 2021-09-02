package NewPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewContactFace extends Main {
    WebDriver driver;

    @FindBy(xpath = "//*[@name='crm_contact[lastName]']")
    private WebElement inputlastname;

    @FindBy(xpath = "//input[@name='crm_contact[firstName]']")
    private WebElement inputfirstname;

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    private WebElement namefirm;

    @FindBy(xpath = "//div[text()='1234']")
    private WebElement namefirm2;

    @FindBy(xpath = "//input[@name='crm_contact[jobTitle]']")
    private WebElement inputposition;

    @FindBy(xpath = "//div[@class='btn-group'][2]")
    private WebElement saveandclose;

    @FindBy(xpath = "//div[@class='control-group']/div/div")
    public WebElement lastnametest;

    @FindBy(xpath = "//div[@class='control-group'][2]/div/div")
    public WebElement firstnametest;

    @FindBy(xpath = "//*[text()='1234']")
    public WebElement nameorgtest;

    @FindBy(xpath = "//div[@class='responsive-cell'][2]/div/div/div[2]/div/div")
    public WebElement nameopositiontest;

    public NewContactFace(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Ввод фамилии")
    public void sendLastName(String lastname) {
        try {
            Thread.sleep(3000);
            inputlastname.sendKeys(lastname);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    @Step("Ввод имени")
    public void sendFirstName(String firstname) {
        inputfirstname.sendKeys(firstname);
    }

    @Step("Выбор фирмы")
    public void sendFirm() {
        namefirm.click();
        Actions usenamefirm = new Actions(driver);
        usenamefirm.moveToElement(namefirm2).click().build().perform();
    }

    @Step("Ввод должности")
    public void sendPosition(String position) {
        inputposition.sendKeys(position);
    }

    @Step("Нажатие кнопки сохранить")
    public void saveClick() {
        saveandclose.click();
    }
}