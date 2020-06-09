package com.ibm.cloud.securityadvisor.findings_api.v1;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListNoteOccurrencesResponse;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListNotesResponse;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListOccurrencesResponse;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListProvidersResponse;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiNote;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiNoteRelatedUrl;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiOccurrence;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiProvider;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CardElementsItemBreakdownCardElement;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Card;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CardElementsItem;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Context;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CreateNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CreateOccurrenceOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.DataTransferred;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.DeleteNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.DeleteOccurrenceOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Finding;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.FindingCountValueType;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.FindingType;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.GetNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.GetOccurrenceNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.GetOccurrenceOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Kpi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.KpiType;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListNoteOccurrencesOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListNotesOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListOccurrencesOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListProvidersOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.NetworkConnection;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CardElementsItemNumericCardElement;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.PostGraphOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.RemediationStep;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Reporter;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Section;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.SocketAddress;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CardElementsItemTimeSeriesCardElement;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.UpdateNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.UpdateOccurrenceOptions;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import com.ibm.cloud.sdk.core.http.Response;
import org.testng.annotations.Test;

import org.powermock.modules.testng.PowerMockTestCase;

public class FindingsApiIntegrationTest extends PowerMockTestCase{
    
    public String ApiKey = System.getenv("API_KEY");
    public String AccountId = System.getenv("ACCOUNT_ID");
    public String IamUrl = System.getenv("IAM_URL");
    public String ApiUrl = System.getenv("FINDINGS_API_URL");
    
