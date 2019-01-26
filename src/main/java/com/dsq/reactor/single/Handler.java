package com.dsq.reactor.single;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by DELL on 2018/12/12.
 */
public class Handler implements Runnable {

    SocketChannel socketChannel;
    SelectionKey selectionKey;
    ByteBuffer input = ByteBuffer.allocate(1024);
    ByteBuffer output = ByteBuffer.allocate(1024);
    static final  int READING = 0, SENDING = 1;
    int state = READING;

    public Handler(Selector selector, SocketChannel channel) throws IOException {
        socketChannel = channel;
        channel.configureBlocking(false);
        selectionKey = socketChannel.register(selector, 0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    boolean inputIsComplete() {
        return true;
    }

    boolean outputIsComplete() {
        return true;
    }

    void process() {

    }

    @Override
    public void run() {
        try {
            if(state == READING) {
                read();
            } else if(state == SENDING) {
                send();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read() throws IOException {
        socketChannel.read(input);
        if(inputIsComplete()) {
            process();
            state = SENDING;
            selectionKey.interestOps(SelectionKey.OP_WRITE);
        }
    }

    void send() throws IOException {
        socketChannel.write(output);
        if(outputIsComplete()) {
            selectionKey.cancel();
        }
    }
}
