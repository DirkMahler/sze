// RootConfig.java
//
// Licensed under the AGPL - http://www.gnu.org/licenses/agpl-3.0.txt
// (c) SZE-Development-Team

package net.sf.sze.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Spring base configuration.
 *
 */
//CSOFF: HideUtilityClassConstructor The method must be static, but it must be
//a spring-bean.
@Configuration
@Import({PersistenceConfig.class, ServiceConfig.class})
public class RootConfig {

    /**
     * Creates a bean which handles the configuration via a property file. To
     * make sure that it will be instantiated early, the method is static.
     *
     * @return a bean which handles the configuration via a property file.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        final PropertySourcesPlaceholderConfigurer ppc =
                new PropertySourcesPlaceholderConfigurer();
        ppc.setIgnoreUnresolvablePlaceholders(true);
        ppc.setFileEncoding("UTF-8");
        return ppc;
    }
}
//CSON: HideUtilityClassConstructor
