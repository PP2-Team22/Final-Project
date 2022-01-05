package menu;

public class Menu {
    private static String welcomeString =
                "************************************************************************************\n" +
                "********** Hello. Welcome to our Passenger Plane Crashes database Client App *******\n" +
                "************************************************************************************\n" +
                "\n\n";

    private static String optionsText = "1 - List all the fields of each entity\n" +
                "2 - Sort the entities\n" +
                "3 - Search entity(ies) based on any given field and value\n" +
                "4 - List column names\n" +
                "5 - Filter entities\n" +
                "6 - Exit from program\n" +
            "Please type the number for choosing the option.";

    private static String listOptionsText =
                    "a - List all the fields of each entity\n" +
                    "b - List only the selected fields of each entity\n" +
                    "c - List entities based on the range of rows";

    private static String listOnlySelectedText = "For which field you want to list?" +
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
            "16 - ClustID";

    private static String listOnRangeOptionText = "Based on which range of rows do you want to list entities?";
    private static String sortOptionText = "Based on which field you want to sort the entities?\n" +
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
            "16 - ClustID";

    private static String sortOrderOptionText = "In which order you want to sort?";
    private static String searchOptionText = "Based on which field you want to search entity(ise)?\n" +
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
            "16 - ClustID";

    private static String filterOptionText = "Based on which field or set of fields " +
                                "and according to which rules you want to filter?";
    private static String filterStringOptionText =
                    "1 - start with\n" +
                    "2 - ends with\n" +
                    "3 - contains\n" +
                    "4 - null";
    private static String filterDateTimeNumbersText =
                    "1 - equal(eq)\n" +
                    "2 - greater than(gt)\n" +
                    "3 - less than(lt)\n" +
                    "4 - greater and equal to(ge)\n" +
                    "5 - less and equal to(le)\n" +
                    "6 - between(bt)\n" +
                    "7 - null";
    private static String filterDateAndTimeText =
                    "1 - in a specific year(y)\n" +
                    "2 - in a specific month(m)\n" +
                    "3 - in a specific day(d)";
    private static String filterClusterIDText =
            "Is there high possibility of fatality ? Type yes or no.";

    public static String getWelcomeString() {
        return welcomeString;
    }

    public static String getOptionsText(){
        return optionsText;
    }

    public static String getListOptionsText(){return listOptionsText;}

    public static String getListOnlySelectedText(){return listOnlySelectedText;}

    public static String getListOnRangeOptionText(){return listOnRangeOptionText;}

    public static String getSortOptionText(){return sortOptionText;}

    public static String getSortOrderOptionText(){return sortOrderOptionText;}

    public static String getSearchOptionText(){return searchOptionText;}

    public static String getFilterOptionText(){return filterOptionText;}

    public static String getFilterDateTimeNumbersText(){return filterDateTimeNumbersText;}

    public static String getFilterDateAndTimeText(){return filterDateAndTimeText;}

    public static void printWelcomeString(){
        System.out.println(getWelcomeString());
    }

    public static void printOptionsText(String message){
        System.out.println(message);
    }

}
