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
package co.elastic.apm.agent.benchmark;

import co.elastic.apm.agent.impl.ElasticApmTracer;
import co.elastic.apm.agent.impl.ElasticApmTracerBuilder;
import co.elastic.apm.agent.impl.error.ErrorCaptureImpl;
import co.elastic.apm.agent.impl.transaction.SpanImpl;
import co.elastic.apm.agent.impl.transaction.TransactionImpl;
import co.elastic.apm.agent.report.ReporterConfigurationImpl;
import co.elastic.apm.agent.util.MathUtils;
import org.ehcache.sizeof.SizeOf;

public class SizeOfSpan {

    public static void main(String[] args) {
        final SizeOf sizeOf = SizeOf.newInstance();
        ElasticApmTracer tracer = new ElasticApmTracerBuilder().buildAndStart();
        final long sizeOfSpan = sizeOf.deepSizeOf(new SpanImpl(tracer));
        final long sizeOfTransaction = sizeOf.deepSizeOf(new TransactionImpl(tracer));
        final long sizeOfError = sizeOf.deepSizeOf(new ErrorCaptureImpl(tracer));

        System.out.println("sizeof span: " + sizeOfSpan);
        System.out.println("sizeof transaction: " + sizeOfTransaction);
        System.out.println("sizeof error: " + sizeOfError);

        final int queueSize = MathUtils.getNextPowerOf2(new ReporterConfigurationImpl().getMaxQueueSize());
        final long sizeOfObjectPools = queueSize * 2 * sizeOfSpan +
            queueSize * 2 * sizeOfTransaction +
            queueSize * sizeOfError;
        System.out.println("sizeOfObjectPools: " + sizeOfObjectPools / 1024.0 / 1024.0 + " MiB");
    }
}
