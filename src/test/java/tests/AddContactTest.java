package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (!app.userHelper().isLogged()) {
            app.userHelper().login(new User().withEmail("pinhas@gmail.com").withPassword("Pinhas123$"));
        }
    }

    @Test(invocationCount = 1)
    public void addContactTestBase(){
        int i = (int)((System.currentTimeMillis())/1000)%3600;

        Contact contact = Contact.builder()
                .name("Contact "+ i)
                .lastName("Add")
                .email("add"+i+"@mail.com")
                .phone("1234"+i)
                .address("Haifa")
                .description("friend")
                .build();

        app.contact().openFormContact();
        app.contact().fillFormContact(contact);
        app.contact().saveContact();
        Assert.assertTrue(app.contact().isContactAdded(contact.getPhone()));
    }

}
