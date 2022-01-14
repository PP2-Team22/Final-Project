package errorsUtil;

public class errorsUtil {
    public static boolean mainMenuCheck(int x)
    {
        if(x >= 1 && x <= 6)return false;
        else return true;
    }
    public static boolean listMenuCheck(String s)
    {
        if(s.equals("a") || s.equals("b") || s.equals("c"))return false;
        else return true;
    }
    public static boolean checkingNumbers(String s)
    {
       for(int i = 0; i < s.length(); i++)
       {
          if(Character.isDigit(s.charAt(i)) == false && s.charAt(i) != ' ')return true;
       }
       String numbers[] = s.split(" ");
       for(int i = 0; i < numbers.length; i++)
       {
          int x = Integer.parseInt(numbers[i]);
          if(!(x >= 1 && x <= 15))return true;
       }
       return  false;
    }
    public static boolean sortCheck(int x)
    {
        if(x >= 1 && x <= 15)return false;
        else return true;
    }
    public static boolean rangeCheck(int l, int r, int limit)
    {
       if(l >= 1 && r <= limit)return false;
       else return true;
    }
    public static boolean orderCheck(String s)
    {
       if(s.equals("ASC") || s.equals("DESC"))return false;
       else return true;
    }
    public static boolean checkYesOrNo(String s)
    {
        if(s.equals("yes") || s.equals("no"))return false;
        else return true;
    }
}
