package HuLuWaGame.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import HuLuWaGame.model.Creature;
import HuLuWaGame.model.Game;

public class NetClient {
    public static Socket socket=null;

    public String loadselfstr(ArrayList<Creature> list) {
        String msg="";
        for(int i=0; i<8; i++) {
            msg += list.get(i).get_name();
            msg += "+";
            msg += list.get(i).get_hp();
            msg += "+";
            msg += list.get(i).get_attack();
            msg += "+";
            msg += list.get(i).get_range();
            msg += "+";
            msg += list.get(i).get_position_x();
            msg += "+";
            msg += list.get(i).get_position_y();
            msg += "+";
            if(list.get(i).get_alive()) {
                msg += "1";
            }
            else {
                msg += "0";
            }
            if(i!=7) {
                msg += "-";
            }
        }
        return msg;
    }

    public ArrayList<Creature> loadbr(String msg) {
        String[] temp = msg.split("\\-");
        ArrayList<Creature> list = new ArrayList<Creature>(8);
        for(int i=0; i<8; i++) {
            Creature creature = new Creature();
            list.add(creature);
        }
        for(int i=0; i<temp.length; i++) {
            //System.out.println(temp[i]);
            String[] creature = temp[i].split("\\+");
            list.get(i).set_name(creature[0]);
            list.get(i).set_hp(Integer.parseInt(creature[1]));
            list.get(i).set_attack(Integer.parseInt(creature[2]));
            list.get(i).set_range(Integer.parseInt(creature[3]));
            list.get(i).set_position_x(Integer.parseInt(creature[4]));
            list.get(i).set_position_y(Integer.parseInt(creature[5]));
            if(creature[6].equals("1")) {
                list.get(i).set_alive(true);
            }
            else {
                list.get(i).set_alive(false);
            }
        }
        return list;
    }

    public void start() {
        String host = "127.0.0.1";
        int port = 8888;

        try {
            socket = new Socket(host,port);
            if(socket!=null){
                System.out.println("连接成功");
            }

            Game game = new Game();
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            String msg = loadselfstr(game.get_list_self());
            pw.println(msg);
            System.out.println("send: "+msg);
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            msg = br.readLine();
            System.out.println(msg);
            game.set_list_enemy(loadbr(msg));
            game.set_gamestate(1);
            System.out.println("--------------------------------------------------");
        }
        catch(Exception e) {
            System.out.println("连接失败");
        }


        //开启两个线程,负责建立输入输出流
        new Thread(new SendMessage(socket,"Client")).start();
        new Thread(new ReceiveMessage(socket,"Client")).start();
    }
}
