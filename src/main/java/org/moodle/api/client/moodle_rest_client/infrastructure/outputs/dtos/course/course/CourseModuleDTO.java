package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseModuleDTO {
    private Long id;
    private String url;
    private String name;
    private Long instance;
    private String description;
    private boolean visible;
    @JsonProperty("uservisible")
    private boolean uservisible;
    @JsonProperty("visibleoncoursepage")
    private boolean visibleoncoursepage;
    private String modicon;
    private String modname;
    private String modplural;
    private String availability;
    private int indent;
    private String onclick;
    private String afterlink;
    private String customdata;
    private boolean noviewlink;
    @JsonProperty("completiondata")
    private CompletionDataDTO completiondata;
}
