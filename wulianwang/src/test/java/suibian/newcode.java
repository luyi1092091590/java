package suibian;

import com.briup.environment.bean.Environment;
import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.server.Server;
import com.briup.environment.util.Backup;
import com.briup.environment.util.WossModuleInit;
import com.briup.environment.util.impl.ConfigurationImpl;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class newcode {
    ConfigurationImpl conf = new ConfigurationImpl();

    @Test
    public void server() throws Exception {
        Server server = conf.getServer();
        server.receiver();
    }

    @Test
    public void client() throws Exception{
        Client client = conf.getClient();
        Gather gather = conf.getGather();
        Collection<Environment> coll = gather.gather();
        client.send(coll);
    }

    //模拟多个客户端
    @Test
    public void newClient() throws Exception{
        ConfigurationImpl newConf = new ConfigurationImpl();
        Client c = newConf.getClient();
        Gather g = newConf.getGather();
        Collection<Environment> collection = g.gather();
        c.send(collection);
    }

    @Test
    public void confMap() {
        Map<String, WossModuleInit> map = conf.getMap();
        System.out.println(map);
    }

    @Test
    public void backup() throws Exception{
        Backup backup = conf.getBackup();
        backup.backup("abc.txt","abc");
    }
}
