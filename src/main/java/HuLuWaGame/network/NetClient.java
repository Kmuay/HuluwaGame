package HuLuWaGame.network;

import java.net.Socket;

public class NetClient {
    public static Socket socket=null;

    public void start() {
        String host = "127.0.0.1";
        int port = 8888;

        try {
            socket = new Socket(host,port);
            if(socket!=null){
                System.out.println("连接成功");
            }
        }
        catch(Exception e) {
            System.out.println("连接失败");
        }

        //开启两个线程,负责建立输入输出流
        new Thread(new SendMessage(socket,"Client")).start();
        new Thread(new ReceiveMessage(socket,"Client")).start();
    }
}
