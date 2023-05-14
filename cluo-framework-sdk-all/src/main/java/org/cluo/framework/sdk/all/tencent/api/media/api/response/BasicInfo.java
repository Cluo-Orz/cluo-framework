package org.cluo.framework.sdk.all.tencent.api.media.api.response;



import java.io.Serializable;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity.media
 * Create in 15:13 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */

public class BasicInfo  implements Serializable {
    protected String id;
    protected String name;
    protected Integer size;
    protected Integer duration;
    protected String description;
    protected String status;
    protected Integer createTime;
    protected Integer updateTime;
    protected Integer expireTime;
    protected Integer classificationId;
    protected String classificationName;
    protected Integer playerId;
    protected String coverUrl;
    protected String type;
    protected String sourceVideoUrl;
    protected String data;

    public String getId() {
        return id;
    }

    public BasicInfo setId(String id) {
        this.id = id;
        return this;
    }

    public String getData() {
        return data;
    }

    public BasicInfo setData(String data) {
        this.data = data;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSourceVideoUrl() {
        return sourceVideoUrl;
    }

    public void setSourceVideoUrl(String sourceVideoUrl) {
        this.sourceVideoUrl = sourceVideoUrl;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BasicInfo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", size=").append(size);
        sb.append(", duration=").append(duration);
        sb.append(", description='").append(description).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", classificationId=").append(classificationId);
        sb.append(", classificationName='").append(classificationName).append('\'');
        sb.append(", playerId=").append(playerId);
        sb.append(", coverUrl='").append(coverUrl).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", sourceVideoUrl='").append(sourceVideoUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
