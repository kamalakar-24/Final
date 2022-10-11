package controllerTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.controllers.Advice.GenaralExceptionalHandler;
import com.digitalbooks.payload.response.ErrorResponse;

@SpringBootTest

public class ExceptionalHandlerTest {
	@InjectMocks
	GenaralExceptionalHandler generalexception;

//	@Test
//	public void exceptionTest() {
//		Exception exe = new Exception();
//		ErrorResponse erroor = generalexception.handleException(exe);
//		ErrorResponse r = new ErrorResponse();
//		r.setErrocode("General");
//		r.setDescription(exe.getMessage());
//		r.setException(exe);
//		assertNotNull(erroor);
//
//	}
}
