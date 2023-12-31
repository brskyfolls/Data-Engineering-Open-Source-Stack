/*
 * Copyright (c) 2023 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.integrations.source.oracle_strict_encrypt;

import com.fasterxml.jackson.databind.node.ArrayNode;
import io.airbyte.cdk.integrations.base.IntegrationRunner;
import io.airbyte.cdk.integrations.base.Source;
import io.airbyte.cdk.integrations.base.spec_modification.SpecModifyingSource;
import io.airbyte.commons.json.Jsons;
import io.airbyte.integrations.source.oracle.OracleSource;
import io.airbyte.protocol.models.v0.ConnectorSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleStrictEncryptSource extends SpecModifyingSource implements Source {

  private static final Logger LOGGER = LoggerFactory.getLogger(OracleStrictEncryptSource.class);

  OracleStrictEncryptSource() {
    super(OracleSource.sshWrappedSource());
  }

  @Override
  public ConnectorSpecification modifySpec(final ConnectorSpecification originalSpec) {
    final ConnectorSpecification spec = Jsons.clone(originalSpec);
    ((ArrayNode) spec.getConnectionSpecification().get("required")).add("encryption");
    // We need to remove the first item from one Of, which is responsible for connecting to the source
    // without encrypted.
    ((ArrayNode) spec.getConnectionSpecification().get("properties").get("encryption").get("oneOf")).remove(0);
    return spec;
  }

  public static void main(final String[] args) throws Exception {
    final Source source = new OracleStrictEncryptSource();
    LOGGER.info("starting source: {}", OracleStrictEncryptSource.class);
    new IntegrationRunner(source).run(args);
    LOGGER.info("completed source: {}", OracleStrictEncryptSource.class);
  }

}
