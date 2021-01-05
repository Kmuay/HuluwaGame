package HuLuWaGame.network;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import HuLuWaGame.model.Creature;
import HuLuWaGame.model.Game;

public class SendMessage implements Runnable{

    String threadname;
    Socket socket;
    PrintWriter pw;

    public SendMessage(Socket socket,String name) {
        this.socket = socket;
        this.threadname = name;
    }

    @Override
    public void run() {
        //System.out.println("Test for SendMessage");
        try{
            //将自己Game里的list_enemy & list_self 发给对方
            //ArrayList<Creature> -> String
            //self/enemy*[name=hp=attack=range=position_x=position_y=alive]*[nextone]
            Game game = new Game();
            while(game.get_gamestate()==1) {
                if(game.get_change()) {
                    pw = new PrintWriter(socket.getOutputStream(),true);
                    String msg = loadenemystr(game.get_list_enemy());
                    pw.println(msg);
                    System.out.println("send-1: "+msg);
                    msg = loadselfstr(game.get_list_self());
                    pw.println(msg);
                    System.out.println("send-2: "+msg);
                }
                game.set_change(false);
                game.set_end(true);
                TimeUnit.SECONDS.sleep(1);
            }
            NetServer.serversocket.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("发送信息失败");
        }
    }

    public String loadenemystr(ArrayList<Creature> list) {
        String msg="enemy*";
        for(int i=0; i<8; i++) {
            msg += list.get(i).get_name();
            msg += "=";
            msg += list.get(i).get_hp();
            msg += "=";
            msg += list.get(i).get_attack();
            msg += "=";
            msg += list.get(i).get_range();
            msg += "=";
            msg += list.get(i).get_position_x();
            msg += "=";
            msg += list.get(i).get_position_y();
            msg += "=";
            if(list.get(i).get_alive()) {
                msg += "1";
            }
            else {
                msg += "0";
            }
            if(i!=7) {
                msg += "*";
            }
        }
        return msg;
    }

    public String loadselfstr(ArrayList<Creature> list) {
        String msg="self*";
        for(int i=0; i<8; i++) {
            msg += list.get(i).get_name();
            msg += "=";
            msg += list.get(i).get_hp();
            msg += "=";
            msg += list.get(i).get_attack();
            msg += "=";
            msg += list.get(i).get_range();
            msg += "=";
            msg += list.get(i).get_position_x();
            msg += "=";
            msg += list.get(i).get_position_y();
            msg += "=";
            if(list.get(i).get_alive()) {
                msg += "1";
            }
            else {
                msg += "0";
            }
            if(i!=7) {
                msg += "*";
            }
        }
        return msg;
    }
}
