import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PavelJanicekSeleniumFinal {
    public static final String CHROMEDRIVER_EXECUTABLE_PATH = "C:\\chromedriver\\chromedriver.exe";
    public static final boolean IS_CONTENT_OF_CART_NEEDED = false;
    private static WebDriver driver;
    private static boolean isSetupDone = false;

    public static void main(String[] args) {
        setupChromedriver();
        EshopTester eshopTester = new EshopTester();
        eshopTester.navigateToEshop();
        for (int i =1;i<3;i++){
            eshopTester.selectCategory();
            eshopTester.sortByHighestPrice();
            eshopTester.addToCartNthItem(i);
        }
        if (IS_CONTENT_OF_CART_NEEDED){
            eshopTester.showCart();
        }


    }

    public static void setupChromedriver(){
        System.setProperty("webdriver.chrome.driver",CHROMEDRIVER_EXECUTABLE_PATH);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        PavelJanicekSeleniumFinal.driver = driver;
        setSetupDone(true);

    }

    public boolean isSetupDone(){
        return this.isSetupDone;
    }

    public static void setSetupDone(boolean setupDone){
        PavelJanicekSeleniumFinal.isSetupDone = setupDone;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
