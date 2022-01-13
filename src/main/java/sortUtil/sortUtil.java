package sortUtil;

import crash.Crash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sortUtil {
    public Comparator<Crash>comparing_date = Comparator.comparing(Crash::getDate);
    public Comparator<Crash>comparing_location = Comparator.comparing(Crash::getLocation);
    public Comparator<Crash>comparing_operator = Comparator.comparing(Crash::getOperator);
    public Comparator<Crash>comparing_flight = Comparator.comparing(Crash::getFlight);
    public Comparator<Crash>comparing_route = Comparator.comparing(Crash::getRoute);
    public Comparator<Crash>comparing_type  = Comparator.comparing(Crash::getType);
    public Comparator<Crash>comparing_registration  = Comparator.comparing(Crash::getRegistration);
    public Comparator<Crash>comparing_cn_ln  = Comparator.comparing(Crash::getCn_ln);
    public Comparator<Crash>comparing_aboard  = Comparator.comparing(Crash::getAboard);
    public Comparator<Crash>comparing_fatalities = Comparator.comparing(Crash::getFatalities);
    public Comparator<Crash>comparing_ground = Comparator.comparing(Crash::getGround);
    public Comparator<Crash>comparing_survivors = Comparator.comparing(Crash::getSurvivors);
    public Comparator<Crash>comparing_survivalRate = Comparator.comparing(Crash::getSurvivalRate);
    public Comparator<Crash>comparing_summary = Comparator.comparing(Crash::getSummary);
    public Comparator<Crash>comparing_clustId = Comparator.comparing(Crash::getClustId);

    public void sortbyDate(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_date);
    }

    public void sortbyLocation(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_location);
    }

    public void sortbyOperator(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_operator);
    }

    public void sortbyFlight(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_flight);
    }

    public void sortbyRoute(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_route);
    }

    public void sortbyType(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_type);
    }

    public void sortbyRegistration(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_registration);
    }

    public void sortbyCnln(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_cn_ln);
    }

    public void sortbyAboard(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_aboard);
    }

    public void sortbyFatalities(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_fatalities);
    }

    public void sortbyGround(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_ground);
    }

    public void sortbySurvivors(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_survivors);
    }

    public void sortbySurvivalRate(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_survivalRate);
    }

    public void sortbySummary(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_summary);
    }

    public void sortbyClustid(ArrayList<Crash>crashes)
    {
        Collections.sort(crashes, comparing_clustId);
    }
}
