package su.nsk.comptech.recreation.api;

import su.nsk.comptech.recreation.api.Drawer.DrawerService;
import su.nsk.comptech.recreation.api.services.PredictionService;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

public class ActualizeResponseDataJob extends TimerTask {

    @Override
    public void run() {
        System.out.println("TimerTask начал свое выполнение в:" + new Date());
        completeTask();
        System.out.println("TimerTask закончил свое выполнение в:" + new Date());
    }

    private void completeTask() {
        try {
            // допустим, выполнение займет 20 секунд
            System.out.println("drawing started");
            List<Integer> list = new ArrayList<Integer>();
            list.add(3);
            list.add(4);
            DrawerService.colorizeBuilding(list);
            System.out.println("drawing ended");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ex(){
        TimerTask timerTask = new ActualizeResponseDataJob();
        // стартуем TimerTask в виде демона

        Timer timer = new Timer(true);
        // будем запускать каждых 10 секунд (10 * 1000 миллисекунд)
        timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
        System.out.println("TimerTask начал выполнение");

        // вызываем cancel() через какое-то время
        /*try {
            Thread.sleep(120000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        PredictionService predictionService = new PredictionService();
        predictionService.getDataPredication();
        timer.cancel();
        System.out.println("TimerTask прекращена");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}