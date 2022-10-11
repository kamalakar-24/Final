package payloadRequestTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.payload.request.BookRequest;

@SpringBootTest
public class BookRequestTest {
		BookRequest book=new BookRequest();
		@Test
		public void emailTest() {
			book.setEmail("tkr24@gmail.com");
			String Book=book.getEmail();
			assertEquals("tkr24@gmail.com", Book);
		}
		@Test
		public void usernameTest() {
			book.setUsername("tkr");
			String Book=book.getUsername();
			assertEquals("tkr", Book);
		}
		@Test
		public void bookIdTest() {
			book.setBookId("24");
			String id=book.getBookId();
			assertEquals("24", id);
		}
}
