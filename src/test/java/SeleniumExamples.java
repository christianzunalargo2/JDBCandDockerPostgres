import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumExamples {

    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        ProfilesIni prof = new ProfilesIni();
        FirefoxProfile ffProfile = prof.getProfile("Selenium");
        ffProfile.setAcceptUntrustedCertificates(true);
        ffProfile.setAssumeUntrustedCertificateIssuer(false);
        driver = new FirefoxDriver();

//        WebDriverManager.chromedriver().setup();
//        ChromeOptions co = new ChromeOptions();
//        co.setAcceptInsecureCerts(true);
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    @Test
    public void openApplication() {
        driver.get("https://cacert.org/");
        String pageTitle = driver.getTitle();
        String expectedTitle = "Welcome to CAcert.org";
        Assert.assertEquals(pageTitle, expectedTitle);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
