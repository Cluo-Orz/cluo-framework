package org.cluo.framework.sdk.all.tencent.api.media.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.all.tencent.api.media.Action;
import org.cluo.framework.sdk.all.tencent.api.media.BaseRequest;
import org.cluo.framework.sdk.support.HttpRequest;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

/**
 * @author: thone
 * time: 2019/6/2 下午1:32
 * desc: //TODO
 **/
public class EditMediaRequest extends BaseRequest<EditMediaRequest> implements Serializable {
    @JsonProperty("InputType")
    protected String inputType = "File";

    @JsonProperty("FileInfos")
    protected List<FileInfo> fileInfo;

    public static class FileInfo implements Serializable{
        @JsonProperty("FileId")
        private String fileId;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }
    }

    public EditMediaRequest(HttpRequest<EditMediaRequest> request) {
        super(request);
        Random random = new Random();
        this.setAction(Action.EditMedia)
                .setNonce(random.nextInt(100000) + 10000)
                .setTimestamp(System.currentTimeMillis() / 1000)
                .setVersion("2018-07-17");
    }

    public String getInputType() {
        return inputType;
    }

    public EditMediaRequest setInputType(String inputType) {
        this.inputType = inputType;
        return this;
    }

    public List<FileInfo> getFileInfo() {
        return fileInfo;
    }

    public EditMediaRequest setFileInfo(List<FileInfo> fileInfo) {
        this.fileInfo = fileInfo;
        return this;
    }
}
