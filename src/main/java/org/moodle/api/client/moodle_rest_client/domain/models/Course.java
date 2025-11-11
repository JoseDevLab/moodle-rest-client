package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.course.CustomField;

import java.util.List;

@Data
@Builder
public class Course {
    private Long id;
    private String shortname;
    private Long categoryid;
    private Long categorysortorder;
    private String fullname;
    private String displayname;
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
    private List<CustomField> customfields;
}
