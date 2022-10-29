import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main = new Main();

    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }

    @Test
    void main() {

    }

    @Test
    void readFileNotExists() {
        IOException thrown = assertThrows(
                IOException.class,
                () -> main.readFile("urinal.dat"),"message");

        assertTrue(thrown.getMessage().contains("IOException read file"));

    }

    @Test()
    void readFileExists() throws IOException {
        assertDoesNotThrow(() -> main.readFile("../../urinal.dat"));

    }



    @Test
    void calculateAvailableUrinals() {
    }

    @Test
    void writeFile() {
    }
}