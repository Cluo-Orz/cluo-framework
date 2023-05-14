package org.cluo.framework.sdk.all.tencent.api.media.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.all.tencent.api.media.Action;
import org.cluo.framework.sdk.all.tencent.api.media.BaseRequest;
import org.cluo.framework.sdk.support.HttpRequest;

import java.io.Serializable;
import java.util.Random;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity.media
 * Create in 15:15 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class TaskRequest extends BaseRequest<TaskRequest> implements Serializable {
    @JsonProperty("TaskId")
    protected String taskId;

    public TaskRequest(HttpRequest<TaskRequest> request) {
        super(request);
        Random random = new Random();
        this.setAction(Action.DescribeTaskDetail)
                .setNonce(random.nextInt(100000) + 10000)
                .setTimestamp(System.currentTimeMillis() / 1000)
                .setVersion("2018-07-17");
    }

    public String getTaskId() {
        return taskId;
    }

    public TaskRequest setTaskId(String taskId) {
        this.taskId = taskId;
        return this;
    }
}
