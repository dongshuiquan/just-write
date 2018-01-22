package com.dsq.swing.table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.StringTokenizer;

/**
 * Created by DELL on 2017/11/10.
 */
public class MutilHeadTable extends JTable {

    public MutilHeadTable(TableModel tm) {
        super(tm);
        init();
    }

    private void init() {
        //为每个列添加自定义的RENDER.这个Api设计比较麻烦.
        CustomizedHeaderRender r = new CustomizedHeaderRender();
        for (int i = 0; i < getModel().getColumnCount(); i++) {
            TableColumn column = getColumnModel().getColumn(i);
            column.setHeaderRenderer(new CustomizedHeaderRender());
        }
    }

    //一个自己定义的头部渲染器.可以根据自己的需要来返回不同的组件显示内容.
    private class CustomizedHeaderRender extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table,
                                                       Object value,
                                                       boolean isSelected,
                                                       boolean hasFocus,
                                                       int row,
                                                       int column) {

            if (value != null && value instanceof String) {
                StringTokenizer t = new StringTokenizer((String) value, "/");
                StringBuffer bf = new StringBuffer();
                bf.append("<html>");

                while (t.hasMoreElements()) {
                    bf.append(t.nextElement());
                    if (t.hasMoreElements())
                        bf.append("<br>");
                    else
                        bf.append("</html>");
                }
                return new JLabel(bf.toString());
            }
            return this;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Leaders");
        Container contentPane = frame.getContentPane();
        String headers[] = {"Line1/line2/line3", "Country"};
        String data[][] = {
                {"Tony Blair", "England"},
                {"Thabo Mbeki", "South Africa"},
        };
        TableModel model = new DefaultTableModel(data, headers);

        MutilHeadTable table = new MutilHeadTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }


}