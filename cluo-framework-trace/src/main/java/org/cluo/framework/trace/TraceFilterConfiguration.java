package org.cluo.framework.trace;

import org.springframework.context.annotation.Bean;

/**
 * @author canfuu.cts
 * @class TraceFilterConfiguration
 * @date 2023/5/14 23:43
 */
public class TraceFilterConfiguration {
    @Bean
    public TraceFilter traceFilter() {
        return new TraceFilter();
    }
}
