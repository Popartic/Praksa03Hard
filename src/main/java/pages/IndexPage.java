package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testingData.StandardData;
import testingData.TimeDelay;

public class IndexPage extends BasePageClass{

    private final String indexURL = StandardData.INDEX_URL;
    private final By postaviOglasLocator = By.cssSelector(".js_ga-event.top-menu-submit-classified");
    private final By registracija = By.xpath("//a[@href='/registracija']");
    private final By emailAdresaLocator = By.xpath("//input[@type='email']");
    private final By passwordLocator = By.xpath("//input[@id='password_first']");
    private final By confirmPasswordLocator = By.xpath("//input[@id='password_second']");
    private final By checkbox1 = By.xpath("//input[@id='tos']");
    private final By checkbox2 = By.xpath("//input[@id='easySaleConsent']");
    private final By checkbox3 = By.xpath("//input[@id='easyBuyConsent']");
    private final By registrujSe = By.xpath("//button[@name='login']");
    private final By registrationWelcome = By.xpath("//div[@class='uk-width-1-1']/div/p/text()");

    private final By prijaviSe = By.cssSelector(".js_ga-event.uk-float-left");
    private final By mailLocator = By.xpath("//input[@id='username_header']");
    private final By dalje = By.xpath("//button[@type='button']");
    private final By passwordLocator2 = By.xpath("//input[@id='password_header']");
    private final By prijaviSeNaProfil = By.xpath("//button[.='Prijavi se']");
    private final By mojProfil = By.xpath("//div[@class='uk-float-left']");
    private final By podesavanja= By.xpath("//a[.='Podešavanja']");
    private final By imeClick = By.xpath("//input[@id='first_name']");
    private final By prezimeClick = By.xpath("//input[@id='last_name']");
    private final By adresaClick = By.xpath("//input[@id='address']");
    private final By gradClick = By.xpath("//input[@id='city']");
    private final By postanskiBrojClick = By.xpath("//input[@id='zip_code']");
    private final By telefonClick = By.xpath("//input[@id='cellphone']");
    private final By odaberiteOkrugClick = By.xpath("//span[.=' Odaberite okrug']");
    private final By sumadijskiOkrug = By.xpath("//label[text()='Šumadijski']");
    private final By sacuvaj = By.xpath("//button[.='Sačuvaj']");
    private final By odjava = By.cssSelector(".uk-nav.uk-nav-dropdown  a[title='Odjavite se iz sistema']");

    public IndexPage (WebDriver driver) {super(driver);}

    public IndexPage open(){
        openUrl(indexURL);
        return this;
    }
    public IndexPage clickPostaviOglas(){
        clickButton(postaviOglasLocator);
        return this;
    }
    public IndexPage clickRegistracija(){
        clickButton(registracija);
        return this;
    }
    public IndexPage unesiEmailAdresu(String email){
        WebElement emailTextField = waitForWebElementToBeVisible(emailAdresaLocator, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(emailTextField,email);
        return this;
    }
    public IndexPage unesiLozinku(String lozinka){
        WebElement lozinkaTextField = waitForWebElementToBeVisible(passwordLocator, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(lozinkaTextField, lozinka);
        return this;
    }
    public IndexPage potvrdiLozinku(String lozinka){
        WebElement potvrdiLozinkuTextField = waitForWebElementToBeVisible(confirmPasswordLocator, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(potvrdiLozinkuTextField,lozinka);
        return this;
    }
    public IndexPage cekirajUsloveKoriscenja(){
        clickCheckbox(checkbox1);
        return this;
    }
    public IndexPage cekirajPomocUProdaji(){
        clickCheckbox(checkbox2);
        return this;
    }
    public IndexPage cekirajPomocUKupovini(){
        clickCheckbox(checkbox3);
        return this;
    }
    public IndexPage clickRegistrujSe(){
        clickButton(registrujSe);
        return this;
    }
    public IndexPage verifyRegistrationWelcomeText(String text){
        WebElement registrationWelcomeTextElement = (WebElement) registrationWelcome;
        String registrationWelcomeText = getTextFromWebElement(registrationWelcomeTextElement);
        Assert.assertEquals(registrationWelcomeText, text);
        return this;
    }
    public IndexPage prijava(){
        clickButton(prijaviSe);
        return this;
    }
    public IndexPage unesiEmailClick(){
        clickButton(mailLocator);
        return this;
    }
    public IndexPage unesiEmail(String email){
        WebElement unesiEmailField = waitForWebElementToBeVisible(mailLocator, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(unesiEmailField,email);
        return this;
    }
    public IndexPage dalje(){
        clickButton(dalje);
        return this;
    }
    public IndexPage unesiPass(String password){
        WebElement unesiPassField = waitForWebElementToBeVisible(passwordLocator2, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(unesiPassField, password);
        return this;
    }
    public IndexPage prijavaProfil(){
        clickButton(prijaviSeNaProfil);
        return this;
    }
    public IndexPage mojProfil(){
        clickButton(mojProfil);
        return this;
    }
    public IndexPage podesavanja(){
        clickButton(podesavanja);
        return this;
    }
    public IndexPage unesiIme(String ime){
        WebElement imeTextField = waitForWebElementToBeVisible(imeClick, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement( imeTextField, ime);
        return this;
    }
    public IndexPage unesiPrezime(String prezime){
        WebElement prezimeTextField = waitForWebElementToBeVisible(prezimeClick, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(prezimeTextField, prezime);
        return this;
    }
    public IndexPage unesiAdresu(String adresa){
        WebElement adresaTextField = waitForWebElementToBeVisible(adresaClick, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(adresaTextField, adresa);
        return this;
    }
    public IndexPage unesiGrad(String grad){
        WebElement gradTextField = waitForWebElementToBeVisible(gradClick, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(gradTextField, grad);
        return this;
    }
    public IndexPage unesiPostanskiBroj(String broj){
        WebElement postanskiTextField = waitForWebElementToBeVisible(postanskiBrojClick,TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(postanskiTextField, broj);
        return this;
    }
    public IndexPage odaberiOkrug(){
        clickButton(odaberiteOkrugClick);
        return this;
    }
    public IndexPage sumadijskiOkrug(){
        clickButton(sumadijskiOkrug);
        return this;
    }
    public IndexPage unesiTelefon(String telefon){
        WebElement unesiTelefon = waitForWebElementToBeVisible(telefonClick, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(unesiTelefon, telefon);
        return this;
    }
    public IndexPage sacuvajProfil(){
        clickButton(sacuvaj);
        return this;
    }
    public IndexPage odjava(){
        clickButton(odjava);
        return this;
    }




}
