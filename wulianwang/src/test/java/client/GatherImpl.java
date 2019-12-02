package client;


import com.briup.environment.client.Gather;
import org.junit.Test;



public class GatherImpl {
    @Test
    public void gather() throws Exception {
        Gather gather = new com.briup.environment.client.impl.GatherImpl();
        gather.gather();
    }
}
