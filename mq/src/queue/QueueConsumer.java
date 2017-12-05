package queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

//消费消息
public class QueueConsumer {

    public static void receive(){
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            Connection conn=factory.createConnection();
            conn.start();
            Session session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue=session.createQueue("first");
            MessageConsumer consumer= session.createConsumer(queue);

            consumer.setMessageListener(new MessageListener() {//注册监听器
                @Override
                public void onMessage(Message message) {
                    TextMessage message1=(TextMessage)message;
                    try {
                        System.out.println("收到消息："+message1.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        receive();
    }
}
