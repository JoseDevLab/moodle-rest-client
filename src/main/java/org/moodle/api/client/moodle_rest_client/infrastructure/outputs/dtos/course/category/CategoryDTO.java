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
    private int descriptionformat;
    private Long parent;
    private int sortorder;
    private int coursecount;
    private Integer visible;
    private Integer visibleold;
    private Long timemodified;
    private int depth;
    private String path;
    private String theme;
}