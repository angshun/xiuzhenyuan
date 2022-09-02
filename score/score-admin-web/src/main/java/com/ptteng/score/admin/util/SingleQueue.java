package com.ptteng.score.admin.util;

import com.ptteng.score.admin.model.Task;
import com.ptteng.score.admin.responseStructure.QueueDealStructure;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.lang.reflect.TypeVariable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/10/12
 */
public class SingleQueue {

    private SingleQueue() {
    }

    private static class SingleQueueInstance {
        /*
    Java的静态内部类单例模式。这一技术是被JVM明确说明了的，因此不存在任何二义性。
    在这段代码中，因为SingleQueue没有static的属性，因此并不会被初始化。直到调用getInstance()的时候，会首先加载SingleQueueInstance类
    这个类有一个static的queue实例，getInstance()把这个内部类的instance返回给使用者.
    静态内部类加载不依赖于外部类，且其只在被引用时装载，即lazy load。

    由于SingletonClassInstance是私有静态内部类，所以不会被其他类知道
    同样，static语义也要求不会有多个实例存在。并且，JSL规范定义，类的构造必须是原子性的，非并发的，因此不需要加同步块
    同样，由于这个构造是并发的，所以getInstance()也并不需要加同步。


    第一种形式是双重校验锁的单例。
    第二种即下面这种静态内部类的单例。
     */
        private static final Queue<QueueDealStructure> queue = new LinkedBlockingQueue<>();
    }


    //诸如此类的工具类方法最好将其设为静态，以免创建工具类对象的性能损耗，虽然增加了极小部分的内存占用。
    public static Queue<QueueDealStructure> getInstance() {
        return SingleQueueInstance.queue;
    }

    public static String reverse(String originStr) {
        //递归字符串反转
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static <T extends Serializable> T clone(T obj) throws Exception {
        //基于序列化接口的深度对象克隆，使用字节数组流
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }

    public static void fileCopy(String source, String target) throws IOException {
        //基于IO的文件复制，java7的TWR写法，IO操作直接写入try块中，自动关闭资源，前提是该对象需要实现AutoCloseable接口
        try (InputStream in = new FileInputStream(source)) {
            try (OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while ((bytesToRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesToRead);
                }
            }
        }
    }

    public static void fileCopyNIO(String source, String target) throws IOException {
        //基于NIO的文件复制
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }

    public static void forEachFile(String iniPath) throws IOException {
        Path path = Paths.get(iniPath);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void formatTime() {
        //jdk1.8新增了LocalDateTime等不变日期类，用于替换calendar
        Date localDateTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        System.out.println(simpleDateFormat.format(localDateTime));

        //java8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));
    }

    public static void main(String[] args) {
        Task task = new Task();
        Task clone = null;
        try {
            clone = clone(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(task.hashCode());
        System.out.println(clone.hashCode());
        System.out.println(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory());

        System.out.println(reverse("123456"));
    }
}
