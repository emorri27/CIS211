/*
Course: CIS211-400
Author: Elliott Morris
Assignment: Module 3, Assignment: Linked Stack - Pokemon Battle
Date: 1/31/2025
Description:

I wrote all the code submitted, and I have provided citations and references where appropriate.
 */

package ASGN_03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class StackTest {
    public static final String POKEMON_FILE = "src/ASGN_03/resources/pokemon.csv";
    public static final LinkedStack<Pokemon> pokemonList = initializePokemon();

    public static void main(String[] args) {
        LinkedStack<Pokemon> playerHand = createHand();
        LinkedStack<Pokemon> computerHand = createHand();

        beginBattle(playerHand, computerHand);
    }

    public static LinkedStack<Pokemon> initializePokemon() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(POKEMON_FILE));
            reader.readLine();
            String pokemonData;
            LinkedStack<Pokemon> pokemonList = new LinkedStack<Pokemon>();

            while ((pokemonData = reader.readLine()) != null) {
                String[] pokemonDataParts = pokemonData.split(",");

                Pokemon pokemon = new Pokemon();
                pokemon.setName(pokemonDataParts[1]);
                pokemon.setType1(pokemonDataParts[2]);
                pokemon.setType2(pokemonDataParts[3]);
                pokemon.setTotal(Integer.valueOf(pokemonDataParts[4]));
                pokemon.setHp(Integer.valueOf(pokemonDataParts[5]));
                pokemon.setAttack(Integer.valueOf(pokemonDataParts[6]));
                pokemon.setDefense(Integer.valueOf(pokemonDataParts[7]));
                pokemon.setSp_attack(Integer.valueOf(pokemonDataParts[8]));
                pokemon.setSp_defense(Integer.valueOf(pokemonDataParts[9]));
                pokemon.setSpeed(Integer.valueOf(pokemonDataParts[10]));
                pokemon.setGeneration(Integer.valueOf(pokemonDataParts[11]));
                pokemon.setLegendary(Boolean.valueOf(pokemonDataParts[12]));
                pokemonList.push(pokemon);
            }
            reader.close();
            return pokemonList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static LinkedStack<Pokemon> createHand() {
        LinkedStack<Pokemon> hand = new LinkedStack<Pokemon>();
        Random rng = new Random();

        for (int i = 0; i < 15; i++) {
            hand.push(pokemonList.get(rng.nextInt(722)));
        }
        return hand;
    }

    public static void beginBattle(LinkedStack<Pokemon> player, LinkedStack<Pokemon> computer) {
        int round = 1;
        int score = 0;

        System.out.println("** The program has no user interaction.");
        for (int i = 0; i < player.length(); i++) {
            int playerAtk = player.get(i).getAttack();
            int computerDfs = computer.get(i).getDefense();

            System.out.println("\nRound #: " + round++);
            System.out.println("Pokemon: " + "name='" + player.get(i).getName() + '\'' + ", attack=" + playerAtk + ", defense=" + player.get(i).getDefense() + '}');
            System.out.println("Pokemon: " + "name='" + computer.get(i).getName() + '\'' + ", attack=" + computer.get(i).getAttack() + ", defense=" + computerDfs + '}');
            System.out.println("##### fight! ######");
            if (playerAtk > computerDfs) {
                System.out.println("Player wins this round.");
                score++;
            } else if (playerAtk == computerDfs) {
                System.out.println("It's a tie!");
            } else {
                System.out.println("Computer wins this round.");
            }
        }
        System.out.println("\nThe battle has come to an end. Player score is: " + score);
    }
}
