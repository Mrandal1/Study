package study.chapter12;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter12
 * @data 2020/5/8 20:59
 */
public class TcpDemo {
    private static class ClientThread implements Runnable {

        private Socket client = null;
        private BufferedReader reader = null;
        private PrintWriter writer = null;
        /*开始连接*/
        boolean flag = true;

        public ClientThread(Socket client) throws Exception {
            this.client = client;
            this.reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.writer = new PrintWriter(client.getOutputStream());

        }

        @Override
        public void run() {
            System.out.println("连接成功！\t" + "连接主机地址" + client.getInetAddress().getHostAddress());
            while (this.flag) {
                if (this.client.isConnected()) {
                    String string = null;
                    try {
                        string = reader.readLine();
                    } catch (IOException e) {
                        System.out.println("断开连接。。。");

                    }
                    assert string != null;
                    if ("".equals(string.trim())) {
                        writer.print("请不要输入空信息！\n");
                        writer.flush();
                    }
                    if ("bye".equals(string.trim())) {
                        System.out.println("通话结束");
                        this.flag = false;
                        writer.print("byebye...\n");
                        writer.flush();

                    }
                    System.out.println("接收到来自客户端的消息：\t" + string.trim());
                    writer.print("【ECHO】" + string.trim() + "\n");
                    writer.flush();
                } else {
                    System.out.println("等待连接。。。");

                }


            }
            try {
                this.client.close();
                this.reader.close();
                this.writer.close();
            } catch (IOException e) {
                System.out.println("断开连接。。。");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * TCP相关类 ServerSocket(服务器端) Socket(客户端)
         *       ServerSocket--设置服务器的监听端口
         *       Socket--指名要连接的服务器与端口
         *
         *
         *
         * */
        boolean flag = true;

        ServerSocket server = new ServerSocket(8989);
        System.out.println("等待客户端连接...");
        Thread.sleep(1000);

        while (flag) {
            /*进行连接。。。*/
            Socket client = server.accept();
            new Thread(new ClientThread(client)).start();
        }
        server.close();

    }
}

