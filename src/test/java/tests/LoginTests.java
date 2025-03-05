package tests;

import utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExtentManager;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @Test(priority = 1)
    public void testValidLogin() {
        ExtentTest test = ExtentManager.createTest("Valid Login Test");
        loginPage = new LoginPage(driver);
        
        loginPage.login("student", "Password123");
        boolean result = loginPage.isLoginSuccessful();
        
        if (result) {
            test.log(Status.PASS, "Login successful.");
        } else {
            test.log(Status.FAIL, "Login failed.");
        }
        Assert.assertTrue(result, "Login should be successful");
    }

    @Test(priority = 2)
    public void testEmptyFields() {
        ExtentTest test = ExtentManager.createTest("Empty Fields Test");
        loginPage = new LoginPage(driver);
        
        loginPage.login("", "");
        boolean result = loginPage.isErrorMessageDisplayed();
        
        if (result) {
            test.log(Status.PASS, "Error message displayed correctly.");
        } else {
            test.log(Status.FAIL, "Error message not displayed.");
        }
        Assert.assertTrue(result, "Error should be displayed for empty fields");
    }

    @Test(priority = 3)
    public void testIncorrectPassword() {
        ExtentTest test = ExtentManager.createTest("Incorrect Password Test");
        loginPage = new LoginPage(driver);
        
        loginPage.login("student", "WrongPass");
        boolean result = loginPage.isErrorMessageDisplayed();
        
        if (result) {
            test.log(Status.PASS, "Error displayed for incorrect password.");
        } else {
            test.log(Status.FAIL, "Error not displayed.");
        }
        Assert.assertTrue(result, "Error should be displayed for incorrect password");
    }
}
