public class Main {
    public static void main(String[] args) {
        RoomService<Room> service = new RoomServiceImpl();

        Room economy = new EconomyRoom(101, 2000, false);
        Room standard = new StandardRoom(202, 3500, false);
        Room lux = new LuxRoom(303, 6000, true);
        Room ultra = new UltraLuxRoom(404, 12000, true);

        service.reserve(economy);
        service.reserve(standard);
        try {
            service.reserve(economy);
        } catch (RoomAlreadyBookedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        service.free(standard);
        service.reserve(standard);
        service.clean(economy);

        System.out.println("\nСостояние комнат:");
        System.out.println(economy);
        System.out.println(standard);
        System.out.println(lux);
        System.out.println(ultra);
    }
}