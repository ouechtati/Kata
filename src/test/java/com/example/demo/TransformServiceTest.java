package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransformServiceTest {

    private final TransformService service = new TransformService();

    @Test
    void testSingleDigit() {
        assertEquals("1", service.transform(1));
        assertEquals("FOOFOO", service.transform(3));
        assertEquals("BARBAR", service.transform(5));
        assertEquals("QUIX", service.transform(7));
    }

    @Test
    void testComplexCases() {
        assertEquals("FOO", service.transform(9));
        assertEquals("FOOBAR", service.transform(51));
        assertEquals("BARFOO", service.transform(53));
        assertEquals("FOOFOOFOO", service.transform(33));
        assertEquals("FOOBARBAR", service.transform(15));
    }

    @Test
    void testInvalidNumbers() {
        assertEquals("Invalid", service.transform(-1));
        assertEquals("Invalid", service.transform(101));
    }
}
