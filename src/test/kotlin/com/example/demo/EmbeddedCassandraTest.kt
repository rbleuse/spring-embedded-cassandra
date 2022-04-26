package com.example.demo

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.CqlSessionBuilder
import com.datastax.oss.driver.api.core.config.DefaultDriverOption
import com.datastax.oss.driver.api.core.config.DriverConfigLoader
import com.github.nosan.boot.autoconfigure.embedded.cassandra.EmbeddedCassandraAutoConfiguration
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration(proxyBeanMethods = false)
class CqlSessionConfiguration {
    @Bean
    fun session(): CqlSession {
        return CqlSessionBuilder().withLocalDatacenter("datacenter1")
            .withConfigLoader(
                DriverConfigLoader.programmaticBuilder()
                    .withInt(DefaultDriverOption.CONNECTION_CONNECT_TIMEOUT, 5000)
                    .withInt(DefaultDriverOption.REQUEST_TIMEOUT, 5000)
                    .withString(DefaultDriverOption.PROTOCOL_VERSION, "V5")
                    .build()
            )
            .build()
    }
}

@DataCassandraTest
@ImportAutoConfiguration(EmbeddedCassandraAutoConfiguration::class)
@Import(CqlSessionConfiguration::class)
class CassandraRepositoriesTest
@Autowired
constructor(
    private val session: CqlSession
) {

    @Test
    fun testQuery() {
        val row = session.execute("SELECT release_version FROM system.local;").one()
        Assertions.assertEquals(row?.getString("release_version"), "4.0.1")
    }
}
