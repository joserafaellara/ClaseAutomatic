package Edit.EducacionIt;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


public class Laboratorio2 {
	
	@Ignore
	public void lab2_E0(){
		System.setProperty("webdriver.chrome.driver","..\\EducacionIt\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://selenium.dev/");
		
		WebElement linkDescarga = driver.findElement(By.linkText("Downloads"));
		linkDescarga.click();
		
	}

	@Ignore
	public void lab2_E1() {
		
		System.setProperty("webdriver.chrome.driver","..\\EducacionIt\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebDriverWait myWaitVar= new WebDriverWait(driver,10);
		
		WebElement txtNombre = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));
		txtNombre.sendKeys("Jose");
		
		WebElement txtApellido = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='u_0_o']")));
		txtApellido.sendKeys("Lara");
		
		WebElement txtCelular = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='reg_email__']")));
		txtCelular.sendKeys("5491138426593");
		
		WebElement txtPasw = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("reg_passwd__")));
		txtPasw.sendKeys("tuttifruti");
		
		Select mes = new Select(myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("month")))); 
		mes.selectByVisibleText("Apr");
		
		Select dia = new Select(myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("day")))); 
		dia.selectByValue("9");
		
		Select ano = new Select(myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("year")))); 
		ano.selectByVisibleText("1998");
		
		WebElement btnClic = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("websubmit")));
		btnClic.click();
		
		
		
		//driver.quit();
		
		
		
		
	}
		
	@Test
	public void Lab2_E2() {
		
		System.setProperty("webdriver.chrome.driver","..\\EducacionIt\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebDriverWait myWaitVar= new WebDriverWait(driver,10);
		
		WebElement txtUser = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("email")));
		txtUser.sendKeys("pepito@tequiero.noe.com.ar");
		
		WebElement txtPassw = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'pass\']")));
		txtPassw.sendKeys("1234567");
		
		WebElement btnEnter = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'loginbutton\']")));
		btnEnter.click();
		
	}
}
