import java.util.*;

public abstract class Room {
    protected int roomNumber;
    protected int maxPeople;
    protected int pricePerNight;
    protected boolean isBooked;

    public Room(int roomNumber, int pricePerNight, boolean isBooked) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.isBooked = isBooked;
        maxPeople = new Random().nextInt(1, 6);
    }
    public int getRoomNumber() { return roomNumber; }
    public int getMaxPeople() { return maxPeople; }
    public int getPricePerNight() { return pricePerNight; }
    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean booked) { isBooked = booked; }

    @Override
    public String toString() {
        return String.format("Room #%d (%d чел, %d руб/ночь, забронирована: %s)",
                roomNumber, maxPeople, pricePerNight, isBooked);
    }
}
