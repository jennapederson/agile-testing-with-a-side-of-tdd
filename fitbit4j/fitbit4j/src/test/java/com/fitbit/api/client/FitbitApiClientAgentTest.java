package com.fitbit.api.client;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fitbit.api.FitbitAPIException;
import com.fitbit.api.client.http.Response;
import com.fitbit.api.common.model.activities.ActivityCategory;
import com.fitbit.api.model.APIResourceCredentials;


public class FitbitApiClientAgentTest {

	@Mock
	private LocalUserDetail localUserDetail;
	@Mock
	private FitbitApiCredentialsCache credentialsCache;
	@Mock
	private APIResourceCredentials resourceCredentials;
	@Mock
	protected Response response;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected=IllegalStateException.class)
	public void testGetActivityCategoriesThrowExceptionWhenNoUser() throws Exception {
		FitbitApiClientAgent agent = new FitbitApiClientAgent();
		agent.getActivityCategories(null);
	}

	
	@Test
	public void testGetActivityCategoriesReturnsEmptyList() throws Exception {
		when(credentialsCache.getResourceCredentials(localUserDetail)).thenReturn(resourceCredentials);
		FitbitApiClientAgent agent = new FitbitApiClientAgent("", "", credentialsCache) {

			@Override
			protected Response httpGet(String url, boolean authenticate)
					throws FitbitAPIException {
				return response;
			}

			@Override
			List<ActivityCategory> convertToActivityCategory(Response res)
					throws JSONException, FitbitAPIException {
				return new ArrayList<ActivityCategory>();
			}
		};
		assertThat(agent.getActivityCategories(localUserDetail).isEmpty(), is(true));
	}

}
