package HuLuWaGame.model;

import java.util.ArrayList;

//一局游戏需要维护的资源
public class Game {

    //1-游戏运行中 2-游戏结束且胜利 3-游戏结束且失败
    public static int gamestate;
    
    //8个自己的棋子
    public static ArrayList<Creature> list_self = new ArrayList<Creature>(8);

    //8个敌方棋子
    public static ArrayList<Creature> list_enemy = new ArrayList<Creature>(8);

    public Game(int state, ArrayList<Creature> list) {
        gamestate = state;
        list_self = list;
    }

    //每次action后，判断游戏是否结束，更新gamestate
    public void end_or_not() {
        int num_self_alive = 0;
        int num_enemy_alive = 0;
        for(int i=0; i<8; i++) {
            if(list_self.get(i).get_alive()) {
                num_self_alive++;
            }
            if(list_enemy.get(i).get_alive()) {
                num_enemy_alive++;
            }
        }
        if(num_self_alive!=0&&num_enemy_alive==0) {
            Game.gamestate=2;
        }
        else {
            if(num_self_alive==0&&num_enemy_alive!=0) {
                Game.gamestate=3;
            }
        }
    }

    public synchronized static void set_state(int i) {
        Game.gamestate=i;
    }

    //[name+hp+attack+range+position_x+position_y+alive]
    public synchronized static void init_enemy(String msg) {
        String[] temp = msg.split("-");
        for(int i=0; i<temp.length; i++) {
            String[] creature = temp[i].split("+");
            list_enemy.get(i).set_name(creature[0]);
            list_enemy.get(i).set_hp(Integer.parseInt(creature[1]));
            list_enemy.get(i).set_attack(Integer.parseInt(creature[2]));
            list_enemy.get(i).set_range(Integer.parseInt(creature[3]));
            list_enemy.get(i).set_position_x(Integer.parseInt(creature[4]));
            list_enemy.get(i).set_position_y(Integer.parseInt(creature[5]));
            if(creature[6]=="1") {
                list_enemy.get(i).set_alive(true);
            }
            else {
                list_enemy.get(i).set_alive(false);
            }
        }
    }


}
