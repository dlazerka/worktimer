package me.lazerka.worktimer.gae;

import com.google.appengine.api.modules.ModulesService;
import com.google.appengine.api.modules.ModulesServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.inject.AbstractModule;

/**
 * @author Dzmitry Lazerka
 */
class GaeServicesModule extends AbstractModule {
	@Override
	protected void configure() {
		//bind(DatastoreService.class).toInstance(DatastoreServiceFactory.getDatastoreService());
		//bind(AsyncDatastoreService.class).toInstance(DatastoreServiceFactory.getAsyncDatastoreService());
		//bind(BlobstoreService.class).toInstance(BlobstoreServiceFactory.getBlobstoreService());
		//bind(ChannelService.class).toInstance(ChannelServiceFactory.getChannelService());
		//bind(ImagesService.class).toInstance(ImagesServiceFactory.getImagesService());
		//bind(MailService.class).toInstance(MailServiceFactory.getMailService());
		//bind(MemcacheService.class).toInstance(MemcacheServiceFactory.getMemcacheService());
		bind(ModulesService.class).toInstance(ModulesServiceFactory.getModulesService());
		//bind(URLFetchService.class).toInstance(URLFetchServiceFactory.getURLFetchService());
		bind(UserService.class).toInstance(UserServiceFactory.getUserService());
	}
}
