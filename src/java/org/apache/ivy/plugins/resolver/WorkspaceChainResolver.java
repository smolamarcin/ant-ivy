/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.ivy.plugins.resolver;

import org.apache.ivy.core.settings.IvySettings;

/**
 * Resolver which decorate normal resolver so that the workspace resolver can
 * hijack the resolveprocess
 * <p>NB : it is for internal usage of Ivy only!</p>
 */
public class WorkspaceChainResolver extends ChainResolver {

    public WorkspaceChainResolver(IvySettings settings, DependencyResolver delegate,
            AbstractWorkspaceResolver workspaceResolver) {
        setName("workspace-chain-" + delegate.getName());
        setSettings(settings);
        setReturnFirst(true);
        add(workspaceResolver);
        add(delegate);
    }
}
