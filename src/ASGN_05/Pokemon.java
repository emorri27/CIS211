package ASGN_05;

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
        String string = "Pokemon: " +
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
