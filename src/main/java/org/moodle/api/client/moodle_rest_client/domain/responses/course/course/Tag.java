package org.moodle.api.client.moodle_rest_client.domain.responses.course.course;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tag {
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