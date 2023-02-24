import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MailPage;
import testingData.StandardData;

public class TC02 extends BaseTestClass{

    private WebDriver driver;
    private String email;
    private String password;

    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
        email = StandardData.EMAIL_ADRESA;
        password = StandardData.PASSWORD;
    }

    @Test
    public void TC02(){

        MailPage mailPage = new MailPage(driver).open();

        mailPage.signIn();
        mailPage.clickEmailField();
        mailPage.unesiEmailAdresu(email);
        mailPage.clickPasswordField();
        mailPage.unesiPassword(password);
        mailPage.clickSingInButton();
        mailPage.blancClick();
        mailPage.clickOnMail();
        mailPage.clickOnConfirmationLink();

    }
    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }
}
