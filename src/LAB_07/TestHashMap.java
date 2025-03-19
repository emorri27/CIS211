package LAB_07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestHashMap {
    public static final String POKEMON_FILE = "src/LAB_07/resources/pokemon.csv";

    public static void main(String[] args) {


        initializePokemonHashMap();

    }

    public static HashMap<String, Pokemon> initializePokemonHashMap() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(POKEMON_FILE));
            reader.readLine();
            String pokemonData;

            int[] frequency = new int[300];
            int collisions = 0;

            HashMap<String, Pokemon> pokemonHashMap = new HashMap<>(300);

            int count = 0;
            while ((pokemonData = reader.readLine()) != null && count < 800) {
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

                int index = pokemonHashMap.hashFunction(pokemon.getName());
                int occurences = frequency[index];

                if (occurences != 0) collisions++;
                frequency[index] = ++occurences;

                pokemonHashMap.put(pokemon.getName(), pokemon);
                count++;
            }
            reader.close();

            int occCount = 0;
            for (int i = 0; i < frequency.length; i++) {
                System.out.println("Index " + i + " had " + frequency[i] + " occurences.");
                occCount += frequency[i];
            }
            System.out.println("Total collisions: " + collisions);
            System.out.println("Total occurence: " + occCount);

            return pokemonHashMap;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}