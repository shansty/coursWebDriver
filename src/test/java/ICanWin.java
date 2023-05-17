import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICanWin {
    ChromeDriver driver;

    @BeforeAll
    public void prepareToStartTest(){
        ChromeDriver driver = new ChromeDriver();
        this.driver = driver;
        driver.get("https://pastebin.com");
    }

    @Test
    public void testWebDriver() throws InterruptedException {
        WebElement kodeInput = driver.findElement(By.xpath("//*[@id=\"postform-text\"]"));
        kodeInput.sendKeys("Hello from WebDriver");
        WebElement pastName = driver.findElement(By.xpath("//*[@id=\"postform-name\"]"));
        pastName.sendKeys("helloweb");
        WebElement pasteExpiration = driver.findElement(By.id("select2-postform-expiration-container"));
        pasteExpiration.click();
        WebElement clickPasteExpiration = driver.findElement(By.xpath("//ul[@id='select2-postform-expiration-results']/li[text()='10 Minutes']"));
        clickPasteExpiration.click();
        WebElement submitBottom = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button"));
        submitBottom.click();
        WebElement finalMessage = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/ol/li/div"));
        String actualResult = finalMessage.getText();
        Assertions.assertEquals("Hello from WebDriver", actualResult);
    }

        @AfterAll
        public void closeTests() throws InterruptedException {
            Thread.sleep(4000);
            driver.quit();
        }

}
