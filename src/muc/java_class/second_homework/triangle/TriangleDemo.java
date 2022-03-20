package muc.java_class.second_homework.triangle;

public class TriangleDemo {
    public static void main(String[] args) {
        //test makeTriangles
        Triangle.makeTriangles(2);

        //test Triangles
        Triangle triangle = new Triangle(6, 8, 10);
        System.out.println(triangle.toString());
    }
}
