package listUtil;

import crash.Crash;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import parser.Parser;

public class listUtil {
    private static String columns = "Date\nTime\nLocation\nOperator\nFlight\nRoute\nType\nRegistration\nCn.Ln\nAboard\nFatalities\nGround\n" +
            "Survivors\nSurvivalRate\nSummary\nClustID\n";

    public static String getColumns()
    {
        return columns;
    }
    public static String ListAllFields(List<Crash>crashes)
    {
        String res = "";
        for(int i = 0; i < crashes.size(); i++)
        {
            res += crashes.get(i) + "\n";
        }
        res += "[------The number of printed crashes is " + crashes.size() + ". ------]";
        return res;
    }
    public static String ListSelectedFields(List<Crash>crashes, String numbers[], TreeMap<Integer, String> dict) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
       List<String>fields = new ArrayList<String>();
       for(String i: numbers)
       {
           int num = Integer.parseInt(i);
           String val = dict.get(num);
           fields.add(val);
       }
       String res = "[ ";
       int sig = 0;
       for(Crash crash: crashes)
       {
          for(String f: fields)
          {
              Class cl = crash.getClass();
              Field cs[] = cl.getDeclaredFields();
              for(Field field: cs)
              {
                 if(field.getName().equals(f))
                 {
                     Method getter = Crash.class.getDeclaredMethod("get" + f);
                     getter.setAccessible(true);
                     res += f + ": " + getter.invoke(crash);
                     res += ", ";
                 }
              }

          }
          res += "]\n";
       }
       res += "[------The number of printed crashes is " + crashes.size() + ". ------]";
       return res;
    }
    public static String ListOnRange(List<Crash> crashes, int l, int r)
    {
        String res = "";
        for(int i = l - 1; i < r; i++)
        {
            res += crashes.get(i) + "\n";
        }
        res += "[------The number of printed crashes is " + (r - l + 1) + ". ------]";
        return res;
    }

}
