package ua.opnu.list.task4;

public class Car implements Comparable {
    private int price, year, horsePower;

    public Car(int price, int year, int horsePower) {
        this.price = price;
        this.year = year;
        this.horsePower = horsePower;
    }

    public int getPrice() { return price; }
    public int getYear() { return year; }
    public int getHorsePower() { return horsePower; }

    @Override
    public int compareTo(Object o) {
        Car other = (Car) o;
        if (this.price != other.price) return this.price < other.price ? 1 : -1;
        if (this.year != other.year) return this.year > other.year ? 1 : -1;
        if (this.horsePower != other.horsePower) return this.horsePower > other.horsePower ? 1 : -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Car{price=" + price + ", year=" + year + ", hp=" + horsePower + "}";
    }

    public static void main(String[] args) {
        Car[] cars = {
            new Car(10000, 2015, 120),
            new Car(12000, 2018, 140),
            new Car(10000, 2016, 130)
        };
        java.util.Arrays.sort(cars);
        for (Car c : cars) System.out.println(c);
    }
}
