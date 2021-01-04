package HuLuWaGame.network;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

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
        System.out.println("Test for SendMessage");
        try{
            //将自己Game里的list_self发给对方
            //ArrayList<Creature> -> String
            //[name+hp+attack+range+position_x+position_y+alive]-[nextone]
            while(Game.gamestate==0) {
                pw = new PrintWriter(socket.getOutputStream(),true);
                String msg = loadselfstr();
                pw.println(msg);
                System.out.println(msg);
                TimeUnit.SECONDS.sleep(1);
            }
            while(Game.gamestate==1) {
                pw = new PrintWriter(socket.getOutputStream(),true);
                String msg = loadenemystr();
                pw.println(msg);
                System.out.println(msg);
                TimeUnit.SECONDS.sleep(1);
            }
            NetServer.serversocket.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("发送信息失败");
        }
    }

    public synchronized String loadselfstr() {
        String msg="";
        for(int i=0; i<8; i++) {
            msg += Game.list_self.get(i).get_name();
            msg += "+";
            msg += Game.list_self.get(i).get_hp();
            msg += "+";
            msg += Game.list_self.get(i).get_attack();
            msg += "+";
            msg += Game.list_self.get(i).get_range();
            msg += "+";
            msg += Game.list_self.get(i).get_position_x();
            msg += "+";
            msg += Game.list_self.get(i).get_position_y();
            msg += "+";
            if(Game.list_self.get(i).get_alive()) {
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

    public synchronized String loadenemystr() {
        String msg="";
        for(int i=0; i<8; i++) {
            msg += Game.list_enemy.get(i).get_name();
            msg += "+";
            msg += Game.list_enemy.get(i).get_hp();
            msg += "+";
            msg += Game.list_enemy.get(i).get_attack();
            msg += "+";
            msg += Game.list_enemy.get(i).get_range();
            msg += "+";
            msg += Game.list_enemy.get(i).get_position_x();
            msg += "+";
            msg += Game.list_enemy.get(i).get_position_y();
            msg += "+";
            if(Game.list_enemy.get(i).get_alive()) {
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
}
