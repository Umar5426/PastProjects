package edu.ucalgary.oop;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class GenderValidatorTest {

    @Test
    public void testIsValidGender() throws IOException {
        GenderValidator validator = new GenderValidator();
        assertTrue(validator.isValidGender("man"));
        assertTrue(validator.isValidGender("gender queer"));
        assertTrue(validator.isValidGender("girl"));
        assertTrue(validator.isValidGender("two-spirit"));
        assertTrue(validator.isValidGender("woman"));
        assertFalse(validator.isValidGender("unicorn")); // Invalid gender
    }
}
