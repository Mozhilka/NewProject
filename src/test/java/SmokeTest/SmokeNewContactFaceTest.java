package SmokeTest;

import NewPage.LoginPage;
import NewPage.NewContactFace;
import NewPage.StartPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmokeNewContactFaceTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("[Jira-1436]")
    @DisplayName("Создание нового контактного лица")
    public void newContactFace() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver browser\\Chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            Faker faker = new Faker(new Locale("ru-RU"));
            String firstname = faker.name().firstName();
            String lastname = faker.name().lastName();
            String position = faker.job().position();
            Thread.sleep(3000);

            LoginPage lp = new LoginPage(driver);
            lp.sendLogin("Applanatest1");
            lp.sendPass("Student2020!");
            lp.buttonClick();

            StartPage sp = new StartPage(driver);
            sp.NewContragent();

            NewContactFace cf = new NewContactFace(driver);
            cf.sendLastName(lastname);
            cf.sendFirstName(firstname);
            cf.sendFirm();
            cf.sendPosition(position);
            cf.saveClick();

            Thread.sleep(3000);
            assertEquals(cf.lastnametest.getText(), lastname);
            assertEquals(cf.firstnametest.getText(), firstname);
            assertEquals(cf.nameorgtest.getText(), "1234");
            assertEquals(cf.nameopositiontest.getText(), position);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}