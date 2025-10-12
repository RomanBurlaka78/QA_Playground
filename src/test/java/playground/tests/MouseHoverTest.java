package playground.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.MouseHoverPage;
import playground.utils.TestListener;

@Listeners(TestListener.class)
public class MouseHoverTest extends BaseTest {

    @Test
    public void testAssertTitle() {
        new MainPage(getDriver())
                .goToPage("Mouse Hover", new MouseHoverPage(getDriver()))
                .titleShouldBeSameAs("Test mouse hover/over");
    }

    @Test
    public void testAssertMouseHoverPrice() {
       String price =  new MainPage(getDriver())
                .goToPage("Mouse Hover", new MouseHoverPage(getDriver()))
                .getPrice();

        Assert.assertEquals(price, "$24.96");

    }
}
