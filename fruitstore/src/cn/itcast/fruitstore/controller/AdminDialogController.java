package cn.itcast.fruitstore.controller;

import cn.itcast.fruitstore.domain.Fruitltem;
import cn.itcast.fruitstore.service.AdminService;
import cn.itcast.fruitstore.view.AbstractAdminDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class AdminDialogController extends AbstractAdminDialog{
    private AdminService adminService=new AdminService();
    public AdminDialogController(){
        super();
    }

    public AdminDialogController(Frame owner, boolean modal) {
        super(owner, modal);
        queryFruitItem();
    }

    @Override
    public void queryFruitItem() {
    String[] thead={"水果编号","水果名称","水果单价","计价单位"};
        ArrayList<Fruitltem> dataList=adminService.queryFruitItem();
        String[][] tbody=list2Array(dataList);
        TableModel dataModel=new DefaultTableModel(tbody,thead);
        table.setModel(dataModel);
    }
    private String[][] list2Array(ArrayList<Fruitltem> list) {
            String[][] tbody=new String[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            Fruitltem fruitltem=list.get(i);
            tbody[i][0]=fruitltem.getNumber();
            tbody[i][1]=fruitltem.getName();
            tbody[i][2]=fruitltem.getPrice()+"";
            tbody[i][3]=fruitltem.getUnit();
        }
        return tbody;
    }
    @Override
    public void addFruitItem() {
        String addNumber = addNumberText.getText();
        String addName = addNameText.getText();
        String addPrice = addPriceText.getText();
        String addUnit = addUnitText.getText();

        boolean addSuccess = adminService.addFruitItem(addNumber, addName, addPrice, addUnit);
        if (addSuccess) {
            queryFruitItem();
        } else {
            JOptionPane.showConfirmDialog(this, "水果编号不可重复");
        }
    }

    @Override
    public void updateFruitItem() {
        String updataNumber = updateNumberText.getText();
        String updateName = updateNameText.getText();
        String updatePrice = updatePriceText.getText();
        String updateUnit = updateUnitText.getText();

        boolean updataSuccess = adminService.updateFruitItem(updataNumber, updateName, updatePrice,updateUnit);
        if (updataSuccess){
            queryFruitItem();
        }else {
            JOptionPane.showConfirmDialog(this, "没有这个水果");
        }
    }

    @Override
    public void delFruitItem() {
    String delNumber=delNumberText.getText();
        boolean delSuccess = adminService.delFruitItem(delNumber);
        if (delSuccess){
            queryFruitItem();
        }else {
            JOptionPane.showConfirmDialog(this, "没有这个水果");
        }
    }

}
