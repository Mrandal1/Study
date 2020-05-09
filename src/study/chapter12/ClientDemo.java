package study.chapter12;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter12
 * @data 2020/5/8 21:41
 */
public class ClientDemo {
    private static final BufferedReader BUF = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        /*定义客户端连接信息*/

        Socket client = null;
        try {
            client = new Socket("localhost", 8989);
        } catch (IOException e) {
            System.out.println("连接服务器失败！");

        }
        if (client == null) {
            System.exit(1);
        }
        /*设置服务器端输入流*/
        Scanner scanner = new Scanner(client.getInputStream());
        /*设置分割符*/
        scanner.useDelimiter("\n");
        /*设置服务器端输出流*/
        PrintStream writer = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {
            if (client.isConnected()) {
                String in = getString("请输入内容:");
                writer.println(in);
                writer.flush();
                if (scanner.hasNext()) {
                    String str = scanner.next().trim();
                    System.out.println("接收到消息：\t" + str);
                }
                if ("bye".equals(in)) {
                    System.out.println("会话结束！");
                    flag = false;
                    writer.close();
                    scanner.close();
                }
            } else {
                System.out.println("失去与服务器的连接！");
                flag = false;
            }


        }
        writer.close();
        scanner.close();
    }

    public static String getString(String prompt) throws IOException {
        System.out.println(prompt);
        String msg = BUF.readLine();
        return msg;
    }
}
