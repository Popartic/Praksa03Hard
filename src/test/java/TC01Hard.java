import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IndexPage;
import testingData.StandardData;

public class TC01Hard extends BaseTestClass{

    private WebDriver driver;
    private String email;
    private String password;
    private String repeatPassword;

    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
        email = StandardData.EMAIL_ADRESA;
        password = StandardData.PASSWORD;
        repeatPassword = StandardData.PASSWORD;
    }

    @Test
    public void TC01(){

        IndexPage indexPage = new IndexPage(driver).open();

        indexPage.clickPostaviOglas();
        indexPage.clickRegistracija();
        indexPage.unesiEmailAdresu(email);
        indexPage.unesiLozinku(password);
        indexPage.potvrdiLozinku(password);
        indexPage.cekirajUsloveKoriscenja().cekirajPomocUProdaji().cekirajPomocUKupovini();
        indexPage.clickRegistrujSe();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }
}
