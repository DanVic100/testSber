import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class testSber extends  BasePage{

    @FindBy(xpath =  "//*[@class='region-list__name']")
    private WebElement buttonRegion;

    @FindBy(xpath =  "//input[@placeholder='Введите название региона']")
    private WebElement region;

    @FindBy(xpath =  "//div[@role='option']")
    private WebElement buttonReg;

    @FindBy(xpath =  "//span[@class='region-list__name']")
    private WebElement newRegion;

    @FindBy(xpath =  "//div[@class = 'social__wrapper' ]")
    private List<WebElement> icons;



    private testSber getNewregion()
    {
        buttonRegion.click();
        wait.until(ExpectedConditions.visibilityOf(region));
        region.sendKeys("Нижегородская область");
        buttonReg.click();

        return  this;
    }

    private testSber assertNewRegion()
    {
        Assert.assertEquals("Титульник страницы не соответстувет выбору в селекте","Нижегородская область",newRegion.getText());

        return this;
    }

    private  testSber assertScroll()
    {
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        return this;
    }

    private  testSber assertIcon()
    {
        boolean isPresent = false;
        if (icons.size()>0) isPresent = true;
        Assert.assertTrue(isPresent);
        return this;
    }

    @Test
    public void testSber()
    {
        this.getNewregion()
                .assertNewRegion()
                .assertScroll()
                .assertIcon();

    }

}
