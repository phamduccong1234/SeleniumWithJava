import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends Page {

	By cbHome = By.xpath("//label[@for='tree-node-home']/span[1]/*[name()='svg']");

	By lbHomes = By.xpath("//div[@id='result']/span");

//	
//	By lbResult = By.xpath("//span[text()='home']");
//	
//	By icExpandAll = By.xpath("//button[@title='Expand all']");
//	
	public void clickHomeCheckBox() {
		driver.findElement(cbHome).click();
	}

	public String getHomeString() {
		String result = "";
		List<WebElement> lbHomeElements = driver.findElements(lbHomes);
		for (WebElement e : lbHomeElements) {
			result = result + e.getText() + " ";
		}

		return result.trim(); // clear space start & end
	}
//	
//	public void clickExpandAll() {
//		driver.findElement(icExpandAll).click();
//	}

	public boolean isCheckBoxUnchecked(By locator) {
		boolean result = true;
		String cssClassValue = driver.findElement(locator).getAttribute("class");
		if (!cssClassValue.contains("uncheck")) {
			result = false;
		}
		return result;
	}

	public CheckBoxPage(WebDriver dr) {
		driver = dr;
	}

}
