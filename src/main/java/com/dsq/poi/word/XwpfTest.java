package com.dsq.poi.word;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlCursor;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

            XWPFStyles wordStyles = document.createStyles();

            //添加一个段落
            XWPFParagraph p1=document.createParagraph();
           // p1.setAlignment(ParagraphAlignment.CENTER);
            p1.setStyle("1");
            XWPFRun r1=p1.createRun();
            r1.setText(data);
            // r1.setStrike(true);

            p1=document.createParagraph();
           // p1.setAlignment(ParagraphAlignment.CENTER);
            p1.setStyle("1");
           r1=p1.createRun();
            r1.setText(data);

            p1=document.createParagraph();
            //p1.setAlignment(ParagraphAlignment.CENTER);
            p1.setStyle("2");
            r1=p1.createRun();
            r1.setText(data);

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
        String filePath = "C:\\Users\\DELL\\Desktop\\导入2.docx";
        String content="";
        InputStream istream=null;
        try {
            istream = new FileInputStream(filePath);
            XWPFDocument document=new XWPFDocument(istream);
            // content=document.getLastParagraph().getText();
            List<XWPFParagraph> paras = document.getParagraphs();
            for(XWPFParagraph p : paras) {
                System.out.println(p.getText() + "===" + p.getStyle());
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

    @Test
    public void copyAndDelete() {
        String src = "C:\\Users\\DELL\\Desktop\\德赛西威公司PLM一期优化项目开发需求规格书V0.92.docx";
        String dest = "C:\\Users\\DELL\\Desktop\\test.docx";

        File destFile = new File(dest);
        if(destFile.exists()) {
            destFile.delete();
        }

        try {
            //destFile.createNewFile();
            System.out.println(destFile.exists());
            System.out.println(destFile.getCanonicalPath());
            Files.copy(new File(src).toPath(), destFile.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        InputStream istream=null;
        try {
            istream = new FileInputStream(dest);
            XWPFDocument document=new XWPFDocument(istream);
            List<XWPFParagraph> paras = document.getParagraphs();
            for(XWPFParagraph p : paras) {
                System.out.println(p.getText() + "===" + p.getStyle());
                if("B".equals(p.getText())) {
                   // p.removeRun(0);

                }
            }
            System.out.println(document.getBodyElements().size());
            document.removeBodyElement(2);

            try(FileOutputStream  ostream = new FileOutputStream(dest)) {
                document.write(ostream);
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
    public void addData() {
        String src = "C:\\Users\\DELL\\Desktop\\新建 Microsoft Word 文档.docx";
        String dest = "C:\\Users\\DELL\\Desktop\\test.docx";

        File destFile = new File(dest);
        if(destFile.exists()) {
            destFile.delete();
        }
        try(InputStream inputStream =new FileInputStream(src)) {
            Files.copy(new File(src).toPath(), destFile.toPath());
            XWPFDocument document=new XWPFDocument(inputStream);

            List<IBodyElement> bodyElements = document.getBodyElements();
            System.out.println(bodyElements);
            Map<Integer, Paragraph> mapPosStyle = new HashMap<>();
            Map<Integer, Paragraph> mapTablePosStyle = new HashMap<>();
            int preStyle = 0;
            String title = "";
            int seq = 1;

            //for(int i = bodyElements.size() - 1; i >= 0;i--) {
            for(int i = 0; i < bodyElements.size();i++) {
                IBodyElement element = bodyElements.get(i);

                if(element instanceof XWPFParagraph ) {
                    XWPFParagraph p = (XWPFParagraph)element;
                    System.out.println(p.getText() + "===" + p.getStyle());
                    String style = p.getStyle();
                    List<XWPFRun> runs = p.getRuns();
                    System.out.println("runs.size : " + runs.size());

                    if((style == null || !NumberUtils.isNumber(style))) {
                        if(runs.size() > 0 ) {
                            Paragraph newPara = new Paragraph();
                            newPara.style = preStyle + 1;
                            newPara.tile = title + seq;
                            seq++;
                            mapPosStyle.put(i, newPara);
                        }

                    } else {
                        preStyle = Integer.parseInt(style);
                        title = p.getText();
                        seq = 1;
                    }
                }
                else if(element instanceof XWPFTable) {
                    Paragraph newPara = new Paragraph();
                    newPara.style = preStyle + 1;
                    newPara.tile = title + seq;
                    seq++;
                    mapTablePosStyle.put(i, newPara);



                }

            }

            for(int i = bodyElements.size() - 1; i >= 0;i--) {
                IBodyElement element = bodyElements.get(i);
                if (element instanceof XWPFParagraph) {
                    XWPFParagraph p = (XWPFParagraph) element;
                    System.out.println(p.getText() + "===" + p.getStyle());
                    String style = p.getStyle();
                    List<XWPFRun> runs = p.getRuns();
                    if (mapPosStyle.containsKey(i) && runs.size() > 0) {
                        Paragraph para = mapPosStyle.get(i);
                        newParagraph(p, para);
                    }
                } else if(mapTablePosStyle.containsKey(i)) {
                    newTable(document, (XWPFTable) element, mapTablePosStyle.get(i));
                }
            }
            System.out.println(document.getBodyElements().size());

            try(FileOutputStream  outputStream = new FileOutputStream(dest)) {
                document.write(outputStream);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  XWPFParagraph newParagraph(XWPFParagraph paragraph, Paragraph para){
        XmlCursor xmlCursor=paragraph.getCTP().newCursor();  //从段落中获取光标
       // xmlCursor.toNextSibling();                          //将光标移动到下一个段落      ，因为光标生成是在段落的最开始位置 所以需要向下移动一个Xml的光标，也就是将光标移动到下一个段落之前，

       // xmlCursor.toPrevSibling();
        paragraph=paragraph.getDocument().insertNewParagraph(xmlCursor);//在光标所在位置添加新的段落

        XWPFRun r1=paragraph.createRun();
        r1.setText(para.tile);
        paragraph.setStyle(para.style + "");
        paragraph.setStyle(para.style  + "");

        return paragraph;
    }


    public static  XWPFParagraph newTable( XWPFDocument document, XWPFTable table, Paragraph para){
        XmlCursor xmlCursor=table.getCTTbl().newCursor();  //从段落中获取光标
        // xmlCursor.toNextSibling();                          //将光标移动到下一个段落      ，因为光标生成是在段落的最开始位置 所以需要向下移动一个Xml的光标，也就是将光标移动到下一个段落之前，

        XWPFParagraph paragraph = document.insertNewParagraph(xmlCursor);
        XWPFRun r1=paragraph.createRun();
        r1.setText(para.tile);
        paragraph.setStyle(para.style + "");
        paragraph.setStyle(para.style  + "");

/*
        XWPFTable tableOne = document.insertNewTbl(xmlCursor);
        XWPFTableRow tableOneRowOne = tableOne.getRow(0);
        tableOneRowOne.getCell(0).setText("Hello");
        tableOneRowOne.addNewTableCell().setText("World");

        xmlCursor=table.getCTTbl().newCursor();
        XWPFTable tableTwo = document.insertNewTbl(xmlCursor);
        XWPFTableRow tableOneRowTwo = tableTwo.getRow(0);
        tableOneRowTwo.getCell(0).setText("This is");
        tableOneRowTwo.addNewTableCell().setText("a table");*/

        return paragraph;
    }

}
