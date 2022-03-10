package cn.itcast.fruitstore.dao;

import cn.itcast.fruitstore.data.DataBase;
import cn.itcast.fruitstore.domain.Fruitltem;

import java.util.ArrayList;

public class AdminDao {
    public ArrayList<Fruitltem> queryAllData(){
        return DataBase.data;
    }
    public void addFruitItem(Fruitltem fruitltem){
        DataBase.data.add(fruitltem);
    }
    public void delFruitItem(String delNumber){
        for (int i = 0; i < DataBase.data.size(); i++) {
            Fruitltem fruitltem = DataBase.data.get(i);
            if(fruitltem.getNumber().equals(delNumber)){
                DataBase.data.remove(i);
            }
        }
    }



}
