package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCourseRequestDTO {
    private String fullname;
    private String shortname;
    private Long categoryid;
    private String idnumber;
    private String summary;
    private Integer summaryformat;
    private String format;
    private Integer showgrades;
    private Integer newsitems;
    private Long startdate;
    private Long enddate;
    private Integer numsections;
    private Long maxbytes;
    private Integer showreports;
    private Integer visible;
    private Long hiddensections;
    private Integer groupmode;
    private Integer groupmodeforce;
    private Long defaultgroupingid;
    private Integer enablecompletion;
    private Long completionnotify;
    private String lang;
    private String forcetheme;
    @JsonProperty("courseformatoptions")
    private List<CourseFormatOptionDTO> courseformatoptions;
    @JsonProperty("customfields")
    private List<CustomFieldRequestDTO> customfields;
}
