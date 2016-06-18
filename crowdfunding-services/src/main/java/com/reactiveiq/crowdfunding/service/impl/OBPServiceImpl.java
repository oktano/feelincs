package com.reactiveiq.crowdfunding.service.impl;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactiveiq.crowdfunding.service.ApplicationSettingService;
import com.reactiveiq.crowdfunding.service.ServiceConstants;
import com.reactiveiq.crowdfunding.service.exception.ExpiredAccessTokenException;
import com.reactiveiq.crowdfunding.service.exception.ObpApiCallFailedException;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;



@Singleton
public class OBPServiceImpl {
	
	private static final String APPLICATION_NAME="birlikteal"; 

	@Inject
	private ApplicationSettingService applicationSettingService;
	
	
	private static final String OBP_AUTH_KEY = "fhpv2zqjhznjzhdcof2nqfwpgnspgpvyib5ssm0g";
	private static final String OBP_SECRET_KEY = "hbw5mt4fsuq1lgtjfwd2f2tmtoaala2mosuyl1ok";
	
	private static final String BASE_URL = "https://bnpparibas-api.openbankproject.com";

	private static final String REQUEST_TOKEN_URL = calcFullPath("/oauth/initiate");
	private static final String ACCESS_TOKEN_URL = calcFullPath("/oauth/token");
	private static final String AUTHORIZE_WEBSITE_URL = calcFullPath("/oauth/authorize");


	private static final Logger LOGGER=LoggerFactory.getLogger(OBPServiceImpl.class);

	private static OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
			OBP_AUTH_KEY, OBP_SECRET_KEY);

	private static OAuthProvider provider = new CommonsHttpOAuthProvider(
			REQUEST_TOKEN_URL, ACCESS_TOKEN_URL, AUTHORIZE_WEBSITE_URL);

	private static String calcFullPath(String relativePath) {
		return BASE_URL + relativePath;
	}


	public OBPServiceImpl()throws Exception{
		/* String url=provider.retrieveRequestToken(consumer, "Birlikteal");
		 System.out.println(url);
		 Scanner sc=new Scanner(System.in);
		 String oauth_verifier = sc.nextLine();
		 
		  provider.retrieveAccessToken(consumer, URLDecoder.decode(oauth_verifier),"UTF-8");
		  
	        String token = consumer.getToken();
	        String secret = consumer.getTokenSecret();
	 */
		
		String token="24DAT54FDBJ32ZV5BCWX2JNSDT2NMI0KK1TMJVE3";
		String secret="KQQM55FPYO520RIVPWZHO2PEVXTMULLUFCDRQ14K";
		//Map<String,String>keyValueMap=applicationSettingService.findAllToMap();
		
		//consumer.setTokenWithSecret(keyValueMap.get(ServiceConstants.ACCESS_TOKEN),keyValueMap.get(ServiceConstants.TOKEN_SECRET));
	 	consumer.setTokenWithSecret(token, secret);
	}
	
	public String getAccessToken()throws Exception{
		 return provider.retrieveRequestToken(consumer, APPLICATION_NAME);
	}


	public  JSONObject getOAuthedJson(String urlString)
			throws ObpApiCallFailedException,ExpiredAccessTokenException {

		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet request = new HttpGet(urlString);
			consumer.sign(request);
			org.apache.http.HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

		//	System.out.println(entity.getContent().r);
			int statusCode = response.getStatusLine().getStatusCode();
			
			switch (statusCode) {

			case 200:
			case 201:
				return parseJsonResponse(entity);
			case 401:
				try {
					JSONObject responseJson = parseJsonResponse(entity);
					if (responseJson.optString("error").contains(
							consumer.getToken())) {
						// We have an expired access token (probably?)
						throw new ExpiredAccessTokenException();
					} else {
						// It wasn't (probably?) an expired token error
					
						throw new ObpApiCallFailedException();
					}
				} catch (JSONException e) {
					// Api response wasn't json -> unexpected
				
					throw new ObpApiCallFailedException();
				}
			default:
				throw new ObpApiCallFailedException();
			}
		} catch (MalformedURLException e) {
			
			throw new ObpApiCallFailedException();
		} catch (OAuthMessageSignerException e) {
		
			throw new ObpApiCallFailedException();
		} catch (OAuthExpectationFailedException e) {
			throw new ObpApiCallFailedException();
		} catch (OAuthCommunicationException e) {
			throw new ObpApiCallFailedException();
		} catch (ClientProtocolException e) {
			throw new ObpApiCallFailedException();
		} catch (IOException e) {
			throw new ObpApiCallFailedException();
		} catch (JSONException e) {
			throw new ObpApiCallFailedException();
		} catch (ObpApiCallFailedException e) {
			throw new ObpApiCallFailedException();
		}

	}

	
	private  JSONObject parseJsonResponse(HttpEntity entity)
			throws ParseException, JSONException, IOException {
		return new JSONObject(EntityUtils.toString(entity));
	}

	public  JSONObject getBanksJson() throws ExpiredAccessTokenException,
			ObpApiCallFailedException {
		return getOAuthedJson(BASE_URL + "/obp/v2.0.0/banks");
	}
	
	public  JSONObject getAccounts() throws ExpiredAccessTokenException,
		ObpApiCallFailedException {
		return getOAuthedJson(BASE_URL + "/obp/v2.0.0/banks");
	}

	public static void main(String []args)throws Exception{
		
		System.out.println(new OBPServiceImpl().getAccounts());
	}

}