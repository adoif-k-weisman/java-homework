package muc.java_class.fourth_homework.counttest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class JCount extends JPanel {
    private workThread oneCountThread;
    static int programRunning;
    private JButton start;
    private JButton stop;
    private JTextField numTxt;//input num
    private JLabel numLabel;// show num when stop
    public static JPanel panel;// panel to panel  避免布局重复
    public static JFrame frame; //
    int oneCountRunning = 0;

    //初始化 jcount 面板
    //创建每个部分的线程
    public JCount() {

        oneCountThread = new workThread();
        programRunning = 0;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        start = new JButton("start");
        start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startBtnHandler();
            }
        });
        stop = new JButton("stop");
        stop.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopBtnHandler();
            }
        });
        numTxt = new JTextField(10);
        numLabel = new JLabel(String.valueOf(0));
        add(numTxt);
        add(numLabel);
        add(start);
        add(stop);
        add(Box.createRigidArea(new Dimension(0, 40)));
        panel.add(this);
    }


    public void startBtnHandler() {
        if (oneCountThread.isAlive() || oneCountThread.isInterrupted()) {//如果线程还存在，就归零
            oneCountThread.fromZeroCount();
        } else if (!"".equals(numTxt.getText().trim()) && numTxt.getText() != null) {//第一次开始计数
            if (Integer.parseInt(numTxt.getText()) > 0) {
                oneCountThread.start();

            }
            programRunning = 1;
        }
        oneCountRunning = 1;
    }

    //已经计数到了输入的数字
    public void endCount() throws InterruptedException {
        if (oneCountThread.end(Integer.parseInt(numTxt.getText()))) {
//        if (oneCountThread.end(Long.getLong(numTxt.getText()))) {
            oneCountThread.interrupt();
//            programRunning += 1;
            oneCountRunning = 0;
        }
    }

    //每数到10,000，Worker Thread会睡眠100 milliseconds
    public void countSleep() {
//        if (oneCountThread.flagRe()) {
        if (oneCountThread.isUpdateLabel()) {
            try {
                oneCountThread.sleep(100);
                numLabel.setText(String.valueOf(oneCountThread.returnI()));//更新Label数字
                programRunning = 1;
//                oneCountThread.returnflag(false);
                oneCountThread.setUpdateLabel(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //stopBtn---> 中断
    public void stopBtnHandler() {
        if (oneCountThread.isAlive()) {
            oneCountThread.interrupt();
        }
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Count");
        frame.setBounds(550, 50, 200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    }

    public static void main(String[] args) throws InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        //初始化 frame
        JCount count1 = new JCount();
        panel.add(count1);
        JCount count2 = new JCount();

        panel.add(count2);
        JCount count3 = new JCount();
        panel.add(count3);
        JCount count4 = new JCount();
        panel.add(count4);
        frame.add(panel);
        frame.setVisible(true);
        //
        while (true) {
            System.out.print("");
            if (count1.oneCountRunning == 1) {
                count1.countSleep();
                count1.endCount();
            }
            if (count2.oneCountRunning == 1) {
                count2.countSleep();
                count2.endCount();
            }
            if (count3.oneCountRunning == 1) {
                count3.countSleep();
                count3.endCount();
            }
            if (count4.oneCountRunning == 1) {
                count4.countSleep();
                count4.endCount();
            }
            /*//四个都以计数完成，释放资源，退出来
            if (count1.flag_ == 0 && count2.flag_ == 0 && count3.flag_ == 0 && count4.flag_ == 0) {
                Thread.sleep(1000);
                frame.setVisible(false);
                frame.dispose();
            }*/
            /*if (countRunning == 1) {
                frame.setVisible(true);
            }*/
        }
    }
}

