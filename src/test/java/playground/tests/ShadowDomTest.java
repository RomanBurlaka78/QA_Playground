package playground.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.ShadowDomPage;

public class ShadowDomTest extends BaseTest {

    @Ignore
    @Test
    public void testGetPercent() {
        String e = new MainPage(getDriver())
                .goToPage("Shadow DOM", new ShadowDomPage(getDriver()))
                .clickButton()
                .getShadowElement();
        System.out.println(e);
    }
}
