package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.*;

public class Navigation {

    WebDriver driver;
    WebDriverWait wait;

    public Navigation(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public ProductsPage goToProductCategoryPage(int i) {
        HomePage homePage = goToHomePage();
        homePage.goToProductCategoryByIndex(i);
        ProductsPage productsPage = new ProductsPage(driver, wait);
        return productsPage;

    }

    public LoginPage goToLoginPage() {
        HomePage homePage = goToHomePage();
        homePage.goToLoginPageBySignInButton();
        LoginPage loginpage = new LoginPage(driver, wait);
        return loginpage;

    }

    public MyAccountPage goToMyAccountPage() {
        LoginPage loginPage = goToLoginPage();
        loginPage.loginUser("TestPractice@gmail.com", "password123");
        MyAccountPage myaccount = new MyAccountPage(driver, wait);
        return myaccount;


    }

    public HomePage goToHomePage() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        return homePage;
    }

    public CartPage goToCartPage() {
        HomePage homePage = goToHomePage();
        homePage.goToCart();
        CartPage cartPage = new CartPage(driver, wait);
        return cartPage;

    }

    public HomePage goToLoggedHomepage() {
        goToMyAccountPage();
        HomePage homepage = goToHomePage();
        return homepage;

    }
    public CartPage goToCartPageWithOneProduct() {
        HomePage homePage = goToHomePage();
        homePage.addRandomProductFromHomepage();
        CartPage cartPage = goToCartPage();
        return cartPage;
    }

}
