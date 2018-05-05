import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

public class testSber {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sberbank.ru/ru/person");
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void testSber()
    {
        WebElement buttonRegion = driver.findElement(By.xpath("//*[@class='region-list__name']"));
        buttonRegion.click();

        WebElement region = driver.findElement(By.xpath("//input[@placeholder='Введите название региона']"));
        region.sendKeys("Нижегородская область");

        WebElement buttonReg = driver.findElement(By.xpath("//div[@role='option']"));
        buttonReg.click();

        WebElement newRegion = driver.findElement(By.xpath("//span[@class='region-list__name']"));
        Assert.assertEquals("Титульник страницы не соответстувет выбору в селекте","Нижегородская область",newRegion.getText());

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");

        Boolean isPresent = driver.findElements(By.xpath("//div[@class = 'social__wrapper' ]")).size() > 0;
        Assert.assertTrue(isPresent);

    }

}
