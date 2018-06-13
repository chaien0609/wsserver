package jp.co.recomot.push.infrastructure.server.dropwizard.main;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.bundles.assets.AssetsBundleConfiguration;
import io.dropwizard.bundles.assets.AssetsConfiguration;
import jp.co.recomot.push.infrastructure.server.dropwizard.main.jedis.JedisConfigFactory;

public class WsServerApplicationConfig extends Configuration implements AssetsBundleConfiguration {

	@Valid
	@NotNull
	@JsonProperty
	private final AssetsConfiguration assets = AssetsConfiguration.builder().build();

	@Override
	public AssetsConfiguration getAssetsConfiguration() {
		return assets;
	}

	@JsonProperty("redis")
	private JedisConfigFactory redisConfig = new JedisConfigFactory();

	public JedisConfigFactory getRedisConfig() {
		return redisConfig;
	}
}