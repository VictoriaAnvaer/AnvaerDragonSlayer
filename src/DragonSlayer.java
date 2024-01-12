import java.util.Scanner;
public class DragonSlayer {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Player player;
    private Room room;
    private Shop shop;

    public void play() {
        mainMenu();
        player = null;
        room = null;
        shop = null;
    }

    public void mainMenu() {
        System.out.println(ConsoleUtility.PURPLE + "--MAIN MENU--" + ConsoleUtility.RESET);
        System.out.println("1. Start New Game");
        System.out.println("2. View Game Information");
        System.out.println("3. View Top Score");
        System.out.println("4. " + ConsoleUtility.RED + "Quit" + ConsoleUtility.RESET);
        int option = SCANNER.nextInt();
        SCANNER.nextLine();
        ConsoleUtility.clearScreen();
        if (option == 1) {
            Menu();
        } else if (option == 2) {
            SCANNER.nextLine();
            mainMenu();
        } else if (option == 3) {
            System.out.println("The current top score is " + Player.getHIGHSCORE() + ConsoleUtility.YELLOW + " gold" + ConsoleUtility.RESET);
            SCANNER.nextLine();
            mainMenu();
        } else if (option == 4) {
            System.out.println("Thank you for playing.");
        }
    }
    public void Menu() {
        System.out.print("Enter your name: ");
        String name = SCANNER.nextLine();
        Player player = new Player(name);
        Room room = new Room();
        Shop shop = new Shop();
        while (Room.getRoomNumber() < 6 && player.getHealth() > 0) {
            ConsoleUtility.clearScreen();
            room.roomMenu();
            player.playerMenu();
            System.out.println(ConsoleUtility.PURPLE + "--MENU--" + ConsoleUtility.RESET);
            System.out.println("1. Upgrades and Powerups");
            System.out.println("2. Search room");
            System.out.println("3. Use health pot");
            System.out.println("4." + ConsoleUtility.RED + " Attack dragon" + ConsoleUtility.RESET);
            System.out.println("5. Inspect player information");
            int option = SCANNER.nextInt();
            SCANNER.nextLine();
            ConsoleUtility.clearScreen();
            if (option == 1) {
                shop.shop();
                System.out.print("Select an option: ");
                int item = SCANNER.nextInt();
                shop.selection(player, item);
                SCANNER.nextLine();
            } else if (option == 2) {
                room.search(player);
            } else if (option == 3) {
                player.useHealthPot();
            } else if (option == 4) {
                room.roomMenu();
                player.playerMenu();
                System.out.print(ConsoleUtility.PURPLE + "-------------------" + ConsoleUtility.RESET + "\nDragon you would like to attack: ");
                int dragonAttack = SCANNER.nextInt();
                room.attack(player, dragonAttack);
                if (room.dragonSlain()) {
                    System.out.println(ConsoleUtility.RED + "All dragons defeated." + ConsoleUtility.RESET);
                    room = new Room();
                }
                SCANNER.nextLine();
            } else if (option == 5) {
                System.out.println(player.info());
            }
            SCANNER.nextLine();
        }
        gameEnd();
    }
    public void gameEnd() {
        ConsoleUtility.clearScreen();
        if (player.getHealth() <= 0) {
            System.out.print("You have died! ");
        } else {
            player.calculateHighScore();
            System.out.print("You have defeated all the dragons in all the rooms! ");
        }
        System.out.println("Game end");
        Room.resetRoomNumber();
        // add results of win/loss later
        mainMenu();
    }
}
