package org.cluo.framework.http;

public class HttpException extends RuntimeException{
    public HttpException(String msg){
        super(msg);
    }
    public HttpException(String msg,Throwable t){
        super(msg,t);
    }
}
