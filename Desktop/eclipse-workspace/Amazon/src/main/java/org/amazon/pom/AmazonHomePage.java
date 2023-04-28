package org.amazon.pom;

import org.amazon.drivers.DriverSetup;
import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AmazonHomePage {

    WebDriver driver = null;

    public AmazonHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Actions act = new Actions(DriverSetup.driver);
   //Entering Text in Search Bar
   @FindBy(id = "twotabsearchtextbox")
   private WebElement searchbtn;

    public void searchbutton()
    {
        searchbtn.sendKeys("iphone");
        searchbtn.sendKeys(Keys.ENTER);
    }
    // Xpath to save list of items
    @FindBy(id = "search")
    private WebElement searchresult;

    @FindBys({@FindBy(id = "search"), @FindBy(xpath = ".//span[@class='a-size-medium a-color-base a-text-normal']")})
    List<WebElement> searchResultItemNames;
   @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    private WebElement firstelement;
///html/body/div[4]/div[3]/div[3]/div/div[1]/div[3]/div[1]/div[1]/div/div[1]/span
   public void clickonfirstresult()
   {
       firstelement.click();
       String name = firstelement.getText();
       System.out.println(name);
   }

    public void getitemstext()
    {

       // System.out.println(firstelement.getText());
        for (WebElement searchResultItemName : searchResultItemNames) {
            System.out.println(searchResultItemName.getText());
        }

    }

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addtocartbutton;

   public void add_cart_button()
   {
       addtocartbutton.click();
   }

    //@FindBy(id = "NATC_SMART_WAGON_CONF_MSG_SUCCESS")
    @FindBy(xpath= "//*[@id='attach-desktop-sideSheet']/div[3]/div/div[1]/div[3]")
    private WebElement success_cart;

   public void added_to_cart()
   {
       success_cart.getText();
       System.out.println("Successfully "+success_cart.getText());
   }



    }



