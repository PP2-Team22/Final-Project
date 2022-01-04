package menu;

public class Menu {
    private String welcomeString =
                "************************************************************************************\n" +
                "********** Hello. Welcome to our Passenger Plane Crashes database Client App *******\n" +
                "************************************************************************************\n" +
                "\n\n";

    private String OptionsText = "1 - List all the fields of each entity\n" +
                "2 - Sort the entities\n" +
                "3 - Search entity(ies) based on any given field and value\n" +
                "4 - List column names\n" +
                "5 - Filter entities\n";

    private String ListOptionsText =
                    "a - List all the fields of each entity\n" +
                    "b - List only the selected fields of each entity\n" +
                    "c - List entities based on the range of rows\n";

    private String ListOnlySelectedText = "For which field you want to list?\n" +
            "1 - Date\n" +
            "2 - Time\n" +
            "3 - Location\n" +
            "4 - Operator\n" +
            "5 - Flight\n" +
            "6 - Route\n" +
            "7 - Type\n" +
            "8 - Registration\n" +
            "9 - cn.In\n\n" +
            "10 - Aboard\n" +
            "11 - Fatalities\n" +
            "12 - Ground\n" +
            "13 - Survivors\n" +
            "14 - SurvivalRate\n" +
            "15 - Summary\n" +
            "16 - ClustID\n";

    private String ListOnRangeOptionText = "Based on which range of rows do you want to list entities?";
    private String SortOptionText = "Based on which field you want to sort the entities?\n" +
            "1 - Date\n" +
            "2 - Time\n" +
            "3 - Location\n" +
            "4 - Operator\n" +
            "5 - Flight\n" +
            "6 - Route\n" +
            "7 - Type\n" +
            "8 - Registration\n" +
            "9 - cn.In\n\n" +
            "10 - Aboard\n" +
            "11 - Fatalities\n" +
            "12 - Ground\n" +
            "13 - Survivors\n" +
            "14 - SurvivalRate\n" +
            "15 - Summary\n" +
            "16 - ClustID\n";

    private String SortOrderOptionText = "In which order you want to sort?";
    private String SearchOptionText = "Based on which field you want to search entity(ise)?\n" +
            "1 - Date\n" +
            "2 - Time\n" +
            "3 - Location\n" +
            "4 - Operator\n" +
            "5 - Flight\n" +
            "6 - Route\n" +
            "7 - Type\n" +
            "8 - Registration\n" +
            "9 - cn.In\n\n" +
            "10 - Aboard\n" +
            "11 - Fatalities\n" +
            "12 - Ground\n" +
            "13 - Survivors\n" +
            "14 - SurvivalRate\n" +
            "15 - Summary\n" +
            "16 - ClustID\n";

    private String FilterOptionText = "Based on which field or set of fields " +
                                "and according to which rules you want to filter?";
    private String FilterStringOptionText =
                    "1 - start with\n" +
                    "2 - ends with\n" +
                    "3 - contains\n" +
                    "4 - null";
    private String FilterDateTimeNumbersText =
                    "1 - equal(eq)\n" +
                    "2 - greater than(gt)\n" +
                    "3 - less than(lt)\n" +
                    "4 - greater and equal to(ge)\n" +
                    "5 - less and equal to(le)\n" +
                    "6 - between(bt)\n" +
                    "7 - null\n";
    private String FilterDateAndTimeText =
                    "1 - in a specific year(y)\n" +
                    "2 - in a specific month(m)\n" +
                    "3 - in a specific day(d)\n";
    private String FilterClusterIDText = "";

    public String getWelcomeString() {
        return this.welcomeString;
    }

    public void printWelcomeString(){
        System.out.println(getWelcomeString());
    }

    public String getOptionsText(){
        return this.OptionsText;
    }

    public void printOptionsText(String message){
        System.out.println(message);
    }

}
