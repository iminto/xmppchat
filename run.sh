#!/bin/sh

export LAUNCHER="io.vertx.core.Launcher"
export VERTICLE="sms.bai.starter.MainVerticle"
export VERTX_CMD="run"

java -cp  $(echo target/dependency/*.jar | tr ' ' ':'):"target/classes" $LAUNCHER $VERTX_CMD $VERTICLE --launcher-class=$LAUNCHER $@
