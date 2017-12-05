package topic;

import common.Pool;

import javax.jms.*;

/**
 * Created by Administrator on 2017/12/1.
 */
public class TopicProducer {
    public static void send(){
        Connection con = Pool.createCon();
        try {
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("second");
            MessageProducer producer = session.createProducer(topic);
            TextMessage message = session.createTextMessage("广播");
            producer.send(message);
            session.close();
            con.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        send();
    }
}
