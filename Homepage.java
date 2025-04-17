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

public class Homepage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    // load page and setup necessary tools before every method
    @BeforeMethod
    void loadPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://nike.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    // close page after every method
    @AfterMethod
    void closePage() {
        driver.quit();
    }

    // get current URL and title of the page
    @Test(priority = 1)
    void urlAndTitle() {
        System.out.println("Current URL: " + driver.getCurrentUrl());

        System.out.println("Page Title: " + driver.getTitle());
    }

    // test the video banner at the top of the page
    @Test(priority = 2)
    void videoBanner() throws InterruptedException {
        // wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/button")));
        Thread.sleep(1000);

        // pause video
        WebElement pauseButton = driver.findElement(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/button"));
        pauseButton.click();
        Thread.sleep(1000);

        // click through the cards of the video banner
        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/div/button[2]"));
        nextButton.click();
        Thread.sleep(1000);
        nextButton.click();
        Thread.sleep(1000);
        nextButton.click();
        Thread.sleep(1000);

        // go back one card
        WebElement prevButton = driver.findElement(By.xpath("//*[@id=\"swiper-21a3d0af-c8cc-41a9-87a1-b719017f8a24\"]/div[3]/div/button[1]"));
        prevButton.click();
        Thread.sleep(1000);

        // go forward one card and wait for it to iterate by itself
        nextButton.click();
        Thread.sleep(8000);
    }

    @Test(priority = 3)
    void topMenu() throws InterruptedException {
        // wait for page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[1]/div/a")));

        // hover over the New menu item of the top menu
        WebElement newMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[1]/div/a")));
        actions.moveToElement(newMenuItem).perform();
        Thread.sleep(1000);

        // hover over the Men menu item of the top menu
        WebElement menMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[2]/div/a")));
        actions.moveToElement(menMenuItem).perform();
        Thread.sleep(1000);

        // hover over the Women menu item of the top menu
        WebElement womenMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[3]/div/a")));
        actions.moveToElement(womenMenuItem).perform();
        Thread.sleep(1000);

        // hover over the Kids menu item of the top menu
        WebElement kidsMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[4]/div/a")));
        actions.moveToElement(kidsMenuItem).perform();
        Thread.sleep(1000);

        // hover over the Jordan menu item of the top menu
        WebElement jordanMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[5]/div/a")));
        actions.moveToElement(jordanMenuItem).perform();
        Thread.sleep(1000);

        // hover over the Sport menu item of the top menu
        WebElement sportMenuItem = driver.findElement((By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/nav/header/div/div/div[2]/nav/ul/li[6]/div/button")));
        actions.moveToElement(sportMenuItem).perform();
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    void slider() throws InterruptedException, IOException {
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
        Thread.sleep(1000);

        File src2 = screenshot.getScreenshotAs(OutputType.FILE);
        File des2 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Dunk.png");
        FileHandler.copy(src2, des2);

        // iterate through to the Air Force 1 card and take a screenshot
        swiperButtonNext.click();
        Thread.sleep(1000);

        File src3 = screenshot.getScreenshotAs(OutputType.FILE);
        File des3 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Air Force 1.png");
        FileHandler.copy(src3, des3);

        // iterate through to the Vomero card and take a screenshot
        swiperButtonNext.click();
        Thread.sleep(1000);

        File src4 = screenshot.getScreenshotAs(OutputType.FILE);
        File des4 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Vomero.png");
        FileHandler.copy(src4, des4);

        // iterate through to the Cortez card and take a screenshot
        swiperButtonNext.click();
        Thread.sleep(1000);

        File src5 = screenshot.getScreenshotAs(OutputType.FILE);
        File des5 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Cortez.png");
        FileHandler.copy(src5, des5);

        // iterate through to the Air Max card and take a screenshot
        swiperButtonNext.click();
        Thread.sleep(1000);

        File src6 = screenshot.getScreenshotAs(OutputType.FILE);
        File des6 = new File("C:\\Users\\Chris\\Documents\\Shop The Classics\\Air Max.png");
        FileHandler.copy(src6, des6);

        // iterate through to the Blazer card and take a screenshot
        swiperButtonNext.click();
        Thread.sleep(1000);

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
        Thread.sleep(1000);
    }

    @Test(priority = 5)
    void bottomMenu() throws InterruptedException {
        // wait for page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Vomero")));

        // move to the bottom menu and cause it to dropdown
        WebElement vomeroMenuItem = driver.findElement((By.linkText("Vomero")));
        actions.moveToElement(vomeroMenuItem).perform();
        Thread.sleep(2500);

        // scroll to show the entire bottom
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scrollBy(0, 250);");
        Thread.sleep(2500);

        // make the dropdown come up
        WebElement findAStoreMenuItem = driver.findElement((By.xpath("//*[@id=\"3895eb94-d5d8-485b-b7cc-6d64ec0b2c39\"]/div/div/nav/div[1]/ul/li[1]/a")));
        actions.moveToElement(findAStoreMenuItem).perform();
        Thread.sleep(2500);
    }
}
