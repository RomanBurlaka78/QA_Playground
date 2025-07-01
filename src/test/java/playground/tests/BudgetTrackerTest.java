package playground.tests;

import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.BudgetTrackerPage;
import playground.pages.MainPage;

public class BudgetTrackerTest extends BaseTest {

    @Test
    public void testAddRecord() {
        new MainPage(getDriver())
                .goToPage("Budget Tracker", new BudgetTrackerPage(getDriver()))
                .addNewEntry("01012025 ", "description of the element", "34213");
    }

    @Test
    public void testDeleteRecord() {
        new MainPage(getDriver())
                .goToPage("Budget Tracker", new BudgetTrackerPage(getDriver()))
                .addNewEntry("01012025 ", "description of the element", "34213")
                .totalShouldBe("000");
    }
}
