package cn.itcast.fruitstore.controller;

import cn.itcast.fruitstore.view.AbstractMainFrame;

public  class MainFrameController extends AbstractMainFrame {
    @Override
    public void showAdminDialog() {
        new AdminDialogController(this,true).setVisible(true);
    }
}
