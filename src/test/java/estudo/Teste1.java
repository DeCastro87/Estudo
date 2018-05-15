package estudo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Teste1 {

		private WebDriver driver;
		private String url;

		@Before
		public void setUp(){

			url = "http://www.google.com.br";

			//System.setProperty("webdriver.gecko.driver", "C:/Webdriver/geckodriver.exe");
			//driver = new FirefoxDriver(); // driver

			System.setProperty("webdriver.chrome.driver","C:/Webdriver/chromedriver.exe");		
			driver = new ChromeDriver(); // driver
			driver.get(url); // caminho
			driver.manage().window().maximize(); // maximar tamanho da página
		}

		@After
		public void tearsdown(){
			driver.quit(); // fechar página
		}

		@Test
		public void ValidarElementosPagina(){
			WebElement Button = driver.findElement(By.name("btnK"));
			assertTrue(Button.equals("Pesquisar Google"));
		}

		@Test
		public void ConsultaPagina(){
			WebElement CampoTexto = driver.findElement(By.name("q"));
			CampoTexto.sendKeys("Teste");
			CampoTexto.submit();
		}

		@Test
		public void AtualizarPagina(){
			driver.navigate().refresh(); // atualizar página
		}
}
