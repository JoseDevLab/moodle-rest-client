package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {
    private Long id;
    private String name;
    private String idnumber;
    private String description;
    private int descriptionformat;
    private Long parent;
    private int sortorder;
    private int coursecount;
    private Boolean visible;
    private Boolean visibleold;
    private Long timemodified;
    private int depth;
    private String path;
    private String theme;
}