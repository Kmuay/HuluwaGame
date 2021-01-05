package HuLuWaGame.model;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//一局游戏需要维护的资源
public class Game {

    //读写锁
    public final static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private static boolean change;

    private static boolean end;

    //0-游戏准备中 1-游戏运行中 2-游戏结束且胜利 3-游戏结束且失败
    private static int gamestate;
    
    //8个自己的棋子
    private static ArrayList<Creature> list_self = new ArrayList<Creature>(8);

    //8个敌方棋子
    private static ArrayList<Creature> list_enemy = new ArrayList<Creature>(8);

    public Game(){}

    public Game(int state, ArrayList<Creature> list) {
        change = false;
        gamestate = state;
        list_self = list;
        for(int i=0; i<8; i++){
            Creature creature = new Creature();
            list_enemy.add(creature);
        }
    }

    public synchronized int get_gamestate() {
        return gamestate;
    }

    public synchronized void set_gamestate(int state) {
        gamestate = state;
    }

    public ArrayList<Creature> get_list_self() {
        return list_self;
    }

    public Creature get_list_self_i(int i) {
        return list_self.get(i);
    }

    public void set_list_self(ArrayList<Creature> list) {
        synchronized(list_self){
            list_self = list;
        }
    }

    public void set_list_self_i(int i,Creature creature) {
        synchronized(list_self){
            list_self.set(i, creature);
        }
    }

    public ArrayList<Creature> get_list_enemy() {
        return list_enemy;
    }

    public Creature get_list_enemy_i(int i) {
        return list_enemy.get(i);
    }

    public void set_list_enemy(ArrayList<Creature> list) {
        synchronized(list_enemy){
            list_enemy=list;
        }
    }

    public boolean get_change() {
        return change;
    }

    public synchronized void set_change(boolean b) {
        change = b;
    }

    public boolean get_end() {
        return end;
    }

    public synchronized void set_end(boolean b) {
        end = b;
    }
}
