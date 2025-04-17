import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HomePage {
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
        // Navigate to Nike homepage
        driver.get("https://nike.com/");

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

    // Test to interact with the video banner at the top of the homepage
    @Test(priority = 2)
    void videoBanner() throws InterruptedException {
        // Wait until the pause button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/button")));
        Thread.sleep(1000);

        // Click to pause the video
        WebElement pauseButton = driver.findElement(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/button"));
        pauseButton.click();
        Thread.sleep(1000);

        // Click the 'next' button on the video banner multiple times
        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/div/button[2]"));
        nextButton.click();
        Thread.sleep(1000);
        nextButton.click();
        Thread.sleep(1000);
        nextButton.click();
        Thread.sleep(1000);

        // Click the 'previous' button to go back one card
        WebElement prevButton = driver.findElement(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/div/button[1]"));
        prevButton.click();
        Thread.sleep(1000);

        // Click next and wait to let the video iterate on its own
        nextButton.click();
        Thread.sleep(8000);
    }

    // Test to hover over each item in the top navigation menu
    @Test(priority = 3)
    void topMenu() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[1]/div/a")));

        // Hover actions for each top menu item
        WebElement newMenuItem = driver.findElement(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[1]/div/a"));
        actions.moveToElement(newMenuItem).perform();
        Thread.sleep(1000);

        WebElement menMenuItem = driver.findElement(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[2]/div/a"));
        actions.moveToElement(menMenuItem).perform();
        Thread.sleep(1000);

        WebElement womenMenuItem = driver.findElement(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[3]/div/a"));
        actions.moveToElement(womenMenuItem).perform();
        Thread.sleep(1000);

        WebElement kidsMenuItem = driver.findElement(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[4]/div/a"));
        actions.moveToElement(kidsMenuItem).perform();
        Thread.sleep(1000);

        WebElement jordanMenuItem = driver.findElement(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[5]/div/a"));
        actions.moveToElement(jordanMenuItem).perform();
        Thread.sleep(1000);

        WebElement sportMenuItem = driver.findElement(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[6]/div/button"));
        actions.moveToElement(sportMenuItem).perform();
        Thread.sleep(1000);
    }

    // Test to interact with a product slider and take screenshots of each product
    @Test(priority = 4)
    void slider() throws InterruptedException, IOException {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("swiper-button-next")));

        // Screenshot the first card (Air Jordan 1)
        WebElement swiperButtonNext = driver.findElement(By.className("swiper-button-next"));
        actions.moveToElement(swiperButtonNext).perform();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src1 = screenshot.getScreenshotAs(OutputType.FILE);
        File des1 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Air Jordan 1.png");
        FileHandler.copy(src1, des1);

        // Capture and save screenshots of each slider card
        String[] productNames = {"Dunk", "Air Force 1", "Vomero", "Cortez", "Air Max", "Blazer"};
        for (String product : productNames) {
            swiperButtonNext.click();
            Thread.sleep(1000);
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            File des = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\" + product + ".png");
            FileHandler.copy(src, des);
        }

        // Navigate back using previous button
        WebElement swiperButtonPrev = driver.findElement(By.className("swiper-button-prev"));
        for (int i = 0; i < productNames.length; i++) {
            swiperButtonPrev.click();
            Thread.sleep(500);
        }
        Thread.sleep(1000);
    }

    // Test to interact with the bottom menu
    @Test(priority = 5)
    void bottomMenu() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Vomero")));

        // Hover over the Vomero menu item to trigger the dropdown
        WebElement vomeroMenuItem = driver.findElement(By.linkText("Vomero"));
        actions.moveToElement(vomeroMenuItem).perform();
        Thread.sleep(2500);

        // Scroll down slightly to show bottom content
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scrollBy(0, 250);");
        Thread.sleep(2500);

        // Hover over the 'Find A Store' link
        WebElement findAStoreMenuItem = driver.findElement(By.xpath("//*[@id=\"3895eb94-d5d8-485b-b7cc-6d64ec0b2c39\"]/div/div/nav/div[1]/ul/li[1]/a"));
        actions.moveToElement(findAStoreMenuItem).perform();
        Thread.sleep(2500);
    }
}
