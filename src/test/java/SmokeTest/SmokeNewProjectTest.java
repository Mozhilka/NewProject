package SmokeTest;

import NewPage.LoginPage;
import NewPage.NewProjectCreate;
import NewPage.StartPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;


public class SmokeNewProjectTest {
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("[Jira-1435]")
    @DisplayName("Создание нового проекта")
    public void newProjectTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver browser\\Chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            Faker faker = new Faker(new Locale("ru-RU"));
            String nameproject = faker.company().name();
            Thread.sleep(3000);

            LoginPage lp = new LoginPage(driver);
            lp.sendLogin("Applanatest1");
            lp.sendPass("Student2020!");
            lp.buttonClick();

            StartPage sp = new StartPage(driver);
            sp.NewProject();

            NewProjectCreate cp = new NewProjectCreate(driver);
            cp.sendNameProject(nameproject);
            cp.sendNameFirm();
            cp.sendCurator();
            cp.sendRP();
            cp.sendManager();
            cp.sendContact();
            cp.saveProject();

            Thread.sleep(3000);

            assertEquals(cp.namepodrtest.getText(), "Research & Development");
            assertEquals(cp.namecuratortest.getText(), "Ким Юрий");
            assertEquals(cp.namerptest.getText(), "Дедова Маргарита");
            assertEquals(cp.namemanagertest.getText(), "Исаева Анастасия");
            assertEquals(cp.contactnametest.getText(), "Норина Александра");
            assertEquals(cp.nameorgtest.getText(), "1234");
            assertEquals(cp.nameprojtest.getText(), nameproject);
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}