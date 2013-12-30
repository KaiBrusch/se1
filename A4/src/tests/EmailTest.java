package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import a10.util.Email;

public class EmailTest {

	@Test
	public void testEmail() {
		Email email = Email.email("Matthias", "gmail", "com");
		assertEquals("Matthias", email.getName());
		assertEquals("gmail", email.getServer());
		assertEquals("com", email.getDomain());
		assertEquals("Matthias@gmail.com", email.toString());
	}

}
