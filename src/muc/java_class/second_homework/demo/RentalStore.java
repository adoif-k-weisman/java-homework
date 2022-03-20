package muc.java_class.second_homework.demo;

public class RentalStore {

    //TO DO： Add the missing data members to this class, each rental store has number of cars.
    private int CarsNum;
    private Car[] OwnCars;
    private String tel;
    private String address;
    static String OpenTime;

    // TO DO： Add the missing implementation to this class
    public RentalStore(String name_num, String tel_) {
        OpenTime = "7:00~22:00";
        this.tel = tel_;
        this.CarsNum = Integer.parseInt(name_num.substring(0, name_num.indexOf(' ')));
        this.address = name_num.substring(name_num.indexOf(' ')).trim();
        //Car[] OwnCars_ = new Car[this.CarsNum];
        //OwnCars = Arrays.copyOf(OwnCars_, this.CarsNum);
        OwnCars = new Car[this.CarsNum];
        //OwnCars_ = null;
    }

    public void addCar(Car p) {
        if (OwnCars[this.CarsNum - 1] != null)
            System.out.println("Our cars are full");
        for (int i = 0; i < this.OwnCars.length; i++) {
            if (OwnCars[i] == null) {
                OwnCars[i] = new Car(p.CarID, p.date);
                break;
            }
        }
    }

    static void printOpeningHours() {
        System.out.println(OpenTime);
    }

    public void printAddress() {
        System.out.println(this.address);
    }

    public void rentCar(String CarName, String RentTime) {
        int flag = 0;
        for (int i = 0; i < this.CarsNum; i++) {
            if (this.OwnCars[i] == null) break;
            if (this.OwnCars[i].CarID.equals(CarName)) {
                if (!this.OwnCars[i].isRented()) {
                    this.OwnCars[i].rented(RentTime);
                    System.out.println("You successfully rent the ford temple");
                    flag = 1;
                    break;
                } else {
                    System.out.println("Sorry, this car is already rented.");
                    flag = 1;
                    break;
                }
            }
        }
        if (flag == 0)
            System.out.println("Sorry, this car is not available in our store");
    }

    public void printAvailableCars() {
        int flag = 0;
        for (int i = 0; this.OwnCars[i] != null; i++) {
            if (!this.OwnCars[i].isRented()) {
                System.out.println(this.OwnCars[i].CarID);
                flag = 1;
            }
        }
        if (flag == 0)
            System.out.println("没有车可用");
    }

    public void returnCar(String name, String data) {
        int flag = 0;
        for (int i = 0; this.OwnCars[i] != null; i++) {
            if (this.OwnCars[i].getCarID().equals(name) && this.OwnCars[i].isRented()) {
                this.OwnCars[i].returned(data);
                System.out.println("return successfully");
                flag = 1;
                break;
            }
        }
        if (flag == 0)
            System.out.println("return failed");
    }

    public static void main(String[] args) {

        // Create two chain stores with store address and contact phone number
        RentalStore firstStore = new RentalStore("100 Zhongguancun Ave.", "3455-5665");   //
        RentalStore secondStore = new RentalStore("228 minzu St.", "4567-5666");

        //TO DO：Add 4 cars  to the first store
        firstStore.addCar(new Car("ford temple", "2020-01-01"));
        firstStore.addCar(new Car("two", "2020-02-02"));
        firstStore.addCar(new Car("three", "2020-03-03"));
        firstStore.addCar(new Car("four", "2020-04-04"));

        // Print store opening hours and the addresses
        System.out.println("store opening hours:");
        printOpeningHours();
        System.out.println("store addresses:");
        firstStore.printAddress();
        secondStore.printAddress();
        System.out.println();

        // Try to rent car ford from the store
        System.out.println("renting a ford car...");
        firstStore.rentCar("ford temple", "2020-09-09");  //print out:You successfully rent the ford temple
        firstStore.rentCar("ford temple", "2020-09-09");//print out: Sorry, this car is already rented.
        secondStore.rentCar("ford temple", "2020-09-09");//print out: Sorry, this car is not available in our store
        System.out.println();

        // Print the all car IDs of all available cars from both stores
        System.out.println("Cars available in the first store:");
        firstStore.printAvailableCars();
        System.out.println();
        System.out.println("Cars available in the second store:");
        secondStore.printAvailableCars();
        System.out.println();

//Return the car ford to the first store
        System.out.println("Returning the ford temple:");
        firstStore.returnCar("ford temple", "2022-02-22");
        System.out.println();

// Print the car IDs of available cars from the first store
        System.out.println("Cars available in the first store:");
        firstStore.printAvailableCars();
    }
}