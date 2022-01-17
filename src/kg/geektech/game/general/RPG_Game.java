package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int round_number;
    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(700, 50);

        Warrior warrior = new Warrior(270, 15, "Saitama");
        Medic doc = new Medic(220, 5, 15, "Tsunada");
        Magic magic = new Magic(240, 20, "Itachi");
        Berserk berserk = new Berserk(300, 20, "Chorgio");
        Medic assistant = new Medic(250, 10, 5, "Sakura");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant};

        printStatistics(heroes, boss);
        while (!isGameFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static void round(Hero[] heroes, Boss boss) {
        round_number++;
        bossHits(heroes, boss);
        heroesHit(heroes, boss);
        applySuperPowers(heroes, boss);
        printStatistics(heroes, boss);
    }

    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("ROUND " + round_number);
        System.out.println("Boss health: " + boss.getHealth()
                + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName()
                    + " health: " + heroes[i].getHealth()
                    + " [" + heroes[i].getDamage() + "]");
        }
    }

    private static void bossHits(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void applySuperPowers(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(heroes, boss);
            }
        }
    }

    private static boolean isGameFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}
