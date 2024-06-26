package players;

import game.RPG_Game;

import java.util.Random;

public class Hacker extends Hero {
    public Hacker(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.BLOCK_DAMAGE_AND_REVERT);
    }


    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (RPG_Game.getRound()%2==0){
            int quantityOfHealth = new Random().nextInt(30)+1;
            boss.setHealth(boss.getHealth() - quantityOfHealth);
            int RandomHero = new Random().nextInt(heroes.length);
            heroes[RandomHero].setHealth(heroes[RandomHero].getHealth() + quantityOfHealth);
            System.out.println("Peter parker stole " + quantityOfHealth + " health from boss and give them for " + heroes[RandomHero].getName());
        }
    }
}
