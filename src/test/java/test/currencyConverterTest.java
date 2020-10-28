package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class currencyConverterTest {
    @Test
    public void converterTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.xe.com/");

        WebElement amountInput = driver.findElement(By.id("amount"));
        amountInput.sendKeys("100");

        WebElement convertButton = driver.findElement(By.xpath("//button[@data-test-id='converter-submit-button']"));
        convertButton.click();

        WebElement converterResult = driver.findElement(By.className("converterresult-toAmount"));

        assertTrue(Double.parseDouble(converterResult.getText()) > 84.0);
    }
}
