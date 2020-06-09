package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.*;

public class CreateCard {

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        FindingCountValueType findingCountValueTypeModel = new FindingCountValueType.Builder()
        .kind("FINDING_COUNT")
        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .text("testString")
        .build();

        NumericCardElement cardElementModel = new NumericCardElement.Builder()
        .kind("NUMERIC")
        .defaultTimeRange("1d")
        .text("sample_text")
        .valueType(findingCountValueTypeModel)
        .build();

        ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder()
        .label("testString")
        .url("testString")
        .build();

        Card cardModel = new Card.Builder()
        .section("testString")
        .title("testString")
        .subtitle("testString")
        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .elements(new java.util.ArrayList<CardElement>(java.util.Arrays.asList(cardElementModel)))
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

        CreateNoteOptions createNoteOptionsModel = new CreateNoteOptions.Builder()
        .accountId("<accountId>")
        .providerId("test")
        .shortDescription("testString")
        .longDescription("testString")
        .kind("CARD")
        .id("test1")
        .reportedBy(reporterModel)
        .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)))
        .card(cardModel)
        .section(sectionModel)
        .build();
        
        Response<ApiNote> resp = findingsApi.createNote(createNoteOptionsModel).execute();
        System.out.println(resp.getResult());
    }
}