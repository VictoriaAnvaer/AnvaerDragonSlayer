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

    public int getHealth() {
        return health;
    }

    public int attack() {
        return ((int) (Math.random() * 10 + 1)) * sword.getAttack();
    }

    public boolean recieveAttack(Dragon dragon) {
        if (((int) (Math.random() * 100 + 1)) > sword.getDodge()) {
            dragon.attack();
            return true;
        }
        return false;
    }

    public String info() {
        String info = "--PLAYER--\nName: " + name;
        info+="\nHealth: " + health;
        info+="\nGold: " + gold;
        info+="\nHealthPot: " + healthPot;
        info+="\n--SWORD--\n";
        info+="Dodge: " + sword.getDodge();
        info+="\nAttack: " + sword.getAttack();
        return info;
    }
}
