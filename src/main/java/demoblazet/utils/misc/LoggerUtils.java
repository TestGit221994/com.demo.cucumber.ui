package demoblazet.utils.misc;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtils {

    private static Logger logger;
    public LoggerUtils(){
        try{
            this.logger=Logger.getLogger("Demo");
            PropertyConfigurator.configure(System.getProperty("user.dir")+"/log4j.properties");
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public static Logger getLogger(){
        Logger Temp=null;
        try{
            if(logger==null){
                LoggerUtils loggerUtil=new LoggerUtils();
                Temp=logger;
            }else{
                Temp=logger;
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }return Temp;
    }









}
