package me.lazerka.worktimer.gae.ah;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Dzmitry Lazerka
 */
@Path("/_ah/start")
public class StartResource {
	private static final Logger logger = LoggerFactory.getLogger(StartResource.class);

	@GET
	public String get() {
		logger.info("Started");
		return "ok";
	}
}
