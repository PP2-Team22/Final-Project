package crash;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Crash {
    private Date Date;
    private boolean isTime;
    private String Location;
    private String Operator;
    private String Flight;
    private String Route;
    private String Type;
    private String Registration;
    private String Cn_ln;
    private int Aboard;
    private int Fatalities;
    private int Ground;
    private int Survivors;
    private double SurvivalRate;
    private String Summary;
    private boolean ClustId;

    public Date getDate() {
        return Date;
    }

    public boolean getIsTime() {
        return isTime;
    }

    public String getLocation() {
        return Location;
    }

    public String getOperator() {
        return Operator;
    }

    public String getFlight() {
        return Flight;
    }

    public String getRoute() {
        return Route;
    }

    public String getType() {
        return Type;
    }

    public String getRegistration() {
        return Registration;
    }

    public String getCn_ln() {
        return Cn_ln;
    }

    public int getAboard() {
        return Aboard;
    }

    public int getFatalities() {
        return Fatalities;
    }

    public int getGround() {
        return Ground;
    }

    public int getSurvivors() {
        return Survivors;
    }

    public double getSurvivalRate() {
        return SurvivalRate;
    }

    public String getSummary() {
        return Summary;
    }

    public boolean getClustId() {
        return ClustId;
    }

    public Crash(Date Date, boolean isTime, String Location, String Operator,
                 String Flight, String Route, String Type, String Registration, String Cn_ln,
                 int Aboard, int Fatalities, int Ground, int Survivors,
                 double SurvivalRate, String Summary, boolean ClustId)
    {
        this.Date = Date;
        this.isTime = isTime;
        this.Location = Location;
        this.Operator = Operator;
        this.Flight = Flight;
        this.Route = Route;
        this.Type = Type;
        this.Registration = Registration;
        this.Cn_ln = Cn_ln;
        this.Aboard = Aboard;
        this.Fatalities = Fatalities;
        this.Ground = Ground;
        this.Survivors = Survivors;
        this.SurvivalRate = SurvivalRate;
        this.Summary = Summary;
        this.ClustId = ClustId;
    }

    public String toString()
    {
        String clust = (ClustId == true ? "High Fatality": "Low Fatality");
        SimpleDateFormat st = (isTime == true ? new SimpleDateFormat("MM/dd/yyyy mm:ss"): new SimpleDateFormat("MM/dd/yyyy "));
        String d = st.format(Date);
        return "[Date:" + d + ", Location: " + Location + ", Operator: " + Operator + ", Flight: " + Flight +
                ", Route: " + Route + ", Type: " + Type + ", Registration: " + Registration + ", Cn.ln: " + Cn_ln +
                ", Aboard: " + Aboard + ", Fatalities: " + Fatalities + ", Ground: " + Ground + ", Survivors: " +
                Survivors + ", Survival Rate: " + SurvivalRate + "\nSummary: " + Summary + ", ClustId: " + clust + "]";
    }
    public void printCrash()
    {
        System.out.println(toString());
    }
}