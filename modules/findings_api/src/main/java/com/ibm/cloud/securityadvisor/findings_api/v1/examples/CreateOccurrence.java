package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.*;

public class CreateOccurrence {

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        RemediationStep remediationStepModel = new RemediationStep.Builder()
        .title("testString")
        .url("https://cloud.ibm.com")
        .build();

        Finding findingModel = new Finding.Builder()
        .severity("LOW")
        .certainty("LOW")
        .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
        .build();

        CreateOccurrenceOptions createOccurrenceOptionsModel = new CreateOccurrenceOptions.Builder()
        .accountId("<accountId>")
        .providerId("test")
        .noteName("<accountId>" + "/providers" + "/test/notes/" + "example")
        .kind("FINDING")
        .id("testString")
        .resourceUrl("https://cloud.ibm.com")
        .remediation("testString")
        .finding(findingModel)
        .replaceIfExists(true)
        .build();

        Response<ApiOccurrence> resp = findingsApi.createOccurrence(createOccurrenceOptionsModel).execute();
        System.out.println(resp.getResult());
    }
}