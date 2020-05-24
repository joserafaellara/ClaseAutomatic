package Pruebas;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
public class Laboratorio3_E1 {
	WebDriver driver;
	
	@BeforeSuite
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver","..\\EducacionIt\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void irUrl() {
		driver.get("https://www.facebook.com/");
	}
	
	@BeforeClass
	public void maxVentana() {
		driver.manage().window().maximize();
	}
  @Test (description="Registro invalido de usuario")
  public void registroUsuario() {
	  
		
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
	
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		
		
	}
	
  @AfterClass
  public void finPrueba() {
	  System.out.println("Fin de Prueba");
  }
  
  @AfterTest
  public void cierre() {
	  driver.quit();
  }
  @AfterSuite
  public void finSuite() {
      System.out.println("Fin Suite");
  }
}
