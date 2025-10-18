package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserGrade {
    private Long courseId;
    private String courseIdNumber;
    private Long userId;
    private String userFullName;
    private String userIdNumber;
    private int maxDepth;
    private List<GradeItem> gradeItems;
}
