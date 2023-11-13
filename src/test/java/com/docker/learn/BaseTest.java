package com.docker.learn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class BaseTest {

    protected static final String REMOTE_URL = "http://localhost:4444";

    // This var for Kubernetes  URL ONLY -> use first URL from command "minikube service selenium-hub –-url"
    //protected static final String REMOTE_URL = "http://127.0.0.1:3941";
    protected static final String SITE_URL = "https://anupdamoda.github.io/AceOnlineShoePortal/index.html";
    private static ChromeOptions chromeOptions;
    private static FirefoxOptions firefoxOptions;
    private static ThreadLocal<RemoteWebDriver> remoteThreadLocalDriver = new ThreadLocal<>();
    protected WebDriver driver;
    protected WebDriverWait wait;


    @Parameters("browser")
    @BeforeMethod
    public void init(@Optional("CHROME") String browser) throws MalformedURLException {

        switch (browser.toUpperCase()) {
            case "CHROME" -> {
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

                remoteThreadLocalDriver.set(new RemoteWebDriver(new URL(REMOTE_URL), chromeOptions));
            }
            case "FIREFOX" -> {
                firefoxOptions = new FirefoxOptions();
                remoteThreadLocalDriver.set(new RemoteWebDriver(new URL(REMOTE_URL), firefoxOptions));
            }
            default -> throw new IllegalStateException("Unexpected value: " + browser);
        }

        driver = remoteThreadLocalDriver.get();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @AfterMethod
    public void tearDown() {
        if (remoteThreadLocalDriver.get() != null) {
            remoteThreadLocalDriver.get().quit();
        }
    }
}
