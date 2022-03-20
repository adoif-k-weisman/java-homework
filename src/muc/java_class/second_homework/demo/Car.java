package muc.java_class.second_homework.demo;

public class Car {
    String CarID;
    String date;
    boolean rented;//以默认值false为未租借

    // constructor: Creates a new car with entry date
    public Car(String Id, String entryDate) {
        // Implement this method
        this.CarID = Id;
        this.date = entryDate;
    }

    public Car() {

    }

    // Marks the car as rented and updates the date to rented date
    public void rented(String rentedDate) {
        // Implement this method
        this.date = rentedDate;
        this.rented = true;
    }

    // Marks the car as not rented and updates the returned date
    public void returned(String rtnDate) {
        // Implement this method
        this.date = rtnDate;
        this.rented = false;
    }

    // check the car rental status,Returns true if it is rented, false otherwise
    public boolean isRented() {
        // Implement this method
        if (this.rented == true)
            return true;
        else
            return false;
    }

    // Returns the car ID
    public String getCarID() {
        // Implement this method
        if (this.CarID != null)
            return this.CarID;
        else
            return null;
    }

    //Returns the date of the car
    public String getDate() {
        // Implement this method
        return this.date;
    }

    public static void main(String[] args) {
        // Small test
        Car coco = new Car("The Da Vinci Code", "2021-01-19");
        //TO DO
        //print out coco info
        System.out.println("Id:" + coco.getCarID() + ",Date:" + coco.getDate() + ",Isrented:" + (coco.isRented() ? "已租借" : "未租借"));
        //check and print out coco rental status
        System.out.println("该汽车租借状态为：" + (coco.isRented() ? "已租借" : "未租借"));
        //rent coco
        coco.rented("2022-03-15");
        //check coco current status and rental date
        System.out.println("租借日期为：" + (coco.isRented() ? coco.getDate() : ""));
        //return coco
        coco.returned("2024-02-30");
        //check and print out coco status and return date
        System.out.println("该汽车归还日期为：" + (coco.isRented() ? "" : coco.getDate()));
    }
}