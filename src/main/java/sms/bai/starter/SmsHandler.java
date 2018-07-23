package sms.bai.starter;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import sms.bai.util.XmppConnUtil;

public class SmsHandler {

  public void get(RoutingContext routingContext) {

//    String param = routingContext.request().getParam("q");
    HttpServerResponse response = routingContext.response();
    JsonObject json=routingContext.getBodyAsJson();
    String toUser=json.getString("toUser");
    String msg=json.getString("msg");
    XmppConnUtil xmppConnUtil=new XmppConnUtil();
    xmppConnUtil.connect();
    xmppConnUtil.sendMsg(toUser,msg);
    json.put("success",true);
    response.putHeader("content-type","application/json");
    response.end(json.encodePrettily());
  }
}
