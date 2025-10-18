package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseModule {
    private Long id;
    private String url;
    private String name;
    private Long instance;
    private String description;
    private boolean visible;
    private boolean uservisible;
    private boolean visibleoncoursepage;
    private String modicon;
    private String modname;
    private String modplural;
    private String availability;
    private int indent;
    private String onclick;
    private String afterlink;
    private String customdata;
    private boolean noviewlink;
    private CompletionData completiondata;
}
