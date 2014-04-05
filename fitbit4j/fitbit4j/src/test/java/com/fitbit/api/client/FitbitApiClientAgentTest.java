package com.fitbit.api.client;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fitbit.api.client.http.Response;
import com.fitbit.api.common.model.activities.Activity;
import com.fitbit.api.model.APIResourceCredentials;


public class FitbitApiClientAgentTest {

	@InjectMocks
	private FitbitApiClientAgent agent;
	@Mock
	private FitbitApiCredentialsCache credentialsCache;
	
	@Mock
	private LocalUserDetail localUser;
	@Mock
	private APIResourceCredentials resourceCredentials;
	@Mock
	private HttpClientSupport httpClientSupport;
	@Mock
	private Response response;
	@Mock
	private ActivitySupport activitySupport;
	@Mock
	private Activity activity;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetActivity() throws Exception {
		when(credentialsCache.getResourceCredentials(localUser)).thenReturn(resourceCredentials);
		when(httpClientSupport.get(anyString(), eq(true))).thenReturn(response);
		when(activitySupport.constructActivity(any(JSONObject.class))).thenReturn(activity);
		Activity result = agent.getActivity(localUser, 123);
		assertThat(result, is(not(nullValue())));
		assertThat(result, is(activity));
	}

}
