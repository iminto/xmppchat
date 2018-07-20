package sms.bai.starter;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class SmsHandler {

  public void get(RoutingContext routingContext) {

//    String param = routingContext.request().getParam("q");
    HttpServerResponse response = routingContext.response();
    JsonObject json=routingContext.getBodyAsJson();
    json.put("msg","ok");
    response.putHeader("content-type","application/json");
    response.end(json.encodePrettily());
  }
}
