import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	public static void main(String[] args) {
		//Web driver Initialization
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
				//Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				//crt site
				String crturl = driver.getCurrentUrl();
				System.out.println("CurrentUrl : " + crturl);
				String title = driver.getTitle();
				System.out.println("Website Title :" + title);
				
				//valid login
				WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
				username.sendKeys("Admin");
				WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
				pass.sendKeys("admin123");
				WebElement login = driver.findElement(By.xpath("//button[text()=' Login ']"));
				login.click();
				
				boolean isDashboardDisplayed = driver.getCurrentUrl().contains("dashboard");
				if (isDashboardDisplayed) {
				    System.out.println("VALID LOGIN TEST : PASSED");
				    
				    //logout
				    WebElement log = driver.findElement(By.xpath("//p[text()='manda user']"));
				    log.click();
				    WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
				    logout.click();
				    
				} else {
				    System.out.println("VALID LOGIN TEST : FAILED");
				}
				
				
				
				//invalid login
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				WebElement username1 = driver.findElement(By.xpath("//input[@placeholder='Username']"));
				username1.sendKeys("admin1");
				WebElement pass1 = driver.findElement(By.xpath("//input[@name='password']"));
				pass1.sendKeys("admin1234");
				WebElement login1 = driver.findElement(By.xpath("//button[text()=' Login ']"));
				login1.click();
				
				String errorMsg = driver.findElement(By.xpath("//p[contains(@class,'alert-content-text')]")).getText();

				if (errorMsg.contains("Invalid credentials")) {
				    System.out.println("INVALID LOGIN TEST : PASSED");
				    System.out.println("ErrorMsg :" + errorMsg);
				} else {
				    System.out.println("INVALID LOGIN TEST : FAILED");
				}
				
			
	}

}
