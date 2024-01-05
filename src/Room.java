public class Room {
    static int ROOM_NUMBER = 0;
    private Dragon d1;
    private Dragon d2;
    private Dragon d3;
    private boolean search;
    private int dragonNumber;



    Room() {
        ROOM_NUMBER++;
        Dragon d1 = new Dragon((int) (Math.random() * 5 + 1));
        Dragon d2 = new Dragon((int) (Math.random() * 5 + 1));
        Dragon d3 = new Dragon((int) (Math.random() * 5 + 1));
        search = false;
        dragonNumber = (int) (Math.random() * 3 + 1);

    }

    public static int getRoomNumber() {
        return ROOM_NUMBER;
    }

    public void enterRoom(Player player) {
    }

    public void search(Player player) {
        if (search == false) {
            if ((int) (Math.random() * 3 + 1 ) > 2) {
                System.out.println("You have recieved a health potion!");
                player.setHealthPot(true);
            }
            System.out.println("No health potions in this room.")
        } else {
            System.out.println("You've already searched this room!");
        }
    }
}
