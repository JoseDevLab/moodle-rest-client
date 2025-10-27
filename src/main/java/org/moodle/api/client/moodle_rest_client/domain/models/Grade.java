package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Grade {
    private Long id;
    private Long assignment;
    private Long userid;
    private Integer attemptnumber;
    private Integer timecreated;
    private Integer timemodified;
    private Integer grader;
    private String grade;
    private String gradefordisplay;
}
