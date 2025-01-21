package ASGN_01;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ArrayList<Pokemon> pokemon = initializePokedex();
        initiatePokedex(pokemon);
    }

    public static void initiatePokedex(ArrayList<Pokemon> pokemon) {

        Scanner keys = new Scanner(System.in);

        Boolean running = true;
        while (running) {
            System.out.println("\n###################### POKEDEX MENU ######################");
            System.out.println("1: Show all pokemon in pokedex.");
            System.out.println("2: Search for pokemon information by name.");
            System.out.println("3: Exit program.");
            System.out.println("Enter choice (1-3):");

            Integer choice = Integer.valueOf(keys.nextLine());

            switch (choice) {
                case 1:
                    listPokemon(pokemon);
                    break;
                case 2:
                    System.out.println("Enter pokemon name:");
                    String name = keys.nextLine();
                    searchPokemon(pokemon, name);
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }


    }

    static void searchPokemon(ArrayList<Pokemon> pokemon, String name) {
        for (Pokemon currentPokemen : pokemon) {
            if (currentPokemen.getName().equals(name)) {
                System.out.println(currentPokemen.toString());
            }
        }
    }
    static void listPokemon(ArrayList<Pokemon> pokemon) {
        for (int i = 0; i < pokemon.size(); i++) {
            System.out.println(pokemon.get(i).toString());
        }
    }
    static ArrayList<Pokemon> initializePokedex() {
        String pokemonFile = "src/ASGN_01/resources/pokemon.csv";

        ArrayList<Pokemon> pokemon = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pokemonFile));
            reader.readLine();
            String pokemonData;

            while ((pokemonData = reader.readLine()) != null) {
                String[] pokemonDataParts = pokemonData.split(",");

                Pokemon newPokemon = new Pokemon();
                newPokemon.setName(pokemonDataParts[1]);
                newPokemon.setType1(pokemonDataParts[2]);
                newPokemon.setType2(pokemonDataParts[3]);
                newPokemon.setTotal(Integer.valueOf(pokemonDataParts[4]));
                newPokemon.setHp(Integer.valueOf(pokemonDataParts[5]));
                newPokemon.setAttack(Integer.valueOf(pokemonDataParts[6]));
                newPokemon.setDefense(Integer.valueOf(pokemonDataParts[7]));
                newPokemon.setSp_attack(Integer.valueOf(pokemonDataParts[8]));
                newPokemon.setSp_defense(Integer.valueOf(pokemonDataParts[9]));
                newPokemon.setSpeed(Integer.valueOf(pokemonDataParts[10]));
                newPokemon.setGeneration(Integer.valueOf(pokemonDataParts[11]));
                newPokemon.setLegendary(Boolean.valueOf(pokemonDataParts[12]));
                pokemon.add(newPokemon);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pokemon;
    }
}

class Pokemon {

    private String name;
    private String type1;
    private String type2;
    private Integer total;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer sp_attack;
    private Integer sp_defense;
    private Integer speed;
    private Integer generation;
    private Boolean legendary;

    public Pokemon() {
    }

    public Pokemon(String name, String type1, String type2, Integer total, Integer hp, Integer attack, Integer defense, Integer sp_attack, Integer sp_defense, Integer speed, Integer generation, Boolean legendary) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.sp_attack = sp_attack;
        this.sp_defense = sp_defense;
        this.speed = speed;
        this.generation = generation;
        this.legendary = legendary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSp_attack() {
        return sp_attack;
    }

    public void setSp_attack(Integer sp_attack) {
        this.sp_attack = sp_attack;
    }

    public Integer getSp_defense() {
        return sp_defense;
    }

    public void setSp_defense(Integer sp_defense) {
        this.sp_defense = sp_defense;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public Boolean getLegendary() {
        return legendary;
    }

    public void setLegendary(Boolean legendary) {
        this.legendary = legendary;
    }

    @Override
    public String toString() {
        java.lang.String string = "Pokemon: " +
                "name='" + name + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", total=" + total +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", sp_attack=" + sp_attack +
                ", sp_defense=" + sp_defense +
                ", speed=" + speed +
                ", generation=" + generation +
                ", legendary=" + legendary +
                '}';
        return string;
    }
}
