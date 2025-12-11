package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SiteInfo {
    private String siteName;
    private String userName;
    private String firstName;
    private String lastName;
    private String fullName;
    private String lang;
    private Long userId;
    private String siteUrl;
    private String userPictureUrl;
    private List<Function> functions;
    private Integer downloadFiles;
    private Integer uploadFiles;
    private String release;
    private String version;
    private String mobileCssUrl;
    private List<AdvancedFeature> advancedFeatures;
    private Integer userCanManageOwnFiles;
    private Integer userQuota;
    private Integer userMaxUploadFileSize;
    private Integer userHomePage;
    private String userHomePageUrl;
    private String userPrivateAccessKey;
    private Long siteId;
    private String siteCalendarType;
    private String userCalendarType;
    private Integer userIsSiteAdmin;
    private String theme;
    private Integer limitConcurrentLogins;
    private Integer userSessionsCount;
    private Integer policyAgreed;
}
