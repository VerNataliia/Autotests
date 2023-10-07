
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.time.Duration;
import static app.TestData.*;
import static app.TestData.TEACHER_PASSWORD;
import static com.codeborne.selenide.Condition.visible;


@Epic("Regression Tests")
@Feature("Login")

public class LoginTests extends A_BaseTest {

    @Test(groups = ("Login"), priority = 1, description = "Verify if a student is able to log in using username and password credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check if a student can log in (Positive case)")
    public void checkStudentLogIn() {
        app.logInUsernamePage.open();
        app.logInUsernamePage.logInWithUsername(STUDENT_USERNAME, STUDENT_PASSWORD);
        app.dashboardPage.START_PRACTICING_BUTTON.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test(groups = ("Login"), priority = 1, description = "Verify if a teacher is able to log in using username and password credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check if a teacher can log in (Positive case)")
    public void checkTeacherLogIn() {
        app.logInUsernamePage.open();
        app.logInUsernamePage.logInWithUsername(TEACHER_USERNAME, TEACHER_PASSWORD);
        app.myClassesPage.MY_CLASSES_PAGE_TITLE.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test(priority = 1, description = "Verify if a parent is able to log in using username and password credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check if a parent can log in (Positive case)")
    public void checkParentLogIn() {
        app.logInUsernamePage.open();
        app.logInUsernamePage.logInWithUsername(PARENT_USERNAME, PARENT_PASSWORD);
        app.dashboardPage.START_PRACTICING_BUTTON.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test(priority = 2, description = "Verify if a user ISN'T able to log in using invalid username")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check if a user can't log in using not correct username (Negative case)")
    public void checkLogInWithInvalidUsername() {
        app.logInUsernamePage.open();
        app.logInUsernamePage.logInWithUsername(TEACHER_USERNAME + "a", TEACHER_PASSWORD);
        app.logInUsernamePage.LOG_IN_ERROR.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test(priority = 2, description = "Verify if a user ISN'T able to log in using incorrect password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check if a user can't log in using not correct password (Negative case)")
    public void checkLogInWithInvalidPassword() {
        app.logInUsernamePage.open();
        app.logInUsernamePage.logInWithUsername(TEACHER_USERNAME, TEACHER_PASSWORD + "a");
        app.logInUsernamePage.LOG_IN_ERROR.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test(priority = 1, description = "Verify if a teacher is able to log in using SSO Google")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check if a teacher can log in using SSO Google (Positive case)")
    public void checkTeacherLogInWithGoogle() {
        app.logInGooglePage.open();
        app.logInGooglePage.logInWithGoogle(TEACHER_GOOGLE_EMAIL, TEACHER_GOOGLE_PASSWORD);
        app.myClassesPage.MY_CLASSES_PAGE_TITLE.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test(priority = 1, description = "Verify if a student is able to log in using SSO Google")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check if a student can log in using SSO Google (Positive case)")
    public void checkStudentLogInWithGoogle() {
        app.logInGooglePage.open();
        app.logInGooglePage.logInWithGoogle(STUDENT_GOOGLE_EMAIL, STUDENT_GOOGLE_PASSWORD);
        app.dashboardPage.START_PRACTICING_BUTTON.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test(priority = 2, description = "Verify if a user ISN'T able to log in using SSO Google with non existing user")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check if a user can log in using SSO Google if no such user in the database(Negative case)")
    public void checkLogInWithGoogleWithNonExistingUser() {
        app.logInGooglePage.open();
        app.logInGooglePage.logInWithGoogle(USER_GOOGLE_NON_EXISTING_IN_DATABASE_EMAIL, USER_GOOGLE_NON_EXISTING_IN_DATABASE_PASSWORD);
        app.logInGooglePage.GOOGLE_ERROR_NO_ACCOUNT.shouldBe(visible, Duration.ofSeconds(10));
    }

    // Я зупинилась на тому, що потрібно дізнатись як система може трошки чекати доки завантажиться сторінка, бо певні тести через це падають + останній тест потрібно новий емейдл
//     - echo "Allure report live here https://${CI_PROJECT_NAMESPACE}.${CI_PAGES_DOMAIN}/-/${CI_PROJECT_NAME}/-/jobs/${CI_JOB_ID}/artifacts/app/build/reports/allure-report/allureReport/index.html"
}
