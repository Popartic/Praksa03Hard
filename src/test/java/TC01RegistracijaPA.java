import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.MailPage;
import testingData.StandardData;

public class TC01RegistracijaPA extends BaseTestClass{

    private WebDriver driver;
    private String email;
    private String password;
    private String repeatPassword;
    private String ime;
    private String prezime;
    private String adresa;
    private String grad;
    private String postanskiBroj;
    private String brojTelefona;
    private String actualProfileMessage;
    private String expectedProfileMessage;

    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
        email = StandardData.EMAIL_ADRESA;
        password = StandardData.PASSWORD;
        repeatPassword = StandardData.PASSWORD;
        ime = StandardData.IME;
        prezime = StandardData.PREZIME;
        adresa = StandardData.ADRESA;
        grad = StandardData.GRAD;
        postanskiBroj = StandardData.POSTANSKI_BROJ;
        brojTelefona = StandardData.BROJ_TELEFONA;
        expectedProfileMessage = StandardData.IZMENA_PROFILA_TEXT;

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

    @Test
    public void TC03(){

        IndexPage indexPage = new IndexPage(driver).open();


        indexPage.prijava();
        indexPage.unesiEmail(email);
        indexPage.dalje();
        indexPage.unesiPass(password);
        indexPage.prijavaProfil();
        indexPage.mojProfil();
        indexPage.popUpClick();
        indexPage.profileMove();
        indexPage.podesavanja();
        indexPage.unesiIme(ime);
        indexPage.unesiPrezime(prezime);
        indexPage.unesiAdresu(adresa);
        indexPage.unesiGrad(grad);
        indexPage.unesiPostanskiBroj(postanskiBroj);
        //indexPage.odaberiOkrug().sumadijskiOkrug();
        indexPage.unesiTelefon(brojTelefona);
        indexPage.sacuvajProfil();
        actualProfileMessage = driver.findElement(By.xpath("//div[@class='uk-alert uk-alert-success']")).getText();
        Assert.assertEquals(actualProfileMessage, expectedProfileMessage);
        indexPage.profileMove();
        indexPage.odjava();
        String oldTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://proton.me/");
        MailPage mailPage = new MailPage(driver);

        mailPage.signIn();
        mailPage.clickEmailField();
        mailPage.unesiEmailAdresu(email);
        mailPage.clickPasswordField();
        mailPage.unesiPassword(password);
        mailPage.clickSingInButton();
        //mailPage.clickOnMail();
        //mailPage.clickOnConfirmationLink();
        driver.switchTo().window(oldTab);

        indexPage.prijava();
        indexPage.unesiEmail(email);
        indexPage.dalje();
        indexPage.unesiPass(password);
        indexPage.prijavaProfil();
        indexPage.notificationClick();
        indexPage.notificationDelete();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }
}
