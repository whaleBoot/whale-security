/**
 * 
 */
package com.whale.security.core.social;

import com.whale.security.core.support.SocialUserInfo;
import org.springframework.social.connect.Connection;

/**
  *@ClassName SocialController
  *@Description TODO
  *@Author coco
  *@Data 2019/9/27 13:57
  *@Version 1.0
  **/
public abstract class SocialController {

	/**
	 * 根据Connection信息构建SocialUserInfo
	 * @param connection
	 * @return
	 */
	protected SocialUserInfo buildSocialUserInfo(Connection<?> connection) {
		SocialUserInfo userInfo = new SocialUserInfo();
		userInfo.setProviderId(connection.getKey().getProviderId());
		userInfo.setProviderUserId(connection.getKey().getProviderUserId());
		userInfo.setNickname(connection.getDisplayName());
		userInfo.setHeadimg(connection.getImageUrl());
		return userInfo;
	}
	
}
