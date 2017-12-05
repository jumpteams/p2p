package topic;

import common.Pool;

import javax.jms.*;

/**
 * Created by Administrator on 2017/12/1.
 */
public class TopicConsumer2 {
    public static void receiver(){
        Connection con = Pool.createCon();
        try {
            con.start();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("second");
            MessageConsumer consumer = session.createConsumer(topic);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage msg= (TextMessage) message;
                    try {
                        System.out.println("receive2:"+msg.getText());
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
        receiver();
    }
}
