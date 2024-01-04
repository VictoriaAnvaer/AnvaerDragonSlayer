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
            player.attack();
            return true;
        }
        return false;
    }


}
