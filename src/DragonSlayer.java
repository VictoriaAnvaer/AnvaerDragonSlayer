import java.util.Scanner;
public class DragonSlayer {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Player player;
    private Room room;

    public void play() {
        mainMenu();
        player = null;
    }

    public void mainMenu() {
        System.out.println("--MAIN MENU--");
        System.out.println("1. Start New Game");
        System.out.println("2. View Game Information");
        System.out.println("3. View Top Score");
        System.out.println("4. Quit");
        int option = SCANNER.nextInt();
        SCANNER.nextLine();
        if (option == 1) {
            Menu();
        } else if (option == 2) {

        } else if (option == 3) {

        } else if (option == 4) {
            System.out.println("Thank you for playing.");
        }
    }
    public void Menu() {
        System.out.print("Enter your name: ");
        String name = SCANNER.nextLine();
        Player player = new Player(name);
        Room room = new Room();
        while (Room.getRoomNumber() < 6 || player.getHealth() > 0) { //edit while loop later
            room.roomMenu();
            player.playerMenu();
            System.out.println("--MENU--");
            System.out.println("1. Upgrades and Powerups");
            System.out.println("2. Search room");
            System.out.println("3. Use health pot");
            System.out.println("4. Attack dragon");
            System.out.println("5. Inspect player information");
            int option = SCANNER.nextInt();
            SCANNER.nextLine();
            if (option == 1) {
                player.upgrade();
            } else if (option == 2) {
                room.search(player);
            } else if (option == 3) {
                player.useHealthPot();
            } else if (option == 4) {
                System.out.print("Dragon you would like to attack: ");
                int dragonAttack = SCANNER.nextInt();
                room.attack(player, dragonAttack);
                if (room.dragonSlain()) {
                    System.out.println("All dragons defeated.");
                    room = new Room();
                }
            } else if (option == 5) {
                System.out.println(player.info());
            }
        }
        gameEnd();
    }
    public void gameEnd() {
        System.out.println("Game end");
        // add results of win/loss later
        mainMenu();
    }
}
