//add room name
public class Room {
    private static int ROOM_NUMBER = 0;
    private Dragon[] dragons;
    private boolean search;
    private int dragonNumber;
    private String roomName;

    Room() {
        ROOM_NUMBER++;
        search = false;
        dragonNumber = (int) (Math.random() * 3 + 1);
        dragons = new Dragon[dragonNumber];
        for (int i = 0; i < dragons.length; i++) {
            Dragon dragon = new Dragon();
            dragons[i] = dragon;
        }
        // sets name of room based on the room position
        if (ROOM_NUMBER == 1) {
            roomName = "The Stone Walls";
        } else if (ROOM_NUMBER == 2) {
            roomName = "The Corridor";
        } else if (ROOM_NUMBER == 3) {
            roomName = "The Treasury";
        } else if (ROOM_NUMBER == 4) {
            roomName = "The Hatching Inferno";
        } else {
            roomName = "The Den";
        }
    }

    public static int getRoomNumber() {
        return ROOM_NUMBER;
    }

    public static void resetRoomNumber() {
        ROOM_NUMBER = 0;
    }

    public boolean dragonSlain() { // checks if all dragons are slain by checking if all dragons in array are null
        for (int i = 0; i < dragons.length; i++) {
            if (dragons[i] != null) {
                return false;
            }
        }
        return true;
    }

    public void roomMenu() {
        System.out.println(ConsoleUtility.PURPLE + "--" + ROOM_NUMBER + ": " + roomName + "--" + ConsoleUtility.RESET);
        for (int i = 0; i < dragons.length; i++) {
            if (dragons[i] == null) { //checks if dragon is null first - otherwise there will be an error + to display slain dragons as null
                System.out.println("\uD83D\uDC09 dragon " + (i + 1) + "- SLAIN");
            } else {
                System.out.println("\uD83D\uDC09 dragon " + (i + 1) + "- level: " + dragons[i].getLevel() + " health: " + dragons[i].getHealth());
            }
        }
    }
    public void attack(Player player, int num) {
        dragons[num - 1].recieveAttack(player);
        ConsoleUtility.pause();
        if (dragons[num - 1].getHealth() <=0) { // ensures that the dragon only attacks the player if the player had not slain it
            player.recieveAttack(dragons[num - 1]);
        } else {
            System.out.println(ConsoleUtility.RED + "Dragon has been slain!" + ConsoleUtility.RESET);
            dragons[num - 1].dragonSlain(player);
            dragons[num - 1] = null; //sets dragon to null when they are slain so that displaying menu is easier
        }
    }

    public void search(Player player) {
        if (search == false) {
            if ((int) (Math.random() * 3 + 1 ) > 1) {
                System.out.println("You have recieved a health potion!");
                player.setHealthPot(true);
            } else {
                System.out.println(ConsoleUtility.RED + "No" + ConsoleUtility.RESET + " health potions in this room.");
            }
            search = true;
        } else {
            System.out.println("You've already searched this room!");
        }
    }
}
