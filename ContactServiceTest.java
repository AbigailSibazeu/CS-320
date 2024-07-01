import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "Julien", "Stewart", "0123456789", "123 Main St");
        service.addContact(contact);
        assertNotNull(service.getContact("1234567890"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "Julien", "Stewart", "0123456789", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "Julien", "Stewart", "0123456789", "123 Main St");
        service.addContact(contact);
        service.updateContact("1234567890", "Abby", "Klain", "0987654321", "456 Elm St");
        Contact updatedContact = service.getContact("1234567890");
        assertEquals("Abby", updatedContact.getFirstName());
        assertEquals("Klain", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }

    @Test
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1234567890", "Julien", "Stewart", "0123456789", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Abby", "Klain", "0987654321", "456 Elm St");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }
}
