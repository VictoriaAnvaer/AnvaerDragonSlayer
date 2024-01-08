//add room name
public class Room {
    static int ROOM_NUMBER = 0;
    private Dragon[] dragons;
    private boolean search;
    private int dragonNumber;



    Room() {
        ROOM_NUMBER++;
        search = false;
        dragonNumber = (int) (Math.random() * 3 + 1);
        dragons = new Dragon[dragonNumber];
        for (int i = 0; i < dragons.length; i++) {
            Dragon dragon = new Dragon();
            dragons[i] = dragon;
        }
    }

    public static int getRoomNumber() {
        return ROOM_NUMBER;
    }

    public void enterRoom(Player player) {
        System.out.println("Welcome to room number " + ROOM_NUMBER + player.getName() +
                            "! There are " + dragonNumber + " dragons in this room.");
    }

    public void roomMenu() {
        System.out.println("--ROOM NUMBER " + ROOM_NUMBER + "--");
        for (int i = 0; i < dragons.length; i++) {
            System.out.println("dragon " + (i + 1) + "- health: " + dragons[i].getHealth() + " level: " + dragons[i].getLevel());
        }
    }
    public void attack(Player player, int num) {
        dragons[num - 1].recieveAttack(player);
        player.recieveAttack(dragons[num - 1]);
    }

    public void search(Player player) {
        if (search == false) {
            if ((int) (Math.random() * 3 + 1 ) > 2) {
                System.out.println("You have recieved a health potion!");
                player.setHealthPot(true);
            } else {
                System.out.println("No health potions in this room.");
            }
            search = true;
        } else {
            System.out.println("You've already searched this room!");
        }
    }
}
