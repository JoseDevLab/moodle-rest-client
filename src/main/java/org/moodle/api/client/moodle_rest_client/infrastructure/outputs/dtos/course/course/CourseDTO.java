package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDTO {
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
    private List<CourseFormatOptionDTO> courseformatoptions;
    private List<CustomFieldRequestDTO> customfields;
}
