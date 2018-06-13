package jp.co.recomot.push.infrastructure.server.dropwizard.main.jedis;

import io.dropwizard.Configuration;

public interface JedisConfiguration<C extends Configuration> {
	JedisConfigFactory getJedisConfigFactory(C configuration);
}