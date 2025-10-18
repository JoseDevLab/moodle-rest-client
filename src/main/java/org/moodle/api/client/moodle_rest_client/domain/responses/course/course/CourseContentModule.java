package org.moodle.api.client.moodle_rest_client.domain.responses.course.course;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.models.CompletionData;

import java.util.List;

@Data
@Builder
public class CourseContentModule {
    private Integer id;
    private String url;
    private String name;
    private Integer instance;
    private Integer contextid;
    private String description;
    private Integer visible;
    private Boolean uservisible;
    private String availabilityinfo;
    private Integer visibleoncoursepage;
    private String modicon;
    private String modname;
    private String purpose;
    private Boolean branded;
    private String modplural;
    private String availability;
    private int indent;
    private String onclick;
    private String afterlink;
    private List<ActivityBadge> activitybadge;
    private String customdata;
    private Boolean noviewlink;
    private Integer completion;
    private CompletionData completiondata;
    private Integer downloadcontent;
    private List<CourseDate> dates;
    private List<CourseContent> contents;
    private Integer groupmode;
    private ContentsInfo contentsinfo;
}