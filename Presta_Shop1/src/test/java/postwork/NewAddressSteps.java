package postwork;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class NewAddressSteps {

    private WebDriver driver;


    @Given("an open browser with MyStore page")
    public void openMyStorePage() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        //Czekamy na przeglądarkę
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do MyStore
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("^user is signed as (.*) with password (.*)$")
    public void signIn(String userName, String password) {
        // Znajdź element SignIn i kliknij
        WebElement element = driver.findElement(By.xpath("//a/span[@class='hidden-sm-down']"));
        element.click();
        //Znajdź element login
        driver.findElement(By.className("form-control")).sendKeys(userName);
        //Znajdź element password
        driver.findElement(By.xpath("//div/input[@name='password']")).sendKeys(password);
        //Kliknij zaloguj
        driver.findElement(By.xpath("//button[@id='submit-login']")).click();
    }

    //    And User can click Addresses
    @And("User can click Addresses")
    public void clickAddress() {
        //Znajdź button address
        driver.findElement(By.xpath("//a[@id='addresses-link']")).click();
    }

    //    And User can click Create new addrress
    @And("User can click Create new addrress")
    public void clickCreateNewAddress() {
        // Znajdź butto Create new address
        driver.findElement(By.xpath("//span[text()='Create new address']")).click();
    }

    @And("User can add new address Alias {string} Address {string} City {string} Zip {string} Phone {string}")
    public void enterYourNextAddress(String alias, String address, String city, String zipCode, String phoneNumber) {
        //Znajdź element alias
        driver.findElement(By.name("alias")).sendKeys(alias);
        //Znajdż element address
        driver.findElement(By.name("address1")).sendKeys(address);
        //Znajdź element city
        driver.findElement(By.name("city")).sendKeys(city);
        //Znajdź element zip/postal
        driver.findElement(By.name("postcode")).sendKeys(zipCode);
        //Znajdź element phone
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phoneNumber);
        //Znajdź button save
        driver.findElement(By.xpath("//footer/button")).click();

    }

    @Then("User can see info: {string}")
    public void theUserCanSee(String expectedText) {
        Boolean text = driver.findElement(By.xpath("//li[text()='Address successfully added!']")).isDisplayed();
        assertTrue("Dodoano nowy adres", text);

    }

    @And("Close browser")
    public void closeBrowser() {
        driver.quit();
    }

    @And("User can click Delete")
    public void dleteAddresses() {
        List list = driver.findElements(By.xpath("//span[text()='Delete']"));
        int x = list.size();

        for (int i = x; i > 1; i--) {
            driver.findElement(By.xpath(("(//span[text()='Delete'])[2]"))).click();
        }

    }

    @And("Check if number of addresses is 1")
    public void checkDel() {
        List list = driver.findElements(By.xpath("//span[text()='Delete']"));
        int x = list.size();
        if (x > 1)
            throw new IllegalArgumentException("You have more than 1 address");
    }

}








