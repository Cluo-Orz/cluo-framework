package org.cluo.framework.sdk.all.tencent.api.echo.api.ProcedureStateChanged;

import org.cluo.framework.sdk.all.tencent.api.echo.EchoBaseRequest;
import org.cluo.framework.sdk.all.tencent.api.media.api.response.ContentReviewInfo;
import org.cluo.framework.sdk.all.tencent.api.media.api.response.Drm;
import org.cluo.framework.sdk.all.tencent.api.media.api.response.MetaData;
import org.cluo.framework.sdk.all.tencent.api.media.api.response.ProcessTask;

import java.io.Serializable;
import java.util.List;

/**
 * In Yiming-org.cluo.framework.sdk.all.tencent.aggregation.ProcedureStateChanged
 * Create in 14:02 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class Request extends EchoBaseRequest<Request.Data> {
    public static class Data implements Serializable {
        private String status;
        private Integer errCode;
        private String message;
        private String fileId;
        private MetaData metaData;
        private List<ContentReviewInfo.ContentReview> contentReviewList;
        private List<AIAnalysis> aiAnalysisList;

        public static class AIAnalysis implements Serializable {
            protected TaskType taskType;
            protected String status;
            protected Integer errCode;
            protected String message;

            public static enum TaskType {
                Tag, Classification
            }

            public static class Tag extends AIAnalysis implements Serializable {
                private Input input;

                public static class Input implements Serializable {
                    private Integer definition;

                    public Integer getDefinition() {
                        return definition;
                    }

                    public void setDefinition(Integer definition) {
                        this.definition = definition;
                    }

                    @Override
                    public String toString() {
                        final StringBuffer sb = new StringBuffer("Input{");
                        sb.append("definition=").append(definition);
                        sb.append('}');
                        return sb.toString();
                    }
                }

                private Output output;

                public static class Output implements Serializable {
                    List<Tag.Classification> classifications;

                    public static class Classification implements Serializable {
                        private String classification;
                        private Float confidence;

                        public String getClassification() {
                            return classification;
                        }

                        public void setClassification(String classification) {
                            this.classification = classification;
                        }

                        public Float getConfidence() {
                            return confidence;
                        }

                        public void setConfidence(Float confidence) {
                            this.confidence = confidence;
                        }

                        @Override
                        public String toString() {
                            final StringBuffer sb = new StringBuffer("Classification{");
                            sb.append("classification='").append(classification).append('\'');
                            sb.append(", confidence=").append(confidence);
                            sb.append('}');
                            return sb.toString();
                        }
                    }

                    public List<Tag.Classification> getClassifications() {
                        return classifications;
                    }

                    public void setClassifications(List<Tag.Classification> classifications) {
                        this.classifications = classifications;
                    }

                    @Override
                    public String toString() {
                        final StringBuffer sb = new StringBuffer("Output{");
                        sb.append("classifications=").append(classifications);
                        sb.append('}');
                        return sb.toString();
                    }
                }

                public Input getInput() {
                    return input;
                }

                public void setInput(Input input) {
                    this.input = input;
                }

                public Output getOutput() {
                    return output;
                }

                public void setOutput(Output output) {
                    this.output = output;
                }

                @Override
                public String toString() {
                    final StringBuffer sb = new StringBuffer("Tag{");
                    sb.append("taskType=").append(taskType);
                    sb.append(", status='").append(status).append('\'');
                    sb.append(", errCode=").append(errCode);
                    sb.append(", message='").append(message).append('\'');
                    sb.append(", input=").append(input);
                    sb.append(", output=").append(output);
                    sb.append('}');
                    return sb.toString();
                }
            }

            public static class Classification extends AIAnalysis implements Serializable {
                private Input input;

                public static class Input implements Serializable {
                    private Integer definition;

                    public Integer getDefinition() {
                        return definition;
                    }

                    public void setDefinition(Integer definition) {
                        this.definition = definition;
                    }

                    @Override
                    public String toString() {
                        final StringBuffer sb = new StringBuffer("Input{");
                        sb.append("definition=").append(definition);
                        sb.append('}');
                        return sb.toString();
                    }
                }

                private Output output;

                public static class Output implements Serializable {
                    List<Tag> classifications;

                    public static class Tag implements Serializable {
                        private String tag;
                        private Float confidence;

                        public String getTag() {
                            return tag;
                        }

                        public void setTag(String tag) {
                            this.tag = tag;
                        }

                        public Float getConfidence() {
                            return confidence;
                        }

                        public void setConfidence(Float confidence) {
                            this.confidence = confidence;
                        }

                        @Override
                        public String toString() {
                            final StringBuffer sb = new StringBuffer("Tag{");
                            sb.append("tag='").append(tag).append('\'');
                            sb.append(", confidence=").append(confidence);
                            sb.append('}');
                            return sb.toString();
                        }
                    }

                }

                public Input getInput() {
                    return input;
                }

                public void setInput(Input input) {
                    this.input = input;
                }

                public Output getOutput() {
                    return output;
                }

                public void setOutput(Output output) {
                    this.output = output;
                }

                @Override
                public String toString() {
                    final StringBuffer sb = new StringBuffer("Classification{");
                    sb.append("taskType=").append(taskType);
                    sb.append(", status='").append(status).append('\'');
                    sb.append(", errCode=").append(errCode);
                    sb.append(", message='").append(message).append('\'');
                    sb.append(", input=").append(input);
                    sb.append(", output=").append(output);
                    sb.append('}');
                    return sb.toString();
                }
            }
        }

        private Drm drm;
        private List<ProcessTask> processTaskList;

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

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public MetaData getMetaData() {
            return metaData;
        }

        public void setMetaData(MetaData metaData) {
            this.metaData = metaData;
        }

        public List<ContentReviewInfo.ContentReview> getContentReviewList() {
            return contentReviewList;
        }

        public void setContentReviewList(List<ContentReviewInfo.ContentReview> contentReviewList) {
            this.contentReviewList = contentReviewList;
        }

        public List<AIAnalysis> getAiAnalysisList() {
            return aiAnalysisList;
        }

        public void setAiAnalysisList(List<AIAnalysis> aiAnalysisList) {
            this.aiAnalysisList = aiAnalysisList;
        }

        public Drm getDrm() {
            return drm;
        }

        public void setDrm(Drm drm) {
            this.drm = drm;
        }

        public List<ProcessTask> getProcessTaskList() {
            return processTaskList;
        }

        public void setProcessTaskList(List<ProcessTask> processTaskList) {
            this.processTaskList = processTaskList;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("status='").append(status).append('\'');
            sb.append(", errCode=").append(errCode);
            sb.append(", message='").append(message).append('\'');
            sb.append(", fileId='").append(fileId).append('\'');
            sb.append(", metaData=").append(metaData);
            sb.append(", contentReviewList=").append(contentReviewList);
            sb.append(", aiAnalysisList=").append(aiAnalysisList);
            sb.append(", drm=").append(drm);
            sb.append(", processTaskList=").append(processTaskList);
            sb.append('}');
            return sb.toString();
        }
    }
}
