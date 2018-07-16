package com.bai.front.service.component;

import com.bai.front.util.PropUtil;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class XmppConnUtil {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private AbstractXMPPConnection connection;

    public AbstractXMPPConnection getConn() {
        String username= PropUtil.getString("username");
        String password=PropUtil.getString("password");
        String domain=PropUtil.getString("domain");
        XMPPTCPConnectionConfiguration.Builder configBuilder = XMPPTCPConnectionConfiguration.builder();
        configBuilder.setUsernameAndPassword(username, password);
        try {
            configBuilder.setResource("xmppchat");
            configBuilder.setXmppDomain(domain);
            connection = new XMPPTCPConnection(configBuilder.build());
            connection.connect();
            connection.login();
            return connection;
        } catch (IOException | InterruptedException | XMPPException | SmackException e) {
            log.error("登录XMPP异常",e);
            return null;
        }
    }

    public void sendMsg(String toUser,String msg) {
        try {
            ChatManager chatManager = ChatManager.getInstanceFor(connection);
            EntityBareJid jid = null;
            jid = JidCreate.entityBareFrom(toUser);
            Message newMessage = new Message();
            newMessage.setBody(msg);
            Chat chat = chatManager.chatWith(jid);
            chat.send(newMessage);
        } catch (Exception e) {
            log.error("发送消息异常",e);
        }

    }

    public AbstractXMPPConnection getConnection() {
        return connection;
    }

    public void setConnection(AbstractXMPPConnection connection) {
        this.connection = connection;
    }
}
