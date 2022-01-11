package listUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import crash.Crash;
import parser.Parser;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public class TestListUtil {
    List<Crash> array;

    public TestListUtil() throws FileNotFoundException, ParseException {
        array = Parser.parse();
    }

    @org.junit.jupiter.api.Test
    void testAll()
    {
        //assertEquals("", listUtil.ListAllFields(array));
    }
    @org.junit.jupiter.api.Test
    void testSelected()
    {
        //assertEquals("", listUtil.ListSelectedFields(array));
    }
    @org.junit.jupiter.api.Test
    void testOnRange()
    {
        //assertEquals("", listUtil.ListOnRange(array, 1, 5) );
        //assertEquals("", listUtil.ListOnRange(array, 4, 15) );
        //assertEquals("", listUtil.ListOnRange(array, 19, 20) );
        //assertEquals("", listUtil.ListOnRange(array, 100, 100) );
    }


}
