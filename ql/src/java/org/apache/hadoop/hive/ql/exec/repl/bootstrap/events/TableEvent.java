/*
  Licensed to the Apache Software Foundation (ASF) under one
  or more contributor license agreements.  See the NOTICE file
  distributed with this work for additional information
  regarding copyright ownership.  The ASF licenses this file
  to you under the Apache License, Version 2.0 (the
  "License"); you may not use this file except in compliance
  with the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package org.apache.hadoop.hive.ql.exec.repl.bootstrap.events;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.ddl.table.partition.add.AlterTableAddPartitionDesc;
import org.apache.hadoop.hive.ql.parse.ReplicationSpec;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.plan.ImportTableDesc;

import java.util.List;

public interface TableEvent extends BootstrapEvent {
  ImportTableDesc tableDesc(String dbName) throws SemanticException;

  List<AlterTableAddPartitionDesc> partitionDescriptions(ImportTableDesc tblDesc)
      throws SemanticException;

  List<String> partitions(ImportTableDesc tblDesc)
          throws SemanticException;

  ReplicationSpec replicationSpec();

  boolean shouldNotReplicate();

  /**
   * Exposing the FileSystem implementation outside which is what it should NOT do.
   */
  Path metadataPath();
}
