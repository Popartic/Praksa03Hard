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



}
