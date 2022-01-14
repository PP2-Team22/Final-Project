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
                    "c - List entities based on the range of rows\n" +
                    "[------ Please type the character for choosing the option --------]";

    private static String listOnlySelectedText = "Which fields you want to list for each entity?\n" +
            "1 - Date and Time\n" +
            "2 - Location\n" +
            "3 - Operator\n" +
            "4 - Flight\n" +
            "5 - Route\n" +
            "6 - Type\n" +
            "7 - Registration\n" +
            "8 - cn.Ln\n" +
            "9 - Aboard\n" +
            "10 - Fatalities\n" +
            "11 - Ground\n" +
            "12 - Survivors\n" +
            "13 - SurvivalRate\n" +
            "14 - Summary\n" +
            "15 - ClustID\n" +
            "[------ Please type the numbers for choosing the options, Example: 1 2 3 8 is for choosing by Date, Location, Operator, cn.Ln--------]\n";

    private static String listOnRangeOptionText = "Based on which range of rows do you want to list entities?\n" +
            "[--------Please type two numbers, the boundaries of the range. For example print crashes in the range [l,r].-------]\n";
    private static String sortOptionText = "Based on which field you want to sort the entities?\n" +
            "1 - Date\n" +
            "2 - Location\n" +
            "3 - Operator\n" +
            "4 - Flight\n" +
            "5 - Route\n" +
            "6 - Type\n" +
            "7 - Registration\n" +
            "8 - cn.Ln\n" +
            "9 - Aboard\n" +
            "10 - Fatalities\n" +
            "11 - Ground\n" +
            "12 - Survivors\n" +
            "13 - SurvivalRate\n" +
            "14 - Summary\n" +
            "15 - ClustID\n" +
            "[------ Please type the numbers for choosing the options, Example: 1 2 3 8 is for choosing by Date, Location, Operator, cn.Ln--------]\n";

    private static String sortOrderOptionText = "In which order you want to sort? Type ASC for ascending order or Type DESC for descending order.\n";
    private static String searchOptionText = "Based on which field you want to search entity(ise)?\n" +
            "1 - Date\n" +
            "2 - Location\n" +
            "3 - Operator\n" +
            "4 - Flight\n" +
            "5 - Route\n" +
            "6 - Type\n" +
            "7 - Registration\n" +
            "8 - cn.Ln\n" +
            "9 - Aboard\n" +
            "10 - Fatalities\n" +
            "11 - Ground\n" +
            "12 - Survivors\n" +
            "13 - SurvivalRate\n" +
            "14 - Summary\n" +
            "15 - ClustID\n" +
            "[------ Please type the numbers for choosing the option, Example: 1 2 3 8 is for choosing by Date, Location, Operator, cn.Ln--------]\n";

    private static String filterOptionText = "Based on how many fields are you going to filter? Type the number.";
    private static String filterStringOptionText =
                    "How do you want to filter?\n" +
                    "1 - start with\n" +
                    "2 - ends with\n" +
                    "3 - contains\n" +
                    "4 - null";
    private static String filterNumbersText =
                    "1 - equal(eq)\n" +
                    "2 - greater than(gt)\n" +
                    "3 - less than(lt)\n" +
                    "4 - greater and equal to(ge)\n" +
                    "5 - less and equal to(le)\n" +
                    "6 - null";
    private static String filterDateAndTimeText =
                    "1 - in a specific year(y)\n" +
                    "2 - in a specific month(m)\n" +
                    "3 - in a specific day(d)";
    private static String filterClusterIDText =
            "Is there high fatality ? Type yes or no.";

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

    public static String getFilterStringOptionText(){return filterStringOptionText;}

    public static String getFilterOptionText(){return filterOptionText;}

    public static String getFilterDateTimeNumbersText(){return filterNumbersText;}

    public static String getFilterDateAndTimeText(){return filterDateAndTimeText;}

    public static String getFilterClusterIDText(){return filterClusterIDText;}

    public static void printWelcomeString(){
        System.out.println(getWelcomeString());
    }

    public static void printOptionsText(String message){
        System.out.println(message);
    }

}
