package Pruebas;

import org.testng.annotations.Test;

import Paginas.paginaInicio;
import Paginas.paginaLogin;
import Utilidades.DatosExcel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Laboratorio4_E2 {

	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String pathDriver = "..\\EducacionIt\\Drivers\\chromedriver.exe";

	@BeforeSuite
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", pathDriver);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void f() {

		paginaInicio inicio = new paginaInicio(driver);
		inicio.clicLogin();
	}

	@Test(priority = 1, dataProvider = "Registro invalido excel")
	public void ingreso(String usuario, String clave) throws IOException {

		paginaLogin login = new paginaLogin(driver);
		login.loginUsuario(usuario, clave);

		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionIt\\Evidencias\\Test.png"));

		Assert.assertEquals("AUTHENTICATION", login.getTituloForm());
		;

	}

	@DataProvider(name = "Registro invalido")

	public Object[][] dp() {

		Object[][] datos = new Object[2][2];
		datos[0][0] = "jose";
		datos[0][1] = "123456";
		datos[1][0] = "pepe";
		datos[1][1] = "4858962";

		return datos;

	}

	@DataProvider(name = "Registro invalido excel")

	public Object[][] datosPruebaExcel() throws Exception {
		
		Object datos[][] = DatosExcel.leerExcel("E:\\EducacionIt\\Recursos\\Datos.xlsx", "Hoja1");

		return datos;
		
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
