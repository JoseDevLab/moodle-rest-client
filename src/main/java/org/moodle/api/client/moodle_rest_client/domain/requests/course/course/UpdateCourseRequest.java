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
    private List<CourseFormatOption> courseformatoptions;
}
