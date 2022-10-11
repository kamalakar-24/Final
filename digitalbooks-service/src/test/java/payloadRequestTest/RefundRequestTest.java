package payloadRequestTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.payload.request.RefundRequest;

@SpringBootTest
public class RefundRequestTest {
RefundRequest refund=new RefundRequest();
@Test
public void paymentIdTest() {
	refund.setPaymentId("12");
	String name=refund.getPaymentId();
	assertEquals("12", name);
}
@Test
public void emailTest() {
	refund.setEmail("kamalakar@gmail.com");
	String mail=refund.getEmail();
	assertEquals("kamalakar@gmail.com", mail);
}
@Test
public void bookId() {
	refund.setBookId("2");
	String id=refund.getBookId();
	assertEquals("2", id);
}


}
