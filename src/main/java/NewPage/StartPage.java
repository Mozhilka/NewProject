package NewPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends Main {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='Контрагенты']")
    private WebElement ca;

    @FindBy(xpath = "//span[text()='Контактные лица']")
    private WebElement contactface;

    @FindBy(xpath = "//*[text()='Создать контактное лицо']")
    private WebElement createca;

    @FindBy(xpath = "//span[text()='Проекты']")
    private WebElement myproject;

    @FindBy(xpath = "//span[text()=\"Мои проекты\"]")
    private WebElement myprojectclick;

    @FindBy(xpath = "//*[text()='Создать проект']")
    private WebElement createproject;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void NewContragent() {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(ca).build().perform();
            contactface.click();
            Thread.sleep(1000);
            createca.click();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void NewProject() {
        try {
            Actions actionsproj = new Actions(driver);
            actionsproj.moveToElement(myproject).build().perform();
            myprojectclick.click();
            Thread.sleep(3000);
            createproject.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}