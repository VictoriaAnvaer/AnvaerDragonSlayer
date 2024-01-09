public class Player {
    private String name;
    private int health;
    private int gold;
    private boolean healthPot;
    private Sword sword;

    Player(String name) {
        this.name = name;
        health = 100;
        gold = 0;
        healthPot = false;
        sword = new Sword();
    }
    public String getName() {
        return name;
    }

    public Sword getSword() {
        return sword;
    }

    public int getHealth() {
        return health;
    }
    public void addGold(int add) {
        gold+=add;
    }

    public void setHealthPot(boolean ft) {
        healthPot = ft;
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
            System.out.println("You currently are not carrying a health pot.");
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
    public void upgrade() {
        System.out.println("The following sword upgrades are available: ");
        System.out.println("Dodge +5 : 10 Gold\nDodge +10 : 20 Gold");
        System.out.println("Attack +5 : 10 Gold\nAttack +10 : 20 Gold");
        // add later
    }
    public void playerMenu() {
        System.out.println(name + "- health: " + health);
    }

    public String info() {
        String info = "--PLAYER--\nName: " + name;
        info+="\nHealth: " + health;
        info+="\nGold: " + gold;
        info+="\nHealth Potion: " + healthPot;
        info+="\n--SWORD--\n";
        info+="Dodge: " + sword.getDodge();
        info+="\nAttack: " + sword.getAttack();
        return info;
    }
}
