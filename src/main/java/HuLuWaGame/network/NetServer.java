package HuLuWaGame.network;

import java.net.ServerSocket;
import java.net.Socket;

//服务器线程，javafx主线程外
//接受客户端发来的包，解析
//封装，发送服务器的包
public class NetServer {

    static ServerSocket serversocket;
    public static Socket socket;

    public void start() {
        int port = 8888;
        try {
            serversocket = new ServerSocket(port);
            System.out.println("服务器已就绪...");
            //创建一个serversocket，在端口8888监听客户请求
            socket = serversocket.accept();
            //阻塞，等待客户，有一个客户则继续执行
            System.out.println("连接成功");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        //开启两个线程，负责建立输入输出流
        new Thread(new SendMessage(socket,"Server")).start();
        new Thread(new ReceiveMessage(socket,"Server")).start();
    }
}
