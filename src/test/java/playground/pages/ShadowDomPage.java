package playground.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class ShadowDomPage extends BasePage<ShadowDomPage> {
    public ShadowDomPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "progress-bar")
    WebElement progressBar;
    WebElement shadowHost = getDriver().findElement(By.tagName("progress-bar"));

    public WebElement getShadowRootElement(WebElement element) {
        WebElement e = (WebElement) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].shadowRoot", element);
        return e;
    }
    public WebElement getShadow() {

        WebElement shadowRoot =  getShadowRootElement(shadowHost);

        return shadowRoot.findElement(By.cssSelector("#shadow-root > div > button"));

    }

    @Step("boost shadow element")
    public ShadowDomPage clickButton() {
        WebElement shadowRoot =  getShadowRootElement(shadowHost);

         shadowRoot.findElement(By.cssSelector("#shadow-root > div > button")).click();

        return this;
    }

    @Step("get shadow root element")
    public String getShadowElement() {

        return progressBar.getDomAttribute("percent");

    }
}
