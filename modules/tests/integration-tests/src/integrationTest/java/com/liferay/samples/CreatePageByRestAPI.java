package com.liferay.samples;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.liferay.samples.utils.CommonMethods;

public class CreatePageByRestAPI {

	CommonMethods commonMethods = new CommonMethods();

	public String createPage(IPageParametersByRestAPI pageParameters) throws Exception {
		List<NameValuePair> params = commonMethods.commonApiParams(pageParameters.getGroupID(),
				pageParameters.getIsPrivatePage());

		params.add(new BasicNameValuePair("parentLayoutId", "0"));
		params.add(new BasicNameValuePair("name", pageParameters.getPageName().toLowerCase()));
		params.add(new BasicNameValuePair("title", pageParameters.getPageName().toLowerCase()));
		params.add(new BasicNameValuePair("description", "description"));
		params.add(new BasicNameValuePair("type", "portlet"));
		params.add(new BasicNameValuePair("hidden", "false"));
		params.add(new BasicNameValuePair("friendlyURL",
				"/" + pageParameters.getPageName().replace(" ", "-").toLowerCase()));

		commonMethods.executePost("/api/jsonws/layout/add-layout", params);
		
		return commonMethods.getMyObj().toString();
	}

}
