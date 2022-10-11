package EntityTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.models.Role;

@SpringBootTest
public class RoleTest {
	Role role = new Role();

//	@Test
//	public void idTest() {
//		role.setId(2);
//		Integer id = role.getId();
//		assertThat(1).isEqualTo(id);
//	}
//	@Test
//	public void nameTest() {
//		role.setName(null);
//		String name= role.getName();
//		assertEquals(null, name);
//	}
}
