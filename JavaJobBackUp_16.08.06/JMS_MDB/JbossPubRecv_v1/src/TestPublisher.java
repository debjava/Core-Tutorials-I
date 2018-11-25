import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

public class TestPublisher
{


	public static void main(String[] args) 
	{
		JmsPublisher jp = new JmsPublisher();
		jp.setJndiProperty();
		TopicSession session = jp.jndiInit() ;
		TopicPublisher publisher = null;
		
		 try
		 {
			publisher=session.createPublisher(jp.topic);
			jp.topicConnection.start();
			TextMessage msg=session.createTextMessage();
			StringBuffer body=new StringBuffer();
			body.append("<?xml version=\"1.0\"?>\n");
			body.append("<message>\n");
			body.append(" <sender>"+"HAI"+"</sender>\n");
			body.append(" <content>"+"WELCOME"+"</content>\n");
			body.append("</message>\n");
			msg.setText(body.toString());
			publisher.publish(msg);
		 }
		 
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }

	}
}
