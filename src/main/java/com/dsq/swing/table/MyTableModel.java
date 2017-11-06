package com.dsq.swing.table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by DELL on 2017/10/24.
 */
public class MyTableModel  {
    public static void main(String[] args) {
        JFrame f = new JFrame("test");
        Object[][] row = {{ false,"语文","数学","英语","",""},{ false, new Date() }};
        String[] h = { "修改","1", "2", "3","4", "5",  };
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public Class<?> getColumnClass(int c){
                return getValueAt(0,c).getClass();
            }
            @Override
            public boolean isCellEditable(int x, int y){
                if ( y == 0)
                    return true;
                else
                    return getValueAt(x,0).toString().equals("true");
            }
        };
        dtm.setDataVector(row,h);
        dtm.addRow(new Object[]{false,"","","","","",});
        final JComboBox<String> jcb = new JComboBox<String>();
        jcb.addItem("数学");
        jcb.addItem("英语");
        jcb.addItem("语文");
        jcb.setEditable(true);
        jcb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = jcb.getSelectedItem().toString();
                if (s.equals(""))
                    return;
                boolean flag = true;
                for (int i = 0; i < jcb.getItemCount(); i++){
                    if (jcb.getItemAt(i).equals(s)){
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    jcb.addItem(s);
            }
        });

        JTable tab = new JTable(dtm);
        for (int i = 1;i < 6; i++){
            tab.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(jcb));
        }
        f.add(new JScrollPane(tab));
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(3);
    }
}
