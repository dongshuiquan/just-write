package com.dsq.swing;

import javax.swing.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class ProgressMonitorExam {
    Timer timer;

    public void init() {
        SimulatedActivity target = new SimulatedActivity(100);
        Thread targetThread = new Thread(target);
        targetThread.start();
        ProgressMonitor dialog = new ProgressMonitor(null, "等待任务完成",
                "已完成", 0, target.getAmount());
        timer = new Timer(300, e -> {
            dialog.setProgress(target.getCurrent());
            if(dialog.isCanceled() || target.getCurrent() >= 100) {
                timer.stop();
                targetThread.interrupt();
//                System.exit(0);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new ProgressMonitorExam().init();
    }
}
