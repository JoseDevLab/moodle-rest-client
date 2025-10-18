package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.enrol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDTO {
    private Integer roleid;
    private String name;
    private String shortname;
    private Integer sortorder;
}
