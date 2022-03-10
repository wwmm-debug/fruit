package cn.ticast.fruitstore.test;

import cn.itcast.fruitstore.view.AbstractAdminDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

@SuppressWarnings("serial")
public class AbstractAdminDialogTest extends AbstractAdminDialog {

    public AbstractAdminDialogTest() {
        super();
        queryFruitItem();
    }
@Override
    public void queryFruitItem(){
        String[] thead=new String[]{"水果编号","水果名称","水果单价","计价单位"};
        String[][] today =new String[][]{
            {"1","苹果","5.0","kg" }
    };
    TableModel data = new DefaultTableModel(today, thead);
    table.setModel(data);
    }

    @Override
    public void addFruitItem() {

    }

    @Override
    public void updateFruitItem() {

    }

    @Override
    public void delFruitItem() {

    }

    public static void main(String[] args) {
        new AbstractAdminDialogTest().setVisible(true);
    }
}
