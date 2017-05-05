package com.vipkid.service.useragent;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;

/**
 * Created by xushengxiang on 2017/5/4.
 */
public class UserAgentUtil {
    public static UserAgentVO getBrowserAndVersion(String user_agent){
        Browser browser = UserAgent.parseUserAgentString(user_agent).getBrowser();
        Version version = browser.getVersion(user_agent);
        return new UserAgentVO(browser.getName(), version.getVersion(), version.getMajorVersion());
    }
}
