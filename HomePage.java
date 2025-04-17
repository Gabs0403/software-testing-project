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

    @BeforeMethod
    void loadPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://nike.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    @AfterMethod
    void closePage() {
        driver.quit();
    }

    @Test(priority = 1)
    void urlAndTitle() {
        System.out.println("Current URL: " + driver.getCurrentUrl());

        System.out.println("Page Title: " + driver.getTitle());
    }

    @Test(priority = 2)
    void videoBanner() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/button")));

        // pauses video
        WebElement pauseButton = driver.findElement(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/button"));
        pauseButton.click();
        Thread.sleep(500);

        // clicks through
        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/div/button[2]"));
        nextButton.click();
        Thread.sleep(500);
        nextButton.click();
        Thread.sleep(500);
        nextButton.click();
        Thread.sleep(500);

        // goes back one
        WebElement prevButton = driver.findElement(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/div/button[1]"));
        prevButton.click();
        Thread.sleep(500);

        // goes forward and waits for it to iterate by itself
        nextButton.click();
        Thread.sleep(7000);
    }

    @Test(priority = 3)
    void headerMenu() throws InterruptedException {
        // wait for page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[1]/div/a")));

        // make the footer menu appear
        WebElement newMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[1]/div/a")));
        actions.moveToElement(newMenuItem).perform();
        Thread.sleep(500);

        // make the footer menu appear
        WebElement menMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[2]/div/a")));
        actions.moveToElement(menMenuItem).perform();
        Thread.sleep(500);

        // make the footer menu appear
        WebElement womenMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[3]/div/a")));
        actions.moveToElement(womenMenuItem).perform();
        Thread.sleep(500);

        // make the footer menu appear
        WebElement kidsMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[4]/div/a")));
        actions.moveToElement(kidsMenuItem).perform();
        Thread.sleep(500);

        // make the footer menu appear
        WebElement jordanMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[5]/div/a")));
        actions.moveToElement(jordanMenuItem).perform();
        Thread.sleep(500);

        // make the footer menu appear
        WebElement sportMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[6]/div/button")));
        actions.moveToElement(sportMenuItem).perform();
        Thread.sleep(500);
    }

    // fully iterate back and forth through the footer slider and take a screenshot each iteration
    @Test(priority = 4)
    void footerSlider() throws InterruptedException, IOException {
        // wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.className("swiper-button-next")));

        // move to the next swiper button and take a screenshot of the Air Jordan 1 card
        WebElement swiperButtonNext = driver.findElement(By.className("swiper-button-next"));
        actions.moveToElement(swiperButtonNext).perform();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src1 = screenshot.getScreenshotAs(OutputType.FILE);
        File des1 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Air Jordan 1.png");
        FileHandler.copy(src1, des1);

        // iterate through to the Dunk card and take a screenshot
        swiperButtonNext.click();
        Thread.sleep(500);

        File src2 = screenshot.getScreenshotAs(OutputType.FILE);
        File des2 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Dunk.png");
        FileHandler.copy(src2, des2);

        // iterate through to the Air Force 1 card and take a screenshot
        swiperButtonNext.click();
        Thread.sleep(500);

        File src3 = screenshot.getScreenshotAs(OutputType.FILE);
        File des3 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Air Force 1.png");
        FileHandler.copy(src3, des3);

        // iterate through to the Vomero card and take a screenshot
        swiperButtonNext.click();
        Thread.sleep(500);

        File src4 = screenshot.getScreenshotAs(OutputType.FILE);
        File des4 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Vomero.png");
        FileHandler.copy(src4, des4);

        // iterate through to the Cortez card and take a screenshot
        swiperButtonNext.click();
        Thread.sleep(500);

        File src5 = screenshot.getScreenshotAs(OutputType.FILE);
        File des5 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Cortez.png");
        FileHandler.copy(src5, des5);

        // iterate through to the Air Max card and take a screenshot
        swiperButtonNext.click();
        Thread.sleep(500);

        File src6 = screenshot.getScreenshotAs(OutputType.FILE);
        File des6 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Air Max.png");
        FileHandler.copy(src6, des6);

        // iterate through to the Blazer card and take a screenshot
        swiperButtonNext.click();
        Thread.sleep(500);

        File src7 = screenshot.getScreenshotAs(OutputType.FILE);
        File des7 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Blazer.png");
        FileHandler.copy(src7, des7);

        // iterate back through the slider using the previous swiper button
        WebElement swiperButtonPrev = driver.findElement(By.className("swiper-button-prev"));
        swiperButtonPrev.click();
        Thread.sleep(500);

        swiperButtonPrev.click();
        Thread.sleep(500);

        swiperButtonPrev.click();
        Thread.sleep(500);

        swiperButtonPrev.click();
        Thread.sleep(500);

        swiperButtonPrev.click();
        Thread.sleep(500);

        swiperButtonPrev.click();
        Thread.sleep(500);
    }

    // show and hide the footer menu
    @Test(priority = 5)
    void footerMenu() throws InterruptedException {
        // wait for page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Vomero")));

        // make the footer menu appear
        WebElement vomeroMenuItem = driver.findElement((By.linkText("Vomero")));
        actions.moveToElement(vomeroMenuItem).perform();
        Thread.sleep(2500);

        // scroll to show the entire footer menu
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scrollBy(0, 250);");
        Thread.sleep(2500);

        // make the footer menu disappear
        WebElement findAStoreMenuItem = driver.findElement((By.xpath("//*[@id=\"3895eb94-d5d8-485b-b7cc-6d64ec0b2c39\"]/div/div/nav/div[1]/ul/li[1]/a")));
        actions.moveToElement(findAStoreMenuItem).perform();
        Thread.sleep(2500);
    }
}


