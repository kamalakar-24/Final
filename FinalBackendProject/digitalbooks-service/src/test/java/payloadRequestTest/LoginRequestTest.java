package payloadRequestTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.payload.request.LoginRequest;

@SpringBootTest
public class LoginRequestTest {
LoginRequest login=new LoginRequest();

@Test
public void usernameTest() {
	login.setUsername("kamalakar");
	String name=login.getUsername();
	assertEquals("kamalakar", name);
}

@Test
public void passwordTest() {
	login.setPassword("password");
	String pass=login.getPassword();
	assertEquals("password", pass);
}
}
