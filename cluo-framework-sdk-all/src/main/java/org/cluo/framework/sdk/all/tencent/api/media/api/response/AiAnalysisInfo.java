package org.cluo.framework.sdk.all.tencent.api.media.api.response;

import java.io.Serializable;
import java.util.List;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.entity.media.response
 * Create in 15:46 2018/7/13
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class AiAnalysisInfo implements Serializable {
    private List<ClassificationInfo> classificationList;
    private List<TagInfo> tagList;

    private static class ClassificationInfo implements Serializable {
        private Integer definition;
        private List<Classification> classifications;

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

        public Integer getDefinition() {
            return definition;
        }

        public void setDefinition(Integer definition) {
            this.definition = definition;
        }

        public List<Classification> getClassifications() {
            return classifications;
        }

        public void setClassifications(List<Classification> classifications) {
            this.classifications = classifications;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ClassificationInfo{");
            sb.append("definition=").append(definition);
            sb.append(", classifications=").append(classifications);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class TagInfo implements Serializable {
        private Integer definition;
        private List<Tags> tags;

        public static class Tags implements Serializable {
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
                final StringBuffer sb = new StringBuffer("Tags{");
                sb.append("classification='").append(classification).append('\'');
                sb.append(", confidence=").append(confidence);
                sb.append('}');
                return sb.toString();
            }
        }

        public Integer getDefinition() {
            return definition;
        }

        public void setDefinition(Integer definition) {
            this.definition = definition;
        }

        public List<Tags> getTags() {
            return tags;
        }

        public void setTags(List<Tags> tags) {
            this.tags = tags;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("TagInfo{");
            sb.append("definition=").append(definition);
            sb.append(", tags=").append(tags);
            sb.append('}');
            return sb.toString();
        }
    }

    public List<ClassificationInfo> getClassificationList() {
        return classificationList;
    }

    public void setClassificationList(List<ClassificationInfo> classificationList) {
        this.classificationList = classificationList;
    }

    public List<TagInfo> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagInfo> tagList) {
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AiAnalysisInfo{");
        sb.append("classificationList=").append(classificationList);
        sb.append(", tagList=").append(tagList);
        sb.append('}');
        return sb.toString();
    }
}
