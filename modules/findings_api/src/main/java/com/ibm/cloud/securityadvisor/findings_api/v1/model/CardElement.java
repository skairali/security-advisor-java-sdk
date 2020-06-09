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
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * CardElement provides details about the elements of a Card.
 */
public class CardElement extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "kind";
  protected static java.util.Map<String, Class<?>> discriminatorMapping;
  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("NUMERIC", NumericCardElement.class);
    discriminatorMapping.put("BREAKDOWN", BreakdownCardElement.class);
    discriminatorMapping.put("TIME_SERIES", TimeSeriesCardElement.class);
  }

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

  protected String kind;
  @SerializedName("default_time_range")
  protected String defaultTimeRange;

  /**
   * Gets the kind.
   *
   * Kind of element
   * - NUMERIC&amp;#58; Single numeric value
   * - BREAKDOWN&amp;#58; Breakdown of numeric values
   * - TIME_SERIES&amp;#58; Time-series of numeric values.
   *
   * @return the kind
   */
  public String kind() {
    return kind;
  }

  /**
   * Gets the defaultTimeRange.
   *
   * The default time range of this card element.
   *
   * @return the defaultTimeRange
   */
  public String defaultTimeRange() {
    return defaultTimeRange;
  }
}

