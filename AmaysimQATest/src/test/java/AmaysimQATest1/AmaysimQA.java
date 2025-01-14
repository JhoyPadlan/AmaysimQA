package AmaysimQATest1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import org.testng.asserts.SoftAssert;

public class AmaysimQA {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jse;

    @BeforeTest
    public void setup() throws InterruptedException {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\p1346942\\IdeaProjects\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

        // Initialize the ChromeDriver with the options
        this.driver = new ChromeDriver();

        Actions action = new Actions(driver);

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        this.jse = (JavascriptExecutor) driver;

        // Maximize the browser window
        driver.manage().window().maximize();

    }

    @Test(priority = 0)
    public void UIPage() throws InterruptedException {

        //Open a Website
        driver.get("https://www.amaysim.com.au/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(2000);

        //ClickShowAll
        driver.findElement(By.xpath("//a[@href='https://www.amaysim.com.au/sim-plans']")).click();

    }

    @Test(priority = 1)
    public void Checkout() throws InterruptedException {

        //Scrolling of the scroll bar

        driver.findElement(By.xpath("//html[@class='js']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(20,document.body.scrollHeight)");

        WebElement DayPlan = driver.findElement(By.xpath("(//a[@class='btn no-icon btn-orange'])[11]"));
        Actions DayPlan1 = new Actions(driver);
        DayPlan1.moveToElement(DayPlan).perform();
        DayPlan.click();

        Thread.sleep(15000);
        driver.findElement(By.xpath("//span[@class='css-15xa8x'][normalize-space()='pick a new number']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='css-1vy9u2m']//div[@class='css-ikyri5']//*[name()='svg']//*[name()='path' and contains(@d,'M8.97358 2')]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='css-1tisfka']")).click();

    }

    @Test(priority = 3)
    public void PaymentPage() throws InterruptedException {

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@class='css-bfx7bq']")).sendKeys("Test");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("test");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='dateOfBirth']")).sendKeys("01011999");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jhoy@gmail.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ctn9NEChcrL9m!F");
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@id='field-input--9'][1])")).sendKeys("0412345678");

        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@class='react-autosuggest__input'])")).sendKeys("Level 6, 17-19 Bridge St, SYDNEY NSW 2000");
        Thread.sleep(1000);
        driver.findElement(By.id("react-autowhatever-1--item-0")).click();

        WebElement Payment1 = driver.findElement(By.id("payments-header-name"));
        jse.executeScript("arguments[0].scrollIntoView(true);", Payment1);

        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='payment-element']//iframe")));
        driver.findElement(By.xpath("(//div[@aria-label='Payment Methods'])//button[1]")).click();
        driver.findElement(By.id("Field-numberInput")).sendKeys("4242424242424242");
        driver.findElement(By.id("Field-expiryInput")).sendKeys("0127");
        driver.findElement(By.id("Field-cvcInput")).sendKeys("123");
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("(//div[contains(@class, 'css-14')])[3]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String errorMessage = driver.findElement(By.xpath("//strong[normalize-space()='Credit Card payment failed']")).getText();
        String ExpectedErrorMessage = "Credit Card payment failed";
        Assert.assertEquals(errorMessage, ExpectedErrorMessage);

        String errorMessage1 = driver.findElement(By.xpath("//span[contains(text(),'Your attempt to pay via Credit Card has failed. Pl')]")).getText();
        String ExpectedErrorMessage1 = "Your attempt to pay via Credit Card has failed. Please ensure you have enough funds and try again or use another credit card.";
        Assert.assertEquals(errorMessage1, ExpectedErrorMessage1);

        System.out.println(("\n" + "Actual: " + errorMessage + "\n" + "Expected Error: " + ExpectedErrorMessage));
        System.out.println(("\n" + "Actual Error: " + errorMessage1 + "\n" + "Expected Error: " + ExpectedErrorMessage1));

        driver.quit();

    }
}