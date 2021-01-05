package HuLuWaGame.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import HuLuWaGame.model.Creature;
import HuLuWaGame.model.Game;

public class ReceiveMessage implements Runnable{

    String threadname;
    Socket socket;
    BufferedReader br;

    public ReceiveMessage(Socket socket,String name) {
        this.socket = socket;
        this.threadname = name;
    }

    @Override
    public void run() {
        //System.out.println("Test for ReceviceMessage");
        try {
            Game game = new Game();
            while(game.get_gamestate()==1) {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //TODO : 更新自己的list_self & list enemy
                if(br!=null) {
                    String msg = br.readLine();
                    System.out.println(msg);
                    String[] temp = msg.split("\\*");
                    if(temp[0].equals("enemy")) {
                        ArrayList<Creature> list = new ArrayList<Creature>(8);
                        for(int i=0; i<8; i++) {
                            Creature creature = new Creature();
                            list.add(creature);
                        }
                        for(int i=1; i<temp.length; i++) {
                            String[] creature = temp[i].split("=");
                            list.get(i-1).set_name(creature[0]);
                            list.get(i-1).set_hp(Integer.parseInt(creature[1]));
                            list.get(i-1).set_attack(Integer.parseInt(creature[2]));
                            list.get(i-1).set_range(Integer.parseInt(creature[3]));
                            list.get(i-1).set_position_x(Integer.parseInt(creature[4]));
                            list.get(i-1).set_position_y(Integer.parseInt(creature[5]));
                            if(creature[6].equals("1")) {
                                list.get(i-1).set_alive(true);
                            }
                            else {
                                list.get(i-1).set_alive(false);
                            }
                        }
                        game.set_list_self(list);
                    }
                    else {
                        ArrayList<Creature> list = new ArrayList<Creature>(8);
                        for(int i=0; i<8; i++) {
                            Creature creature = new Creature();
                            list.add(creature);
                        }
                        for(int i=1; i<temp.length; i++) {
                            String[] creature = temp[i].split("=");
                            list.get(i-1).set_name(creature[0]);
                            list.get(i-1).set_hp(Integer.parseInt(creature[1]));
                            list.get(i-1).set_attack(Integer.parseInt(creature[2]));
                            list.get(i-1).set_range(Integer.parseInt(creature[3]));
                            list.get(i-1).set_position_x(Integer.parseInt(creature[4]));
                            list.get(i-1).set_position_y(Integer.parseInt(creature[5]));
                            if(creature[6].equals("1")) {
                                list.get(i-1).set_alive(true);
                            }
                            else {
                                list.get(i-1).set_alive(false);
                            }
                        }
                        game.set_list_enemy(list);
                    }
                }
                TimeUnit.MILLISECONDS.sleep(500);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("信息接受失败");
        }
    }
}
