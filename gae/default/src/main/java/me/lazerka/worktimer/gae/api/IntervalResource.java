package me.lazerka.worktimer.gae.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Dzmitry Lazerka
 */
@Path("/interval")
public class IntervalResource {

	@GET
	@Path("/list")
	public String list() {
		return "stub";
	}
}
