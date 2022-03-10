package cn.itcast.fruitstore.service;

import cn.itcast.fruitstore.dao.AdminDao;
import cn.itcast.fruitstore.domain.Fruitltem;

import java.util.ArrayList;

public class AdminService {
    private AdminDao adminDao=  new  AdminDao();
    public ArrayList<Fruitltem> queryFruitItem(){
        ArrayList<Fruitltem> data=adminDao.queryAllData();
        return data;
    }
    public boolean addFruitItem(String number,String name,String price,String unit){
        ArrayList<Fruitltem> data=queryFruitItem();
        for (int i = 0; i < data.size(); i++) {
            Fruitltem fruitltem=data.get(i);
            if(number.equals(fruitltem.getNumber())){
                return false;
            }
        }
        Fruitltem thisFruitITEM=new Fruitltem(number,name, Double.parseDouble(price),unit);
        adminDao.addFruitItem(thisFruitITEM);
        return  true;
    }
    public boolean updateFruitItem(String number,String name,String price,String unit){
        ArrayList<Fruitltem> data=queryFruitItem();
        for (int i = 0; i < data.size(); i++) {
            Fruitltem fruitltem=data.get(i);
            if(number.equals(fruitltem.getNumber())){
                adminDao.delFruitItem(number);
                Fruitltem thisFruitItem=new Fruitltem(number,name, Double.parseDouble(price),unit);
                adminDao.addFruitItem(thisFruitItem);
                return true;
            }
        }
        return false;
    }
    public boolean delFruitItem(String delNumber){
        ArrayList<Fruitltem> data=queryFruitItem();
        for (int i = 0; i < data.size(); i++) {
        Fruitltem fruitItem=data.get(i);
        if (delNumber.equals(fruitItem.getNumber())){
            adminDao.delFruitItem(delNumber);
            return true;
        }

        }
        return false;
    }




}
