package cn.itcast.fruitstore.view;

import cn.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractMainFrame extends JFrame {
    private JLabel titleLabel=new JLabel(new ImageIcon("./cat.jpg"));
    private JButton btn=new  JButton("进入系统");

    public AbstractMainFrame()  {
        this.init();
        this.addComponent();
        this.addListener();
    }

    private void addListener() {
    btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            showAdminDialog();
        }
    });
    }

    public abstract void  showAdminDialog();
    private void addComponent() {
        this.add(this.titleLabel,BorderLayout.NORTH);//图片放入北区
        //JPanel对象
        JPanel btnPanel=new JPanel();
        //清除布局
        btnPanel.setLayout(null);
        this.add(btnPanel);
        //按钮
        btn.setBounds(240,20,120,50);
        btnPanel.add(btn);
    }

    private void init() {
        this.setTitle("水果超市欢迎你");
        this.setSize(600,400);
        GUITools.center(this);
        GUITools.setTitleImage(this,"title.png");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出
    }

}
