package menu;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMenu {
    @Test
    void test()
    {
        assertEquals("Hi", new Menu().getHello());
    }

}
