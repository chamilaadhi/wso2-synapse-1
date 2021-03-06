/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.synapse.mediators.xslt;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.synapse.mediators.MediatorTestCase;
import org.apache.synapse.samples.framework.clients.StockQuoteSampleClient;

/**
 * Test case for XSLT transformation by selecting the xslt file from file system
 */
public class FileSystemLocalEntryXsltTransformationTestCase extends MediatorTestCase {

    public FileSystemLocalEntryXsltTransformationTestCase() {
        loadConfiguration("/mediators/fileSystemLocalEntryXsltTransformationTestConfig.xml");
    }

    public void testFileSystemLocalEntryXsltTransformation() throws AxisFault {
        StockQuoteSampleClient client = getStockQuoteClient();
        OMElement response = client.sendCustomQuoteRequest("http://localhost:8280/services/xsltInFileSystemTestProxy",
                null, null, "IBM");
        assertNotNull("Response is null", response);
        assertTrue("Invalid response received", response.toString().contains("Code"));
        assertTrue("Invalid response received", response.toString().contains("IBM"));
    }
}
