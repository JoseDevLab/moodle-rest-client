package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityBadgeDTO {
    private String badgecontent;
    private String badgestyle;
    private String badgeurl;
    private String badgeelementid;
    private List<BadgeExtraAttributeDTO> badgeextraattributes;
}