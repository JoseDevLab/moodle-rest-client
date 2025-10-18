package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseContentDTO {
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
    private List<TagDTO> tags;
}