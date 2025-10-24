package org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.user;

import lombok.Builder;
import lombok.Data;
import org.moodle.api.client.moodle_rest_client.domain.models.Warning;

import java.util.List;

@Data
@Builder
public class AccessInformation {
    private Integer canviewusergradereport;
    private Integer canviewmygrades;
    private Integer canviewallgrades;
    private List<Warning> warnings;
}
