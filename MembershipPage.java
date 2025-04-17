import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;

import java.time.Duration;

public class MembershipPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    // Setup method to run before each test method
    @BeforeMethod
    void loadPage() {
        // Launch a new Chrome browser
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Navigate to Nike Membership page
        driver.get("https://www.nike.com/membership");

        // Initialize WebDriverWait and Actions
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    // Cleanup method to run after each test method
    @AfterMethod
    void closePage() {
        // Close the browser
        driver.quit();
    }

    // Test to print current URL and title of the page
    @Test(priority = 1)
    void urlAndTitle() {
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
    }

    // Test to interact with both carousels on the membership page
    @Test(priority = 2)
    void carousels() throws InterruptedException {
        // Wait for first carousel next button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"799c975e-c181-4b6b-b0ea-769e17198073\"]/div/section/div/div[2]/button[2]")));

        // Scroll to the top carousel
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scrollBy(0, 1000);");
        Thread.sleep(1000);

        // Click next button twice on the top carousel
        WebElement carouselBtnNext1 = driver.findElement(By.xpath("//*[@id=\"799c975e-c181-4b6b-b0ea-769e17198073\"]/div/section/div/div[2]/button[2]"));
        carouselBtnNext1.click();
        Thread.sleep(1000);
        carouselBtnNext1.click();
        Thread.sleep(1000);

        // Click previous button twice on the top carousel
        WebElement carouselBtnPrev1 = driver.findElement(By.xpath("//*[@id=\"799c975e-c181-4b6b-b0ea-769e17198073\"]/div/section/div/div[2]/button[1]"));
        carouselBtnPrev1.click();
        Thread.sleep(500);
        carouselBtnPrev1.click();
        Thread.sleep(500);

        // Scroll to the bottom carousel
        exe.executeScript("window.scrollBy(0, 1000);");
        Thread.sleep(1000);

        // Click next button twice on the bottom carousel
        WebElement carouselBtnNext2 = driver.findElement(By.xpath("//*[@id=\"1c647239-6d06-40e2-8f00-baeb97eccb09\"]/div/section/div/div[2]/button[2]"));
        carouselBtnNext2.click();
        Thread.sleep(1000);
        carouselBtnNext2.click();
        Thread.sleep(1000);

        // Click previous button twice on the bottom carousel
        WebElement carouselBtnPrev2 = driver.findElement(By.xpath("//*[@id=\"1c647239-6d06-40e2-8f00-baeb97eccb09\"]/div/section/div/div[2]/button[1]"));
        carouselBtnPrev2.click();
        Thread.sleep(500);
        carouselBtnPrev2.click();
        Thread.sleep(1000);
    }

    // Test to open and close the FAQ dropdowns
    @Test(priority = 3)
    void faq() throws InterruptedException {
        // Wait for the first FAQ dropdown to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"80f81ad0-339d-49ec-a096-2e6425918eea__286dbec1-feda-4f8b-b134-8ae948bcfd5e__panel\"]/summary/span/span[2]")));

        // Open all FAQ dropdowns
        WebElement faqDropDown1 = driver.findElement(By.xpath("//*[@id=\"80f81ad0-339d-49ec-a096-2e6425918eea__286dbec1-feda-4f8b-b134-8ae948bcfd5e__panel\"]/summary/span/span[2]"));
        faqDropDown1.click();
        Thread.sleep(1000);

        WebElement faqDropDown2 = driver.findElement(By.xpath("//*[@id=\"80f81ad0-339d-49ec-a096-2e6425918eea__77c46060-33fb-4681-bd86-f4df71e8e55f__panel\"]/summary/span/span[2]"));
        faqDropDown2.click();
        Thread.sleep(1000);

        WebElement faqDropDown3 = driver.findElement(By.xpath("//*[@id=\"80f81ad0-339d-49ec-a096-2e6425918eea__4c93e329-8b23-47e4-b298-7202bbe086fd__panel\"]/summary/span/span[2]"));
        faqDropDown3.click();
        Thread.sleep(1000);

        // Scroll to view all content
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scrollBy(0, 250);");
        Thread.sleep(500);

        // Close all FAQ dropdowns
        faqDropDown3.click();
        Thread.sleep(500);
        faqDropDown2.click();
        Thread.sleep(500);
        faqDropDown1.click();
        Thread.sleep(1000);
    }

    // Test to simulate joining with incorrect and then corrected email
    @Test(priority = 4)
    void joinUs() throws InterruptedException {
        // Wait for and click the "Join Us" button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ea4b7f00-6dc9-4308-a283-1437995c384e\"]/div/div/nav/div[1]/ul/li[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"ea4b7f00-6dc9-4308-a283-1437995c384e\"]/div/div/nav/div[1]/ul/li[1]/a")).click();

        // Wait for email input field
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        WebElement email = driver.findElement(By.id("username"));

        // Enter incorrect email and try to proceed
        email.sendKeys("fgcucen4072testemail");
        email.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        // Correct the email and try again
        email.sendKeys("@gmail.com");
        Thread.sleep(1000);
        email.sendKeys(Keys.ENTER);
    }

    // Test to simulate signing in with incorrect and then corrected email
    @Test(priority = 5)
    void signIn() throws InterruptedException {
        // Wait for and click the "Sign In" link
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/div[1]/div/div[2]/nav/ul/li[4]")));
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/div[1]/div/div[2]/nav/ul/li[4]"));
        signIn.click();

        // Wait for email input field
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        WebElement email = driver.findElement(By.id("username"));

        // Enter incorrect email and try to proceed
        email.sendKeys("cs48898");
        email.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        // Correct the email and try again
        email.sendKeys("@gmail.com");
        Thread.sleep(1000);
        email.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }
}
