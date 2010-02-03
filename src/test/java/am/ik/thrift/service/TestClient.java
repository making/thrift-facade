package am.ik.thrift.service;

import junit.framework.TestCase;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;

public class TestClient extends TestCase {
    public void test() throws Exception {
        TSocket transport = new TSocket("localhost", 8944);
        TProtocol protocol = new TBinaryProtocol(transport);
        ServiceFacade.Client client = new ServiceFacade.Client(protocol);
        try {
            transport.open();
            InputDto input = new InputDto();
            input.setId("XXX001");
            OutputDto output = client.execute(input);
            assertNotNull(output);
            assertEquals("OK:XXX001", output.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        } finally {
            if (transport != null) {
                transport.close();
            }
        }

    }
}
