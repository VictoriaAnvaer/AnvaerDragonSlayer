public class Sword {
    private int attack;
    private int dodge;

    Sword() {
        attack = 10;
        dodge = 20;
    }

    public void setAttack(int increment) {
        attack+=increment;
    }
    public void setDodge(int increment) {
        dodge+=increment;
    }

    public int getAttack() {
        return attack;
    }

    public int getDodge() {
        return dodge;
    }

}
