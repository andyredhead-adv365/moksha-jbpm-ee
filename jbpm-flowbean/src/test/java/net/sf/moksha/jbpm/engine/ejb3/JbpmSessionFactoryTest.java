package net.sf.moksha.jbpm.engine.ejb3;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class JbpmSessionFactoryTest {

	@Deployment
	public static Archive<?> createTestArchive() {
		WebArchive webArchive = 
		ShrinkWrap.create(WebArchive.class, "test.war")
				.addClasses(JbpmSessionFactory.class)
				.addAsWebInfResource(new File("src/main/resources/jboss-deployment-structure.xml"), "jboss-deployment-structure.xml")
				.addAsWebInfResource(new File("src/test/resources/ejb-jar.xml"), "ejb-jar.xml")
		;
		
		System.out.println("The test archive:\n" + webArchive.toString(true));
		
		return webArchive;
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
