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
import com.ibm.cloud.securityadvisor.findings_api.v1.model.SocketAddress;
import com.ibm.cloud.securityadvisor.findings_api.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SocketAddress model.
 */
public class SocketAddressTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSocketAddress() throws Throwable {
    SocketAddress socketAddressModel = new SocketAddress.Builder()
      .address("testString")
      .port(Long.valueOf("26"))
      .build();
    assertEquals(socketAddressModel.address(), "testString");
    assertEquals(socketAddressModel.port(), Long.valueOf("26"));

    String json = TestUtilities.serialize(socketAddressModel);

    SocketAddress socketAddressModelNew = TestUtilities.deserialize(json, SocketAddress.class);
    assertTrue(socketAddressModelNew instanceof SocketAddress);
    assertEquals(socketAddressModelNew.address(), "testString");
    assertEquals(socketAddressModelNew.port(), Long.valueOf("26"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSocketAddressError() throws Throwable {
    new SocketAddress.Builder().build();
  }

}