package com.dsq.poi.word;

import org.apache.poi.xwpf.usermodel.*;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * Created by DELL on 2017/9/26.
 */
public class XwpfTest {

    //向word中写入数据
    @Test
    public  void writeDataDoc() {
        String path = "C:\\Users\\DELL\\Desktop\\hello.doc";
        String data = "hello world";
        OutputStream ostream=null;
        try {
            ostream = new FileOutputStream(path);
            ostream.write(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ostream!=null)
                try {
                    ostream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    //向word中写入数据
    @Test
    public  void writeDataDocx() {
        String path = "C:\\Users\\DELL\\Desktop\\hello.docx";
        String data = "hello world !";
        InputStream istream=null;
        OutputStream ostream=null;
        try {
            //istream = new FileInputStream(path);
            ostream = new FileOutputStream(path);
            XWPFDocument document=new XWPFDocument();
            //添加一个段落
            XWPFParagraph p1=document.createParagraph();
            p1.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun r1=p1.createRun();
            r1.setText(data);
            // r1.setStrike(true);
            document.write(ostream);
            System.out.println("创建word成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(istream!=null)
                try {
                    istream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(ostream!=null)
                try {
                    ostream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
    //读取数据 docx
    @Test
    public void readDataDocx() {
        String filePath = "C:\\Users\\DELL\\Desktop\\hello.docx";
        String content="";
        InputStream istream=null;
        try {
            istream = new FileInputStream(filePath);
            XWPFDocument document=new XWPFDocument(istream);
            // content=document.getLastParagraph().getText();
            List<XWPFParagraph> paras = document.getParagraphs();
            for(XWPFParagraph p : paras) {
                System.out.println(p.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(istream!=null)
                try {
                    istream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Test
    public void readTable() throws IOException {
        String path = "C:\\Users\\DELL\\Desktop\\test.docx";
        try(InputStream input = new FileInputStream(path);) {
            XWPFDocument document = new XWPFDocument(input);
            // 获取所有表格
            List<XWPFTable> tables = document.getTables();
            for (XWPFTable table : tables) {
                // 获取表格的行
                List<XWPFTableRow> rows = table.getRows();
                for (XWPFTableRow row : rows) {
                    // 获取表格的每个单元格
                    List<XWPFTableCell> tableCells = row.getTableCells();
                    for (XWPFTableCell cell : tableCells) {
                        // 获取单元格的内容
                        String text = cell.getText();
//                        System.out.println(text);

                        cell.setText("acfun");
                    }
                }
            }
            try(OutputStream outputStream = new FileOutputStream(path)) {
                document.write(outputStream);
            }
        }
        }

}
