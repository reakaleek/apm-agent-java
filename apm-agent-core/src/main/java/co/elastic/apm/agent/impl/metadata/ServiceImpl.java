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


import co.elastic.apm.agent.tracer.service.Service;

import javax.annotation.Nullable;


/**
 * Information about the instrumented Service
 */
public class ServiceImpl implements Service {

    /**
     * Name and version of the Elastic APM agent
     * (Required)
     */
    @Nullable
    private Agent agent;
    /**
     * Name and version of the web framework used
     */
    @Nullable
    private Framework framework;
    /**
     * Name and version of the programming language used
     */
    @Nullable
    private Language language;
    /**
     * Representation of a service node
     */
    @Nullable
    private NodeImpl node;
    /**
     * Immutable name of the service emitting this event
     * (Required)
     */
    @Nullable
    private String name;
    /**
     * Environment name of the service, e.g. "production" or "staging"
     */
    @Nullable
    private String environment;
    /**
     * Name and version of the language runtime running this service
     */
    @Nullable
    private RuntimeInfo runtime;
    /**
     * Version of the service emitting this event
     */
    @Nullable
    private String version;
    /**
     * ID of the service emitting this event
     */
    @Nullable
    private String id;

    /**
     * Name and version of the Elastic APM agent
     * (Required)
     */
    @Nullable
    public Agent getAgent() {
        return agent;
    }

    /**
     * Name and version of the Elastic APM agent
     * (Required)
     */
    public ServiceImpl withAgent(Agent agent) {
        this.agent = agent;
        return this;
    }

    /**
     * Name and version of the Framework
     * (Required)
     */
    @Nullable
    public Framework getFramework() {
        return framework;
    }

    /**
     * Name and version of the Framework
     * (Required)
     */
    public ServiceImpl withFramework(Framework framework) {
        this.framework = framework;
        return this;
    }

    /**
     * Name and version of the programming language used
     */
    @Nullable
    public Language getLanguage() {
        return language;
    }

    /**
     * Name and version of the programming language used
     */
    public ServiceImpl withLanguage(Language language) {
        this.language = language;
        return this;
    }

    @Nullable
    @Override
    public NodeImpl getNode() {
        return node;
    }

    /**
     * Representation of a service node
     */
    public ServiceImpl withNode(NodeImpl node) {
        this.node = node;
        return this;
    }

    @Nullable
    @Override
    public String getName() {
        return name;
    }

    /**
     * Immutable name of the service emitting this event
     * (Required)
     */
    public ServiceImpl withName(String name) {
        this.name = name;
        return this;
    }

    @Nullable
    @Override
    public String getEnvironment() {
        return environment;
    }

    /**
     * Environment name of the service, e.g. "production" or "staging"
     */
    public ServiceImpl withEnvironment(@Nullable String environment) {
        this.environment = environment;
        return this;
    }

    /**
     * Name and version of the language runtime running this service
     */
    @Nullable
    public RuntimeInfo getRuntime() {
        return runtime;
    }

    /**
     * Name and version of the language runtime running this service
     */
    public ServiceImpl withRuntime(RuntimeInfo runtime) {
        this.runtime = runtime;
        return this;
    }

    @Nullable
    @Override
    public String getVersion() {
        return version;
    }

    /**
     * Version of the service emitting this event
     */
    public ServiceImpl withVersion(@Nullable String version) {
        this.version = version;
        return this;
    }

    /**
     * ID of the service emitting this event
     */
    @Nullable
    public String getId() {
        return id;
    }

    /**
     * ID of the service emitting this event
     */
    public ServiceImpl withId(@Nullable String id) {
        this.id = id;
        return this;
    }

}
