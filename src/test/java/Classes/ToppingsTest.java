package Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToppingsTest {

    @Test
    void getToppings() {
    }

    @Test
    void setToppings_id() {
        Toppings expected = new Toppings(1, "Sonka", 600);
        int actual = 1;
        assertEquals(expected.toppings_id, actual);
    }

    @Test
    void setName() {
        Toppings expected = new Toppings(1, "Sonka", 600);
        String actual = "Sonka";
        assertEquals(expected.name, actual);
    }

    @Test
    void setPrice() {
        Toppings expected = new Toppings(1, "Sonka", 600);
        int actual = 600;
        assertEquals(expected.price, actual);
    }
}