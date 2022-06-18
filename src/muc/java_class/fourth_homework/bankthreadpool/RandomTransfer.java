package muc.java_class.fourth_homework.bankthreadpool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//生成转账记录写入文件
public class RandomTransfer {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        BufferedWriter bw = new BufferedWriter(new FileWriter("Transfer_record.txt"));
        int cnt = random.nextInt(100, 200);
        System.out.println("准备写入" + cnt + "次转账记录!");
        while (cnt > 0) {
            int from = random.nextInt(1, 21);
            int to = random.nextInt(1, 21);
            if (from == to) {//无效数据
                continue;
            }
            int amount = random.nextInt(1, 100) * 100;
            //以字符串形式写入
            bw.write(from + " ");
            //bw.write(" ");
            bw.write(to + " ");
            //bw.write(" ");
            bw.write(amount + "\r\n");
            //bw.write("\r\n");
            // bw.flush();
            cnt--;
        }
        //写入表示转账结束的信息
        bw.write(-1 + " " + 0 + " " + 0);
        bw.close();

        System.out.println("写入转账记录成功");

        /*//读取数据
        BufferedReader br = new BufferedReader(new FileReader("Transfer_record.txt"));


        String line = br.readLine();
        System.out.println("读取到的数据:" + line);
        br.close();
        //对读取到的字符进行切割
        String[] s = line.split(" ");
        //把字符数组转化成int数组
        int[] nums = new int[s.length];
        //遍历s数组进行数据转换
        for (int i = 0; i < s.length; i++) {
            int n = Integer.parseInt(s[i]);
            nums[i] = n;
        }

        Arrays.sort(nums);
        System.out.println("排序后的数据:" + Arrays.toString(nums));*/
    }
}
