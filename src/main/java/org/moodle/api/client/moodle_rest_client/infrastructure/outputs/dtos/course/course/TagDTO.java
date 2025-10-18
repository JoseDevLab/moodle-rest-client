package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagDTO {
    private Integer id;
    private String name;
    private String rawname;
    private Integer isstandard;
    private Integer tagcollid;
    private Integer taginstanceid;
    private Integer taginstancecontextid;
    private Integer itemid;
    private Integer ordering;
    private Integer flag;
    private String viewurl;
}