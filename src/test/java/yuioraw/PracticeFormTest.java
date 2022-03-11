package yuioraw;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import yuioraw.AutomationPracticeFormPage;


public class PracticeFormTest extends TestBase {
    @Test
    @Tag("properties")
    void practiceFormTest(){
        Faker faker = new Faker();

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                phone = "9121112233",
                address = faker.address().fullAddress(),
                gender = "Female",
                day = "10",
                month = "February",
                year = "2000",
                subject = "English",
                hobbies = "Sports",
                state = "NCR",
                city = "Delhi";

        AutomationPracticeFormPage page = new AutomationPracticeFormPage();

        page.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .chooseGender(gender)
                .typeMobilePhone(phone)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .chooseHobbies(hobbies)
//                .uploadFile()
                .typeAddress(address)
                .selectState(state)
                .selectCity(city)
                .submitForm();

        page.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", email)
                .checkResults("Gender", gender)
                .checkResults("Mobile", phone)
                .checkResults("Date of Birth", day + " " + month + "," + year)
                .checkResults("Subjects", subject)
                .checkResults("Hobbies", hobbies)
//                .checkResults("Picture", "file.txt")
                .checkResults("Address", address)
                .checkResults("State and City", state + " " + city);

    }

    @Test
    void failedTest(){
        assert false;
    }

    @Test
    @Disabled
    void skippedTest(){
        assert true;
    }
}
