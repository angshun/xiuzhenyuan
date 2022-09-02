package com.jnshu.Utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Tom on 2017/5/17.
 */
public class windows {

    public static void main(String [] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
////        JFileChooser给你个例子吧
////首先是创建JFileChooser 对象，里面带个参数，表示默认打开的目录，这里是默认打开当前文件所在的目录。
//        JFileChooser file = new JFileChooser ("");
////下面这句是去掉显示所有文件这个过滤器。
//        file.setAcceptAllFileFilterUsed(false);
////添加excel文件的过滤器
////        file.addChoosableFileFilter(new ExcelFileFilter("xls"));
////添加exe文件的过滤器
////        file.addChoosableFileFilter(new ExcelFileFilter("exe"));
////使用showOpenDialog()方法，显示出打开选择文件的窗口，当选择了某个文件后，或者关闭此窗口那么都会返回一个
////整型数值，如果返回的是0，代表已经选择了某个文件。如果返回1代表选择了取消按钮或者直接关闭了窗口*/
//        int result = file.showOpenDialog(null);
////JFileChooser.APPROVE_OPTION是个整型常量，代表0。就是说当返回0的值我们才执行相关操作，否则什么也不做。
//if(result == JFileChooser.APPROVE_OPTION)
//{
////获得你选择的文件绝对路径。并输出。当然，我们获得这个路径后还可以做很多的事。
//   String path = file.getSelectedFile().getAbsolutePath();
//   System.out.println(path);
//}
//else
//{
//    System.out.println("你已取消并关闭了窗口！");
//   }
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFileChooser fc=new JFileChooser();
        fc.showOpenDialog(null);
        System.out.println(fc.getSelectedFile());
}


}
