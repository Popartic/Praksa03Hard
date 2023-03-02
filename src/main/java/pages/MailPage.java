package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testingData.StandardData;
import testingData.TimeDelay;

public class MailPage extends BasePageClass{

    private final String mailURL = StandardData.MAIL_URL;

    private final By signIn = By.xpath("//a[@target='_self']");
    private final By emailUsernameField = By.xpath("//input[@autocomplete='username']");
    private final By passwordField = By.xpath("//input[@autocomplete='current-password']");
    private final By signInButton = By.cssSelector("form[name='loginForm'] > .button.button-large.button-solid-norm.mt1-5.w100");
    private final By blancClick = By.cssSelector(".p1 .flex:nth-child(4) .text-bold");
    private final By clickMailPolovniA = By.xpath("//span[.='PolovniAutomobili']");
    private final By clickMailAktivacija = By.xpath("//span[@title='noreply@polovniautomobili.com']");
    private final By linkConfirmation = By.cssSelector(".modal-two-footer [aria-busy='false']:nth-of-type(2)");

    public MailPage (WebDriver driver) {super(driver);}

    public MailPage open(){
        openUrl(mailURL);
        return this;
    }
    public MailPage signIn(){
        clickButton(signIn);
        return this;
    }
    public MailPage clickEmailField(){
        clickButton(emailUsernameField);
        return this;
    }
    public MailPage unesiEmailAdresu(String email) {
        WebElement emailTextField = waitForWebElementToBeVisible(emailUsernameField, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(emailTextField, email);
        return this;
    }
    public MailPage unesiPassword(String password){
        WebElement passwordTextField = waitForWebElementToBeVisible(passwordField, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(passwordTextField,password);
        return this;
    }
    public MailPage clickPasswordField(){
        clickButton(passwordField);
        return this;
    }
    public MailPage clickSingInButton(){
        clickButton(signInButton);
        return this;
    }
    public MailPage blancClick(){
        clickButton(blancClick);
        return this;
    }
    public MailPage clickOnMail(){
        clickButton(clickMailAktivacija);
        return this;
    }
    public MailPage clickOnConfirmationLink(){
        clickButton(linkConfirmation);
        return this;
    }
}
