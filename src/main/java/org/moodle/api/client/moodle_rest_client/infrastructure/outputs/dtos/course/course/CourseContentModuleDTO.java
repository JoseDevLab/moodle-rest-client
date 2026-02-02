package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.deserializers.BooleanOrAnythingDeserializer;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.deserializers.IntegerOrAnythingDeserializer;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseContentModuleDTO {
    private Integer id;
    private String url;
    private String name;
    private Integer instance;
    private Integer contextid;
    private String description;
    private Integer visible;
    private Boolean uservisible;
    private String availabilityinfo;
    private Integer visibleoncoursepage;
    private String modicon;
    private String modname;
    private String purpose;
    @JsonDeserialize(using = BooleanOrAnythingDeserializer.class)
    private Boolean branded;
    private String modplural;
    private String availability;
    private int indent;
    private String onclick;
    private String afterlink;
    private List<ActivityBadgeDTO> activitybadge;
    private String customdata;
    private Boolean noviewlink;
    private Integer completion;
    private CompletionDataDTO completiondata;
    private Integer downloadcontent;
    private List<CourseDateDTO> dates;
    private Integer groupmode;
    private List<CourseContentDTO> contents;
    private ContentsInfoDTO contentsinfo;
}
