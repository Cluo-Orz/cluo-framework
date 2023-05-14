package org.cluo.framework.sdk.all.tencent.api.media.api.response;

import java.io.Serializable;
import java.util.List;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity.media
 * Create in 15:13 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class Drm implements Serializable {
    private Integer definition;
    private String encryptType;
    private String keySource;
    private String getKeyUrl;
    private List<String> edkList;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Drm{");
        sb.append("definition=").append(definition);
        sb.append(", encryptType='").append(encryptType).append('\'');
        sb.append(", keySource='").append(keySource).append('\'');
        sb.append(", getKeyUrl='").append(getKeyUrl).append('\'');
        sb.append(", edkList=").append(edkList);
        sb.append('}');
        return sb.toString();
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public Integer getDefinition() {
        return definition;
    }

    public void setDefinition(Integer definition) {
        this.definition = definition;
    }

    public String getKeySource() {
        return keySource;
    }

    public void setKeySource(String keySource) {
        this.keySource = keySource;
    }

    public String getGetKeyUrl() {
        return getKeyUrl;
    }

    public void setGetKeyUrl(String getKeyUrl) {
        this.getKeyUrl = getKeyUrl;
    }

    public List<String> getEdkList() {
        return edkList;
    }

    public void setEdkList(List<String> edkList) {
        this.edkList = edkList;
    }
}
