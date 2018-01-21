package chatbot.core.handlers.sessa;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import chatbot.io.incomingrequest.IncomingRequest;
import chatbot.io.incomingrequest.RequestContent;
import chatbot.io.response.ResponseList;
import junit.framework.Assert;
import static org.mockito.BDDMockito.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
/**
 * Junit test for Sessa,that mocks the 
 * functionality of sendHttpRequest method and sends a static
 * input to SessaHandler search method. 
 * 
 * @author IDREES
 *
 */
public class SessaHandlerTest extends MockitoJUnit{
    @SuppressWarnings("deprecation")
	@Test
	/**
	   * This is the test case method.
	   * @return nothing.
	   */
	 public void testsessa() throws Exception{  
    	 	IncomingRequest req = new IncomingRequest(); 
		 	RequestContent add =  new RequestContent();
		 	add.setText("hello");
		 	add.setPayload("text");
		 	List<RequestContent> messageData= new ArrayList<RequestContent>();
		 	messageData.add(add);
		 	req.setRequestContent(messageData);
  	
		 	SessaHandler obj = mock(SessaHandler.class);
		 	when(obj.sendHTTPRequest("http://localhost:7070/search?query=hello")).thenReturn("Hello, how may I help you?");
		 	when(obj.search(req)).thenCallRealMethod();
		 	ResponseList response = obj.search(req);
		 	String mocked_response = obj.sendHTTPRequest("http://localhost:7070/search?query=hello");
		 	System.out.print(mocked_response);

}
}

