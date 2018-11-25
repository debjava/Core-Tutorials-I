import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

public class TestSubscriber implements MessageListener 
{


public void subscriber()
{
	try
	{
		JmsPublisher jp = new JmsPublisher();
		jp.setJndiProperty();
		TopicSession session = jp.jndiInit() ;
		TopicSubscriber subscriber=session.createSubscriber(jp.topic);
		subscriber.setMessageListener(this);
		jp.topicConnection.start();
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	
}
	
	public static void main(String[] args) 
	{
		TestSubscriber test11 = new TestSubscriber();
		test11.subscriber();
		
		
	

	}

	public void onMessage(Message msg) 
	{
		System.out.println("Am i receiving any message?");
		 try
		 {
			 if(msg instanceof TextMessage )
			 {
				 TextMessage textmessage=(TextMessage)msg;
				 String ss = textmessage.getText();
				 System.out.println(ss);
			 }
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		
	}

}
