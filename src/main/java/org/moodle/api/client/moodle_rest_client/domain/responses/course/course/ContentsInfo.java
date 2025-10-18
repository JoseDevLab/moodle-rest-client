package org.moodle.api.client.moodle_rest_client.domain.responses.course.course;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ContentsInfo {
    private Integer filescount;
    private Integer filessize;
    private Integer lastmodified;
    private List<String> mimetypes;
    private String repositorytype;
}