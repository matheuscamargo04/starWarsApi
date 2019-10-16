package com.starWarsApis.starWarsApis.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.starWarsApis.starWarsApis.domain.Endpoints;
import com.starWarsApis.starWarsApis.util.RestCallUtils;

@Service
public class RestCallService {

	public static <T> Object call(String url, Class<T> dtoClass, Endpoints endpoint) {

		final String encoding = "utf-8";

		HttpsURLConnection con = null;
		BufferedReader reader = null;
		StringBuffer strBuff = new StringBuffer();

		con = RestCallUtils.getConnectionToURL(url);

		try {

			reader = new BufferedReader(new InputStreamReader(con.getInputStream(), encoding));
			String responseAsString = null;

			while ((Objects.nonNull(responseAsString = reader.readLine()))) {
				strBuff.append(responseAsString);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		if (Objects.nonNull(con)) {
			con.disconnect();
		}
		if (Objects.nonNull(reader)) {
			try {
				reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return new Gson().fromJson(strBuff.toString(), dtoClass);

	}

}
