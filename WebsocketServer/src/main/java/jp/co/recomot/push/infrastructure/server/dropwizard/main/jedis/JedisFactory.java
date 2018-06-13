package jp.co.recomot.push.infrastructure.server.dropwizard.main.jedis;

import org.glassfish.hk2.api.Factory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Factory to create Jedis connections from the JedisPool Singleton
 * setup in {@link jp.co.recomot.push.infrastructure.server.dropwizard.main.jedis.WsEndpointHandlerBinder.jersey.JedisPoolBinder}.
 */
public class JedisFactory implements Factory<Jedis> {
    private final JedisPool pool;

    public JedisFactory(JedisPool pool) {
        this.pool = pool;
    }

    @Override
    public Jedis provide() {
        return pool.getResource();
    }

    @Override
    public void dispose(Jedis jedis) {
        // we can close the connection directly because Jedis knows
        //   which pool created it.
        jedis.close();
    }
}
