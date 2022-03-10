package cn.itcast.fruitstore.data;

import cn.itcast.fruitstore.domain.Fruitltem;

import java.util.ArrayList;

public class DataBase {
    public static ArrayList<Fruitltem> data =new ArrayList<Fruitltem>();
    static {
        data.add(new Fruitltem( "1","苹果", 5.0 ," kg " ));
    }
}
