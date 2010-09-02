package org.mule.endpoints;

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.tck.FunctionalTestCase;

/**
 *
 */
public class DynamicEndpointConfigTestCase extends FunctionalTestCase
{

    @Override
    protected String getConfigResources()
    {
        return "dynamic-endpoint-config.xml";
    }

    public void testName() throws Exception
    {

        MuleMessage msg = new DefaultMuleMessage("Data", muleContext);
        msg.setOutboundProperty("testProp", "testPath");
        final MuleMessage response = muleContext.getClient().send("vm://in", msg);
        assertNotNull(response);
        assertNull(response.getExceptionPayload());
        assertEquals("Data Received", response.getPayload());
    }
}
