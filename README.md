# xmppchat

#### 项目介绍
提供restful的接口用于推送消息到手机上，通常用于监控等webhook。
这个分支是vertx版本

#### 为啥选择XMPP
1. 微信是垃圾
2. 钉钉接口比较简单且单向，且钉钉只适用公司场景
3. XMPP协议通用公开，PC客户端和手机客户端很多
4. MQTT，你在逗我
5. Telegram，番羽土啬很麻烦
6. BerryChat等新潮IM，很新，玩的人不多

#### 需要安装什么软件接收
PC端可安装Gajim，跨所有平台
安卓手机可安装Bruno或Xabber Dev

#### 运行
mvn compile dependency:copy-depend
java  -cp  $(echo target/dependency/*.jar | tr ' ' ':'):"target/classes" io.vertx.core.Launcher start sms.bai.starte
r.MainVerticle
