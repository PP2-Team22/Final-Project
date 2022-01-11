package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import crash.Crash;

public class Parser {
   private static Crash read_Crash(Scanner f) throws ParseException {
       String line = f.nextLine();
       String date = "", time = "", location = "", operator = "", flight = "", route = "", type = "", registration = "";
       String cn_ln = "", aboardCnt = "", fatalitiesCnt = "", groundCnt = "", survivorsCnt = "", survivalRate = "";
       String summary = "", clustId = "";
       int n = line.length();

       int index = 0;
       for(; index < n; index++)
       {
           if(line.charAt(index) == ','){index++; break;}
           date += line.charAt(index);
       }
       for(; index < n; index++)
       {
           if(line.charAt(index) == ','){index++; break;}
           time += line.charAt(index);
       }
       int sig = 0;
       if(line.charAt(index) == '"')
       {
           sig = 1;
           index++;
       }
       for(; index < n; index++)
       {
           if(line.charAt(index) == (sig == 1 ? '"' : ',')){index++; break;}
           location += line.charAt(index);
       }
       if(sig == 1)index++;
       sig = 0;
       if(line.charAt(index) == '"')
       {
           sig = 1;
           index++;
       }
       for(; index < n; index++)
       {
           if(line.charAt(index) == (sig == 1 ? '"' : ',')){index++; break;}
           operator += line.charAt(index);
       }
       if(sig == 1)index++;
       for(; index < n; index++)
       {
           if(line.charAt(index) == ','){index++; break;}
           flight += line.charAt(index);
       }
       sig = 0;
       if(line.charAt(index) == '"')
       {
           sig = 1;
           index++;
       }
       for(; index < n; index++)
       {
           if(line.charAt(index) == (sig == 1 ? '"' : ',')){index++; break;}
           route += line.charAt(index);
       }
       if(sig == 1)index++;
       for(; index < n; index++)
       {
           if(line.charAt(index) == ','){index++; break;}
           type += line.charAt(index);
       }
       for(; index < n; index++)
       {
           if(line.charAt(index) == ','){index++; break;}
           registration += line.charAt(index);
       }
       for(; index < n; index++)
       {
           if(line.charAt(index) == ','){index++; break;}
           cn_ln += line.charAt(index);
       }
       for(; index < n; index++)
       {
           if(line.charAt(index) == ','){index++; break;}
           aboardCnt += line.charAt(index);
       }
       for(; index < n; index++)
       {
           if(line.charAt(index) == ','){index++; break;}
           fatalitiesCnt += line.charAt(index);
       }
       for(; index < n; index++)
       {
           if(line.charAt(index) == ','){index++; break;}
           groundCnt += line.charAt(index);
       }
       for(; index < n; index++)
       {
           if(line.charAt(index) == ','){index++; break;}
           survivorsCnt += line.charAt(index);
       }
       for(; index < n; index++)
       {
           if(line.charAt(index) == ','){index++; break;}
           survivalRate += line.charAt(index);
       }
       index++;
       for(; index < n; index++)
       {
           if(line.charAt(index) == '"'){index++; break;}
           summary += line.charAt(index);
       }
       index++;
       for(; index < n; index++)
       {
           clustId += line.charAt(index);
       }
       boolean istime = true;
       if(time == "")istime = false;
       SimpleDateFormat st = (istime == true ? new SimpleDateFormat("MM/dd/yyyy mm:ss"): new SimpleDateFormat("MM/dd/yyyy "));
       Date d = st.parse(date + " " + time);
       boolean cl = (clustId.equals("High Fatality") ? true: false);
       Crash c = new Crash(d, istime, location, operator, flight, route, type, registration, cn_ln,
               Integer.parseInt(aboardCnt), Integer.parseInt(fatalitiesCnt), Integer.parseInt(groundCnt),
               Integer.parseInt(survivorsCnt), Double.parseDouble(survivalRate),
               summary, cl);
       return c;
   }

   private String read_columns() throws FileNotFoundException {
       Scanner f = new Scanner(new File("src/main/data/dataset.csv"));
       f.useDelimiter(",");
       int cnt = 16;
       String res = "";
       while(cnt > 0)
       {
           cnt--;
           res = res + f.next();
       }
       return res;
   }

   public static List<Crash> parse() throws FileNotFoundException, ParseException {
     Scanner f = new Scanner(new File("src/main/data/dataset.csv"));
     f.nextLine();
     List<Crash>array = new ArrayList<Crash>();
     while(f.hasNextLine()) {
         Crash c = read_Crash(f);
         array.add(c);
     }
     return array;
   }


}
