package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class MainScreenController {

    public Label footer;

    public void initialize(){
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date.toString());
//        footer.setText(date.toString());
        System.out.println("asd");
        Runnable rTimeUpdate = () -> {
            try {
                timeUpdate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        // Run the task in a background thread
        Thread backgroundThread = new Thread(rTimeUpdate);
        // Terminate the running thread if the application exits
        backgroundThread.setDaemon(true);
        // Start the thread
        backgroundThread.start();

        Connection connection;

        DBCon dbHandler = new DBCon();

        connection = dbHandler.Connect();

        try {
            if (!connection.isClosed()){
                System.out.println("opened");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void timeUpdate() throws InterruptedException {
        while (true){
            SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date distDate = new Date();
            try {
                distDate = Date.from(sdate.parse("2018-11-26 6:00").toInstant());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date date = new Date();
            Date finalDistDate = distDate;
            long mills = distDate.getTime() - date.getTime();
            long days = mills/1000/60/60/24%365;
            long hours = mills/1000/60/60%24;
            long mins = mills/1000/60%60;
            String lasts = days + " дней " + hours + " часов " + mins + " минут до старта World Skills Russia" ;
            Runnable run = () -> {
                footer.setText(lasts);
            };
            Platform.runLater(run);
            Thread.sleep(1000);
        }
    }
}
