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
        driver.findElement(By.xpath("//input[@id='myInput']"));
       // Thread.sleep (1000);
        String actualURL=browserURL(driver);
        String expectedURL= "https://www.poorvikamobile.com/apple-iphone-12-mini-white-256gb";
        String headervalue = "Apple iphone 12 mini";
        String actualheaderValue=driver.findElement(By.xpath("//h1[@content=\"Apple iPhone 12 Mini (White, 256GB)\"]")).getText();
        String actualprice = driver.findElement(By.xpath("//span[@itemprop=\"price\"]")).getText();
        String  expectedprice = "RS.82,900";

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
