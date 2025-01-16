/*
Author: Elliott Morris
Assignment: Module 1, Lab 1: Java Review
Date: 1/16/2025
Description: Simulates a battle between two pokemon.
 */

public class Main {
    public static void main(String[] args) {
        Pokemon raichu = new Pokemon("Raichu", 90, 55, 60);
        Pokemon nidorino = new Pokemon("Nidorino",72, 57, 61);

        raichu.challenge(nidorino);
    }
}

class Pokemon {

    private String name;
    private Integer attack_value;
    private Integer defense_value;
    private Integer hp;

    public Pokemon(String name, Integer attack_value, Integer defense_value, Integer hp) {
        this.name = name;
        this.attack_value = attack_value;
        this.defense_value = defense_value;
        this.hp = hp;
    }
    
    public void challenge(Pokemon enemy) {
        System.out.println(this.getName() + " has challenged " + enemy.getName() + "!");
        System.out.println("The battle has begun!\n");

        int round_counter = 0;
        Pokemon attacker = null;
        Pokemon defender = null;
        boolean challengers_ready = true;

        while (challengers_ready) {
            System.out.println("Round #" + (round_counter + 1) + ":");
            if (round_counter % 2 == 0) {
                attacker = this;
                defender = enemy;
            } else if (round_counter % 2 == 1) {
                attacker = enemy;
                defender = this;
            }
            challengers_ready = attacker.attack(defender);
            round_counter++;
        }
        System.out.println("The battle has ended. " + attacker.getName() + " won the battle!\n");
    }

    private boolean attack(Pokemon enemy) {
        int damage = this.getAttack_value() - enemy.getDefense_value();

        System.out.println(this.getName() + " attacked " + enemy.getName() + " for " + damage + " damage!");
        enemy.setHp(enemy.getHp() - damage);
        if (enemy.getHp() < 0) {
            enemy.setHp(0);
            System.out.println("\n" + enemy.getName() + " has fainted!");
            return false;
        } else {
            System.out.println(enemy.getName() + "is now at " + enemy.getHp() + " HP!\n");
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAttack_value() {
        return attack_value;
    }

    public void setAttack_value(Integer attack_value) {
        this.attack_value = attack_value;
    }

    public Integer getDefense_value() {
        return defense_value;
    }

    public void setDefense_value(Integer defense_value) {
        this.defense_value = defense_value;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }
}
