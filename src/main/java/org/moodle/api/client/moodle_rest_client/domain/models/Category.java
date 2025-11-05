package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long id;
    private String name;
    private String idnumber;
    private String description;
    private Integer descriptionformat;
    private Long parent;
    private Integer sortorder;
    private Integer coursecount;
    private Boolean visible;
    private Boolean visibleold;
    private Long timemodified;
    private Integer depth;
    private String path;
    private String theme;
}