package com.ibm.cloud.securityadvisor.notifications_api.v1;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.InternalServerErrorException;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.securityadvisor.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.BulkDeleteChannelsResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ChannelResponseDefinition;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ChannelResponseDefinitionAlertSourceItem;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ChannelResponseDefinitionSeverity;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.CreateChannelsResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.CreateNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.DeleteChannelResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.DeleteNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.DeleteNotificationChannelsOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetChannelResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetChannelResponseChannel;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetChannelResponseChannelAlertSourceItem;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetChannelResponseChannelSeverity;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetPublicKeyOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ListAllChannelsOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ListChannelsResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.NotificationChannelAlertSourceItem;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.PublicKeyResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.TestChannelResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.TestNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.UpdateChannelResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.UpdateNotificationChannelOptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import com.ibm.cloud.sdk.core.http.Response;
import org.testng.annotations.Test;

import org.powermock.modules.testng.PowerMockTestCase;

public class NotificationsApiIntegrationTest extends PowerMockTestCase{
    
    public String ApiKey = System.getenv("API_KEY");
    public String AccountId = System.getenv("ACCOUNT_ID");
    public String IamUrl = System.getenv("IAM_URL");
    public String ApiUrl = System.getenv("NOTIFICATIONS_API_URL");
    public Authenticator authenticator = new IamAuthenticator(ApiKey, IamUrl, null, null, true, null);
    public NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator);

    @Test
    public void testListChannels() throws Throwable  {
        notificationsApi.setServiceUrl(ApiUrl);
        ListAllChannelsOptions opts = new ListAllChannelsOptions.Builder()
        .accountId(AccountId)
        .build();
        
        Response<ListChannelsResponse> resp = notificationsApi.listAllChannels(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void testCreateNotificationChannel() throws Throwable  {
        notificationsApi.setServiceUrl(ApiUrl);

        NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
        .providerName("testString")
        .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .build();

        CreateNotificationChannelOptions createNotificationChannelOptionsModel = new CreateNotificationChannelOptions.Builder()
        .accountId(AccountId)
        .name("testString")
        .type("Webhook")
        .endpoint("https://cloud.ibm.com")
        .description("testString")
        .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low")))
        .enabled(true)
        .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
        .build();
            
        Response<CreateChannelsResponse> resp = notificationsApi.createNotificationChannel(createNotificationChannelOptionsModel).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = InternalServerErrorException.class)
    public void testDeleteChannels() throws Throwable  {
        notificationsApi.setServiceUrl(ApiUrl);

        List<String> channelsList = new ArrayList<String>();
        channelsList.add("testString");

        DeleteNotificationChannelsOptions opts = new DeleteNotificationChannelsOptions.Builder()
        .accountId(AccountId)
        .body(channelsList)
        .build();
            
        Response<BulkDeleteChannelsResponse> resp = notificationsApi.deleteNotificationChannels(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = InternalServerErrorException.class)
    public void testDeleteChannel() throws Throwable  {
        notificationsApi.setServiceUrl(ApiUrl);

        DeleteNotificationChannelOptions opts = new DeleteNotificationChannelOptions.Builder()
        .accountId(AccountId)
        .channelId("koi-bhi-channel")
        .build();
            
        Response<DeleteChannelResponse> resp = notificationsApi.deleteNotificationChannel(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = InternalServerErrorException.class)
    public void testGetChannel() throws Throwable  {
        notificationsApi.setServiceUrl(ApiUrl);

        GetNotificationChannelOptions opts = new GetNotificationChannelOptions.Builder()
        .accountId(AccountId)
        .channelId("koi-bhi-channel")
        .build();
            
        Response<GetChannelResponse> resp = notificationsApi.getNotificationChannel(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = InternalServerErrorException.class)
    public void testUpdateChannel() throws Throwable  {
        notificationsApi.setServiceUrl(ApiUrl);

        NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
        .providerName("testString")
        .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .build();

        UpdateNotificationChannelOptions opts = new UpdateNotificationChannelOptions.Builder()
        .accountId(AccountId)
        .name("testString")
        .type("Webhook")
        .endpoint("https://cloud.ibm.com")
        .description("testString")
        .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low")))
        .enabled(true)
        .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
        .channelId("koi-bhi-channel")
        .build();
            
        Response<UpdateChannelResponse> resp = notificationsApi.updateNotificationChannel(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = InternalServerErrorException.class)
    public void testTestChannel() throws Throwable  {
        notificationsApi.setServiceUrl(ApiUrl);

        TestNotificationChannelOptions opts = new TestNotificationChannelOptions.Builder()
        .accountId(AccountId)
        .channelId("koi-bhi-channel")
        .build();
            
        Response<TestChannelResponse> resp = notificationsApi.testNotificationChannel(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void testGetPublicKey() throws Throwable  {
        notificationsApi.setServiceUrl(ApiUrl);

        GetPublicKeyOptions opts = new GetPublicKeyOptions.Builder()
        .accountId(AccountId)
        .build();
            
        Response<PublicKeyResponse> resp = notificationsApi.getPublicKey(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

}
