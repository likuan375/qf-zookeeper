package com.qf.qfzookeeper;

import com.qf.qfzookeeper.util.MyWatcher;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QfZookeeperApplicationTests {

	@Test
	public void contextLoads() throws IOException, KeeperException, InterruptedException {
		//创建连接
		ZooKeeper zooKeeper = new ZooKeeper("10.20.151.43:2181",2000,new MyWatcher());

		String s = zooKeeper.create("/newyou", "data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

		Stat stat = zooKeeper.exists("/newlol", false);
		zooKeeper.setData("/newlol","jiangshi".getBytes(),-1);
		System.out.println(stat.getEphemeralOwner());
		zooKeeper.getData("/newlol",new MyWatcher(),null);
		Stat exists = zooKeeper.exists("/newttt", new MyWatcher());

		zooKeeper.close();
		System.in.read();
	}

}
