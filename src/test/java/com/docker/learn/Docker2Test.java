package com.docker.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Docker2Test extends BaseTest {


    @Test
    public void doTest() {

        driver.get(SITE_URL);
        wait.until(d -> driver.findElement(By.xpath("//*[@id=\"menuToggle\"]/input")).isEnabled());

        driver.findElement(By.xpath("//*[@id=\"menuToggle\"]/input")).click();
        wait.until(d -> driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]/li")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]/li")).click();
        wait.until(d -> driver.findElement(By.xpath("//*[@id=\"usr\"]"))).isDisplayed();

        driver.findElement(By.xpath("//*[@id=\"usr\"]")).sendKeys("user");
        driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"second_form\"]/input")).click();
        wait.until(d -> driver.findElement(By.xpath("//*[@id=\"ShoeType\"]"))).isDisplayed();

        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"ShoeType\"]"));
        String actualFirstCategory = webElement.getText();
        System.out.println(actualFirstCategory);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String expectedFirstCategory = "Formal Shoes";
        Assert.assertEquals(expectedFirstCategory, actualFirstCategory);
    }
}
