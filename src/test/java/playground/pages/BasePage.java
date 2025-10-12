package playground.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v132.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import playground.utils.TestListener;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public abstract class BasePage<T>  {

    protected WebDriver driver;
    private Actions actions ;

    public Actions getActions() {

        return  new Actions(getDriver());
    }


    @FindBy(tagName = "title")
    WebElement titlePage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(),this);

    }
    public T waitForPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState").equals("complete"));
        return (T)this;
    }

    public WebDriver getDriver() {
        return driver;
    }


    @Step("the title should be same as : {titlePage}")
    public void titleShouldBeSameAs(String titlePage) {

        Assert.assertEquals(getDriver().getTitle(),titlePage);
    }

    public WebDriverWait wait5() {
        return  new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    }



}
