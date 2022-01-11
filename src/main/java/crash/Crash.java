package crash;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Crash {
    private Date date;
    private boolean isTime;
    private String location;
    private String operator;
    private String flight;
    private String route;
    private String type;
    private String registration;
    private String cn_ln;
    private int aboardCnt;
    private int fatalitiesCnt;
    private int groundCnt;
    private int survivorsCnt;
    private double survivalRate;
    private String summary;
    private boolean clustId;

    public Date getDate() {
        return date;
    }

    public boolean getIsTime() {
        return isTime;
    }

    public String getLocation() {
        return location;
    }

    public String getOperator() {
        return operator;
    }

    public String getFlight() {
        return flight;
    }

    public String getRoute() {
        return route;
    }

    public String getType() {
        return type;
    }

    public String getRegistration() {
        return registration;
    }

    public String getCn_ln() {
        return cn_ln;
    }

    public int getAboardCnt() {
        return aboardCnt;
    }

    public int getFatalitiesCnt() {
        return fatalitiesCnt;
    }

    public int getGroundCnt() {
        return groundCnt;
    }

    public int getSurvivorsCnt() {
        return survivorsCnt;
    }

    public double getSurvivalRate() {
        return survivalRate;
    }

    public String getSummary() {
        return summary;
    }

    public boolean getClustId() {
        return clustId;
    }

    public Crash(Date date, boolean isTime, String location, String operator,
                 String flight, String route, String type, String registration, String cn_ln,
                 int aboardCnt, int fatalitiesCnt, int groundCnt, int survivorsCnt,
                 double survivalRate, String summary, boolean clustId)
    {
        this.date = date;
        this.isTime = isTime;
        this.location = location;
        this.operator = operator;
        this.flight = flight;
        this.route = route;
        this.type = type;
        this.registration = registration;
        this.cn_ln = cn_ln;
        this.aboardCnt = aboardCnt;
        this.fatalitiesCnt = fatalitiesCnt;
        this.groundCnt = groundCnt;
        this.survivorsCnt = survivorsCnt;
        this.survivalRate = survivalRate;
        this.summary = summary;
        this.clustId = clustId;
    }

    public String toString()
    {
        String clust = (clustId == true ? "High Fatality": "Low Fatality");
        SimpleDateFormat st = (isTime == true ? new SimpleDateFormat("MM/dd/yyyy mm:ss"): new SimpleDateFormat("MM/dd/yyyy "));
        String d = st.format(date);
        return "[Date:" + d + ", Location: " + location + ", Operator: " + operator + ", Flight: " + flight +
                ", Route: " + route + ", Type: " + type + ", Registration: " + registration + ", Cn.ln: " + cn_ln +
                ", Aboard: " + aboardCnt + ", Fatalities: " + fatalitiesCnt + ", Ground: " + groundCnt + ", Survivors: " +
                survivorsCnt + ", Survival Rate: " + survivalRate + "\nSummary: " + summary + ", ClustId: " + clust + "]";
    }
    public void printCrash()
    {
        System.out.println(toString());
    }
}
