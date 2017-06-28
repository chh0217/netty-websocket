package my.ch.serviceinterct.client;

import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenh on 2017/6/28.
 */
public class SendThread implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(TestClient.class);

    private Channel channel;

    public SendThread(Channel channel){
        this.channel = channel;
    }
    @Override
    public void run() {
        for(int i=0;;i++){
            try {
                Thread.sleep(5000);
                logger.info(i+":::::啊哈哈哈哈哈");
                channel.writeAndFlush(i+":::::啊哈哈哈哈哈");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
