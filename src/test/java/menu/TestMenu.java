package menu;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMenu {
    @org.junit.jupiter.api.Test
    public void test()
    {
        assertEquals("Hi", new Menu().getHello());
        assertEquals("Hello World", new Menu().getHello());
    }

}
