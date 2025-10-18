package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateCourseRequestDTO {
    private Long id;
    private String fullname;
    private String shortname;
    private Long categoryid;
    private String idnumber;
    private String summary;
    private int summaryformat;
    private String format;
    private boolean showgrades;
    private int newsitems;
    private Long startdate;
    private Long enddate;
    private int numsections;
    private Long maxbytes;
    private boolean showreports;
    private boolean visible;
    private int groupmode;
    private int groupmodeforce;
    private Long defaultgroupingid;
    private boolean enablecompletion;
    private Long completionnotify;
    private String lang;
    private String forcetheme;
    @JsonProperty("courseformatoptions")
    private List<CourseFormatOptionDTO> courseformatoptions;
}
