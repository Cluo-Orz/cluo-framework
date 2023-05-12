package org.cluo.framework.http;

import java.util.Map;

public class HttpResponse {
    protected int code;
    protected byte[] content;
    protected Object responseBody;
    protected Map<String,String> header;

    public int getCode() {
        return code;
    }

    public <S> S getResponseBody() {
        return (S)responseBody;
    }

    public byte[] getContent() {
        return content;
    }

    public Map<String, String> getHeader() {
        return header;
    }
}
