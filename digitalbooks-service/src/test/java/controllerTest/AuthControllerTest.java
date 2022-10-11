package controllerTest;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.digitalbooks.controllers.AuthController;
import com.digitalbooks.models.ERole;
import com.digitalbooks.models.Role;
import com.digitalbooks.models.User;
import com.digitalbooks.payload.request.LoginRequest;
import com.digitalbooks.payload.request.SignupRequest;
import com.digitalbooks.payload.response.MessageResponse;
import com.digitalbooks.repository.RoleRepository;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.security.jwt.JwtUtils;

@RunWith(SpringRunner.class)
public class AuthControllerTest {
	@Mock
	AuthenticationManager authenticationManager;

	@Mock
	UserRepository userRepository;

	@Mock
	RoleRepository roleRepository;

	@Mock
	PasswordEncoder encoder;

	@Mock
	JwtUtils jwtUtils;
	
	@InjectMocks
	AuthController authController;
	
	@Test
	public void testAuthenticateUser() {
		LoginRequest loginRequest= new LoginRequest();
		loginRequest.setUsername("kamalakar");
		loginRequest.setPassword("123456");
		Authentication authToken = new UsernamePasswordAuthenticationToken (loginRequest.getUsername(), loginRequest.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authToken);
	}
	
	@Test
	public void testRegisterUsertWithExistingUser() {
		SignupRequest signUpRequest = new SignupRequest();
		Set<Role> rolelist= new HashSet();
		Role role= new Role();
		role.setName(ERole.ROLE_AUTHOR);
		signUpRequest.setUsername("kamalakar");
		signUpRequest.setPassword("123456");
		signUpRequest.setEmail("kamalakar24@gmail.com");
		rolelist.add(role);
		when(userRepository.existsByUsername(signUpRequest.getUsername())).thenReturn(true);
		ResponseEntity responseEntity= ResponseEntity
				.badRequest()
				.body(new MessageResponse("Error:  Username is already taken!"));
		ResponseEntity responseEntity1= authController.registerUser(signUpRequest);
		assertNotNull(responseEntity1);
	}
	
	@Test
	public void testRegisterUsertWithExistinEmail() {
		SignupRequest signUpRequest = new SignupRequest();
		Set<Role> rolelist= new HashSet();
		Role role= new Role();
		role.setName(ERole.ROLE_AUTHOR);
		signUpRequest.setUsername("kamalakar");
		signUpRequest.setPassword("123456");
		signUpRequest.setEmail("kamalakar24@gmail.com");
		rolelist.add(role);
		when(userRepository.existsByEmail(signUpRequest.getEmail())).thenReturn(true);
		ResponseEntity responseEntity= ResponseEntity
				.badRequest()
				.body(new MessageResponse("Error: Email is already in use!"));
		ResponseEntity responseEntity1= authController.registerUser(signUpRequest);
		assertNotNull(responseEntity1);
	}
	
	@Test
	public void testRegisterUserWithDefaultUser() {
		SignupRequest signUpRequest = new SignupRequest();
		Set<Role> rolelist= new HashSet();
//		Role role= new Role();
//		role.setName(ERole.ROLE_AUTHOR);
		signUpRequest.setUsername("kamalakar");
		signUpRequest.setPassword("123456");
		signUpRequest.setEmail("kamalakar@gmail.com");
//		rolelist.add(role);
//		when(userRepository.existsByEmail(signUpRequest.getEmail())).thenReturn(true);
//		ResponseEntity responseEntity= ResponseEntity
//				.badRequest()
//				.body(new MessageResponse("Error: Email is already in use!"));
//		ResponseEntity responseEntity1= authController.registerUser(signUpRequest);
//		assertNotNull(responseEntity1);
		
		// Create new user's account
				User user = new User(signUpRequest.getUsername(), 
									 signUpRequest.getEmail(),
									 encoder.encode(signUpRequest.getPassword()));

				Set<String> strRoles = signUpRequest.getRole();
				Set<Role> roles = new HashSet<>();
				when(signUpRequest.getRole()).thenReturn(null);
				
				Role readerRole = new Role();
				readerRole.setName(ERole.ROLE_AUTHOR);
				Optional<Role> optioanl=Optional.of(readerRole);
				when(roleRepository.findByName(ERole.ROLE_READER)).thenReturn(optioanl);
				ResponseEntity responseEntity=ResponseEntity.ok(new MessageResponse("Reader"+"  registered is  successfully!"));
				ResponseEntity responseEntity1=authController.registerUser(signUpRequest);
                assertNotNull(responseEntity1);
	}
	
	@Test
	public void testRegisterUserWithDefaultUserReader() {
		SignupRequest signUpRequest = new SignupRequest();
		Set<Role> rolelist= new HashSet();
		Role role= new Role();
		role.setName(ERole.ROLE_READER);
		signUpRequest.setUsername("kamalakar");
		signUpRequest.setPassword("123456");
		signUpRequest.setEmail("kamalakar@gmail.com");	
		rolelist.add(role);
	
		// Create new user's account
				User user = new User(signUpRequest.getUsername(), 
									 signUpRequest.getEmail(),
									 encoder.encode(signUpRequest.getPassword()));

				Set<String> strRoles = signUpRequest.getRole();
				Set<Role> roles = new HashSet<>();
				when(signUpRequest.getRole()).thenReturn(strRoles);
				
				Role readerRole = new Role();
				readerRole.setName(ERole.ROLE_READER);
				Optional<Role> optioanl=Optional.of(readerRole);
				when(roleRepository.findByName(ERole.ROLE_READER)).thenReturn(optioanl);
				ResponseEntity responseEntity=ResponseEntity.ok(new MessageResponse("Reader"+"  registered is  successfully!"));
				ResponseEntity responseEntity1=authController.registerUser(signUpRequest);
                assertNotNull(responseEntity1);
	}
	}



