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
    private List<CustomField> customfields;
}
