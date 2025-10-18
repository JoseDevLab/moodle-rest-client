package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.course.CourseContentModule;

import java.util.List;

@Data
@Builder
public class Section {
    private Long id;
    private String name;
    private Boolean visible;
    private String summary;
    private Integer summaryformat;
    private Integer section;
    private Boolean hiddenbynumsections;
    private Boolean uservisible;
    private String availabilityinfo;
    private String component;
    private Long itemid;
    private List<CourseContentModule> modules;
}
