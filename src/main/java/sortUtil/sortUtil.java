package sortUtil;

import crash.Crash;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class sortUtil {
    public static Comparator<Crash>comparing_date = Comparator.comparing(Crash::getDate);
    public static Comparator<Crash>comparing_location = Comparator.comparing(Crash::getLocation);
    public static Comparator<Crash>comparing_operator = Comparator.comparing(Crash::getOperator);
    public static Comparator<Crash>comparing_flight = Comparator.comparing(Crash::getFlight);
    public static Comparator<Crash>comparing_route = Comparator.comparing(Crash::getRoute);
    public static Comparator<Crash>comparing_type  = Comparator.comparing(Crash::getType);
    public static Comparator<Crash>comparing_registration  = Comparator.comparing(Crash::getRegistration);
    public static Comparator<Crash>comparing_cn_ln  = Comparator.comparing(Crash::getCn_ln);
    public static Comparator<Crash>comparing_aboard  = Comparator.comparing(Crash::getAboard);
    public static Comparator<Crash>comparing_fatalities = Comparator.comparing(Crash::getFatalities);
    public static Comparator<Crash>comparing_ground = Comparator.comparing(Crash::getGround);
    public static Comparator<Crash>comparing_survivors = Comparator.comparing(Crash::getSurvivors);
    public static Comparator<Crash>comparing_survivalRate = Comparator.comparing(Crash::getSurvivalRate);
    public static Comparator<Crash>comparing_summary = Comparator.comparing(Crash::getSummary);
    public static Comparator<Crash>comparing_clustId = Comparator.comparing(Crash::getClustId);

    public static void sortbyDate(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_date);
        }
        else
        {
            Collections.sort(crashes, comparing_date.reversed());
        }
    }

    public static void sortbyLocation(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_location);
        }
        else
        {
            Collections.sort(crashes, comparing_location.reversed());
        }
    }

    public static void sortbyOperator(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_operator);
        }
        else
        {
            Collections.sort(crashes, comparing_operator.reversed());
        }
    }

    public void sortbyFlight(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_flight);
        }
        else
        {
            Collections.sort(crashes, comparing_flight.reversed());
        }
    }

    public void sortbyRoute(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_route);
        }
        else
        {
            Collections.sort(crashes, comparing_route.reversed());
        }
    }

    public void sortbyType(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_type);
        }
        else
        {
            Collections.sort(crashes, comparing_type.reversed());
        }
    }

    public void sortbyRegistration(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_registration);
        }
        else
        {
            Collections.sort(crashes, comparing_registration.reversed());
        }
    }


    public void sortbyCn_ln(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_cn_ln);
        }
        else
        {
            Collections.sort(crashes, comparing_cn_ln.reversed());
        }
    }

    public void sortbyAboard(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_aboard);
        }
        else
        {
            Collections.sort(crashes, comparing_aboard.reversed());
        }
    }

    public void sortbyFatalities(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_fatalities);
        }
        else
        {
            Collections.sort(crashes, comparing_fatalities.reversed());
        }
    }

    public void sortbyGround(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_ground);
        }
        else
        {
            Collections.sort(crashes, comparing_ground.reversed());
        }
    }

    public void sortbySurvivors(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_survivors);
        }
        else
        {
            Collections.sort(crashes, comparing_survivors.reversed());
        }
    }

    public void sortbySurvivalRate(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_survivalRate);
        }
        else
        {
            Collections.sort(crashes, comparing_survivalRate.reversed());
        }
    }

    public void sortbySummary(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_summary);
        }
        else
        {
            Collections.sort(crashes, comparing_summary.reversed());
        }
    }

    public void sortbyClustId(List<Crash>crashes, String order)
    {
        if(order.equals("ASC"))
        {
            Collections.sort(crashes, comparing_clustId);
        }
        else
        {
            Collections.sort(crashes, comparing_clustId.reversed());
        }
    }
}
