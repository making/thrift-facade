package am.ik.thrift.facade;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import am.ik.thrift.service.InputDto;
import am.ik.thrift.service.OutputDto;
import am.ik.thrift.service.ServiceFacade;

public class ServiceFacadeImpl implements ServiceFacade.Iface {
    private static final Logger logger = LoggerFactory
            .getLogger(ServiceFacadeImpl.class);

    @Override
    public OutputDto execute(InputDto input) throws TException {
        logger.info(String.format("入力:%s", input));
        OutputDto output = new OutputDto();
        output.setMessage("OK:" + input.getId());
        logger.info(String.format("出力:%s", output));
        return output;
    }

}
