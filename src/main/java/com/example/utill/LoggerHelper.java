package com.example.utill;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.Level;

public abstract class LoggerHelper {
    public static void exceptionsLogger (Class c, Exception e) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm");
        Logger logger = Logger.getLogger(c.getName());
        try {
            Handler handler = new FileHandler("logs/logger" + dateFormat.format(new Date())+ ".log");
            logger.addHandler(handler);
            logger.log(Level.SEVERE, e.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
