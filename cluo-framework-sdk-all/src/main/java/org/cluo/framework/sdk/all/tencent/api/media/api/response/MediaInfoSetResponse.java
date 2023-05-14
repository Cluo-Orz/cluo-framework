package org.cluo.framework.sdk.all.tencent.api.media.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author: thone
 * time: 2019/6/2 下午1:51
 * desc: //TODO
 **/
public class MediaInfoSetResponse implements Serializable {
    @JsonProperty("FileId")
    private String fileId;

    @JsonProperty("BasicInfo")
    private BasicInfo basicInfo;

    public static class BasicInfo implements Serializable{
        @JsonProperty("ClassId")
        private String classId;

        @JsonProperty("ClassName")
        private String className;

        @JsonProperty("ClassPath")
        private String classPath;

        @JsonProperty("CoverUrl")
        private String coverUrl;

        @JsonProperty("CreateTime")
        private String createTime;

        @JsonProperty("Description")
        private String description;

        @JsonProperty("expireTime")
        private String expireTime;

        @JsonProperty("Name")
        private String name;

        @JsonProperty("MediaUrl")
        private String mediaUrl;

        @JsonProperty("Type")
        private String type;

        @JsonProperty("StorageRegion")
        private String storageRegion;

        @JsonProperty("SourceInfo")
        private SourceInfo sourceInfo;

        @JsonProperty("Vid")
        private String vid;

        @JsonProperty("UpdateTime")
        private String updateTime;

        public static class SourceInfo implements Serializable {
            @JsonProperty("sourceType")
            private String SourceType;

            @JsonProperty("SourceContext")
            private String sourceContext;

            public String getSourceType() {
                return SourceType;
            }

            public void setSourceType(String sourceType) {
                SourceType = sourceType;
            }

            public String getSourceContext() {
                return sourceContext;
            }

            public void setSourceContext(String sourceContext) {
                this.sourceContext = sourceContext;
            }
        }

        public String getClassId() {
            return classId;
        }

        public void setClassId(String classId) {
            this.classId = classId;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getClassPath() {
            return classPath;
        }

        public void setClassPath(String classPath) {
            this.classPath = classPath;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMediaUrl() {
            return mediaUrl;
        }

        public void setMediaUrl(String mediaUrl) {
            this.mediaUrl = mediaUrl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStorageRegion() {
            return storageRegion;
        }

        public void setStorageRegion(String storageRegion) {
            this.storageRegion = storageRegion;
        }

        public SourceInfo getSourceInfo() {
            return sourceInfo;
        }

        public void setSourceInfo(SourceInfo sourceInfo) {
            this.sourceInfo = sourceInfo;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        public String toString() {
            return "BasicInfo{" +
                    "classId='" + classId + '\'' +
                    ", className='" + className + '\'' +
                    ", classPath='" + classPath + '\'' +
                    ", coverUrl='" + coverUrl + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", description='" + description + '\'' +
                    ", expireTime='" + expireTime + '\'' +
                    ", name='" + name + '\'' +
                    ", mediaUrl='" + mediaUrl + '\'' +
                    ", type='" + type + '\'' +
                    ", storageRegion='" + storageRegion + '\'' +
                    ", sourceInfo=" + sourceInfo +
                    ", vid='" + vid + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    '}';
        }
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }


    @Override
    public String toString() {
        return "MediaInfoSetResponse{" +
                "fileId='" + fileId + '\'' +
                ", basicInfo=" + basicInfo +
                '}';
    }
}
