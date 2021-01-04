package HuLuWaGame.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

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
        System.out.println("Test for ReceviceMessage");
        try {
            while(Game.gamestate==0){
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Game.init_enemy(br.readLine());
            }
            while(Game.gamestate==1){
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(br.readLine());
                TimeUnit.SECONDS.sleep(1);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("信息接受失败");
        }
    }


    
}
