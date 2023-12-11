package handsonassesment;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mmthandson {
	public static String url="https://www.makemytrip.com/";
	WebDriver driver;
	JavascriptExecutor scroll;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
	
	
	@BeforeTest
	public void openmmt() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		htmlreporter=new ExtentHtmlReporter("extent.html");
        extent=new ExtentReports();
        extent.attachReporter(htmlreporter);
        
		driver.get(url);
		Thread.sleep(3000);
		driver.manage().window().maximize();  
        test=extent.createTest("TEST CASE 1");
        test.pass("close login pop up");
    	driver.findElement(By.xpath("//*[@class='commonModal__close']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
    	driver.switchTo().defaultContent();
    	extent.flush();
	}
	@Test
	public void hp() throws InterruptedException {
          
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//holiday package selection
		test=extent.createTest("TEST CASE 2");
		test.pass("select holiday package");
		driver.findElement(By.linkText("Holiday Packages")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//scroll down
		scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,100)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		//cancel all alert pop ups
		test=extent.createTest("TEST CASE 3");
		test.pass("skip all alerts");
		driver.findElement(By.xpath("//*[@class='primaryBtnWhite border-btn font16 latoBold']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//select from location
		test=extent.createTest("TEST CASE 4");
		test.pass("add location as banglore");
		driver.findElement(By.xpath("//*[@data-cy='fromCity']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement from=driver.findElement(By.xpath("//*[@placeholder='Enter City']"));
		from.clear();
		from.sendKeys("Banglore");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@data-testid='Bangalore']")).click();
		
		
		//to location
		test=extent.createTest("TEST CASE 5");
		test.pass("select thailand");
		driver.findElement(By.xpath("//*[@data-cy='toCity']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div[2]/div/div[2]/div")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//select date
		test=extent.createTest("TEST CASE 6");
		test.pass("select date");
		WebElement date= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[1]/div[3]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[3]/div[7]/div/p"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		date.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//add room and guest
		test=extent.createTest("TEST CASE 7");
		test.pass("Select guest and click apply");
		driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//filters
		test=extent.createTest("TEST CASE 8");
		test.pass("add required filters");
		Thread.sleep(3000);
		WebElement abt= driver.findElement(By.xpath("//*[@class='action']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		abt.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//search
		test=extent.createTest("TEST CASE 9");
		test.pass("click search");
		driver.findElement(By.xpath("//*[@data-cy='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		List<WebElement> skipButton = driver.findElements(By.xpath("//*[@class='skipBtn']"));
		if (!skipButton.isEmpty()) {
		    // skip
		    
		    skipButton.get(0).click(); 
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    scroll.executeScript("window.scrollBy(0,100)");
		} 
		
		
	
		List<WebElement> type1 = driver.findElements(By.xpath("(//*[@class='daysbadge'])[1]"));
        if(!type1.isEmpty()) {
        	//when filter on top
        	
        
    		
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	driver.findElement(By.xpath("(//*[@class='daysbadge'])[1]")).click();
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("(//*[@class='variant-card-heading'])[1]")).click();
    		test=extent.createTest("TEST CASE 10");
    		test.pass("select a package");
        }
        
        scroll.executeScript("window.scrollBy(0,100)");
        scroll.executeScript("window.scrollBy(0,100)");
        
        List<WebElement> type2 = driver.findElements(By.xpath("(//*[@class='selected'])[1]"));
        if(!type2.isEmpty()) {
        	//filter on left
        	
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		driver.findElement(By.xpath("//*[@id=\"modalpopup\"]/div/span")).click();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    		scroll.executeScript("window.scrollBy(0,100)");
        	
        	
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		driver.findElement(By.xpath("(//*[@class='selected'])[1]")).click();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		driver.findElement(By.xpath("(//*[@class='variant-card-heading'])[1]")).click();
    		test=extent.createTest("TEST CASE 10");
    		test.pass("select a package");
        }
        
            //switch to new tab
      		Set<String> s= driver.getWindowHandles();
      		String[] arr = s.toArray(new String[s.size()]);
      		String child=arr[1];
      		driver.switchTo().window(child);
      		test=extent.createTest("TEST CASE 11");
      		test.pass("click on skip button in new tab");
      		driver.findElement(By.xpath("//*[@class='skipBtn']")).click();
      		driver.switchTo().window(child);
      		
      		//change hotel
      		driver.findElement(By.xpath("(//*[@id='change'])[3]")).click();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		Thread.sleep(3000);
    		test=extent.createTest("TEST CASE 12");
    		test.pass("select a new hotel from list of available hotel");
            driver.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[1]")).click();
            Thread.sleep(4000);
            test=extent.createTest("TEST CASE 13");
    		test.pass("click on update in price");
            driver.findElement(By.xpath("//*[@class='updatePackageBtnText font10']")).click();
            driver.navigate().refresh();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
            
            test=extent.createTest("TEST CASE 14");
    		test.pass("select add activity");
            driver.findElement(By.xpath("(//*[@class='appendRight3'])[6]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);
            test=extent.createTest("TEST CASE 15");
    		test.pass("select a particual day for activity");
            driver.findElement(By.id("chooseAndAddBtn")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);
            test=extent.createTest("TEST CASE 16");
    		test.pass("select add activity");
            driver.findElement(By.xpath("//*[@class='primaryBtn fill selectBtn']")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);
            test=extent.createTest("TEST CASE 17");
    		test.pass("update the added activity");
            driver.findElement(By.xpath("//*[@class='updatePackageBtnText font10 btn btn-primary btn-sm']")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      		
        
	
		
		
		extent.flush();
	}
}
