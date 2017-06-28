package my.ch.serviceinterct.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * Created by chenh on 2017/6/28.
 */
public class TestClientOutHandler extends ChannelOutboundHandlerAdapter{
    private static Integer i = 1;
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        super.write(ctx,i++,promise);
    }
}
