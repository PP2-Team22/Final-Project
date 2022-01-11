package parser;
import crash.Crash;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParser {
    @org.junit.jupiter.api.Test
    void test() throws FileNotFoundException, ParseException {
        List<Crash> crashes = Parser.parse();
        assertEquals("[Date:" + "01/30/2000 21:08" + ", Location: " + "Off Abidjan, Ivory Coast" + ", Operator: " + "Kenya Airways" + ", Flight: " + "431" +
                ", Route: " + "Abidjan - Lagos" + ", Type: " + "AirbusA310-304" + ", Registration: " + "5Y-BEN" + ", Cn.ln: " + "426" +
                ", Aboard: " + "179" + ", Fatalities: " + "169" + ", Ground: " + "0" + ", Survivors: " +
                "10" + ", Survival Rate: " + "0.055865922" + "\nSummary: " + "The aircraft crashed into the AtlantiOcean three minutes after taking off from Felix Houphouet-Boigny Airport.  A few seconds after lifting off the ground the stall warning sounded and continued for about 20 seconds until it was manually turned off by the crew. Three seconds later the plane impacted the water. The pilot's response to an alarm that inaccurately indicated the plane had stalled. The pilot failed to complete established procedure for such an emergency. Takeoff conditions also contributed to the accident, which occurred at night, hampering the crew's ability to judge the plane's distance from the sea." +
                ", ClustId: " + "High Fatality" + "]", crashes.get(0).toString());
    }
}
