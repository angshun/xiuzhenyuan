package com.ptteng.start;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by shun 2017.07.07.11 11:06
 */
public class ServerStart2 {
    public static void main(String[] args) throws InterruptedException {
        Node node = NodeFactory.newInstance().createNode( "StudentService.composite");
        node.start();
        while (true ) {
            System.out.println("Service2启动发布成功");
            TimeUnit. SECONDS.sleep(Long.MAX_VALUE);
        }
    }
}
