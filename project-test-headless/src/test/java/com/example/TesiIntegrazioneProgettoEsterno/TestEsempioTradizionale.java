package com.example.TesiIntegrazioneProgettoEsterno;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class TestEsempioTradizionale {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\Downloads\\chromedriver_win32_ChromeV97\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testEsempioTradizionale() throws Exception {
    driver.get("http://localhost:4200/");
    driver.findElement(By.id("exampleInputEmail1")).click();
    driver.findElement(By.id("exampleInputEmail1")).clear();
    driver.findElement(By.id("exampleInputEmail1")).sendKeys("Mario");
    driver.findElement(By.id("exampleInputPassword1")).click();
    driver.findElement(By.id("exampleInputPassword1")).clear();
    driver.findElement(By.id("exampleInputPassword1")).sendKeys("Rossi");
    driver.findElement(By.xpath("//div[2]/div/input")).click();
    driver.findElement(By.xpath("//div[2]/div/input")).clear();
    driver.findElement(By.xpath("//div[2]/div/input")).sendKeys("mario.rossi@email.com");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.id("exampleInputEmail1")).click();
    driver.findElement(By.id("exampleInputEmail1")).clear();
    driver.findElement(By.id("exampleInputEmail1")).sendKeys("Mattia");
    driver.findElement(By.id("exampleInputPassword1")).click();
    driver.findElement(By.id("exampleInputPassword1")).clear();
    driver.findElement(By.id("exampleInputPassword1")).sendKeys("Verdi");
    driver.findElement(By.xpath("//div[2]/div/input")).click();
    driver.findElement(By.xpath("//div[2]/div/input")).clear();
    driver.findElement(By.xpath("//div[2]/div/input")).sendKeys("mattia.verdi@email.com");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Users Created'])[1]/following::button[1]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}