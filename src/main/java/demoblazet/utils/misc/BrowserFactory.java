package demoblazet.utils.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static demoblazet.utils.misc.PropertyUtils.getProperty;

public class BrowserFactory {

    private static BrowserFactory browserIni;
    private final List<String> availableBrowsers;
    private static HashMap<String,String> brList;

    private BrowserFactory(){
        if(Boolean.valueOf(getProperty("cross.browser"))){
            availableBrowsers=new ArrayList<>(Arrays.asList(getProperty("browser.list").trim().split(",")));
        }else {
            availableBrowsers=new ArrayList<>(Arrays.asList(getProperty("browser.type").trim()));
        }
    }
    public synchronized static BrowserFactory getInstance(){
        if(browserIni==null){
            browserIni=new BrowserFactory();
        }return browserIni;
    }

    public synchronized String getBrowserName()throws IndexOutOfBoundsException{
        if(Boolean.valueOf(getProperty("cross.browser"))){
            System.out.println(" BrowserName while return " +availableBrowsers.remove(0));
            return availableBrowsers.remove(0);
        }else {
            return availableBrowsers.get(0);
        }
    }

    public synchronized String setBr(String threadId,String browserName){
        if(brList==null){
            brList=new HashMap<>();
            brList.put(threadId,browserName);
        }else {
            brList.put(threadId,browserName);
        }
        return browserName;
    }

    public synchronized HashMap<String,String> getBrList(){
        return brList;
    }

    public synchronized String getBr(String threadName){
        return brList.get(threadName);
    }

}
