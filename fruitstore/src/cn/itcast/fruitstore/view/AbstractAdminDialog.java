package cn.itcast.fruitstore.view;

import cn.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractAdminDialog extends JDialog {
    private  JLabel tableLabel=new JLabel("水果列表");
    private JScrollPane tablePane= new JScrollPane();//滚动视口
    protected JTable table=new JTable();
    private  JLabel numberLabel=new JLabel("水果编号");
    private  JLabel nameLabel=new JLabel("水果名称");
    private  JLabel priceLabel=new JLabel("水果单价");
    private  JLabel unitLabel=new JLabel("计量单位");

    protected JTextField addNumberText =new JTextField(6);
    protected JTextField addNameText =new JTextField(6);
    protected JTextField addPriceText =new JTextField(6);
    protected JTextField addUnitText =new JTextField(6);
    private final JButton addBtn =new JButton("添加水果");

    protected JTextField updateNumberText =new JTextField(6);
    protected JTextField updatePriceText =new JTextField(6);
    protected JTextField updateNameText =new JTextField(6);
    protected JTextField updateUnitText =new JTextField(6);
    private JButton updateBtn =new JButton("修改水果");

    protected JTextField delNumberText=new JTextField(6);
    private JButton delbtn  =new JButton("删除水果");

    public AbstractAdminDialog(Frame owner, boolean modal) {
        super(owner, modal);
        this.init();
        this.addComponent();
        this.addListener();
    }
    public AbstractAdminDialog() {
    this(null,true);
    }
    private void addListener() {
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addFruitItem();
            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                updateFruitItem();
            }
        });
        delbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                delFruitItem();
            }
        });

    }
    public abstract void queryFruitItem();
    public abstract void addFruitItem();
    public abstract void updateFruitItem();
    public abstract void delFruitItem();


    private void addComponent() {
        this.setLayout(null);
        //表格标题
        tableLabel.setBounds(265,20,70,25);
        this.add(tableLabel);
        //表格
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        tablePane.setBounds(50,50,500,200);
        table.setEnabled(false);
        tablePane.setViewportView(table);
        this.add(tablePane);

        numberLabel.setBounds(50,250,70,25);
        nameLabel.setBounds(150,250,70,25);
        priceLabel.setBounds(250,250,70,25);
        unitLabel.setBounds(350,250,70,25);
        this.add(numberLabel);
        this.add(nameLabel);
        this.add(priceLabel);
        this.add(unitLabel);


        addNumberText.setBounds(50,280,80,25);
        addNameText.setBounds(150,280,80,25);
        addPriceText.setBounds(250,280,80,25);
        addUnitText.setBounds(350,280,80,25);
        this.add(addNumberText);
        this.add(addNameText);
        this.add(addPriceText);
        this.add(addUnitText);

        addBtn.setBounds(460,280,90,25);
        this.add(addBtn);

        updateNumberText.setBounds(50,310,80,25);
        updateNameText.setBounds(150,310,80,25);
        updatePriceText.setBounds(250,310,80,25);
        updateUnitText.setBounds(350,310,80,25);
        this.add(updateNameText);
        this.add(updateNumberText);
        this.add(updatePriceText);
        this.add(updateUnitText);
        updateBtn.setBounds(460,310,90,25);

        this.add(updateBtn);

        delNumberText.setBounds(50,340,80,25);
        this.add(delNumberText);
        delbtn.setBounds(460,340,90,25);
        this.add(delbtn);
    }

    private void init() {
        this.setTitle("超市货物管理!");
        this.setSize(600,400);
        GUITools.center(this);
        this.setResizable(false);
    }
}
