/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package co.elastic.apm.agent.hibernatesearch;

import co.elastic.apm.agent.tracer.AbstractSpan;
import co.elastic.apm.agent.tracer.TraceState;
import co.elastic.apm.agent.tracer.Span;
import co.elastic.apm.agent.tracer.Tracer;

public final class HibernateSearchHelper {

    private HibernateSearchHelper() {

    }

    public static Span<?> createAndActivateSpan(final Tracer tracer, final String methodName,
                                                final String query) {

        TraceState<?> active = tracer.currentContext();
        AbstractSpan<?> activeSpan = active.getSpan();
        // avoid creating the same span twice for example, when an instrumented API is wrapped
        if (activeSpan == null || activeSpan instanceof Span<?> && HibernateSearchConstants.HIBERNATE_SEARCH_ORM_TYPE
            .equals(((Span<?>) activeSpan).getSubtype())) {
            return null;
        }

        Span<?> span = active.createSpan().activate();

        span.withType(HibernateSearchConstants.HIBERNATE_SEARCH_ORM_SPAN_TYPE)
            .withSubtype(HibernateSearchConstants.HIBERNATE_SEARCH_ORM_TYPE)
            .withAction(methodName);
        span.getContext().getDb()
            .withType(HibernateSearchConstants.HIBERNATE_SEARCH_ORM_TYPE)
                .withStatement(query);
        span.withName(HibernateSearchConstants.HIBERNATE_SEARCH_ORM_SPAN_NAME)
                .appendToName(" ").appendToName(methodName).appendToName("()");
        return span;
    }
}
