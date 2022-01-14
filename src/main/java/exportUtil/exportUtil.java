package exportUtil;

import java.io.*;

public class exportUtil {
    public static void export(String file_name, String body) throws IOException {
        PrintWriter f= new PrintWriter(new File(file_name));
        String export = listUtil.listUtil.getColumns();
        export += body;
        f.write(body);
        f.close();
        System.out.println("Information was successfully exported");
    }
}
