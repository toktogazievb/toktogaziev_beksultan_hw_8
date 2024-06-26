package players;

public class Witcher extends Hero {
    public Witcher(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.BRING_BACK_TO_LIFE);
    }


    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() == 0 && !(heroes[i] instanceof Witcher)) {
                heroes[i].setHealth(this.getHealth());
                this.setHealth(0);
                System.out.println("Witcher bring back to life " + heroes[i].getName() + " and give him health");
                break;
            }
        }
    }
}
