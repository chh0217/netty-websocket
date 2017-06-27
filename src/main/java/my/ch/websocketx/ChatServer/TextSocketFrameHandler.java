package my.ch.websocketx.ChatServer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenh on 2017/6/27.
 */
public class TextSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static final Logger logger = LoggerFactory.getLogger(TextSocketFrameHandler.class);
    private ChannelGroup group;

    public TextSocketFrameHandler(ChannelGroup group){
        this.group = group;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        group.add(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String u = ctx.channel().remoteAddress() + ":";
//        group.write(u.getBytes());
//        group.write(msg.retain());
        group.write(new TextWebSocketFrame(u+msg.text()));
        group.flush();
    }
}
