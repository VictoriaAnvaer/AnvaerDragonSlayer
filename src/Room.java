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

    public boolean dragonSlain() {
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
            if (dragons[i] == null) {
                System.out.println("\uD83D\uDC09 dragon " + (i + 1) + "- SLAIN");
            } else {
                System.out.println("\uD83D\uDC09 dragon " + (i + 1) + "- level: " + dragons[i].getLevel() + " health: " + dragons[i].getHealth());
            }
        }
    }
    public void attack(Player player, int num) {
        dragons[num - 1].recieveAttack(player);
        player.recieveAttack(dragons[num - 1]);
        if (dragons[num - 1].getHealth() <= 0) {
            System.out.println("Dragon has been slain!");
            dragons[num - 1].dragonSlain(player);
            dragons[num - 1] = null;
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
