package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SectionDTO {
    private Long id;
    private String name;
    private Integer visible;
    private String summary;
    private Integer summaryformat;
    private Integer section;
    private Integer hiddenbynumsections;
    private Boolean uservisible;
    private String availabilityinfo;
    private String component;
    private Long itemid;
    private List<CourseContentModuleDTO> modules;
}
