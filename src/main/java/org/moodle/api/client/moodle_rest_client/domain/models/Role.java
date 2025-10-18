package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {
    private Integer roleid;
    private String name;
    private String shortname;
    private Integer sortorder;
}
