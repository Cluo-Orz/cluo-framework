package org.cluo.framework.trace;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author canfuu.cts
 * @class TraceFilter
 * @date 2023/5/14 23:09
 */
@WebFilter(filterName = "first" , urlPatterns = "/*")
@Order(1)
public class TraceFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            // 填充数据（适用logback、log4j 1.x）
            MDC.put("TRACE_ID", TraceUtil.getTraceId());
            // 填充数据（适用log4j 2.x）
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            // 请求结束时清除数据，否则会造成内存泄露问题
            MDC.remove("TRACE_ID");
            TraceUtil.removeTraceId();
        }
    }
}
