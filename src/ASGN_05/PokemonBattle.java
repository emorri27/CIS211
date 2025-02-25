package ASGN_05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
    public static final String POKEMON_FILE = "src/ASGN_05/resources/pokemon.csv";
    public static final Pokemon[] POKEMON_LIST = initializePokemon();
    public static final int HAND_SIZE = 10;

    public static void main(String[] args) {
        CircularArrayQueue<Pokemon> playerHand = createHand();
        CircularArrayQueue<Pokemon> computerHand = createHand();

        beginBattle(playerHand, computerHand);
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
            hand.enqueue(POKEMON_LIST[rng.nextInt(722)]);
        }
        return hand;
    }

    public static void beginBattle(CircularArrayQueue<Pokemon> player, CircularArrayQueue<Pokemon> computer) {
        boolean gameOver = false;
        Scanner keys = new Scanner(System.in);

        while (!gameOver) {
            int currentRound = 1;
            System.out.println("Welcome to the pokemon battle ground.");
            System.out.println("How many rounds will this be?");
            int rounds = keys.nextInt();
            int i = 0;
            do {
                // Localizing the Pokemon objects
                Pokemon playerPokemon = player.dequeue();
                Pokemon computerPokemon = computer.dequeue();

                int playerAtk = playerPokemon.getAttack();
                int computerDfs = computerPokemon.getDefense();

                System.out.println("\nRound #: " + currentRound++);
                System.out.println("Pokemon: " + "name='" + playerPokemon.getName() + '\'' + ", attack=" + playerAtk + ", defense=" + playerPokemon.getDefense() + '}');
                System.out.println("Pokemon: " + "name='" + computerPokemon.getName() + '\'' + ", attack=" + computerPokemon.getAttack() + ", defense=" + computerDfs + '}');
                System.out.println("##### fight! ######");
                if (playerAtk > computerDfs) {
                    System.out.println("Player wins this round.");
                    player.enqueue(playerPokemon);
                    player.enqueue(computerPokemon);
                } else if (playerAtk == computerDfs) {
                    System.out.println("It's a tie!");
                    player.enqueue(playerPokemon);
                    computer.enqueue(computerPokemon);
                } else {
                    System.out.println("Computer wins this round.");
                    computer.enqueue(computerPokemon);
                    computer.enqueue(playerPokemon);
                }
                System.out.println("Player has " + player.length() + " cards left.");
                System.out.println("Computer has " + computer.length() + " cards left.");
                i++;
            } while (i < rounds && !player.isEmpty() && !computer.isEmpty());
            System.out.println("\n\n\nPlayer has " + player.length() + " cards left.");
            System.out.println("Computer has " + computer.length() + " cards left.");
            if (player.length() > computer.length()) {
                System.out.println("Player wins!");
            } else if (player.length() < computer.length()) {
                System.out.println("Computer wins!");
            } else {
                System.out.println("The battle ended in a tie!");
            }
            System.out.println("Do you want another battle? (1 for yes, any other input will exit the battle)");
            int choice = keys.nextInt();
            switch (choice) {
                case 1:
                    break;
                default:
                    gameOver = true;
            }
        }
    }
}
