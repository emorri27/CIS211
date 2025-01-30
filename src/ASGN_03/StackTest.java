/*
Course: CIS211-400
Author: Elliott Morris
Assignment: Module 2, Assignment: Array Stack and Test Program
Date: 1/27/2025
Description: This program implements a generic stack using an array, following the Stack<T> interface. It includes
push, pop, peek, isEmpty, and length operations. It also tests to validate functionality and edge cases.

I wrote all the code submitted, and I have provided citations and references where appropriate.
 */

package ASGN_03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StackTest {
    public static void main(String[] args) {
        LinkedStack<Pokemon> playerHand = createHand();
    }

    public static LinkedStack<Pokemon> createHand() {
        String pokemonFile = "src/ASGN_03/resources/pokemon.csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(pokemonFile));
            LinkedStack<Pokemon> hand = new LinkedStack<Pokemon>();
            // NEED TO PICK 15 RANDOM POKEMON
            // hand.push(pokemon)

            return hand;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
