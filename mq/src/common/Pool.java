package common;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;

public class Pool {
    private static ActiveMQConnectionFactory factory;
    static {
        factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
    };
    public static Connection createCon(){
        try {
            Connection con = factory.createConnection();
            return  con;
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
