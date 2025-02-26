/*
Course: CIS211-400
Author: Elliott Morris
Assignment: Module 5, Assignment: Circular Array Queue
Date: 2/25/2025
Description: This program simulates a Pokemon battle using a circular array queue.
Players receive a queue of 10 Pokemon and battle based on attack vs defense.
Tiebreakers continue until a winner is determined.

I wrote all the code submitted, and I have provided citations and references where appropriate.
*/

package ASGN_05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
    public static final String POKEMON_FILE = "src/ASGN_05/resources/pokemon.csv";
    public static final Pokemon[] POKEMON_LIST = initializePokemon();
    public static final int HAND_SIZE = 10;

    public static void main(String[] args) {
        boolean endProgram = false;
        Scanner keys = new Scanner(System.in);
        while (!endProgram) {
            System.out.println("Welcome to the pokemon battle ground.");
            System.out.println("How many rounds will this be?");

            try {
                int rounds = keys.nextInt();
                if (rounds <= 0) {
                    System.out.println("Error: Rounds must be greater than 0.");
                    keys.nextLine();
                    continue;
                }
                beginBattle(rounds);
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input");
                keys.nextLine();
                continue;
            }

            // continue or end the program
            System.out.println("Do you want another battle? (1 for yes, any other input will exit the battle)");
            int choice = keys.nextInt();
            if (choice != 1) endProgram = true;
        }
    }

    public static Pokemon[] initializePokemon() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(POKEMON_FILE));
            reader.readLine();
            String pokemonData;
            Pokemon[] POKEMON_LIST = new Pokemon[721];

            int i = 0;
            while ((pokemonData = reader.readLine()) != null && i < 721) {
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
                POKEMON_LIST[i] = (pokemon);
                i++;
            }
            reader.close();
            return POKEMON_LIST;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static CircularArrayQueue<Pokemon> createHand() {
        CircularArrayQueue<Pokemon> hand = new CircularArrayQueue<Pokemon>(HAND_SIZE*2);
        Random rng = new Random();

        for (int i = 0; i < HAND_SIZE; i++) {
            hand.enqueue(POKEMON_LIST[rng.nextInt(721)]);
        }
        return hand;
    }

    public static void beginBattle(int rounds) {
        CircularArrayQueue<Pokemon> playerHand = createHand();
        CircularArrayQueue<Pokemon> computerHand = createHand();

        for (int currentRound = 0; currentRound < rounds && !playerHand.isEmpty() && !computerHand.isEmpty(); currentRound++) {
            // Localizing the Pokemon objects
            Pokemon playerPokemon = playerHand.dequeue();
            Pokemon computerPokemon = computerHand.dequeue();

            System.out.println("\nRound #: " + (currentRound+1));
            int winner = fight(playerPokemon, computerPokemon);
            switch (winner) {
                case 1:
                    playerHand.enqueue(playerPokemon);
                    playerHand.enqueue(computerPokemon);
                    break;
                case 2:
                    CircularArrayQueue<Pokemon> tiePool = new CircularArrayQueue<>(20);
                    tiePool.enqueue(playerPokemon);
                    tiePool.enqueue(computerPokemon);
                    boolean tieResolved = false;

                    while (!tieResolved) {
                        if (playerHand.isEmpty()) {
                            System.out.println("Player ran out of cards. Computer wins the tie pool.");
                            while (!tiePool.isEmpty()) {
                                computerHand.enqueue(tiePool.dequeue());
                            }
                            break;
                        } else if (computerHand.isEmpty()) {
                            System.out.println("Computer ran out of cards. Player wins the tie pool.");
                            while (!tiePool.isEmpty()) {
                                playerHand.enqueue(tiePool.dequeue());
                            }
                            break;
                        }

                        Pokemon playerTieBreaker = playerHand.dequeue();
                        Pokemon computerTieBreaker = computerHand.dequeue();
                        tiePool.enqueue(playerTieBreaker);
                        tiePool.enqueue(computerTieBreaker);

                        int tieResult = fight(playerTieBreaker, computerTieBreaker);

                        if (tieResult == 1) {
                            System.out.println("Player wins the tiebreaker and collects the tie pool.");
                            while (!tiePool.isEmpty()) {
                                playerHand.enqueue(tiePool.dequeue());
                            }
                            tieResolved = true;
                        } else if (tieResult == 3) {
                            System.out.println("Computer wins the tiebreaker and collects the tie pool.");
                            while (!tiePool.isEmpty()) {
                                computerHand.enqueue(tiePool.dequeue());
                            }
                            tieResolved = true;
                        } else {
                            System.out.println("Another tie! Continuing tie breaker...");
                        }
                    }
                    break;
                case 3:
                    computerHand.enqueue(computerPokemon);
                    computerHand.enqueue(playerPokemon);
                    break;
            }

            // updates card counts displayed
            System.out.println("Player has " + playerHand.length() + " cards left.");
            System.out.println("Computer has " + computerHand.length() + " cards left.");
        }

        // display final card counts and winner
        System.out.println("\n\n\nPlayer has " + playerHand.length() + " cards left.");
        System.out.println("Computer has " + computerHand.length() + " cards left.");
        if (playerHand.length() > computerHand.length()) {
            System.out.println("Player wins!");
        } else if (playerHand.length() < computerHand.length()) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("The battle ended in a tie!");
        }
    }

    public static int fight(Pokemon playerPokemon, Pokemon computerPokemon) {

        int playerAtk = playerPokemon.getAttack();
        int computerDfs = computerPokemon.getDefense();

        System.out.println("Pokemon: " + "name='" + playerPokemon.getName() + '\'' + ", attack=" + playerAtk + ", defense=" + playerPokemon.getDefense() + '}');
        System.out.println("Pokemon: " + "name='" + computerPokemon.getName() + '\'' + ", attack=" + computerPokemon.getAttack() + ", defense=" + computerDfs + '}');
        System.out.println("##### fight! ######");

        if (playerAtk > computerDfs) {
            System.out.println("Player wins this round.");
            return 1;
        } else if (playerAtk == computerDfs) {
            System.out.println("It's a tie!");
            return 2;
        } else {
            System.out.println("Computer wins this round.");
            return 3;
        }
    }
}
