package am.ik.thrift.facade;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import am.ik.thrift.service.ServiceFacade;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("サービス開始");
        try {
            TServerSocket serverTransport = new TServerSocket(8944);
            TProcessor processor = new ServiceFacade.Processor(
                    new ServiceFacadeImpl());
            Factory protocolFactory = new TBinaryProtocol.Factory();
            TServer server = new TThreadPoolServer(processor, serverTransport,
                    protocolFactory);
            logger.info("サービス起動");
            server.serve();
        } catch (Exception e) {
            logger.error("例外発生", e);
        }
        logger.info("サービス終了");
    }
}
