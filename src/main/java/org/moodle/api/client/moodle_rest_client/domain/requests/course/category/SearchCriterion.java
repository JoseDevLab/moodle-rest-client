package org.moodle.api.client.moodle_rest_client.domain.requests.course.category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchCriterion {
    /**
     * The category column to search, expected keys (value format) are:"id" (int) the category id,"ids" (string) category ids separated by
     * commas,"name" (string) the category name,"parent" (int) the parent category id,"idnumber" (string) category idnumber - user must have
     * 'moodle/category:manage' to search on idnumber,"visible" (int) whether the returned categories must be visible or hidden. If the key is not passed,
     * then the function return all categories that the user can see. - user must have 'moodle/category:manage' or
     * 'moodle/category:viewhiddencategories' to search on visible,"theme" (string) only return the categories having this theme - user must have
     * 'moodle/category:manage' to search on theme
     */
    private String key;
    /**
     * the value to match
     */
    private String value;
}
