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
package co.elastic.apm.agent.report.processor;

import co.elastic.apm.agent.impl.error.ErrorCaptureImpl;
import co.elastic.apm.agent.impl.transaction.TransactionImpl;
import org.stagemonitor.configuration.ConfigurationRegistry;

/**
 * A processor is executed right before a event (a {@link TransactionImpl} or {@link ErrorCaptureImpl}) gets reported.
 * <p>
 * You can use this for example to sanitize certain information.
 * </p>
 * <p>
 * The constructor can optionally have a {@link ConfigurationRegistry} parameter.
 * </p>
 */
public interface Processor {

    /**
     * This method is executed before the provided {@link TransactionImpl} is reported.
     *
     * @param transaction The transaction to process.
     */
    void processBeforeReport(TransactionImpl transaction);

    /**
     * This method is executed before the provided {@link ErrorCaptureImpl} is reported.
     *
     * @param error The error to process.
     */
    void processBeforeReport(ErrorCaptureImpl error);
}
