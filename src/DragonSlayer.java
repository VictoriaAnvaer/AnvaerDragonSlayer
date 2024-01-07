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

        }
    }

    public void Menu() {
        System.out.print("Enter your name: ");
        String name = SCANNER.nextLine();
        Player player = new Player(name);
        Room room = new Room();
        while (player.getHealth() > 0 && Room.getRoomNumber() < 6) {
            room.roomMenu();
            player.playerMenu();
            System.out.println("--MENU--");
            System.out.println("1. Enter next room");
            System.out.println("2. Search room");
            System.out.println("3. Use health pot");
            System.out.println("4. Attack dragon");
            System.out.println("5. Inspect dragon level");
            System.out.println("6. Inspect player information");
            System.out.println("7. Upgrades and Powerups");
            int option = SCANNER.nextInt();
            SCANNER.nextLine();
            //ConsoleUtility.clearScreen();
            if (option == 1) {
            } else if (option == 2) {
            } else if (option == 3) {
            } else if (option == 4) {
            } else if (option == 5) {
            } else if (option == 6) {
                System.out.println(player.info());
            } else if (option == 7) {

            }
        }
    }
}
