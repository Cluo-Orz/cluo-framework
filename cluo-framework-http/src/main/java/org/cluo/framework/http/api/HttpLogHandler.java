package org.cluo.framework.http.api;

public interface HttpLogHandler {



    void info(String msg);

    void error(String msg);

    void error(String msg,Throwable t);
}
