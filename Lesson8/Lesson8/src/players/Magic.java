package players;

import java.util.Random;

public class Magic extends Hero {

    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int randomAtkBoost = new Random().nextInt(3) + 1;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i].getDamage() != 0) {
                heroes[i].setDamage(heroes[i].getDamage() + randomAtkBoost);
            }

        }
    }
}
