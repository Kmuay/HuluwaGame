package HuLuWaGame.model;

//Creature Class 是各种棋子的基类
public class Creature {

    //棋子类别
    protected String name;
    //基础信息
    protected int hp;
    protected int attack;
    protected int range;
    protected int mp;
    //坐标信息
    protected int position_x;
    protected int position_y;
    //是否存活
    protected boolean alive;

    public Creature() {
        this.name="Creature";
        this.hp=1;
        this.attack=1;
        this.range=1;
        this.mp=0;
        this.position_x=0;
        this.position_y=0;
        this.alive=true;
    }

    public Creature(String name) {
        this.name=name;
        this.hp=1;
        this.attack=1;
        this.range=1;
        this.mp=0;
        this.position_x=0;
        this.position_y=0;
        this.alive=true;
    }

    public String get_name() {
        return this.name;
    }

    public int get_hp() {
        return this.hp;
    }

    public int get_attack() {
        return this.attack;
    }

    public int get_range() {
        return this.range;
    }

    public int get_mp() {
        return this.mp;
    }

    public int get_position_x() {
        return this.position_x;
    }

    public int get_position_y() {
        return this.position_y;
    }

    public boolean get_alive() {
        return this.alive;
    }

    public void set_name(String name) {
        this.name=name;
    }

    public void set_mp(int mp) {
        this.mp=mp;
    }

    public void set_hp(int hp) {
        this.hp=hp;
    }

    public void set_attack(int attack) {
        this.attack=attack;
    }

    public void set_range(int range) {
        this.range=range;
    }

    public void set_position_x(int position_x) {
        this.position_x=position_x;
    }

    public void set_position_y(int position_y) {
        this.position_y=position_y;
    }

    public void set_alive(boolean alive) {
        this.alive=alive;
    }

    public void dead() {
        this.alive=false;
    }
}
