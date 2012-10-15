package net.sf.moksha.jbpm.engine.ejb3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.Logger;

/**
 * A thread safe singleton factory class for jBPM (5.3+) sessions.
 * 
 * It is expected that sessions created by instances of this factory will be used for a single interaction with a single flow within a single process instance, however that is up to
 * the clients of the factory.
 * 
 * Eventually the strategy for loading process definitions will become pluggable, until then, the process definitions are loaded from .xxx.
 * 
 * @author andy.redhead
 *
 */
@Singleton
@Startup
public class JbpmSessionFactory {

	private static Logger _log = Logger.getLogger(JbpmSessionFactory.class);
	
	@PostConstruct
	public void init() {
		if (_log.isDebugEnabled()) {
			_log.debug("init - begin");
		}
		
		System.out.println("init");
		
		if (_log.isDebugEnabled()) {
			_log.debug("init end");
		}
	}
	
	@PreDestroy
	public void shutdown() {
		if (_log.isDebugEnabled()) {
			_log.debug("shutdown - begin");
		}
		
		System.out.println("shutdown");
		
		if (_log.isDebugEnabled()) {
			_log.debug("shutdown end");
		}		
	}
	
	/**
	 * Called by clients to obtain a 
	 * @return
	 */
	public String createJbpmSession() {
		String jbpmSession = null;
		if (_log.isDebugEnabled()) {
			_log.debug("createJbpmSession - begin");
		}
		
		_log.info("createJbpmSession - here is an info level log message");
		
		System.out.println("createJbpmSession");
		
		jbpmSession = "hello";
		
		if (_log.isDebugEnabled()) {
			_log.debug("createJbpmSession - end");
		}		
		return jbpmSession;
	}
	
}
