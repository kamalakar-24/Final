package EntityTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.models.User;

@SpringBootTest
public class UserEntityTest {
	User author = new User();

	@Test
	public void iDtest() {
		author.setId(1L);
		Long id = author.getId();
		assertThat(1L).isEqualTo(id);

	}

	@Test
	public void userNameTest() {
		author.setUsername("kamal");
		String name = author.getUsername();
		assertEquals("kamal", name);

	}

	@Test
	public void emailTest() {
		author.setEmail("kamalakar24@gmail.com");
		String email = author.getEmail();
		assertEquals("kamalakar24@gmail.com", email);

	}

	@Test
	public void passwordTest() {
		author.setPassword("password");
		String pass = author.getPassword();
		assertEquals("password", pass);

	}
}
