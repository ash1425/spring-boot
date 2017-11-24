/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.actuate.autoconfigure.metrics.export.datadog;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link DatadogPropertiesConfigAdapter}.
 *
 * @author Stephane Nicoll
 */
public class DatadogPropertiesConfigAdapterTests {

	@Test
	public void apiKeyInferUri() {
		DatadogProperties properties = new DatadogProperties();
		properties.setApiKey("my-key");
		assertThat(new DatadogPropertiesConfigAdapter(properties).uri())
				.contains("?api_key=my-key");
	}

	@Test
	public void uriCanBeSet() {
		DatadogProperties properties = new DatadogProperties();
		properties.setUri("https://app.example.com/api/v1/series");
		properties.setApiKey("my-key");
		assertThat(new DatadogPropertiesConfigAdapter(properties).uri())
				.isEqualTo("https://app.example.com/api/v1/series");
	}

}
