public class Dragon {
    private int health;
    private int level;
    Dragon() {
        health = 100;
        level = (int) (Math.random() * 3 + 1);
    }
    public int getHealth() {
        return health;
    }
    public int getLevel() {
        return level;
    }
    public int attack() {
        return ((int) (Math.random() * 5 + 5)) * level;
    }
    public void recieveAttack(Player player) {
        if (((int) (Math.random() * 100 + 1)) > level * 20) {
            int attack = player.attack();
            health-=attack;
            System.out.println("Player attacks dragon for " + attack + " health");
        } else {
            System.out.println("Player attack has missed!");
        }
    }
    public void dragonSlain(Player player) { // random power up for player when they slay a dragon
        int drop = (int) (Math.random() * 4 + 1);
        if (drop == 1) {
            System.out.println(ConsoleUtility.YELLOW + "Dragon dropped gold!" + ConsoleUtility.RESET);
            player.addGold(level * 20);
        } else if (drop == 2) {
            System.out.println(ConsoleUtility.CYAN + "Dragon dropped a sword upgrade!" + ConsoleUtility.RESET);
            (player.getSword()).setAttack(5);
            (player.getSword()).setDodge(5);
        } else if (drop == 3) {
            player.addHealth(20);
            System.out.println(ConsoleUtility.GREEN + "Dragon dropped a health boost! Your health increased by 20." + ConsoleUtility.RESET);
        } else if (drop == 4) {
            System.out.println("Dragon did not drop anything!");
        }
    }
}
