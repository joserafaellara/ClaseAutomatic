package Pruebas;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;

import Paginas.paginaInicio;
import Paginas.paginaLogin;

public class Laboratorio3_E2 {
	WebDriver driver;
	String url="http://automationpractice.com/index.php";
	String pathDriver="..\\EducacionIt\\Drivers\\chromedriver.exe";
	
	@BeforeTest
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", pathDriver);
        driver = new ChromeDriver();
        driver.get(url);
    	driver.manage().window().maximize(); 
	}
	
  @Test (priority=0)
  public void f() {
	  
	  paginaInicio inicio = new paginaInicio(driver);
	  inicio.clicLogin();
  }
  
  @Test (priority=1)
  public void ingreso() throws IOException {
	  
	  paginaLogin login = new paginaLogin(driver);
	  login.loginUsuario("jcbakjcb", "jvbkjdfb");
	  File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(screen, new File("..\\EducacionIt\\Evidencias\\Test.png"));
  }
  
  @AfterTest
  public void cerrarPagina() {driver.quit();}
  
 
}
