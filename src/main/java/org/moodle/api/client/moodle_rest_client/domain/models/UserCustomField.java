
package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCustomField {
    private String type;
    private String value;
    private String displayvalue;
    private String name;
    private String shortname;
}