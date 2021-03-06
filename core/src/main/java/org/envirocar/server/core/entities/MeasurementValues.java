/*
 * Copyright (C) 2013 The enviroCar project
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
package org.envirocar.server.core.entities;

import org.envirocar.server.core.util.Pagination;
import org.envirocar.server.core.util.UpCastingIterable;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann <autermann@uni-muenster.de>
 */
public class MeasurementValues extends UpCastingIterable<MeasurementValue> {
    public static MeasurementValuesBuilder from(
            Iterable<? extends MeasurementValue> delegate) {
        return new MeasurementValuesBuilder(delegate);
    }

    protected MeasurementValues(Iterable<? extends MeasurementValue> delegate,
                                Pagination pagination, long elements) {
        super(delegate, pagination, elements);
    }

    public static class MeasurementValuesBuilder {
        private Iterable<? extends MeasurementValue> delegate;
        private Pagination pagination;
        private long elements;

        public MeasurementValuesBuilder(
                Iterable<? extends MeasurementValue> delegate) {
            this.delegate = delegate;
        }

        public MeasurementValuesBuilder withPagination(Pagination pagination) {
            this.pagination = pagination;
            return this;
        }

        public MeasurementValuesBuilder withElements(long elements) {
            this.elements = elements;
            return this;
        }

        public MeasurementValues build() {
            return new MeasurementValues(delegate, pagination, elements);
        }
    }
}
