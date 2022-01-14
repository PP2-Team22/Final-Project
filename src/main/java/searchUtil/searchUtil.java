package searchUtil;

import crash.Crash;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class searchUtil {
    public static List<Crash> search(List<Crash> crashes, String numbers[], TreeMap<Integer, String> dict, String names) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> fields = new ArrayList<String>();
        for (String i : numbers) {
            int num = Integer.parseInt(i);
            String val = dict.get(num);
            fields.add(val);
        }
        List<Crash>ans = new ArrayList<Crash>();
        String res = "";
        for (Crash crash : crashes) {
            int sig = 0;
            for (String f : fields) {
                Class cl = crash.getClass();
                Field cs[] = cl.getDeclaredFields();
                for (Field field : cs) {
                    if (field.getName().equals(f)) {
                        Method getter = Crash.class.getDeclaredMethod("get" + f);
                        getter.setAccessible(true);
                        String t = String.valueOf(field.getType());
                        int sTime = 0;
                        if(t.contains("Date"))
                        {
                            Method getT = Crash.class.getDeclaredMethod("getIsTime");
                            getT.setAccessible(true);
                            sTime = 1;
                            boolean istime = (boolean)getT.invoke(crash);
                            SimpleDateFormat st = (istime == true ? new SimpleDateFormat("MM/dd/yyyy mm:ss"): new SimpleDateFormat("MM/dd/yyyy "));
                            res = st.format(getter.invoke(crash));
                        }
                        else if(t.contains("String"))
                        {
                            res = (String)getter.invoke(crash);
                        }
                        else if(t.contains("boolean"))
                        {
                            boolean is = (boolean)getter.invoke(crash);
                            res = (is == true? "true" : "false");
                        }
                        if(sTime == 1) {
                            String ns[] = res.split(" ");
                            if (ns.length > 0 && names.contains(ns[0]) == false) {
                                if(ns.length > 1 && names.contains(ns[1]) == false) {
                                    sig = 1;
                                    break;
                                }
                                else if(ns.length < 2)
                                {
                                    sig = 1;
                                    break;
                                }
                            }


                        }
                        else{
                            if (names.contains(res) == false) {
                                sig = 1;
                                break;
                            }
                        }



                    }
                }
                if(sig == 1)break;

            }
            if(sig == 0)ans.add(crash);
        }
        return ans;
    }
}