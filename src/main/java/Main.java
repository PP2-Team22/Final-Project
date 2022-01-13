import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import java.util.List;
import java.util.Scanner;

import crash.Crash;
import menu.Menu;
import listUtil.listUtil;
import sortUtil.sortUtil;
import parser.Parser;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.util.TreeMap;

public class Main {
    public static void main(String args[]) throws FileNotFoundException, ParseException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Scanner sc = new Scanner(System.in);
        List<Crash> crashes = Parser.parse();
        Class cl = crashes.get(0).getClass();
        Field cs[] = cl.getDeclaredFields();
        int x = 0;
        while(true)
        {
            if(x == 0) {
                Menu.printWelcomeString();
                Menu.printOptionsText(Menu.getOptionsText());
            }
            else if(x == 1) {
                Menu.printOptionsText(Menu.getListOptionsText());
                String c = sc.next();
                if(c.equals("a"))
                {
                    String pr = listUtil.ListAllFields(crashes);
                    System.out.println(pr);
                }
                else if(c.equals("b"))
                {
                    TreeMap<Integer, String> dict = new TreeMap<Integer, String>();
                    int cnt = 1;
                    for(Field f: cs)
                    {
                        if(cnt <= 1)
                        {
                            dict.put(cnt, f.getName());
                        }
                        else if(cnt == 2)
                        {

                        }
                        else
                        {
                           dict.put(cnt - 1, f.getName());
                        }
                        cnt++;
                    }
                    Menu.printOptionsText(Menu.getListOnlySelectedText());
                    sc.nextLine();
                    String ff = sc.nextLine();
                    String numbers[] = ff.split(" ");
                    String list = listUtil.ListSelectedFields(crashes, numbers, dict);
                    System.out.println(list);
                }
                else if(c.equals("c"))
                {
                    Menu.printOptionsText(Menu.getListOnRangeOptionText());
                    int l = sc.nextInt(), r = sc.nextInt();
                    String list = listUtil.ListOnRange(crashes, l, r);
                    System.out.println(list);
                }
            }
            else if(x == 2) {
                Menu.printOptionsText(Menu.getSortOptionText());
                int c = sc.nextInt();
                Menu.printOptionsText(Menu.getSortOrderOptionText());
                String order = sc.next();
                TreeMap<Integer, String> dict = new TreeMap<Integer, String>();
                int cnt = 1;
                for(Field f: cs)
                {
                    if(cnt <= 1)
                    {
                        dict.put(cnt, f.getName());
                    }
                    else if(cnt == 2)
                    {

                    }
                    else
                    {
                        dict.put(cnt - 1, f.getName());
                    }
                    cnt++;
                }
                String op = dict.get(c);
                sortUtil util = new sortUtil();
                Class sortu = util.getClass();
                Method sortby = sortUtil.class.getDeclaredMethod("sortby" + op, List.class, String.class);
                sortby.invoke(util, crashes, order);
                System.out.println("Database was successfully sorted !");
            }
            else if(x == 3) {
                Menu.printOptionsText(Menu.getSearchOptionText());
            }
            else if(x == 4) {
                Menu.printOptionsText(listUtil.getColumns());
            }
            else if(x == 5) {
                Menu.printOptionsText(Menu.getFilterOptionText());
            }
            else if(x == 6) return;

            if(x != 0) {
                Menu.printOptionsText("Do you want to continue ? Type yes");
                String yes = sc.next();
                Menu.printWelcomeString();
                Menu.printOptionsText(Menu.getOptionsText());

            }
            x = sc.nextInt();

        }
    }
}