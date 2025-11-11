package org.moodle.api.client.moodle_rest_client.domain.requests.course.course;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.models.CourseFormatOption;

import java.util.List;

@Data
@Builder
public class UpdateCourseRequest {
    private Long id;
    private String fullname;
    private String shortname;
    private Long categoryid;
    private String idnumber;
    private String summary;
    private Integer summaryformat;
    private String format;
    private Boolean showgrades;
    private Integer newsitems;
    private Long startdate;
    private Long enddate;
    private Integer numsections;
    private Long maxbytes;
    private Boolean showreports;
    private Boolean visible;
    private Integer groupmode;
    private Integer groupmodeforce;
    private Long defaultgroupingid;
    private Boolean enablecompletion;
    private Long completionnotify;
    private String lang;
    private String forcetheme;
    private List<CourseFormatOption> courseformatoptions;
}
