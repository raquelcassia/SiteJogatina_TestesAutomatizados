package testSelenium;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiteJogatina {

	static Logger logger = Logger.getLogger(SiteJogatina.class);

	WebDriver driver;

	@Before
	public void init() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.get("https://www.jogatina.com/");
		this.driver.manage().window().maximize();
		logger.info("Registro no Log - Acessando Site Jogatina");
		Thread.sleep(500);

	}

	@After
	public void finish() throws Throwable {
		// this.driver.quit();
	}

	String email = "raquel.teste@teste.com";
	String senha = "senhafacil";

	@Test
	public void etapas() throws Throwable {
		System.out.println("Executando..");

		// Cadastro

		logger.info("Inicio Etapa 1 - Realizando o Cadastro");
		this.driver.findElement(By.xpath("/html/body/div[3]/div/div/a")).click();

		Thread.sleep(2000);
		logger.info("Inserindo Email: " + email);
		this.driver.findElement(By.id("emailIn")).sendKeys("raquel.teste@teste.com");

		Thread.sleep(2000);
		logger.info("Inserindo Senha: " + senha);
		this.driver.findElement(By.id("password-field")).sendKeys("senhafacil");

		Thread.sleep(2000);
		logger.info("Cadastro Realizado");
		this.driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/form/div/fieldset[3]/input")).click();

		// Alterar Apelido

		Thread.sleep(500);
		logger.info("Inicio Etapa 2 - Alterando Imagem");
		logger.info("Abrindo pop-up de alterar imagem...");
		this.driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[6]")).click();

		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[6]/ul/li[9]/a")).click();

		Thread.sleep(500);
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div[2]/div[1]/iframe")));

		driver.findElement(By.xpath("/html/body/form/div[1]/div/ul/li[16]/label/img")).click();

		Thread.sleep(2000);
		this.driver.findElement(By.xpath("/html/body/form/div[2]/div/div[2]/input")).click();

		Thread.sleep(3000);
		logger.info("Texto: " + driver.findElement(By.xpath("/html/body/div[2]")).getText());

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		this.driver.findElement(By.id("cboxClose")).click();

		// Alterando Apelido

		logger.info("Inicio Etapa 3 - Alterando Apelido");
		logger.info("Abrindo pop-up de alterar apelido...");

		Thread.sleep(500);
		this.driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[6]")).click();

		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[6]/ul/li[10]/a")).click();

		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div[2]/div[1]/iframe")));

		Thread.sleep(1000);
		logger.info("Inserindo novo apelido: " + "KelCassTest");
		this.driver.findElement(By.name("newScreenName")).sendKeys("KelCassTest");

		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/div[2]/div/form/div/div[3]/input")).click();

		Thread.sleep(3000);
		logger.info("Texto: " + driver.findElement(By.xpath("/html/body/div[2]/div/div")).getText());

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		this.driver.findElement(By.id("cboxClose")).click();

		// Sair do Cadastro

		logger.info("Inicio Etapa 4 - Sair do Cadastro");
		Thread.sleep(500);
		logger.info("Saindo do Cadastro...");
		this.driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[6]/a/i")).click();
		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[6]/ul/li[13]/a")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		// Voltando pra Pag Inicial

		logger.info(" Inicio Etapa 5 - Inspecionar Imagens");
		logger.info("Voltando para tela inicial...");

		this.driver.findElement(By.xpath("/html/body/div[1]/div/div/div/a")).click();
		Thread.sleep(1000);

		// Acessando Informações do Bingo Jogatina

		logger.info("Acessando informações do Bingo Jogatina..");
		this.driver.findElement(By.xpath("/html/body/ul/li[3]/a/p")).click();

		// Validando Prints do Jogo

		logger.info("Validando Imagens..");
		Thread.sleep(1000);

		String img1 = "https://s3.amazonaws.com/static.jogatina.com/imagens/2013/jogos/online/bingo/ilustracoes/thumb/tela-2-20130717.jpg";

		String imgJogatina = this.driver.findElement(By.xpath("/html/body/div[3]/div[5]/div[1]/ul/li[2]/a/img")).getAttribute("src");

		if (img1.equals(imgJogatina)){
			logger.info("Imagem 1: TRUE");
		} else {
			logger.info("Imagem 1: FALSE" + imgJogatina);

		}
		
		
		// Fechar o Browser
		Thread.sleep(1000);
		this.driver.quit();

	}
}
