package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDTO {
    private Long id;
    private String name;
    private String idnumber;
    private String description;
    private Integer descriptionformat;
    private Long parent;
    private Integer sortorder;
    private Integer coursecount;
    private Integer visible;
    private Integer visibleold;
    private Long timemodified;
    private Integer depth;
    private String path;
    private String theme;
}