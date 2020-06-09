/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cloud.securityadvisor.findings_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.BreakdownCardElement;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ValueType;
import com.ibm.cloud.securityadvisor.findings_api.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the BreakdownCardElement model.
 */
public class BreakdownCardElementTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testBreakdownCardElement() throws Throwable {
    ValueType valueTypeModel = new ValueType();
    valueTypeModel.setKind("KPI");
    valueTypeModel.setText("testString");
    assertEquals(valueTypeModel.kind(), "KPI");
    assertEquals(valueTypeModel.text(), "testString");

    BreakdownCardElement breakdownCardElementModel = new BreakdownCardElement.Builder()
      .kind("BREAKDOWN")
      .defaultTimeRange("1d")
      .text("testString")
      .valueTypes(new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)))
      .build();
    assertEquals(breakdownCardElementModel.kind(), "BREAKDOWN");
    assertEquals(breakdownCardElementModel.defaultTimeRange(), "1d");
    assertEquals(breakdownCardElementModel.text(), "testString");
    assertEquals(breakdownCardElementModel.valueTypes(), new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)));

    String json = TestUtilities.serialize(breakdownCardElementModel);

    BreakdownCardElement breakdownCardElementModelNew = TestUtilities.deserialize(json, BreakdownCardElement.class);
    assertTrue(breakdownCardElementModelNew instanceof BreakdownCardElement);
    assertEquals(breakdownCardElementModelNew.kind(), "BREAKDOWN");
    assertEquals(breakdownCardElementModelNew.defaultTimeRange(), "1d");
    assertEquals(breakdownCardElementModelNew.text(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testBreakdownCardElementError() throws Throwable {
    new BreakdownCardElement.Builder().build();
  }

}