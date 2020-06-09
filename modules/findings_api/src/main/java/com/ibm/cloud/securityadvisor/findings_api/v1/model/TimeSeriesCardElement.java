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
 * A card element with a time series chart.
 */
public class TimeSeriesCardElement extends CardElement {

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
  @SerializedName("default_interval")
  protected String defaultInterval;
  @SerializedName("value_types")
  protected List<FindingCountValueType> valueTypes;

  /**
   * Builder.
   */
  public static class Builder {
    private String kind;
    private String defaultTimeRange;
    private String text;
    private String defaultInterval;
    private List<FindingCountValueType> valueTypes;

    public Builder(TimeSeriesCardElement timeSeriesCardElement) {
      this.kind = timeSeriesCardElement.kind;
      this.defaultTimeRange = timeSeriesCardElement.defaultTimeRange;
      this.text = timeSeriesCardElement.text;
      this.defaultInterval = timeSeriesCardElement.defaultInterval;
      this.valueTypes = timeSeriesCardElement.valueTypes;
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
    public Builder(String kind, String text, List<FindingCountValueType> valueTypes) {
      this.kind = kind;
      this.text = text;
      this.valueTypes = valueTypes;
    }

    /**
     * Builds a TimeSeriesCardElement.
     *
     * @return the new TimeSeriesCardElement instance
     */
    public TimeSeriesCardElement build() {
      return new TimeSeriesCardElement(this);
    }

    /**
     * Adds an valueTypes to valueTypes.
     *
     * @param valueTypes the new valueTypes
     * @return the TimeSeriesCardElement builder
     */
    public Builder addValueTypes(FindingCountValueType valueTypes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(valueTypes,
        "valueTypes cannot be null");
      if (this.valueTypes == null) {
        this.valueTypes = new ArrayList<FindingCountValueType>();
      }
      this.valueTypes.add(valueTypes);
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the TimeSeriesCardElement builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the defaultTimeRange.
     *
     * @param defaultTimeRange the defaultTimeRange
     * @return the TimeSeriesCardElement builder
     */
    public Builder defaultTimeRange(String defaultTimeRange) {
      this.defaultTimeRange = defaultTimeRange;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the TimeSeriesCardElement builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the defaultInterval.
     *
     * @param defaultInterval the defaultInterval
     * @return the TimeSeriesCardElement builder
     */
    public Builder defaultInterval(String defaultInterval) {
      this.defaultInterval = defaultInterval;
      return this;
    }

    /**
     * Set the valueTypes.
     * Existing valueTypes will be replaced.
     *
     * @param valueTypes the valueTypes
     * @return the TimeSeriesCardElement builder
     */
    public Builder valueTypes(List<FindingCountValueType> valueTypes) {
      this.valueTypes = valueTypes;
      return this;
    }
  }

  protected TimeSeriesCardElement(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
      "text cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.valueTypes,
      "valueTypes cannot be null");
    kind = builder.kind;
    defaultTimeRange = builder.defaultTimeRange;
    text = builder.text;
    defaultInterval = builder.defaultInterval;
    valueTypes = builder.valueTypes;
  }

  /**
   * New builder.
   *
   * @return a TimeSeriesCardElement builder
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
   * Gets the defaultInterval.
   *
   * The default interval of the time series.
   *
   * @return the defaultInterval
   */
  public String defaultInterval() {
    return defaultInterval;
  }

  /**
   * Gets the valueTypes.
   *
   * the value types associated to this card element.
   *
   * @return the valueTypes
   */
  public List<FindingCountValueType> valueTypes() {
    return valueTypes;
  }
}

