package Demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

/**
 * $ javax.swing.ImageIO 1.4
 *      static BufferedImage read (File file);
 *      static BufferedImage read(URL url);
 *###  从给定地址或URL上读取图片
 */

/**
 * $ java.awt.Image 1.0
 *      Graphics getGraphics();
 * ###  返回一个图形环境，以便绘制该图像缓冲区
 *
 *      void flush();
 *###  释放该图像缓冲区中保存的所有资源
 */

/**
 * $ java.Graphics 1.0
 *      boolean drawImage(Image image,int x,int y,ImageObserver boserver);
 *###  绘制一幅非比例图像。该调用可能会在图像还未绘制完成就返回
 *      int x:左上角x坐标 int y：左上角y坐标 image：要绘制的图像 ImageObserver:绘制进程中以通告为目的的对象（可能为null）
 *
 *      Boolean drawImage(Image image,int x,int y,int Width,int height,ImageObserver observer);
 *###  绘制一幅等比例图像。系统将按照比例将图像放入给定高和宽的区域。该调用可能在图像还没有绘制完成是就退出
 *
 *      void copyArea(int x,int y,int width,int height,int dx,int dy);
 *###  拷贝屏幕的一块区域x:原始屏幕左上角x坐标。y:原始区域左上角y坐标。width:原始区域的宽度 height:原始区域的高度 dx:原始区域到目标区域的水平距离 dy:原始区域到目标区域的垂直距离
 *
 *      void dispose();
 * ###  释放图形环境和操作系统资源。必须释放由调用Image.getGraphics这样的方法获得的图形环境，但不要释放由paintComponent获得的图形环境。
 */

/**
 * $  java.awt.Component 1.0
 *      Image createImage(int width,int height);
 *###  创建一个用于双缓冲的脱屏图像缓冲区。
 */

/**
 *
 */
public class Demo_five {
    public static void main(String[] args){
        ImageFrame frame=new ImageFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ImageFrame extends JFrame{
    public ImageFrame(){
        setTitle("ImageTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        ImagePanel panel=new ImagePanel();
        add(panel);
    }
    public static final int DEFAULT_WIDTH=400;
    public static final int DEFAULT_HEIGHT=400;
}

class ImagePanel extends JPanel{
    private Image image;
    public ImagePanel(){
        try{
            image=ImageIO.read(new File("Z:\\image\\daogou.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(image==null) {
            return;
        }

        int imageWidth=image.getWidth(this);
        int imageHeight=image.getHeight(this);

        g.drawImage(image,0,0,null);

        for(int i=0;i*imageWidth<=getWidth();i++) {
            for(int j=0;j*imageHeight<=getHeight();j++) {
                if (i + j > 0) {
                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
                }
            }
        }
    }
}

