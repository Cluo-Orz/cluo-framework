package org.cluo.framework.sdk.all.tencent.api.media.api.response;

import java.io.Serializable;
import java.util.List;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity.media.response
 * Create in 15:41 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class ContentReviewInfo implements Serializable {
    private List<ContentReview.Porn.Output> pornList;
    private List<ContentReview.Terrorism.Output> terrorismList;

    public static class ContentReview implements Serializable {
        protected TaskType taskType;
        protected String status;
        protected Integer errCode;
        protected String message;
        protected Output output;

        public static class Output {
            private Float confidence;
            private String suggestion;
            private Integer definition;
            private List<Segment> segments;

            public static class Segment {
                private Float startTimeOffset;
                private Float endTimeOffset;
                private Float confidence;
                private String suggestion;
                private String url;
                private Integer picUrlExpireTimeStamp;

                @Override
                public String toString() {
                    final StringBuffer sb = new StringBuffer("Segment{");
                    sb.append("startTimeOffset=").append(startTimeOffset);
                    sb.append(", endTimeOffset=").append(endTimeOffset);
                    sb.append(", confidence=").append(confidence);
                    sb.append(", suggestion=").append(suggestion);
                    sb.append(", url='").append(url).append('\'');
                    sb.append(", picUrlExpireTimeStamp=").append(picUrlExpireTimeStamp);
                    sb.append('}');
                    return sb.toString();
                }

                public Float getStartTimeOffset() {
                    return startTimeOffset;
                }

                public void setStartTimeOffset(Float startTimeOffset) {
                    this.startTimeOffset = startTimeOffset;
                }

                public Float getEndTimeOffset() {
                    return endTimeOffset;
                }

                public void setEndTimeOffset(Float endTimeOffset) {
                    this.endTimeOffset = endTimeOffset;
                }

                public Float getConfidence() {
                    return confidence;
                }

                public void setConfidence(Float confidence) {
                    this.confidence = confidence;
                }

                public String getSuggestion() {
                    return suggestion;
                }

                public void setSuggestion(String suggestion) {
                    this.suggestion = suggestion;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public Integer getPicUrlExpireTimeStamp() {
                    return picUrlExpireTimeStamp;
                }

                public void setPicUrlExpireTimeStamp(Integer picUrlExpireTimeStamp) {
                    this.picUrlExpireTimeStamp = picUrlExpireTimeStamp;
                }
            }

            public Integer getDefinition() {
                return definition;
            }

            public void setDefinition(Integer definition) {
                this.definition = definition;
            }

            public Float getConfidence() {
                return confidence;
            }

            public void setConfidence(Float confidence) {
                this.confidence = confidence;
            }

            public String getSuggestion() {
                return suggestion;
            }

            public void setSuggestion(String suggestion) {
                this.suggestion = suggestion;
            }

            public List<Segment> getSegments() {
                return segments;
            }

            public void setSegments(List<Segment> segments) {
                this.segments = segments;
            }

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("Output{");
                sb.append("confidence=").append(confidence);
                sb.append(", suggestion='").append(suggestion).append('\'');
                sb.append(", definition=").append(definition);
                sb.append(", segments=").append(segments);
                sb.append('}');
                return sb.toString();
            }
        }

        public static enum TaskType {
            Porn, Terriorism
        }

        public static class Porn extends ContentReview implements Serializable {
        }

        public static class Terrorism extends ContentReview implements Serializable {
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ContentReview{");
            sb.append("taskType=").append(taskType);
            sb.append(", status='").append(status).append('\'');
            sb.append(", errCode=").append(errCode);
            sb.append(", message='").append(message).append('\'');
            sb.append(", output=").append(output);
            sb.append('}');
            return sb.toString();
        }

        public TaskType getTaskType() {
            return taskType;
        }

        public void setTaskType(TaskType taskType) {
            this.taskType = taskType;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getErrCode() {
            return errCode;
        }

        public void setErrCode(Integer errCode) {
            this.errCode = errCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Output getOutput() {
            return output;
        }

        public void setOutput(Output output) {
            this.output = output;
        }

    }

    public List<ContentReview.Porn.Output> getPornList() {
        return pornList;
    }

    public void setPornList(List<ContentReview.Porn.Output> pornList) {
        this.pornList = pornList;
    }

    public List<ContentReview.Terrorism.Output> getTerrorismList() {
        return terrorismList;
    }

    public void setTerrorismList(List<ContentReview.Terrorism.Output> terrorismList) {
        this.terrorismList = terrorismList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ContentReviewInfo{");
        sb.append("pornList=").append(pornList);
        sb.append(", terrorismList=").append(terrorismList);
        sb.append('}');
        return sb.toString();
    }
}
