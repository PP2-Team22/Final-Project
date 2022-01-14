package filterUtil;

import crash.Crash;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class filterUtil {
    boolean check_string(String s, String s1, int sig)
    {
        if(s.length() > s1.length())
        {
            return false;
        }
        if(sig == 1)
        {

          for(int i = 0; i < s.length(); i++)
          {
           if(s1.charAt(i) !=s.charAt(i))
           {
               return false;
           }
          }
          return true;
       }
       else if(sig == 2)
       {
          int last = s1.length();
          for(int i = s.length(); i >= 0; i--)
          {
              if(s.charAt(i) != s1.charAt(last))return false;
              last--;
          }
       }
       else return s1.contains(s);


        return false;
    }
    boolean check_date(Date one, int two, int sig)
    {
        if(sig == 1)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(one);
            int one_year = calendar.get(Calendar.YEAR);

            if(one_year == two)return true;
            else return false;
        }
        else if(sig == 2)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(one);
            int one_year = calendar.get(Calendar.YEAR);

            if(one_year == two)return true;
            else return false;
        }
        else
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(one);
            int one_year = calendar.get(Calendar.YEAR);

            if(one_year == two)return true;
            else return false;
        }
    }
    boolean check_int(int one, int two, int sig)
    {
        if(one == two && sig == 1)
        {
            return true;
        }
        else if(one < two && sig == 3)
        {
            return true;
        }
        else if(one > two && sig == 2)
        {
            return true;
        }
        else if(one >= two && sig == 4)
        {
            return true;
        }
        else if(one <= two && sig == 5)
        {
            return true;
        }
        else if(one == 0 && sig == 6)
        {
            return true;
        }
        else return false;
    }
    boolean check_double(double one, double two, int sig)
    {
        if(one == two && sig == 1)
        {
            return true;
        }
        else if(one < two && sig == 3)
        {
            return true;
        }
        else if(one > two && sig == 2)
        {
            return true;
        }
        else if(one >= two && sig == 4)
        {
            return true;
        }
        else if(one <= two && sig == 5)
        {
            return true;
        }
        else if(one == 0 && sig == 6)
        {
            return true;
        }
        else return false;
    }
    public List<Crash> filter(List<Crash> crashes, TreeMap<Integer, Object> d, TreeMap<Integer, Integer> sig, TreeMap<Integer, String> dict) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ParseException {
      List<Crash>res = new ArrayList<Crash>();
      for(Crash crash: crashes)
      {
        int sigg = 0;
        for(Map.Entry<Integer, Integer> pair : sig.entrySet()) {
            String f = dict.get(pair.getKey());
            Field field = Crash.class.getDeclaredField(f);
            field.setAccessible(true);
            String type = String.valueOf(field.getType());
            if(type.contains("String"))
            {
                Method getter = Crash.class.getDeclaredMethod("get" + f);
                getter.setAccessible(true);
                String val_of_field = (String) getter.invoke(crash);
                if(check_string((String) d.get(pair.getKey()), val_of_field, pair.getValue()) == false)
                {
                  sigg = 1;
                  break;
                }
            }
            else if(type.contains("Date"))
            {
                Method getter = Crash.class.getDeclaredMethod("get" + f);
                getter.setAccessible(true);
                Date val_of_field = (Date) getter.invoke(crash);
                String dt = (String) d.get(pair.getKey());

                if(check_date(val_of_field, Integer.parseInt(dt), pair.getValue()) == false)
                {
                    sigg = 1;
                    break;
                }
            }
            else if(type.contains("int"))
            {
                Method getter = Crash.class.getDeclaredMethod("get" + f);
                getter.setAccessible(true);
                Integer val_of_field = (Integer) getter.invoke(crash);
                if(check_int(val_of_field, (int) d.get(pair.getKey()), pair.getValue()) == false)
                {
                    sigg = 1;
                    break;
                }
            }
            else if(type.contains("double"))
            {
                Method getter = Crash.class.getDeclaredMethod("get" + f);
                getter.setAccessible(true);
                Double val_of_field = (Double) getter.invoke(crash);
                if(check_double(val_of_field, (double) d.get(pair.getKey()), pair.getValue()) == false)
                {
                    sigg = 1;
                    break;
                }
            }
            else if(type.contains("boolean"))
            {
                Method getter = Crash.class.getDeclaredMethod("get" + f);
                getter.setAccessible(true);
                boolean is = (boolean) getter.invoke(crash);
                boolean check = (d.get(pair.getKey()).equals("yes") ? true: false);
                if(check != is)
                {
                    sigg = 1;
                    break;
                }
            }
        }
        if(sigg == 0)res.add(crash);
      }
      return res;
    }
}
