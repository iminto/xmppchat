package sms.bai.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() {
    SmsHandler smsHandler=new SmsHandler();
    Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());
    router.post("/api/sms").handler(routingContext ->smsHandler.get(routingContext));
    vertx.createHttpServer().requestHandler(router::accept).listen(8080);
  }

}
