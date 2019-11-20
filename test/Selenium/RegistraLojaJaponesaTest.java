// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
public class RegistraLojaJaponesaTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void registraLojaJaponesa() {
    driver.get("http://localhost:8080/nyahfoodXP/index.jsp");
    driver.manage().window().setSize(new Dimension(1552, 840));
    driver.findElement(By.linkText("Registrar Loja")).click();
    driver.findElement(By.name("txtNomeLoja")).click();
    driver.findElement(By.name("txtNomeLoja")).sendKeys("Looojaaa");
    driver.findElement(By.name("txtNomeGerenteLoja")).sendKeys("LIBELULA");
    driver.findElement(By.name("txtEmailLoja")).sendKeys("libelula123@gmail.com");
    driver.findElement(By.name("txtTelefoneLoja")).sendKeys("35991434352");
    driver.findElement(By.id("cep")).sendKeys("36080001");
    driver.findElement(By.name("txtNumeroLoja")).sendKeys("992");
    driver.findElement(By.id("cidade")).sendKeys("Juiz de Fora");
    driver.findElement(By.id("uf")).sendKeys("MG");
    driver.findElement(By.name("txtSenhaLoja")).click();
    driver.findElement(By.name("txtSenhaLoja")).sendKeys("123987546");
    driver.findElement(By.name("txtCnpjLoja")).click();
    driver.findElement(By.name("txtCnpjLoja")).sendKeys("12312312111111");
    driver.findElement(By.name("txtDescricaoLoja")).click();
    driver.findElement(By.name("txtDescricaoLoja")).sendKeys("asdasdas");
    driver.findElement(By.name("txtComplementoLoja")).click();
    driver.findElement(By.name("txtComplementoLoja")).sendKeys("ap 03");
    driver.findElement(By.name("btnConfirmar")).click();
  }
}
