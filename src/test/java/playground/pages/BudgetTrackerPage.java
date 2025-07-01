package playground.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BudgetTrackerPage extends BasePage<BudgetTrackerPage> {
    public BudgetTrackerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()= 'New Entry']")
    WebElement buttonNewEntry;


    @FindBy(xpath = "//tbody[@class = 'entries']/tr[1]//input[@class ='input input-date']")
    WebElement setDate;

    @FindBy(xpath = "//tbody[@class = 'entries']//tr[1]//input[@class= 'input input-description']")
    WebElement setDescription;

    @FindBy(xpath = "//tbody[@class = 'entries']//tr[1]//input[@class= 'input input-amount']")
    WebElement setAmount;
    @FindBy(css= "select[class= 'input input-type']")
    WebElement selectType;

//    Select select = new Select(selectType);
    @FindBy(css = "button[class ='delete-entry']")
    WebElement buttonDelete;
    @FindBy(css = "span[class='total']")
    WebElement total;


    @Step("add new entry")
    public BudgetTrackerPage addNewEntry(String date, String description, String amount) {
        buttonNewEntry.click();
        setDate.sendKeys(date);
        setDescription.sendKeys(description);
//        select.selectByVisibleText("Expense");
        selectType.click();
        setAmount.clear();
        setAmount.sendKeys(amount);

        return this;
    }

    @Step("delete record")
    public BudgetTrackerPage deleteRecord() {
        buttonDelete.click();
        return this;
    }

    @Step("assert tottal")
    public void  totalShouldBe(String totalSum) {
       Assert.assertEquals(total.getText().replaceAll("[^0-9]", ""), totalSum);

    }
}
