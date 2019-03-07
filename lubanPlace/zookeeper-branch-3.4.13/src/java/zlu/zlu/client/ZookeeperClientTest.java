package zlu.client;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * zookeeper原生客户端
 */
public class ZookeeperClientTest {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper=new ZooKeeper("192.168.0.131:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("开始："+event);
            }
        });

        Stat stat=new Stat();
        String s=new String(zooKeeper.getData("/zlu",true,stat));
        System.out.println("結果："+s);
        System.in.read();
    }


}
