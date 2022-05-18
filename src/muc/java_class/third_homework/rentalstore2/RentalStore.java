package muc.java_class.third_homework.rentalstore2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/*
第二步: 实现RentalStore功能。两个连锁店各自有一定数量的车，车可以用数组定义。
租车店营业时间7:00~22:00,用String类型表示即可。补充代码完整，有的方法可能需要定义为static，不要更改main里的方法调用。
 */
public class RentalStore {
    //TO DO： Add the missing data members to this class, each rental store has number of cars.
    // TO DO： Add the missing implementation to this class
    private String address;
    private String telephone;
    //private Set<Car> garage = new HashSet<>();
    private HashSet<Car> garage = new HashSet<>();
    private static String openingHours = "7:00~22:00";

    public RentalStore(String address_, String telephone_) {
        this.address = address_;
        this.telephone = telephone_;
    }

    public RentalStore() {

    }

    public String getAddress() {
        return address;
    }

    public void addCar(Car newCar) {
        garage.add(newCar);
    }

    public static void printOpeningHours() {
        System.out.println(openingHours);
    }

    public static void main(String[] args) {

        // Create two chain stores with store address and contact phone number
        RentalStore firstStore = new RentalStore("100 Zhongguancun Ave.", "3455-5665");   //
        RentalStore secondStore = new RentalStore("228 minzu St.", "4567-5666");

        //TO DO：Add 4 cars  to the first store
        firstStore.addCar(new Car("Cadillac ", "2022-03-17"));
        firstStore.addCar(new Car("ford temple", "2022-01-01"));
        firstStore.addCar(new Car("Porsche", "2021-10-30"));
        firstStore.addCar(new Car("Toyota", "2022-02-22"));

        //use carId as identification to judge have or not
        //firstStore.addCar(new Car("Toyota", "2024-02-22"));
        //firstStore.printAvailableCars();

        //add 3 cars to the second store
        secondStore.addCar(new Car("HUMMER", "2021-04-03"));
        secondStore.addCar(new Car("Maybach", "2021-05-05"));
        secondStore.addCar(new Car("Lamborghini", "2021-06-01"));


        // Print store opening hours and the addresses
        System.out.println("store opening hours:");
        printOpeningHours();
        System.out.println("the store addresses:");
        firstStore.printAddress();
        secondStore.printAddress();
        System.out.println();

        // Try to rent car ford from the store
        System.out.println("renting a ford car...");
        firstStore.rentCar("ford temple");  //print out:You successfully rent the ford temple
        firstStore.rentCar("ford temple");//print out: Sorry, this car is already rented.
        secondStore.rentCar("ford temple");//print out: Sorry, this car is not available in our store
        System.out.println();

        // Print the all car IDs of all available cars from both stores
        System.out.println("Cars available in the first store:" + firstStore.getAddress());
        firstStore.printAvailableCars();
        System.out.println();
        System.out.println("Cars available in the second store:" + secondStore.getAddress());
        secondStore.printAvailableCars();
        System.out.println();

        //Return the car ford to the first store
        System.out.println("Returning the ford temple:");
        firstStore.returnCar("ford temple");
        System.out.println();

        // Print the car IDs of available cars from the first store
        System.out.println("Cars available in the first store:");
        firstStore.printAvailableCars();


    }

    //get car
    public Car getCar(String carID) {
        Iterator<Car> iterator = garage.iterator();

        for (Car car : garage) {
            if (carID.equals(car.getCarID())) {
                return car;
            }
        }
        /*
        while (iterator.hasNext()) {//下一位有元素
            if (carID.hashCode() == iterator.hashCode()) {
                Car a = (Car) iterator;
            }
            return true;
        }
        */
        return null;
    }

    public void rentCar(String carId) {
        Car car_ = getCar(carId);//get change object
        if (car_ != null) {
            if (!car_.isRented()) {
                Date nowTime = new Date();//get now time
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// Set formatting date
                String rentTime = sdf.format(nowTime);//format date
                //change info
                garage.remove(car_);
                car_.rented(rentTime);
                garage.add(car_);

                System.out.println("You successfully rent the " + carId);
            } else {
                System.out.println("Sorry, this car is already rented.");
            }
            return;
        }
        System.out.println("Sorry, this car is not available in our store");
    }


    public void printAddress() {
        System.out.println(address);
    }

    public void returnCar(String carId) {
        Car car_ = getCar(carId);//get change object

        if (car_ != null) {
            if (car_.isRented()) {// rented
                Date nowTime = new Date();//get now time
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// Set formatting date
                String rentTime = sdf.format(nowTime);//format date

                garage.remove(car_);
                car_.returned(rentTime);
                garage.add(car_);

                System.out.println("You successfully return the " + carId);
                System.out.println(car_.toString());
            } else {
                System.out.println("Sorry, this car is available in our store. No need to return it");
                System.out.println("maybe your input CarId is wrong.");
            }
            return;
        }
        System.out.println("Sorry, this car is not available in our store");
    }

    public void printAvailableCars() {
        for (Car car : garage) {
            if (!car.isRented()) {
                System.out.println(car.toString());
            }
        }
    }

}
