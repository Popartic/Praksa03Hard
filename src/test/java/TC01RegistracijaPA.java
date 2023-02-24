import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IndexPage;
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
        indexPage.podesavanja();
        indexPage.unesiIme(ime);
        indexPage.unesiPrezime(prezime);
        indexPage.unesiAdresu(adresa);
        indexPage.unesiGrad(grad);
        indexPage.unesiPostanskiBroj(postanskiBroj);
        //indexPage.odaberiOkrug().sumadijskiOkrug();
        indexPage.unesiTelefon(brojTelefona);
        indexPage.sacuvajProfil();
        indexPage.odjava();



    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }
}
