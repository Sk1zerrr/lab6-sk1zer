package ua.opnu.list.task3;

interface GPS { double[] getCoordinates(); }
interface Cellular { void makeCall(); void receiveCall(); }

public class Smartphone implements GPS, Cellular {
    private double latitude, longitude;

    public Smartphone(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double[] getCoordinates() { return new double[]{latitude, longitude}; }
    public void makeCall() { System.out.println("Dialing..."); }
    public void receiveCall() { System.out.println("Incoming call!"); }

    public static void main(String[] args) {
        Smartphone phone = new Smartphone(49.83, 24.03);
        phone.makeCall();
        phone.receiveCall();
        System.out.println("Coords: " + phone.getCoordinates()[0] + ", " + phone.getCoordinates()[1]);
    }
}
