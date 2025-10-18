package org.moodle.api.client.moodle_rest_client.domain.responses.course.course;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BadgeExtraAttribute {
    private String name;
    private String value;
}