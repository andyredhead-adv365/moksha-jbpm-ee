package net.sf.moksha.jbpm.engine.ejb3;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class JbpmSessionFactoryTest {

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addClasses(JbpmSessionFactory.class)
				.addAsResource(new File("src/main/resources/jboss-deployment-structure.xml"));
	}
	
	@EJB
	JbpmSessionFactory _jbpmSessionFactory;
	
	@Test
	public void testGetJbpmSession() {
		
		assertNotNull("testGetJbpmSession - jbpmSessionFactory is null", _jbpmSessionFactory);
		
		String jbpmSession = _jbpmSessionFactory.createJbpmSession();
		assertNotNull("testGetJbpmSession - jbpm session is null", jbpmSession);
		
		System.out.println("testGetJbpmSession - string is: " + jbpmSession);
	}
	
}
