public class Shop {
    int upgradeOne;
    int upgradeTwo;

    Shop() {
        upgradeOne = 10;
        upgradeTwo = 20;
    }
    public void shop() {
        System.out.println("The following sword upgrades are available: ");
        System.out.println("1. Dodge +5 : 10 Gold\n2. Dodge +10 : 20 Gold");
        System.out.println("2. Attack +5 : 10 Gold\n4. Attack +10 : 20 Gold");
        // add later
    }

    public void selection(Player player, int item) {
        if ((item == 1 || item == 2) && player.getGold() >= upgradeOne) {

        } else if ((item == 3 || item == 4) && player.getGold() >= upgradeTwo) {

        } else {

        }
    }
}
