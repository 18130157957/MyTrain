package com.nvr.webdriver;

import com.nvr.browserName.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 关于浏览器操作的类
 */
public class WebDriverUtils {
    private static WebDriver driver;

    private WebDriverUtils() {
    }

    /**
     * 浏览器操作
     *
     * @param browserName
     * @return 浏览器驱动
     * @author lijinjin
     */
    public static WebDriver openBrowser(BrowserName browserName) {
        String projectPath = System.getProperty("user.dir");
        String driversPath;
        if (browserName.equals(BrowserName.chrome)) {
            driversPath = projectPath + "/drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driversPath);
            driver = new ChromeDriver();

        } else if (browserName.equals(BrowserName.ie)) {
            driversPath = projectPath + "/drivers/IEDriverServer.exe";
            System.setProperty("webdriver.ie.driver", driversPath);
            driver = new InternetExplorerDriver();

        } else if (browserName.equals(BrowserName.firefox)) {
            driver = new FirefoxDriver();

        } else if (browserName.equals(BrowserName.edge)) {
           /* driversPath = projectPath + "/drivers/MicrosoftWebDriver.exe";
            System.setProperty("webdriver.edge.driver", driversPath);
            driver = new EdgeDriver();*/
        } else {
            System.err.println("当前浏览器名称:" + browserName + "错误,\t请输入正确的浏览器名称");
        }
        //设置等待时间
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // 窗口最大化

        driver.manage().window().maximize();
        return driver;
    }

    /**
     * 关闭浏览器所有窗口
     */
    public static void closeAll() {
        if (!Objects.isNull(driver)) {
            driver.quit();
        }
    }

    /**
     * 关闭当前浏览器窗口
     */
    public static void closed() {
        if (!Objects.isNull(driver)) {
            driver.close();
        }
    }

    /**
     * 浏览器前进
     */
    public static void foword() {
        if (!Objects.isNull(driver)) {
            driver.navigate().forward();
        }
    }

    /**
     * 浏览器回退
     */
    public static void back() {
        if (!Objects.isNull(driver)) {
            driver.navigate().back();
        }
    }

    /**
     * 浏览器刷新
     */
    public static void refresh() {
        if (!Objects.isNull(driver)) {
            driver.navigate().refresh();
        }
    }
}
