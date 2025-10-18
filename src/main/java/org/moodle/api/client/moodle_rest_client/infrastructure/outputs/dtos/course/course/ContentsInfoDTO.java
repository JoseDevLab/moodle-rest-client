package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentsInfoDTO {
    private Integer filescount;
    private Integer filessize;
    private Integer lastmodified;
    private List<String> mimetypes;
    private String repositorytype;
}