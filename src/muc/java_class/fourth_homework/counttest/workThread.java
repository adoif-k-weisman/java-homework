package muc.java_class.fourth_homework.counttest;

//线程的内容
/*
2.Start Button首先是否有正在计数的work thread运行，如果有正在运行的work thread, 中断该thread的运行，
从零开始计数。Stop Button将会中断worker threads的运行。

一旦Worker Thread创建，立即从0开始计数到Text Field中输入的数，每数到10,000，Worker Thread会睡眠100 milliseconds，
 */
public class workThread extends Thread {
    private int i;
    int t;
    int temp;
    private boolean updateLabel;

    @Override
    public void run() {
        while (i >= 0) {
            t++;
            if (t % 10000 == 0)//考虑到程序直接计数过快
                i = i + 10;
            if (i % 10000 == 0 && i != 0) {
                temp = i;
//                returnflag(true);
                setUpdateLabel(true);
            }
            System.out.print("");
            if (this.currentThread().isInterrupted())
                break;
        }

    }

    public workThread() {
        i = 0;
        t = 0;
    }

    public boolean isUpdateLabel() {
        return updateLabel;
    }

    public void setUpdateLabel(boolean updateLabel) {
        this.updateLabel = updateLabel;
    }


    public void returnflag(boolean ret) {
        updateLabel = ret;
    }

    public boolean flagRe() {
        return updateLabel;
    }

    public boolean end(long num) {
        if (i >= num)
            return true;
        else
            return false;
    }

    public int returnI() {
        return temp;
    }

    //归零
    //如果有正在运行的work thread, 中断该thread的运行，
    //从零开始计数。
    public void fromZeroCount() {
        i = 0;
        t = 0;
    }
}
