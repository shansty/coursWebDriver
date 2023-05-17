import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BringItOn {
    ChromeDriver driver;
    @BeforeEach
    public void prepareToStartTest(){
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
    }

    @Test
    public void testWebDriver() throws InterruptedException {
        WebElement kodeInput = driver.findElement(By.xpath("//*[@id=\"postform-text\"]"));
        kodeInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --forcer");
        WebElement syntaxHighlighting = driver.findElement(By.id("select2-postform-format-container"));
        syntaxHighlighting.click();
        WebElement clickSyntaxHighlighting = driver.findElement(By.xpath("//ul[@class='select2-results__options select2-results__options--nested']/li[text()='Bash']"));
        clickSyntaxHighlighting.click();
        WebElement pasteExpiration = driver.findElement(By.id("select2-postform-expiration-container"));
        pasteExpiration.click();
        WebElement clickPasteExpiration = driver.findElement(By.xpath("//ul[@id='select2-postform-expiration-results']/li[text()='10 Minutes']"));
        clickPasteExpiration.click();
        WebElement pastName = driver.findElement(By.xpath("//*[@id=\"postform-name\"]"));
        pastName.sendKeys("how to gain dominance among developers");
        WebElement submitBottom = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button"));
        submitBottom.click();

        WebElement finalPastName = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]"));
        String actualPastName = finalPastName.getText();
        Assertions.assertEquals("how to gain dominance among developers", actualPastName);

        WebElement chosenSyntax = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/a[1]"));
        String finalSyntax = chosenSyntax.getText();
        Assertions.assertEquals("Bash", finalSyntax);

        WebElement inputCodeText = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/ol"));
        String finalCodeText = inputCodeText.getText();
        Assertions.assertEquals("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --forcer", finalCodeText);

        Thread.sleep(4000);
        driver.quit();
    }
}
