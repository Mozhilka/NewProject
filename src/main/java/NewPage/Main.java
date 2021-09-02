package NewPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\driver browser\\Chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            Thread.sleep(5000);

            LoginPage lp = new LoginPage(driver);
            lp.sendLogin("Applanatest1");
            lp.sendPass("Student2020!");
            lp.buttonClick();

            StartPage sp = new StartPage(driver);
            sp.NewContragent();
            sp.NewProject();

            NewProjectCreate cp = new NewProjectCreate(driver);
            cp.sendNameProject("Попытка номер три");
            cp.sendNameFirm();
            cp.sendCurator();
            cp.sendRP();
            cp.sendManager();
            cp.sendContact();
            cp.saveProject();


            NewContactFace cf = new NewContactFace(driver);
            cf.sendLastName("Иванов");
            cf.sendFirstName("Иван");
            cf.sendFirm();
            cf.sendPosition("Менеджер");
            cf.saveClick();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}