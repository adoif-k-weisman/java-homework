package muc.java_class.second_homework.triangle;


/*
2. 创建一个名为Triangle的类，三角形三条边为数据成员，实现构造方法和toString()。
（1）实现一个无参数的triangleType()方法，返回一个String表示三角形的类型。
可能的返回值为：“Equilateral”，“Isosceles”, “Flat”,  “Scalene”, “RightAngled”,
在toString()方法中调用此方法，从而输出对象时能够反映出三角形类型。
（2)创建一个静态方法static void makeTriangles(int n)，打印出边长为1~n组合的所有三角形。

 */
public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle() {
        this.a = 1;
        this.b = 1;
        this.c = 1;
    }

    public String triangleType() {
        if (a + c <= b || a + b <= c || b + c <= a) {
            return "Flat";
        } else if (this.a == this.b && this.a == this.c) {
            return "Equilateral";
        } else if (this.a == this.b || this.a == this.c || this.b == this.c) {
            return "Isosceles";
        } else if ((a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a)) {
            return "RightAngled";
        } else {
            return "Scalene";
        }
        //Scalene ---不等边三角形
        //RightAngled  直角三角形
    }

    @Override
    public String toString() {
        return this.triangleType() + "(" + this.a + ", " + this.b + ", " + this.c + ")";
//        return "三角形的三边分别为：" + this.a + "," + this.b + "," + this.c + ",它是一个" + this.triangleType() + "三角形";
    }

    //（2)创建一个静态方法static void makeTriangles(int n)，打印出边长为1~n组合的所有三角形。
    public static void makeTriangles(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    System.out.println(new Triangle(i, j, k).toString());
                }
            }
        }
    }

}
