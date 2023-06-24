package ru.netology.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NegativeOrderCardTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
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
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Smirnova Maria");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370006989");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=name].input_invalid .input__sub")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrder2() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).clear();
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370006989");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector("[data-test-id=name].input_invalid .input__sub")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrder3() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванова Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+793700069899");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=phone].input_invalid .input__sub")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrder4() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванова Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+7937000698");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=phone].input_invalid .input__sub")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrder5() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванова Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("79370006989");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=phone].input_invalid .input__sub")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrder6() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванова Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).clear();
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();

        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector("[data-test-id=phone].input_invalid .input__sub")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOrderWithoutAgreement() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванова Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79370006989");
        driver.findElement(By.className("button")).click();

        boolean actual = driver.findElement(By.cssSelector("[data-test-id=agreement].input_invalid")).isDisplayed();

        Assertions.assertTrue(actual);

    }
}
