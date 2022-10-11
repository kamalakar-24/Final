package payloadRequestTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.payload.request.SignupRequest;

@SpringBootTest
public class signUpTest {
	SignupRequest signup=new SignupRequest();
	
	@Test
	public void usernameTest() {
		signup.setUsername("kamalakar");
		String name=signup.getUsername();
		assertEquals("kamalakar", name);
	}
	
	@Test
	public void passwordTest() {
		signup.setPassword("password");
		String pass=signup.getPassword();
		assertEquals("password", pass);
	}
	
	@Test
	public void emailTest() {
		signup.setEmail("tkr24@gmail.com");
		String mail=signup.getEmail();
		assertEquals("tkr24@gmail.com", mail);
	}
}
