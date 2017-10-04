package com.liferay.samples.utils;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;

public class CommonMethods {

	private JSONObject myObj;

	private static final String liferayPortalUserEmail = "manoel.cyreno@liferay.com";
	private static final String liferayPortalPassword = "test";

	public void executePost(String postUrl, List<NameValuePair> params) throws Exception {
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			URL url = new URL(SeleniumReadPropertyKeys.DRIVER.getCurrentUrl().toString());
			HttpHost targetHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());

			HttpPost post = new HttpPost(postUrl);
			setCredentials(post);
			setParams(post, params);

			HttpResponse resp = httpClient.execute(targetHost, post, new BasicHttpContext());
			HttpEntity entity = resp.getEntity();
			myObj = new JSONObject(EntityUtils.toString(entity));
		}
	}

	public List<NameValuePair> commonApiParams(String groupID, String isPrivatePage, String layoutId) {
		List<NameValuePair> params = commonApiParams(groupID, isPrivatePage);

		params.add(new BasicNameValuePair("layoutId", layoutId));
		return params;
	}

	public List<NameValuePair> commonApiParams(String groupID, String isPrivatePage) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();

		params.add(new BasicNameValuePair("groupId", groupID));

		if ("yes".equals(isPrivatePage) || "true".equals(isPrivatePage)) {
			params.add(new BasicNameValuePair("privateLayout", "true"));
		} else {
			params.add(new BasicNameValuePair("privateLayout", "false"));
		}
		return params;
	}

	private void setCredentials(HttpPost post) {
		Base64 base = new Base64();
		String credentials = base.encodeAsString((liferayPortalUserEmail + ":" + liferayPortalPassword).getBytes());
		post.setHeader("Authorization", "Basic " + credentials);
	}

	private void setParams(HttpPost post, List<NameValuePair> params) throws UnsupportedEncodingException {
		UrlEncodedFormEntity encodeForm = new UrlEncodedFormEntity(params, "UTF-8");
		post.setEntity(encodeForm);
	}

	public JSONObject getMyObj() {
		return myObj;
	}
}
