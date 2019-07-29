package imagetool;


import imagetool.convert.ImageToChar;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.cn;

/**
 * 调用示例
 * @author 小帅丶
 *
 */
public class Sample {
	public static void main(String[] args) throws Exception {
		ImageToChar.load("D:/download.jpg", "d:/gif/woman1.txt");//静态图片转字符保存为txt文件

		ImageToChar.loadGif("D:/1.gif", "D:/gif/");//动图转为动态的字符图片

		/*BufferedImage bi = null;
		bi = ImageIO.read(new File("D:/download.jpg"));
        String bytePic = ImageToChar.txtToImageByBase64(bi);//静态图转字符 返回转换后图片的base64
        System.out.println(bytePic);*/
	}
}
