import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EshopTester extends PavelJanicekSeleniumFinal {
    public static final String MY_FAVORITE_ESHOP = "https://esoteria.cz";
    public static final int DEFAULT_WAIT_TIME_IN_SECONDS = 10;
    private WebDriver driver;
    private WebDriverWait wait;

    public EshopTester(){
        if (!isSetupDone()){
            throw new RuntimeException("driver is not initialized properly!");
        }
        driver = PavelJanicekSeleniumFinal.getDriver();
        wait = new WebDriverWait(driver,DEFAULT_WAIT_TIME_IN_SECONDS);
    }

    public void navigateToEshop(){
        driver.get(MY_FAVORITE_ESHOP);
    }

    public void selectCategory(){
        String myCategory = "cat-item-845";
        WebElement categorySelect = driver.findElement(By.className(myCategory));
        categorySelect.click();
    }

    public void sortByHighestPrice(){
        String sortElementCategory = "orderby";
        wait.until(ExpectedConditions.elementToBeClickable(By.className(sortElementCategory)));
        Select sort = new Select(driver.findElement(By.className(sortElementCategory)));
        sort.selectByValue("price-desc");
    }

    public void addToCartNthItem(int i){
        String xPath = "//*[@id=\"left-area\"]/ul/li[" + i + "]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        WebElement product = driver.findElement(By.xpath(xPath));
        product.click();
        addToCart();
    }

    public void addToCart(){
        String addToCartClass = "single_add_to_cart_button";
        wait.until(ExpectedConditions.elementToBeClickable(By.className(addToCartClass)));
        WebElement addToCartButton = driver.findElement(By.className(addToCartClass));
        addToCartButton.click();
    }

    public void showCart(){
        String cartId = "et-secondary-menu";
        WebElement cart = driver.findElement(By.id(cartId));
        cart.click();
    }
}
