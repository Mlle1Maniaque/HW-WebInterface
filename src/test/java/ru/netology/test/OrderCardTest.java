package ru.netology.test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class OrderCardTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
    }

    @BeforeEach
    void shouldTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldOrder1() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванова Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370006989");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrder2() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Януш-Ким Яна");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370006989");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrder3() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Януш Ким Яна");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370006989");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrder4() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Цой Ким Анна-Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370006989");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrder5() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Цой Ким Анна Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370006989");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrder6() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("цой-ким анна-мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370006989");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrder7() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("С М");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370006989");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }
}
