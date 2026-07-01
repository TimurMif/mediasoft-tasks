public class RoomServiceImpl implements RoomService<Room> {
    @Override
    public void clean(Room room) {
        System.out.println("Комната " + room.getRoomNumber() + " убрана.");
    }

    @Override
    public void reserve(Room room) {
        if (room.isBooked()) {
            throw new RoomAlreadyBookedException("Комната " + room.getRoomNumber() + " уже забронирована!");
        }
        room.setBooked(true);
        System.out.println("Комната " + room.getRoomNumber() + " забронирована.");
    }

    @Override
    public void free(Room room) {
        if (!room.isBooked()) {
            System.out.println("Комната " + room.getRoomNumber() + " уже свободна.");
            return;
        }
        room.setBooked(false);
        System.out.println("Комната " + room.getRoomNumber() + " освобождена.");
    }
}