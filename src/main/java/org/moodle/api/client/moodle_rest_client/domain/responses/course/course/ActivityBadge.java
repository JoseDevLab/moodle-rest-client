package org.moodle.api.client.moodle_rest_client.domain.responses.course.course;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActivityBadge {
    private String badgecontent;
    private String badgestyle;
    private String badgeurl;
    private String badgeelementid;
    private List<BadgeExtraAttribute> badgeextraattributes;
}