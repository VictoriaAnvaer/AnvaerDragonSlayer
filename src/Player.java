public class Player {
    private static int HIGHSCORE = 0;
    private String name;
    private int health;
    private int gold;
    private int totGold;
    private boolean healthPot;
    private Sword sword;

    Player(String name) {
        this.name = name;
        health = 100;
        gold = 0;
        totGold = 0;
        healthPot = false;
        sword = new Sword();
    }

    public static int getHIGHSCORE() {
        return HIGHSCORE;
    }

    public int getGold() {
        return gold;
    }

    public Sword getSword() {
        return sword;
    }

    public int getHealth() {
        return health;
    }
    public void setHealthPot(boolean ft) {
        healthPot = ft;
    }
    public void addGold(int add) {
        gold+=add;
        if (add > 0) {
            totGold+=add;
        }
    }
    public void addHealth(int add) {
        health+=add;
    }
    public void useHealthPot() {
        if (healthPot) {
            health+= (health)/2;
            if (health > 100) {
                health = 100;
            }
            healthPot = false;
            System.out.println("Your health is now " + health);
        } else {
            System.out.println("You currently are not carrying a health potion.");
        }
    }
    public int attack() {
        return ((int) (Math.random() * 10 + 1)) * sword.getAttack();
    }
    public void recieveAttack(Dragon dragon) {
        if (((int) (Math.random() * 100 + 1)) > sword.getDodge()) {
            int attack = dragon.attack();
            health -=attack;
            System.out.println("Dragon attacks player for " + attack + " health");
        } else {
            System.out.println("Dragon attack has missed!");
        }
    }
    public void playerMenu() {
        System.out.println("\uD83E\uDDD9 " + name + "- health: " + health);
    }
    public String info() {
        String info = ConsoleUtility.PURPLE + "--PLAYER--" + ConsoleUtility.RESET + "\nName: " + name;
        info+="\nHealth: " + health;
        info+= ConsoleUtility.YELLOW + "\nGold: " + gold + ConsoleUtility.RESET;
        info+="\nHealth Potion: " + healthPot;
        info+= ConsoleUtility.PURPLE + "\n--SWORD--\n" + ConsoleUtility.RESET;
        info+="Dodge: " + sword.getDodge();
        info+="\nAttack: " + sword.getAttack();
        return info;
    }
    public void calculateHighScore() {
        if (totGold > HIGHSCORE) {
            HIGHSCORE = totGold;
        }
    }
}
