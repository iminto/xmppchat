package com.bai.front.service.component;

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
import java.io.IOException;

public class XmppConnUtil {
    public AbstractXMPPConnection getConn(String username, String password, String domain) {
        XMPPTCPConnectionConfiguration.Builder configBuilder = XMPPTCPConnectionConfiguration.builder();
        configBuilder.setUsernameAndPassword(username, password);
        try {
            configBuilder.setResource("xmppchat");
            configBuilder.setXmppDomain(domain);
            AbstractXMPPConnection connection = new XMPPTCPConnection(configBuilder.build());
            connection.connect();
            connection.login();
            return connection;
        } catch (IOException | InterruptedException | XMPPException | SmackException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void sendMsg(AbstractXMPPConnection connection) {
        ChatManager chatManager = ChatManager.getInstanceFor(connection);
        EntityBareJid jid = null;
        try {
            jid = JidCreate.entityBareFrom("haha@xabber.org");
            Message newMessage = new Message();
            newMessage.setBody("报警信息：java.lang.OutOfMemoryError");
            Chat chat = chatManager.chatWith(jid);
            chat.send(newMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
