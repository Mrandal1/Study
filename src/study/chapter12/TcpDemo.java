package study.chapter12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter12
 * @data 2020/5/8 20:59
 */
public class TcpDemo {
    public static void main(String[] args) throws Exception {
        /*
         * TCP相关类 ServerSocket(服务器端) Socket(客户端)
         *       ServerSocket--设置服务器的监听端口
         *       Socket--指名要连接的服务器与端口
         *
         *
         *
         * */
        ServerSocket server = new ServerSocket(9999);
        System.out.println("等待客户端连接");
        /*进行连接。。。*/
        Socket client = server.accept();
        /*设置客户端输入流*/
        Scanner scanner = new Scanner(client.getInputStream());
        /*设置分割符*/
        scanner.useDelimiter("\n");

        /*设置客户端输出流*/
        PrintStream writer = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {

            if (scanner.hasNext()) {
                String str = scanner.next().trim();
                if ("bye".equals(str)) {
                    writer.print("byebye...");
                    writer.close();
                    scanner.close();
                    flag = false;
                } else {
                    writer.print("[ECHO]" + str);
                    writer.flush();
                }
            }

        }
        writer.close();
        scanner.close();

    }
}

