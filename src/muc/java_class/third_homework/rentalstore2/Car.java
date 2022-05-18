package muc.java_class.third_homework.rentalstore2;

import java.util.Objects;

//没写完
public class Car {
    private String CarID;
    private String date;
    private boolean rented;

    // construcor: Creates a new car with entry date
    public Car(String Id, String entryDate) {
        // Implement this method
        this.CarID = Id;
        this.date = entryDate;
        this.rented = false;
    }

    // Marks the car as rented and updates the date to rented date
    public void rented(String rentedDate) {
        // Implement this method
        rented = true;
        date = rentedDate;
    }

    // Marks the car as not rented and updates the returned date
    public void returned(String rtnDate) {
        // Implement this method
        rented = false;
        date = rtnDate;
    }

    // check the car rental status,Returns true if it is rented, false otherwise
    public boolean isRented() {
        // Implement this method
        if (this.rented == true)
            return true;
        return false;
    }

    public void showRentStatus() {
        boolean flag = this.isRented();
        if (flag) {
            System.out.println("Car：" + this.getCarID() + " is rented at date:" + this.getDate());
        } else {
            System.out.println("Car：" + this.getCarID() + " is not rented");
            System.out.println("The last rental return time at date:" + this.getDate());
        }
    }

    // Returns the car ID
    public String getCarID() {
        // Implement this method
        //return null;
        return this.CarID;
    }

    //Returns the date of the car
    public String getDate() {
        // Implement this method
        return date;
    }

    @Override
    public String toString() {
        String info = "CarID: " + CarID + " , Rent date " + date + " , is";
        if (this.rented == true)
            info += " rented";
        else
            info += " not rented";
        return info;
    }

    //重写的必要？
    //carID就是唯一标识
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
//        return rented == car.rented && Objects.equals(CarID, car.CarID) && Objects.equals(date, car.date);
        return Objects.equals(CarID, car.CarID);

    }


    @Override
    public int hashCode() {
        return Objects.hash(CarID);
    }

    public static void main(String[] args) {
        // Small test
        Car coco = new Car("The Da Vinci Code", "2021-01-19");
        //TO DO
        //print out coco info
        System.out.println(coco.toString());
        //check and print out coco rental status
        coco.showRentStatus();
        //rent coco
        coco.rented("2022-03-18");
        //check coco current status and rental date
        coco.showRentStatus();
        //return coco
        coco.returned("2022-04-18");
        //check and print out coco status and return date
        coco.showRentStatus();
    }
}
/*
某租车行有两个连锁店，可提供租车，还车功能。根据提供的两个类代码框架，Car和RentalStore，补充完整代码，实现功能。
*（10）第一步: 实现 Car:补充代码完整，并创建几个Car对象验证。
**（10%）第二步: 实现RentalStore功能。两个连锁店各自有一定数量的车，车可以用数组定义。
租车店营业时间7:00~22:00,用String类型表示即可。补充代码完整，有的方法可能需要定义为static，不要更改main里的方法调用。
 */
