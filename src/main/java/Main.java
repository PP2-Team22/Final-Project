import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import java.util.List;
import java.util.Scanner;

import crash.Crash;
import menu.Menu;
import listUtil.listUtil;
import sortUtil.sortUtil;
import parser.Parser;
import searchUtil.searchUtil;
import filterUtil.filterUtil;
import exportUtil.exportUtil;
import errorsUtil.errorsUtil;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.TreeMap;
import java.util.Random;

public class Main {
    public static void main(String args[]) throws IOException, ParseException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        Scanner sc = new Scanner(System.in);
        List<Crash> crashes = Parser.parse();
        Class cl = crashes.get(0).getClass();
        Field cs[] = cl.getDeclaredFields();
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
                while(errorsUtil.listMenuCheck(c))
                {
                    Menu.printOptionsText("Error!! You can type only a, b or c!!!");
                    c = sc.next();
                }
                if(c.equals("a"))
                {
                    String pr = listUtil.ListAllFields(crashes);
                    System.out.println(pr);
                }
                else if(c.equals("b"))
                {
                    Menu.printOptionsText(Menu.getListOnlySelectedText());
                    sc.nextLine();
                    String ff = sc.nextLine();
                    while (errorsUtil.checkingNumbers(ff))
                    {
                        Menu.printOptionsText("Error!!! You can type only numbers from 1 to 15 !!");
                        ff = sc.nextLine();
                    }
                    String numbers[] = ff.split(" ");
                    String list = listUtil.ListSelectedFields(crashes, numbers, dict);
                    System.out.println(list);
                }
                else if(c.equals("c"))
                {
                    Menu.printOptionsText(Menu.getListOnRangeOptionText());
                    int l = sc.nextInt(), r = sc.nextInt();
                    while(errorsUtil.rangeCheck(l, r, crashes.size()))
                    {
                        Menu.printOptionsText("Error!!! You can type only numbers from 1 to " + crashes.size() + "!!");
                        l = sc.nextInt();
                        r = sc.nextInt();
                    }
                    String list = listUtil.ListOnRange(crashes, l, r);
                    System.out.println(list);
                }
            }
            else if(x == 2) {
                Menu.printOptionsText(Menu.getSortOptionText());
                int c = sc.nextInt();
                while(errorsUtil.sortCheck(c))
                {
                    Menu.printOptionsText("Error!!! You can type only numbers from 1 to " + 15 + "!!");
                    c = sc.nextInt();
                }
                Menu.printOptionsText(Menu.getSortOrderOptionText());
                String order = sc.next();
                while(errorsUtil.orderCheck(order))
                {
                    Menu.printOptionsText("Error!!! You can type only ASC or DESC!!!");
                    order = sc.next();
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
                sc.nextLine();
                String num = sc.nextLine();
                while (errorsUtil.checkingNumbers(num))
                {
                    Menu.printOptionsText("Error!!! You can type only numbers from 1 to 15 !!");
                    num = sc.nextLine();
                }
                String[] numbers = num.split(" ");
                Menu.printOptionsText("Type the values of each field in ascending order of numbers to find the record.\n" +
                        "Example: If you typed earlier numbers 2 7, type: Kano, Nigeria 5N-ESF\n" +
                        "If you type the value of Date use format MM/dd/yyyy mm:ss or MM/dd/yyyy. For example: 01/30/2000\n" +
                        "If you type the value of ClustId, consider that for high fatality you need to type true or false for low fatality");
                String s = sc.nextLine();
                List<Crash>res = searchUtil.search(crashes, numbers, dict, s);
                Menu.printOptionsText("Do you want to export the results? Type yes or no");
                String ch = sc.next();
                int ex = 0;
                while(errorsUtil.checkYesOrNo(ch))
                {
                    Menu.printOptionsText("You can type only yes or no!");
                    ch = sc.next();
                }
                if(ch.equals("yes"))ex = 1;
                Random rand = new Random();
                Menu.printOptionsText(Menu.getListOnlySelectedText());
                sc.nextLine();
                String ff = sc.nextLine();
                while (errorsUtil.checkingNumbers(ff))
                {
                    Menu.printOptionsText("Error!!! You can type only numbers from 1 to 15 !!");
                    ff = sc.nextLine();
                }
                String number[] = ff.split(" ");
                String list = listUtil.ListSelectedFields(res, number, dict);
                System.out.println(list);
                if(ex == 1)exportUtil.export("export " + rand.nextInt(124124) + ".csv", listUtil.ListAllFieldsExport(res));
            }
            else if(x == 4) {
                Menu.printOptionsText(listUtil.getColumns());
            }
            else if(x == 5) {
                Menu.printOptionsText(Menu.getFilterOptionText());
                int num = sc.nextInt();
                TreeMap<Integer, Object>d = new TreeMap<Integer, Object>();
                TreeMap<Integer, Integer>sigs = new TreeMap<Integer, Integer>();
                for(int i = 1; i <= num; i++)
                {
                    Menu.printOptionsText("Type the number of field, which you chose. \n" +
                            "            1 - Date and Time\n" +
                            "            2 - Location\n" +
                            "            3 - Operator\n" +
                            "            4 - Flight\n" +
                            "            5 - Route\n" +
                            "            6 - Type\n" +
                            "            7 - Registration\n" +
                            "            8 - cn.Ln\n" +
                            "            9 - Aboard\n" +
                            "            10 - Fatalities\n" +
                            "            11 - Ground\n" +
                            "            12 - Survivors\n" +
                            "            13 - SurvivalRate\n" +
                            "            14 - Summary\n" +
                            "            15 - ClustID\n");
                    int field_num = sc.nextInt();
                    while(errorsUtil.sortCheck(field_num))
                    {
                        Menu.printOptionsText("Error!!! You can type only numbers from 1 to " + 15 + "!!");
                    }
                    Field field = Crash.class.getDeclaredField(dict.get(field_num));
                    field.setAccessible(true);
                    String type = String.valueOf(field.getType());
                    if(type.contains("String"))
                    {
                        Menu.printOptionsText(Menu.getFilterStringOptionText());
                        int sig = sc.nextInt();
                        while(errorsUtil.rangeCheck(sig, sig, 4))
                        {
                            Menu.printOptionsText("Error!!! You can type only numbers from 1 to 4!");
                            sig = sc.nextInt();
                        }
                        Menu.printOptionsText("Type the value of field for filtering.");
                        String name = sc.next();
                        sigs.put(field_num, sig);
                        d.put(field_num, name);
                    }
                    else if(type.contains("Date"))
                    {
                        Menu.printOptionsText(Menu.getFilterDateAndTimeText());
                        int sig = sc.nextInt();
                        while(errorsUtil.rangeCheck(sig, sig, 3))
                        {
                            Menu.printOptionsText("Error!!! You can type only numbers from 1 to 3!");
                            sig = sc.nextInt();
                        }
                        Menu.printOptionsText("Type the value of field for filtering.");
                        String name = sc.next();
                        sigs.put(field_num, sig);
                        d.put(field_num, name);
                    }
                    else if(type.contains("double")) {
                        Menu.printOptionsText(Menu.getFilterDateTimeNumbersText());
                        int sig = sc.nextInt();
                        while(errorsUtil.rangeCheck(sig, sig, 6))
                        {
                            Menu.printOptionsText("Error!!! You can type only numbers from 1 to 6!");
                            sig = sc.nextInt();
                        }
                        double s = 0;
                        if(sig != 6) {
                            Menu.printOptionsText("Type the value of field for filtering.");
                            s = sc.nextDouble();
                        }
                        sigs.put(field_num, sig);
                        d.put(field_num, s);
                    }
                    else if(type.contains("int")){
                        Menu.printOptionsText(Menu.getFilterDateTimeNumbersText());
                        int sig = sc.nextInt();
                        while(errorsUtil.rangeCheck(sig, sig, 6))
                        {
                            Menu.printOptionsText("Error!!! You can type only numbers from 1 to 6!");
                            sig = sc.nextInt();
                        }
                        int s = 0;
                        if(sig != 6) {
                            Menu.printOptionsText("Type the value of field for filtering.");
                            s = sc.nextInt();
                        }
                        sigs.put(field_num, sig);
                        d.put(field_num, s);
                    }
                    else if(type.contains("boolean"))
                    {
                       Menu.printOptionsText(Menu.getFilterClusterIDText());
                       String ch = sc.next();
                       while(errorsUtil.checkYesOrNo(ch))
                       {
                            Menu.printOptionsText("You can type only yes or no!");
                            ch = sc.next();
                       }
                       sigs.put(field_num, 0);
                       d.put(field_num, ch);

                    }

                }
                List<Crash>res = new filterUtil().filter(crashes, d, sigs, dict);
                Menu.printOptionsText("Do you want to export the results? Type yes or no");
                String ch = sc.next();
                int ex = 0;
                while(errorsUtil.checkYesOrNo(ch))
                {
                    Menu.printOptionsText("You can type only yes or no!");
                    ch = sc.next();
                }
                if(ch.equals("yes"))ex = 1;

                Random rand = new Random();
                Menu.printOptionsText(Menu.getListOnlySelectedText());
                sc.nextLine();
                String ff = sc.nextLine();
                while (errorsUtil.checkingNumbers(ff))
                {
                    Menu.printOptionsText("Error!!! You can type only numbers from 1 to 15 !!");
                    ff = sc.nextLine();
                }
                String number[] = ff.split(" ");
                String list = listUtil.ListSelectedFields(res, number, dict);
                System.out.println(list);
                if(ex == 1)exportUtil.export("export " + rand.nextInt(124124) + ".csv", listUtil.ListAllFieldsExport(res));
            }
            else if(x == 6) return;

            if(x != 0) {
                String yes = "no";
                while(yes.equals("no")) {
                    Menu.printOptionsText("Do you want to continue ? Type yes");
                    yes = sc.next();
                    while(errorsUtil.checkYesOrNo(yes))
                    {
                        Menu.printOptionsText("You can type only yes or no!");
                        yes = sc.next();
                    }
                }
                Menu.printWelcomeString();
                Menu.printOptionsText(Menu.getOptionsText());
            }
            x = sc.nextInt();
            while(errorsUtil.mainMenuCheck(x))
            {
              Menu.printOptionsText("Error!!! You can type only numbers from 1 to 6 for choosing the options !!!");
              x = sc.nextInt();
            }

        }
    }
}