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
package com.ibm.cloud.securityadvisor.notifications_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getPublicKey options.
 */
public class GetPublicKeyOptions extends GenericModel {

  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;

    private Builder(GetPublicKeyOptions getPublicKeyOptions) {
      this.accountId = getPublicKeyOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     */
    public Builder(String accountId) {
      this.accountId = accountId;
    }

    /**
     * Builds a GetPublicKeyOptions.
     *
     * @return the new GetPublicKeyOptions instance
     */
    public GetPublicKeyOptions build() {
      return new GetPublicKeyOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetPublicKeyOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected GetPublicKeyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a GetPublicKeyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

