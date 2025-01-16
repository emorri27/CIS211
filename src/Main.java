public class Main {
    public static void main(String[] args) {
        Pokemon raichu = new Pokemon("Raichu", 90, 55, 60);
        Pokemon nidorino = new Pokemon("Nidorino",72, 57, 61);

        Battle battle = new Battle(raichu, nidorino);
        battle.attack(raichu, nidorino);
        battle.attack(nidorino, raichu);
        battle.attack(raichu, nidorino);
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

class Battle {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Integer round_counter;

    Battle(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.round_counter = round_counter;
    }

    public void attack(Pokemon pokemon1, Pokemon pokemon2) {
        pokemon2.setHp(pokemon2.getHp() - (pokemon1.getAttack_value() - pokemon2.getDefense_value()));
        System.out.println(pokemon2.getName() + "is now at " + pokemon2.getHp() + " HP!");
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }
}
