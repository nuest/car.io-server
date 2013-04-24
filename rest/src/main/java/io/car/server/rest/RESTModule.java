/**
 * Copyright (C) 2013  Christian Autermann, Jan Alexander Wirwahn,
 *                     Arne De Wall, Dustin Demuth, Saqib Rasheed
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.car.server.rest;

import com.google.common.collect.ImmutableMap;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.FeaturesAndProperties;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class RESTModule extends JerseyServletModule {

    @Override
    protected void configureServlets() {
        serve("/*").with(GuiceContainer.class, ImmutableMap.of(
                PackagesResourceConfig.PROPERTY_PACKAGES, getClass().getPackage().getName(),
                ResourceConfig.FEATURE_DISABLE_WADL, String.valueOf(true),
                FeaturesAndProperties.FEATURE_FORMATTED, String.valueOf(true),
                JSONConfiguration.FEATURE_POJO_MAPPING, String.valueOf(false)));
    }
}
