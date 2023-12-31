package app.pages.signup;

import app.DataGenerator;
import app.pages.base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TeacherSignupStepOnePage extends BasePage {
    public TeacherSignupStepOnePage(String pageUrl) {
        super(pageUrl);
    }

    private final SelenideElement
    TEACHER_SIGNUP_STEP_ONE_PAGE_TITLE = $(byTagName("h1")),
    TEACHER_SIGNUP_WITH_GOOGLE_BUTTON = $(byXpath("//a[@class='google-sign-in-btn sign-in-btn']")),
    TEACHER_SIGNUP_WITH_MICROSOFT_BUTTON = $(byXpath("//a[@class='microsoft-sign-in-btn sign-in-btn']")),
    TEACHER_SIGNUP_WITH_CLEVER_BUTTON = $(byXpath("//a[@class='clever-sign-in-btn sign-in-btn']")),
    TEACHER_SIGNUP_USERNAME_INPUT = $(byXpath("//input[@placeholder='Username']")),
    TEACHER_SIGNUP_PASSWORD_INPUT = $(byXpath("//input[@placeholder='Password']")),
    TEACHER_SIGNUP_BUTTON = $(byXpath("//div[@class='primary-button']")),
    TEACHER_SIGN_UP_NOT_TEACHER_BUTTON = $(byXpath("//a[contains(text(),\"Oops, I'm not a teacher\")]")),
    TEACHER_SIGN_UP_HAVE_ALREADY_ACCOUNT_BUTTON = $(byXpath("//div[@class='secondary-button']")),
    TEACHER_SIGN_UP_TERMS_OF_USE_BUTTON = $(byXpath("//a[contains(text(),'Terms of Use')]")),
    TEACHER_SIGN_UP_PRIVACY_POLICY_BUTTON = $(byXpath("//a[contains(text(),'Terms of Use')]"));

    public void assertTeacherSignUpPageTitle(String header) {
        TEACHER_SIGNUP_STEP_ONE_PAGE_TITLE.shouldHave(Condition.text(header));
    }
    public void clickOnSignUpGoogleButtonAsTeacher() {TEACHER_SIGNUP_WITH_GOOGLE_BUTTON.click();}
    public void clickOnSignUpMicrosoftButtonAsTeacher() {
        TEACHER_SIGNUP_WITH_MICROSOFT_BUTTON.click();
    }
    public void clickOnSignUpCleverButtonAsTeacher() {
        TEACHER_SIGNUP_WITH_CLEVER_BUTTON.click();
    }

    DataGenerator dataGenerator = new DataGenerator();

    public void setNewTeacherUsername() {
        String newTeacherUsername = "NewStudentAutotest"+ dataGenerator.getRandomNumber(1000, 9999);
        TEACHER_SIGNUP_USERNAME_INPUT.sendKeys(newTeacherUsername);
    }
    public void setNewTeacherPassword() {
        String passwordForNewTeacher = "NewStudentAutotest"+ dataGenerator.getRandomNumber(1000, 9999);
        TEACHER_SIGNUP_PASSWORD_INPUT.sendKeys(passwordForNewTeacher);
    }
    public void assertSignUpButtonIsAble() {
        TEACHER_SIGNUP_BUTTON.shouldNotBe(Condition.disabled);
    }
    public void clickOnSignUpButtonAsTeacher() {
        TEACHER_SIGNUP_BUTTON.click();
    }


}

