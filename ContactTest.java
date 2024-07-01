import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "Julien", "Stewart", "0123456789", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Julien", contact.getFirstName());
        assertEquals("Stewart", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Julien", "Stewart", "0123456789", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Julien", "Stewart", "0123456789", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Stewart", "0123456789", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Julien", "Stewart", "012345678", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Julien", "Stewart", "0123456789", null);
        });
    }
}
