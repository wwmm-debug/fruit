package cn.ticast.fruitstore.test;

import cn.itcast.fruitstore.view.AbstractMainFrame;

public class AbstractMainFrameTest  extends AbstractMainFrame {

    public static void main(String[] args) {
        new  AbstractMainFrameTest().setVisible(true);
    }
    @Override
    public void showAdminDialog() {
        System.out.println("进入管理界面");
    }
}
