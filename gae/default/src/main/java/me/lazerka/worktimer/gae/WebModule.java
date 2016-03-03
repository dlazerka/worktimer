package me.lazerka.worktimer.gae;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.common.collect.ImmutableMap;
import com.googlecode.objectify.util.jackson.ObjectifyJacksonModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.Map;

/**
 * Bindings for web-related stuff.
 * @author Dzmitry Lazerka
 */
class WebModule extends JerseyServletModule {

	@Override
	protected void configureServlets() {
		bind(UnhandledExceptionMapper.class);

		serve("/api/*").with(GuiceContainer.class, getJerseyParams());

		setUpJackson();

		//bind(WorktimeResource.class);
	}

	private Map<String, String> getJerseyParams() {
		return ImmutableMap.of(
				// Where Jersey must find servlets.
				// PackagesResourceConfig.PROPERTY_PACKAGES, "me.lazerka.worktimer.gae",

				// Don't serve application.wadl (slows server startup and exposes all URLs we have).
				PackagesResourceConfig.FEATURE_DISABLE_WADL, "true"
		);
	}

	private void setUpJackson() {
		// Handle "application/json" by Jackson.

		ObjectMapper mapper = new ObjectMapper();
		// Only map fields, not getters, nor setters.
		mapper.disable(MapperFeature.AUTO_DETECT_GETTERS);
		mapper.disable(MapperFeature.AUTO_DETECT_IS_GETTERS);
		mapper.disable(MapperFeature.AUTO_DETECT_SETTERS);

		mapper.enable(MapperFeature.USE_GETTERS_AS_SETTERS); // default
		mapper.enable(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS); // default

		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); // default
		mapper.enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
		mapper.enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
		mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES); // default

		// Probably we don't want to serialize Ref in full, but as Key always.
		mapper.registerModule(new ObjectifyJacksonModule());
		mapper.registerModule(new JodaModule());

		JacksonJsonProvider provider = new JacksonJsonProvider(mapper);
		bind(JacksonJsonProvider.class).toInstance(provider);
		bind(ObjectMapper.class).toInstance(mapper);
	}
}
