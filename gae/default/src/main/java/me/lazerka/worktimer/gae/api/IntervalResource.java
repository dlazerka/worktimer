package me.lazerka.worktimer.gae.api;

import com.google.common.collect.ImmutableList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * @author Dzmitry Lazerka
 */
@Path("/api/interval")
public class IntervalResource {

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<String> list() {
		return ImmutableList.of("foo", "bar");
	}
}
