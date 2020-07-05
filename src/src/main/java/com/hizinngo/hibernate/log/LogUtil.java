package com.hizinngo.hibernate.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class LogUtil {
    private static final String file = "log.txt";

    private static BufferedWriter openLog() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        return bw;
    }

    private static void closeLog(BufferedWriter bw) throws IOException{
        bw.close();
    }

    public static void printLog(String mess){
        BufferedWriter bw = null;
        try {
            bw = openLog();
            bw.write(mess);
            closeLog(bw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
