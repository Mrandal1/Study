package study.chapter12;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter12
 * @data 2020/5/8 21:41
 */
public class ClientDemo {
    private static final BufferedReader BUF = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        /*定义客户端连接信息*/
        Socket client = new Socket("localhost", 9999);
        /*设置服务器端输入流*/
        Scanner scanner = new Scanner(client.getInputStream());
        /*设置分割符*/
        scanner.useDelimiter("\n");
        /*设置服务器端输出流*/
        PrintStream writer = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {
            String in = getString("");
            writer.println(in);
            if (scanner.hasNext()) {
                String str=scanner.next().trim();
                System.out.println(str);
            }
            if ("bye".equals(in)) {
                flag = false;
                writer.close();
                scanner.close();
            }

        }
        writer.close();
        scanner.close();
    }

    public static String getString(String prompt) throws IOException {
        System.out.println(prompt);
        String str = BUF.readLine();
        return str;
    }
}
