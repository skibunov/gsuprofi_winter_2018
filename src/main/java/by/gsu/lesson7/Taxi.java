package by.gsu.lesson7;

public class Taxi extends Auto<Taxi> {
    int passengers;

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
