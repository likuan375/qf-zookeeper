package com.qf.qfzookeeper.util;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class MyWatcher implements Watcher{
    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.EventType type = watchedEvent.getType();
        System.out.println(type);
        Event.KeeperState state = watchedEvent.getState();
        System.out.println(state);
    }
}
