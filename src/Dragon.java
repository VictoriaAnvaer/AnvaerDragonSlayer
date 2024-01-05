public class Dragon {
    private int health;
    private int level;
    Dragon(int level) {
        health = 100;
        this.level = level;
    }

    public int attack() {
        return ((int) (Math.random() * 10 + 5)) * level;
    }
    public boolean recieveAttack(Player player) {
        if (((int) (Math.random() * 100 + 1)) > level * 20) {
            health-=player.attack();
            return true;
        }
        return false;
    }
    public void dragonSlain() {
        int drop = (int) (Math.random() * 4 + 1);
        if (drop == 1) {
            System.out.println("Dragon dropped gold!");
        } else if (drop == 2) {
            System.out.println("Dragon dropped a sword upgrade!");
        } else if (drop == 3) {
            System.out.println("Dragon dropped a health boost!");
        } else if (drop == 4) {
            System.out.println("Dragon did not drop anything!");
        }

    }


}
