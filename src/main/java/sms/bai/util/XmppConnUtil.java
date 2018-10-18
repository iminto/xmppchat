package sms.bai.util;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import java.io.IOException;

public class XmppConnUtil {

    private AbstractXMPPConnection connection;

    public AbstractXMPPConnection connect() {
        String username= PropUtil.getString("username");
        String password=PropUtil.getString("password");
        String domain=PropUtil.getString("domain");
        String host=PropUtil.getString("host");
        Integer timeout=PropUtil.getInt("timeout");
        XMPPTCPConnectionConfiguration.Builder configBuilder = XMPPTCPConnectionConfiguration.builder();
        configBuilder.setUsernameAndPassword(username, password);
        try {
            configBuilder.setResource("xmppchat");
            configBuilder.setXmppDomain(domain);
            configBuilder.setConnectTimeout(timeout);
            configBuilder.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
            configBuilder.setHost(host);
            connection = new XMPPTCPConnection(configBuilder.build());
            connection.connect();
            connection.login();
            return connection;
        } catch (IOException | InterruptedException | XMPPException | SmackException e) {
            System.out.println("登录XMPP异常"+e.getMessage());
            return null;
        }
    }

    public void sendMsg(String toUser,String msg) {
        try {
            if(!connection.isConnected()){
                connect();
            }
            ChatManager chatManager = ChatManager.getInstanceFor(connection);
            EntityBareJid jid = null;
            jid = JidCreate.entityBareFrom(toUser);
            Message newMessage = new Message();
            newMessage.setBody(msg);
            Chat chat = chatManager.chatWith(jid);
            chat.send(newMessage);
        } catch (Exception e) {
            System.out.println("发送消息异常"+e.getMessage());
        }

    }

    public AbstractXMPPConnection getConnection() {
        return connection;
    }

    public void setConnection(AbstractXMPPConnection connection) {
        this.connection = connection;
    }
}
