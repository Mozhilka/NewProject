package NewProject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestNewContact {


    @Test
    @DisplayName("Создание контакного лица")
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://crm.geekbrains.space/user/login");

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            WebDriverWait element = (new WebDriverWait(driver, 20));

            WebElement inputlogin = driver.findElement(By.xpath("//input[@id='prependedInput']"));
            inputlogin.click();
            inputlogin.sendKeys("Applanatest1");

            WebElement inputpassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
            inputpassword.click();
            inputpassword.sendKeys("Student2020!");

            WebElement button = driver.findElement(By.xpath("//button[@id='_submit']"));
            button.click();

            WebElement ca = driver.findElement(By.xpath("//span[text()='Контрагенты']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(ca).build().perform();

            WebElement contactface = driver.findElement(By.xpath("//span[text()='Контактные лица']"));
            contactface.click();
            Thread.sleep(10000);

            WebElement createca = driver.findElement(By.xpath("//*[text()='Создать контактное лицо']"));
            createca.click();
            Thread.sleep(10000);

            WebElement inpitlastname = driver.findElement(By.xpath("//input[@name='crm_contact[lastName]']"));
            inpitlastname.click();
            inpitlastname.sendKeys("Иванов");

            WebElement inputfirstname = driver.findElement(By.xpath("//input[@name='crm_contact[firstName]']"));
            inputfirstname.click();
            inputfirstname.sendKeys("Анатолий");

            WebElement namefirm = driver.findElement(By.xpath("//span[text()='Укажите организацию']"));
            namefirm.click();

            WebElement namefirm2 = driver.findElement(By.xpath("//div[text()='1234']"));
            Actions usenamefirm = new Actions(driver);
            usenamefirm.moveToElement(namefirm2).click().build().perform();

            WebElement inputposition = driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']"));
            inputposition.click();
            inputposition.sendKeys("Менеджер");

            WebElement saveandclose = driver.findElement(By.xpath("//button[@class='btn btn-success action-button']"));
            saveandclose.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}