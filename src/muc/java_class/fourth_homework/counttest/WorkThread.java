package muc.java_class.fourth_homework.counttest;

//线程的内容
/*
2.Start Button首先是否有正在计数的work thread运行，如果有正在运行的work thread, 中断该thread的运行，
从零开始计数。Stop Button将会中断worker threads的运行。

一旦Worker Thread创建，立即从0开始计数到Text Field中输入的数，每数到10,000，Worker Thread会睡眠100 milliseconds，
 */
public class WorkThread extends Thread {
    private int slowNum;
    private int fastNum;
    private int tempNum;
    private boolean updateLabel;

    @Override
    public void run() {
        while (slowNum >= 0) {
            fastNum++;
            if (fastNum % 10000 == 0)//考虑到程序直接计数过快
                slowNum = slowNum + 10;
            if (slowNum % 10000 == 0 && slowNum != 0) {
                tempNum = slowNum;
                setUpdateLabel(true);
            }
            System.out.print("");
            if (this.currentThread().isInterrupted())
                break;
        }

    }

    public WorkThread() {
        slowNum = 0;
        fastNum = 0;
    }

    public boolean isUpdateLabel() {
        return updateLabel;
    }

    public void setUpdateLabel(boolean updateLabel) {
        this.updateLabel = updateLabel;
    }


    public boolean end(long num) {
        if (slowNum >= num)
            return true;
        else
            return false;
    }

    public int getCurNum() {
        return tempNum;
    }

    //归零
    //如果有正在运行的work thread, 中断该thread的运行，
    //从零开始计数。
    public void fromZeroCount() {
        slowNum = 0;
        fastNum = 0;
    }
}
