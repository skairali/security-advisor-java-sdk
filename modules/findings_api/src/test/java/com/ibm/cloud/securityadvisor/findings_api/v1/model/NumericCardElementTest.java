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
import com.ibm.cloud.securityadvisor.findings_api.v1.model.NumericCardElement;
import com.ibm.cloud.securityadvisor.findings_api.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the NumericCardElement model.
 */
public class NumericCardElementTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testNumericCardElement() throws Throwable {
    NumericCardElement numericCardElementModel = new NumericCardElement.Builder()
      .kind("NUMERIC")
      .defaultTimeRange("1d")
      .text("testString")
      .valueType("testString")
      .build();
    assertEquals(numericCardElementModel.kind(), "NUMERIC");
    assertEquals(numericCardElementModel.defaultTimeRange(), "1d");
    assertEquals(numericCardElementModel.text(), "testString");
    assertEquals(numericCardElementModel.valueType(), "testString");

    String json = TestUtilities.serialize(numericCardElementModel);

    NumericCardElement numericCardElementModelNew = TestUtilities.deserialize(json, NumericCardElement.class);
    assertTrue(numericCardElementModelNew instanceof NumericCardElement);
    assertEquals(numericCardElementModelNew.kind(), "NUMERIC");
    assertEquals(numericCardElementModelNew.defaultTimeRange(), "1d");
    assertEquals(numericCardElementModelNew.text(), "testString");
    assertEquals(numericCardElementModelNew.valueType(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testNumericCardElementError() throws Throwable {
    new NumericCardElement.Builder().build();
  }

}