package NewPage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewProjectCreate extends Main {
    WebDriver driver;

    @FindBy(xpath = "//input[@name='crm_project[name]']")
    private WebElement inputname;

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    private WebElement newproject;

    @FindBy(xpath = "//div[text()='1234']")
    private WebElement namefirm;

    @FindBy(xpath = "//div[@class='select2-container select2']")
    private WebElement contact;

    @FindBy(xpath = "//div[text()='Норина Александра']")
    private WebElement contactname;

    @FindBy(xpath = "//div[@class='btn-group'][2]")
    private WebElement saveproject;

    @FindBy(xpath = "//*[@class='controls']/div")
    public WebElement nameprojtest;

    @FindBy(xpath = "//*[text()='1234']")
    public WebElement nameorgtest;

    @FindBy(xpath = "//div[text()='Research & Development']")
    public WebElement namepodrtest;

    @FindBy(xpath = "//div[text()='Ким Юрий']")
    public WebElement namecuratortest;

    @FindBy(xpath = "//div[text()='Дедова Маргарита']")
    public WebElement namerptest;

    @FindBy(xpath = "//div[text()='Исаева Анастасия']")
    public WebElement namemanagertest;

    @FindBy(xpath = "//*[@class='string-cell grid-cell grid-body-cell grid-body-cell-fio']")
    public WebElement contactnametest;

    public NewProjectCreate(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Ввод имени проекта")
    public void sendNameProject(String namenewproject) {

        inputname.sendKeys(namenewproject);
        newproject.click();
    }

    @Step("Выбор фирмы")
    public void sendNameFirm() {

        Actions project = new Actions(driver);
        project.moveToElement(namefirm).click().build().perform();
        Select project2 = new Select(driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")));
        project2.selectByValue("1");
    }

    @Step("Выбор куратора пректа")
    public void sendCurator() {
        Select curator = new Select(driver.findElement(By.xpath("//select[@name='crm_project[curator]']")));
        curator.selectByValue("40");
    }

    @Step("Выбор руководителя проекта")
    public void sendRP() {
        Select rp = new Select(driver.findElement(By.xpath("//select[@name='crm_project[rp]']")));
        rp.selectByValue("59");
    }

    @Step("Выбор  менеджера проекта")
    public void sendManager() {
        Select manager = new Select(driver.findElement(By.xpath("//select[@name='crm_project[manager]']")));
        manager.selectByValue("11");
    }

    @Step("Выбор контактного лица проекта")
    public void sendContact() {
        contact.click();
        Actions contactname2 = new Actions(driver);
        contactname2.moveToElement(contactname).click().build().perform();
    }

    @Step("Нажатие кнопки сохранить")
    public void saveProject() {
        saveproject.click();
    }
}