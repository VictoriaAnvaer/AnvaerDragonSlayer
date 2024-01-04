public class Room {
    static int ROOM_NUMBER = 0;
    private Dragon dragon;

    Room() {
        ROOM_NUMBER++;
        Dragon dragon = new Dragon(1);
    }
}
