package com.volia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_C {
    public static void main(String[] args) {
        System.setProperty("webdriver.opera.driver", "D:\\MyProjectJava\\Selenium\\src\\main\\resources\\chromedriver.exe");

        WebDriver webDriver = new OperaDriver();
        Actions actions = new Actions(webDriver);
        WebDriverWait wait = new WebDriverWait(webDriver, 30);

        String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
        webDriver.get(url);
        webDriver.manage().window().maximize();
        WebElement mail = webDriver.findElement(By.id("email"));
        mail.sendKeys("webinar.test@gmail.com");
        WebElement password = webDriver.findElement(By.name("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement enter = webDriver.findElement(By.className("ladda-label"));
        enter.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#subtab-AdminCatalog > a")));

        WebElement catalog = webDriver.findElement(By.cssSelector("#subtab-AdminCatalog > a"));
        actions.moveToElement(catalog).perform();
        WebElement categories = webDriver.findElement(By.xpath("//*[@id=\"subtab-AdminCategories\"]/a"));
        actions.moveToElement(categories).click(categories).perform();

        WebElement add = webDriver.findElement(By.cssSelector("#page-header-desc-category-new_category"));
        add.click();

        WebElement enter_field = webDriver.findElement(By.xpath("//*[@id=\"name_1\"]"));
        actions.sendKeys(enter_field,"MichaelNewCategory").perform();
        WebElement save = webDriver.findElement(By.xpath("//*[@id=\"category_form_submit_btn\"]"));
        save.click();

        WebElement name_field = webDriver.findElement(By.cssSelector("#table-category > thead > tr.nodrag.nodrop.filter.row_hover > th:nth-child(3) > input"));
        actions.sendKeys(name_field,"MichaelNewCategory").perform();
        WebElement search = webDriver.findElement(By.xpath("//*[@id=\"submitFilterButtoncategory\"]"));
        search.click();

        //webDriver.quit();
    }
}
