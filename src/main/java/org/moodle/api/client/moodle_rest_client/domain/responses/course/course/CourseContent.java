package org.moodle.api.client.moodle_rest_client.domain.responses.course.course;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CourseContent {
    private String type;
    private String filename;
    private String filepath;
    private Integer filesize;
    private String fileurl;
    private String content;
    private Integer timecreated;
    private Integer timemodified;
    private Integer sortorder;
    private String mimetype;
    private Boolean isexternalfile;
    private String repositorytype;
    private Integer userid;
    private String author;
    private String license;
    private List<Tag> tags;
}