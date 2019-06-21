package com.nvr.testcase;

import com.nvr.browserName.BrowserName;
import com.nvr.webdriver.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {
    @Test
    public void testOpenBroswer()  {
        WebDriver driver = WebDriverUtils.openBrowser(BrowserName.edge);
        driver.get("http://www.baidu.com");
        WebDriverUtils.closeAll();
    }
}
