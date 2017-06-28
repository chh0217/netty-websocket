package my.ch.serviceinterct;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import my.ch.serviceinterct.domain.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by chenh on 2017/6/28.
 */
public class ServiceHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ServiceHandler.class);

    private final ChannelGroup group;

    private Map<String, RegisterService> serviceMap = new ConcurrentHashMap<>();

    public ServiceHandler(ChannelGroup group) {
        this.group = group;
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        Channel c = ctx.channel();
        group.add(c);
        InetSocketAddress address = (InetSocketAddress) c.remoteAddress();
        System.out.println(address.getAddress());
        System.out.println(address.getHostName());
        System.out.println(address.getHostString());
        System.out.println(address.getPort());
        ctx.fireChannelRegistered();
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("我是接收到的消息:" + msg.toString());
        super.channelRead(ctx, msg);
    }
}