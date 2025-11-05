package org.moodle.api.client.moodle_rest_client.domain.responses.course.category;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.moodle.api.client.moodle_rest_client.domain.models.Category;

import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class RecursiveCategory extends Category {
    private List<RecursiveCategory> children;
}
