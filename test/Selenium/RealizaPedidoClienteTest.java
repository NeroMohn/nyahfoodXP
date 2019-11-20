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
public class RealizaPedidoClienteTest {
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
  public void realizaPedidoCliente() {
    driver.get("http://localhost:8080/nyahfoodXP/index.jsp");
    driver.manage().window().setSize(new Dimension(1064, 801));
    driver.findElement(By.cssSelector(".top-menu li:nth-child(2) > a")).click();
    driver.findElement(By.linkText("Pedir")).click();
    driver.findElement(By.linkText("Pedir Comida")).click();
    driver.findElement(By.name("txtQuantidade")).click();
    driver.findElement(By.name("txtQuantidade")).sendKeys("2");
    driver.findElement(By.name("optPagamento")).click();
    {
      WebElement dropdown = driver.findElement(By.name("optPagamento"));
      dropdown.findElement(By.xpath("//option[. = 'Cartao']")).click();
    }
    driver.findElement(By.name("optPagamento")).click();
    driver.findElement(By.name("btnConfirmar")).click();
  }
}