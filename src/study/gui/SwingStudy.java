package study.gui;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Randal1
 * @version V1.0
 * @Package study
 * @data 2020/5/13 21:37
 */
public class SwingStudy {
    public static void main(String[] args) {
        /*创建一个顶级窗口*/
        JFrame jf = new JFrame("顶级窗口");
        /*设置窗口大小*/
        jf.setSize(250, 250);
        /*设置窗口位置*/
        jf.setLocationRelativeTo(null);

        /*创建中间容器（面板）*/
        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(204 ,204,204,100));
        /*创建一个按钮，并将其添加至面板*/
        JButton button = new JButton("简单按钮");

        jPanel.add(button);

        /*将面板添加至顶级窗口*/
        jf.setContentPane(jPanel);
        /*显示窗口*/
        jf.setVisible(true);
    }
}
