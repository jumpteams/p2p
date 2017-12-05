package queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

//消息生产者
public class QueueProducer {
    public static void send(){
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            Connection conn=factory.createConnection();//获取连接

            Session session=conn.createSession(false,Session.AUTO_ACKNOWLEDGE);//创建会话

            Queue q=session.createQueue("first");

            MessageProducer producer=session.createProducer(q);

            TextMessage msg=session.createTextMessage("我发送消息了");

            producer.send(msg);//发送

            session.close();
            conn.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        send();
    }
}
