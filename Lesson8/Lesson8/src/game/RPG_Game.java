package game;

import players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();
    private static int round = 0;

    public static int getRound() {
        return round;
    }

    public static void startGame() {
        Boss thanos = new Boss(1300, 50, "Thanos");

        Berserk captainAmerica = new Berserk(300,
                15, "Captain America");
        Warrior ironMan = new Warrior(270, 20, "Iron man");
        Magic thor = new Magic(320, 15, "Thor");
        Medic drStrange = new Medic(220, 10, "DR Strange", 10);
        Medic wong = new Medic(230, 5, "Wong", 5);
        Witcher scarlet = new Witcher(250, 0, "Wanda");
        Hacker peterParker = new Hacker(270, 15, "Peter Parker");


        Hero[] avengers = {captainAmerica, ironMan, thor, drStrange, wong, scarlet, peterParker};

        System.out.println("------------- Start game Assemble  -------------");
        printStatistics(thanos, avengers);

        while (!isGameOver(thanos, avengers)) {
            round(thanos, avengers);
        }
    }

    private static boolean isGameOver(Boss thanos, Hero[] heroes) {
        if (thanos.getHealth() <= 0) {
            System.out.println("Avengers won!!!");
            return true;
        }
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                return false;
            }
        }
        System.out.println("Thanos won!!!");
        return true;
    }

    private static void round(Boss thanos, Hero[] avengers) {
        round++;
        thanos.chooseDefence();
        System.out.println("-------------ROUND " + round + " -------------");
        thanos.attackBoss(avengers);
        for (int i = 0; i < avengers.length; i++) {
            if (avengers[i].getSuperAbilityEnum() != thanos.getDefence() && avengers[i].getHealth() > 0) {
                avengers[i].attackHero(thanos);
                avengers[i].applySuperAbility(thanos, avengers);
            }
        }
        printStatistics(thanos, avengers);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

}
