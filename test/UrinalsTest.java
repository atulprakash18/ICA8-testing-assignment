package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }

    @Test
    public void testGoodString() {
        Assertions.fail();
    }
}