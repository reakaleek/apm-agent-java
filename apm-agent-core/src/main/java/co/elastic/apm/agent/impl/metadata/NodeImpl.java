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
package co.elastic.apm.agent.impl.metadata;

import co.elastic.apm.agent.tracer.service.Node;

import javax.annotation.Nullable;

/**
 * A representation of a service node, ie JVM
 */
public class NodeImpl implements Node {

    /**
     * (Optional)
     * A name representing this JVM. Should be unique within the service.
     */
    @Nullable
    private final String name;

    public NodeImpl(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    @Override
    public String getName() {
        return name;
    }

    public boolean hasContents() {
        return name != null && !name.isEmpty();
    }
}
