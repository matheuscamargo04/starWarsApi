package com.starWarsApis.starWarsApis.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.core.MediaType;

import com.starWarsApis.starWarsApis.domain.Endpoints;
import com.starWarsApis.starWarsApis.exceptions.NotFoundException;

public class RestCallUtils {

	public static HttpsURLConnection getConnectionToURL(String filmUrl) {

		HttpsURLConnection con = null;
		URL url = null;

		try {
			url = new URL(filmUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getCause());
		}

		try {
			con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", MediaType.APPLICATION_JSON);
			con.setRequestProperty("user-agent", "spring");
			con.setConnectTimeout(300000);

			if (con.getResponseCode() != 200) {

				if (con.getResponseCode() == 404) {
					throw new NotFoundException("Response not found for request " + filmUrl + ".");

				} else {
					throw new RuntimeException(
							"HTTP GET Request on " + filmUrl + " failed with Error code: " + con.getResponseCode());

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error getting connect with " + filmUrl + ". Error: " + e.getMessage());
		}

		return con;
	}

	public static String composeUrl(Long id, Endpoints endpoints) {

		final String encoding = "utf-8";

		try {

			if (Objects.nonNull(id)) {
				return endpoints.getUrl() + URLEncoder.encode(id.toString(), encoding);
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

		return null;
	}

}
