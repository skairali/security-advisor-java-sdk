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

import com.google.gson.annotations.SerializedName;

/**
 * A card element with a single numeric value.
 */
public class NumericCardElement extends CardElement {

  /**
   * Kind of element
   * - NUMERIC&amp;#58; Single numeric value
   * - BREAKDOWN&amp;#58; Breakdown of numeric values
   * - TIME_SERIES&amp;#58; Time-series of numeric values.
   */
  public interface Kind {
    /** NUMERIC. */
    String NUMERIC = "NUMERIC";
  }

  protected String text;
  @SerializedName("value_type")
  protected Object valueType;

  /**
   * Builder.
   */
  public static class Builder {
    private String kind;
    private String defaultTimeRange;
    private String text;
    private Object valueType;

    public Builder(NumericCardElement numericCardElement) {
      this.kind = numericCardElement.kind;
      this.defaultTimeRange = numericCardElement.defaultTimeRange;
      this.text = numericCardElement.text;
      this.valueType = numericCardElement.valueType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param kind the kind
     * @param text the text
     * @param valueType the valueType
     */
    public Builder(String kind, String text, Object valueType) {
      this.kind = kind;
      this.text = text;
      this.valueType = valueType;
    }

    /**
     * Builds a NumericCardElement.
     *
     * @return the new NumericCardElement instance
     */
    public NumericCardElement build() {
      return new NumericCardElement(this);
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the NumericCardElement builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the defaultTimeRange.
     *
     * @param defaultTimeRange the defaultTimeRange
     * @return the NumericCardElement builder
     */
    public Builder defaultTimeRange(String defaultTimeRange) {
      this.defaultTimeRange = defaultTimeRange;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the NumericCardElement builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the valueType.
     *
     * @param valueType the valueType
     * @return the NumericCardElement builder
     */
    public Builder valueType(Object valueType) {
      this.valueType = valueType;
      return this;
    }
  }

  protected NumericCardElement(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
      "text cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.valueType,
      "valueType cannot be null");
    kind = builder.kind;
    defaultTimeRange = builder.defaultTimeRange;
    text = builder.text;
    valueType = builder.valueType;
  }

  /**
   * New builder.
   *
   * @return a NumericCardElement builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * The text of this card element.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the valueType.
   *
   * @return the valueType
   */
  public Object valueType() {
    return valueType;
  }
}

