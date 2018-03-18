package com.dsq.rpc;

import java.io.IOException;

/**
 * Created by DELL on 2018/3/18.
 */
public interface Server {

    public void stop();

    public void start() throws IOException;

    public void register(Class serviceInterface, Class impl);

    public boolean isRunning();

    public int getPort();
}
