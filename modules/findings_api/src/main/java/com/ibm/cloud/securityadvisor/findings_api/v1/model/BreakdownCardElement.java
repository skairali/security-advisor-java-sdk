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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * A card element with a breakdown of values.
 */
public class BreakdownCardElement extends CardElement {

  /**
   * Kind of element
   * - NUMERIC&amp;#58; Single numeric value
   * - BREAKDOWN&amp;#58; Breakdown of numeric values
   * - TIME_SERIES&amp;#58; Time-series of numeric values.
   */
  public interface Kind {
    /** NUMERIC. */
    String NUMERIC = "NUMERIC";
    /** BREAKDOWN. */
    String BREAKDOWN = "BREAKDOWN";
    /** TIME_SERIES. */
    String TIME_SERIES = "TIME_SERIES";
  }

  protected String text;
  @SerializedName("value_types")
  protected List<ValueType> valueTypes;

  /**
   * Builder.
   */
  public static class Builder {
    private String kind;
    private String defaultTimeRange;
    private String text;
    private List<ValueType> valueTypes;

    public Builder(BreakdownCardElement breakdownCardElement) {
      this.kind = breakdownCardElement.kind;
      this.defaultTimeRange = breakdownCardElement.defaultTimeRange;
      this.text = breakdownCardElement.text;
      this.valueTypes = breakdownCardElement.valueTypes;
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
     * @param valueTypes the valueTypes
     */
    public Builder(String kind, String text, List<ValueType> valueTypes) {
      this.kind = kind;
      this.text = text;
      this.valueTypes = valueTypes;
    }

    /**
     * Builds a BreakdownCardElement.
     *
     * @return the new BreakdownCardElement instance
     */
    public BreakdownCardElement build() {
      return new BreakdownCardElement(this);
    }

    /**
     * Adds an valueTypes to valueTypes.
     *
     * @param valueTypes the new valueTypes
     * @return the BreakdownCardElement builder
     */
    public Builder addValueTypes(ValueType valueTypes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(valueTypes,
        "valueTypes cannot be null");
      if (this.valueTypes == null) {
        this.valueTypes = new ArrayList<ValueType>();
      }
      this.valueTypes.add(valueTypes);
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the BreakdownCardElement builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the defaultTimeRange.
     *
     * @param defaultTimeRange the defaultTimeRange
     * @return the BreakdownCardElement builder
     */
    public Builder defaultTimeRange(String defaultTimeRange) {
      this.defaultTimeRange = defaultTimeRange;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the BreakdownCardElement builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the valueTypes.
     * Existing valueTypes will be replaced.
     *
     * @param valueTypes the valueTypes
     * @return the BreakdownCardElement builder
     */
    public Builder valueTypes(List<ValueType> valueTypes) {
      this.valueTypes = valueTypes;
      return this;
    }
  }

  protected BreakdownCardElement(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
      "text cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.valueTypes,
      "valueTypes cannot be null");
    kind = builder.kind;
    defaultTimeRange = builder.defaultTimeRange;
    text = builder.text;
    valueTypes = builder.valueTypes;
  }

  /**
   * New builder.
   *
   * @return a BreakdownCardElement builder
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
   * Gets the valueTypes.
   *
   * the value types associated to this card element.
   *
   * @return the valueTypes
   */
  public List<ValueType> valueTypes() {
    return valueTypes;
  }
}

