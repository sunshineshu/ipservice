package com.hsu.service.useragent;

/**
 * Created by xushengxiang on 2017/5/4.
 */
public class UserAgentVO {
    private String browser;
    private String version;
    private String majorVersion;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(String majorVersion) {
        this.majorVersion = majorVersion;
    }

    public UserAgentVO() {
    }

    public UserAgentVO(String browser, String version, String majorVersion) {
        this.browser = browser;
        this.version = version;
        this.majorVersion = majorVersion;
    }
}
