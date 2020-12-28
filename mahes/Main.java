package mahes;



import com.Selenium_intellij.mahes3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class Main {

    public static void main(String[] args)throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.poorvikamobile.com/");
        driver.manage().window().maximize();
        mahes3 home = new mahes3();
        WebElement el = driver.findElement(home.Search);
        System.out.println("browserURL(driver)");
        el.sendKeys("iphone");
        driver.findElement(By.xpath("//input[@autocomplete=\"off\"]")).click();
       // Thread.sleep (1000);
        driver.findElement(home.button).click();
        driver.findElement(home.sort).click();
        driver.findElement(By.xpath("//*[@id=\"scroll_product\"]/div[1]/div/div[1]/div[1]/a")).click();
        String actualURL=browserURL(driver);
        //Thread.sleep(2000);
        String expectedURL= "https://www.poorvikamobile.com/apple-iphone-xr-red-64gb";
        String headervalue = "Apple-iphone-xr-64gb";
        String actualheaderValue=driver.findElement(By.xpath("//h1[@itemprop=\"name\"]")).getText();
        String actualprice = driver.findElement(By.xpath("//span[@id=\"price-special\"]")).getText();
        String expectedprice = "RS.47,900";

        if(expectedURL.equals(actualURL))
        {
            System.out.println("URL have match");
        }else
        {
            throw new AssertionError("URL doesn't match");
        }
        driver.close();


    }

    private static String browserURL(WebDriver driver)
    {
        return driver.getCurrentUrl();
    }

}
