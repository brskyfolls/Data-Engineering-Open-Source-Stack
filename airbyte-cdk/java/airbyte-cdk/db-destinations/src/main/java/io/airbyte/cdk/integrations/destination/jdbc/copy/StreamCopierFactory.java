/*
 * Copyright (c) 2023 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.cdk.integrations.destination.jdbc.copy;

import io.airbyte.cdk.db.jdbc.JdbcDatabase;
import io.airbyte.cdk.integrations.destination.StandardNameTransformer;
import io.airbyte.cdk.integrations.destination.jdbc.SqlOperations;
import io.airbyte.protocol.models.v0.ConfiguredAirbyteStream;

public interface StreamCopierFactory<T> {

  StreamCopier create(String configuredSchema,
                      T config,
                      String stagingFolder,
                      ConfiguredAirbyteStream configuredStream,
                      StandardNameTransformer nameTransformer,
                      JdbcDatabase db,
                      SqlOperations sqlOperations);

  static String getSchema(final String namespace, final String configuredSchema, final StandardNameTransformer nameTransformer) {
    if (namespace != null) {
      return nameTransformer.convertStreamName(namespace);
    } else {
      return nameTransformer.convertStreamName(configuredSchema);
    }
  }

}