    public Authenticator authenticator = new IamAuthenticator(ApiKey, IamUrl, null, null, true, null);
    public FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);

    @Test
    public void testPostGraph() throws Throwable  {
        System.out.println(ApiKey+" "+AccountId+" "+IamUrl+" "+ApiUrl);
        findingsApi.setServiceUrl(ApiUrl);
        PostGraphOptions opts = new PostGraphOptions.Builder()
        .accountId(AccountId)
        .contentType("application/graphql")
        .body(new ByteArrayInputStream("{notes{id}}".getBytes()))
        .build();
        
        Response<Void> resp = findingsApi.postGraph(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test
    public void testGetProviders() throws Throwable  {
        findingsApi.setServiceUrl(ApiUrl);
        ListProvidersOptions opts = new ListProvidersOptions.Builder()
        .accountId(AccountId)
        .build();
        
        Response<ApiListProvidersResponse> resp = findingsApi.listProviders(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test
    public void testPostNote() throws Throwable  {
        findingsApi.setServiceUrl(ApiUrl);

        Authenticator authenticator = new IamAuthenticator(ApiKey, IamUrl, null, null, true, null);

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl(ApiUrl);

        Reporter reporterModel = new Reporter.Builder()
        .id("testString")
        .title("testString")
        .url("testString")
        .build();

        FindingCountValueType findingCountValueTypeModel = new FindingCountValueType.Builder()
        .kind("FINDING_COUNT")
        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .text("testString")
        .build();

        CardElementsItemNumericCardElement cardElementModel = new CardElementsItemNumericCardElement.Builder()
        .kind("NUMERIC")
        .defaultTimeRange("1d")
        .text("testString")
        .valueType(findingCountValueTypeModel)
        .build();

        FindingCountValueType findingCount1 = new FindingCountValueType.Builder()
        .kind("FINDING_COUNT")
        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("providers/custom-provider/notes/custom-note")))
        .text("testString")
        .build();

        FindingCountValueType findingCount2 = new FindingCountValueType.Builder()
        .kind("FINDING_COUNT")
        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("providers/custom-provider/notes/custom-note-1")))
        .text("testString")
        .build();

        CardElementsItemTimeSeriesCardElement timeseriesElement = new CardElementsItemTimeSeriesCardElement.Builder()
        .kind("TIME_SERIES")
        .defaultTimeRange("1d")
        .text("testString")
        .valueTypes(new java.util.ArrayList<Object>(java.util.Arrays.asList(findingCount1, findingCount2)))
        .build();

        Card cardModel = new Card.Builder()
        .section("My Security Tools")
        .title("My new ts card")
        .subtitle("Time Series")
        .order(Long.valueOf("4"))
        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("providers/custom-provider/notes/custom-note", "providers/custom-provider/notes/custom-note-1")))
        .requiresConfiguration(false)
        .badgeText("testString")
        .elements(new java.util.ArrayList<CardElementsItem>(java.util.Arrays.asList(cardElementModel, timeseriesElement)))
        .build();

        CreateNoteOptions createNoteOptionsModel = new CreateNoteOptions.Builder()
        .accountId(AccountId)
        .providerId("testString")
        .shortDescription("testString")
        .longDescription("testString")
        .kind("CARD")
        .id("testString4")
        .reportedBy(reporterModel)
        .shared(true)
        .card(cardModel)
        .build();

        Response<ApiNote> resp = findingsApi.createNote(createNoteOptionsModel).execute();

        assertNotNull(resp);
        assertEquals(200, resp.getStatusCode());
    }

    @Test
    public void testListNotes() throws Throwable  {
        findingsApi.setServiceUrl(ApiUrl);

        ListNotesOptions opts = new ListNotesOptions.Builder()
        .accountId(AccountId)
        .providerId("test")
        .build();

        Response<ApiListNotesResponse> resp = findingsApi.listNotes(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void testGetNote() throws Throwable {
        findingsApi.setServiceUrl(ApiUrl);

        GetNoteOptions opts = new GetNoteOptions.Builder()
        .accountId(AccountId)
        .providerId("test")
        .noteId("koi-bhi-card")
        .build();

        Response<ApiNote> resp = findingsApi.getNote(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void testUpdateNote() throws Throwable {
        findingsApi.setServiceUrl(ApiUrl);

        FindingCountValueType findingCountValueTypeModel = new FindingCountValueType.Builder()
        .kind("FINDING_COUNT")
        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .text("testString")
        .build();

        CardElementsItemTimeSeriesCardElement cardElementModel = new CardElementsItemTimeSeriesCardElement.Builder()
        .kind("TIME_SERIES")
        .defaultTimeRange("1d")
        .text("testString")
        .defaultInterval("testString")
        .valueTypes(new java.util.ArrayList<Object>(java.util.Arrays.asList(findingCountValueTypeModel)))
        .build();

        RemediationStep remediationStepModel = new RemediationStep.Builder()
        .title("testString")
        .url("testString")
        .build();

        ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder()
        .label("testString")
        .url("testString")
        .build();

        Card cardModel = new Card.Builder()
        .section("testString")
        .title("testString")
        .subtitle("testString")
        .order(Long.valueOf("1"))
        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .requiresConfiguration(true)
        .badgeText("testString")
        .badgeImage("testString")
        .elements(new java.util.ArrayList<CardElementsItem>(java.util.Arrays.asList(cardElementModel)))
        .build();

        FindingType findingTypeModel = new FindingType.Builder()
        .severity("LOW")
        .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
        .build();

        KpiType kpiTypeModel = new KpiType.Builder()
        .aggregationType("SUM")
        .build();

        Reporter reporterModel = new Reporter.Builder()
        .id("testString")
        .title("testString")
        .url("testString")
        .build();

        Section sectionModel = new Section.Builder()
        .title("testString")
        .image("testString")
        .build();

        UpdateNoteOptions opts = new UpdateNoteOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .shortDescription("testString")
        .longDescription("testString")
        .kind("FINDING")
        .id("testString")
        .reportedBy(reporterModel)
        .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)))
        .shared(true)
        .finding(findingTypeModel)
        .kpi(kpiTypeModel)
        .card(cardModel)
        .section(sectionModel)
        .noteId("koi-bhi-note")
        .build();

        Response<ApiNote> resp = findingsApi.updateNote(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void testDeleteNote() throws Throwable {
        findingsApi.setServiceUrl(ApiUrl);

        DeleteNoteOptions opts = new DeleteNoteOptions.Builder()
        .accountId(AccountId)
        .providerId("test")
        .noteId("koi-bhi-card")
        .build();

        Response<Void> resp = findingsApi.deleteNote(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void testGetNoteByOccurrenceId() throws Throwable {
        findingsApi.setServiceUrl(ApiUrl);

        GetOccurrenceNoteOptions opts = new GetOccurrenceNoteOptions.Builder()
        .accountId(AccountId)
        .providerId("test")
        .occurrenceId("koi-bhi-occurrence")
        .build();

        Response<ApiNote> resp = findingsApi.getOccurrenceNote(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }
    
    @Test(expectedExceptions = NotFoundException.class)
    public void testCreateOccurrence() throws Throwable {
        findingsApi.setServiceUrl(ApiUrl);

        SocketAddress socketAddressModel = new SocketAddress.Builder()
        .address("testString")
        .port(Long.valueOf("26"))
        .build();

        DataTransferred dataTransferredModel = new DataTransferred.Builder()
        .clientBytes(Long.valueOf("26"))
        .serverBytes(Long.valueOf("26"))
        .clientPackets(Long.valueOf("26"))
        .serverPackets(Long.valueOf("26"))
        .build();

        NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
        .direction("testString")
        .protocol("testString")
        .client(socketAddressModel)
        .server(socketAddressModel)
        .build();

        RemediationStep remediationStepModel = new RemediationStep.Builder()
        .title("testString")
        .url("testString")
        .build();

        Context contextModel = new Context.Builder()
        .region("testString")
        .resourceCrn("testString")
        .resourceId("testString")
        .resourceName("testString")
        .resourceType("testString")
        .serviceCrn("testString")
        .serviceName("testString")
        .environmentName("testString")
        .componentName("testString")
        .toolchainId("testString")
        .build();

        Finding findingModel = new Finding.Builder()
        .severity("LOW")
        .certainty("LOW")
        .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
        .networkConnection(networkConnectionModel)
        .dataTransferred(dataTransferredModel)
        .build();

        Kpi kpiModel = new Kpi.Builder()
        .value(Double.valueOf("72.5"))
        .total(Double.valueOf("72.5"))
        .build();

        CreateOccurrenceOptions createOccurrenceOptionsModel = new CreateOccurrenceOptions.Builder()
        .accountId(AccountId)
        .providerId("test")
        .noteName(AccountId + "/providers" + "/test/notes/" + "test")
        .kind("FINDING")
        .id("testString")
        .resourceUrl("testString")
        .remediation("testString")
        .context(contextModel)
        .finding(findingModel)
        .kpi(kpiModel)
        .replaceIfExists(true)
        .build();

        Response<ApiOccurrence> resp = findingsApi.createOccurrence(createOccurrenceOptionsModel).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test
    public void testListOccurrences() throws Throwable {
        findingsApi.setServiceUrl(ApiUrl);

        ListOccurrencesOptions opts = new ListOccurrencesOptions.Builder()
        .accountId(AccountId)
        .providerId("test")
        .build();

        Response<ApiListOccurrencesResponse> resp = findingsApi.listOccurrences(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }


    @Test(expectedExceptions = NotFoundException.class)
    public void testGetOccurrence() throws Throwable {
        findingsApi.setServiceUrl(ApiUrl);

        GetOccurrenceOptions opts = new GetOccurrenceOptions.Builder()
        .accountId(AccountId)
        .providerId("test")
        .occurrenceId("koi-bhi-occurrence")
        .build();

        Response<ApiListOccurrencesResponse> resp = findingsApi.getOccurrence(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void testUpdateOccurrence() throws Throwable {
        findingsApi.setServiceUrl(ApiUrl);

        SocketAddress socketAddressModel = new SocketAddress.Builder()
        .address("testString")
        .port(Long.valueOf("26"))
        .build();

        DataTransferred dataTransferredModel = new DataTransferred.Builder()
        .clientBytes(Long.valueOf("26"))
        .serverBytes(Long.valueOf("26"))
        .clientPackets(Long.valueOf("26"))
        .serverPackets(Long.valueOf("26"))
        .build();

        NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
        .direction("testString")
        .protocol("testString")
        .client(socketAddressModel)
        .server(socketAddressModel)
        .build();

        RemediationStep remediationStepModel = new RemediationStep.Builder()
        .title("testString")
        .url("testString")
        .build();

        Context contextModel = new Context.Builder()
        .region("testString")
        .resourceCrn("testString")
        .resourceId("testString")
        .resourceName("testString")
        .resourceType("testString")
        .serviceCrn("testString")
        .serviceName("testString")
        .environmentName("testString")
        .componentName("testString")
        .toolchainId("testString")
        .build();

        Finding findingModel = new Finding.Builder()
        .severity("LOW")
        .certainty("LOW")
        .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
        .networkConnection(networkConnectionModel)
        .dataTransferred(dataTransferredModel)
        .build();

        Kpi kpiModel = new Kpi.Builder()
        .value(Double.valueOf("72.5"))
        .total(Double.valueOf("72.5"))
        .build();

        UpdateOccurrenceOptions updateOccurrenceOptionsModel = new UpdateOccurrenceOptions.Builder()
        .accountId(AccountId)
        .providerId("test")
        .noteName(AccountId + "/providers" + "/test/notes/" + "test")
        .kind("FINDING")
        .id("testString")
        .resourceUrl("testString")
        .remediation("testString")
        .context(contextModel)
        .finding(findingModel)
        .kpi(kpiModel)
        .occurrenceId("koi-bhi-occurrence")
        .build();

        Response<ApiOccurrence> resp = findingsApi.updateOccurrence(updateOccurrenceOptionsModel).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void testDeleteOccurrence() throws Throwable {
        findingsApi.setServiceUrl(ApiUrl);

        DeleteOccurrenceOptions opts = new DeleteOccurrenceOptions.Builder()
        .accountId(AccountId)
        .providerId("test")
        .occurrenceId("koi-bhi-occurrence")
        .build();

        Response<Void> resp = findingsApi.deleteOccurrence(opts).execute();
        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }
}
