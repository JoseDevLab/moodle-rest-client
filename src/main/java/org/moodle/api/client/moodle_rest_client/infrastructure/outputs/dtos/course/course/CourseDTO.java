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
    private List<CourseFormatOptionDTO> courseformatoptions;
    private List<CustomFieldDTO> customfields;
}
