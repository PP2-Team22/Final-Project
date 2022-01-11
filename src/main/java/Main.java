import java.util.Scanner;
import menu.Menu;

public class Main {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        while(true)
        {
            if(x == 0) {
                Menu.printWelcomeString();
                Menu.printOptionsText(Menu.getOptionsText());
            }
            else if(x == 1) {
                Menu.printOptionsText(Menu.getListOptionsText());
            }
            else if(x == 2) {
                Menu.printOptionsText(Menu.getSortOptionText());
            }
            else if(x == 3) {
                Menu.printOptionsText(Menu.getSearchOptionText());
            }
            else if(x == 4) {
                Menu.printOptionsText("");
            }
            else if(x == 5) {
                Menu.printOptionsText(Menu.getFilterOptionText());
            }
            else if(x == 6) return;
            x = sc.nextInt();
        }
    }
}