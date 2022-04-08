package test;

import model.Idioma;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdiomaTest {

    @Test
    public void testToString (){
        Idioma i = new Idioma("Portugues");
        String excpected = "Portugues";
        String actual = i.toString();
        assertEquals(excpected, actual);
    }
}