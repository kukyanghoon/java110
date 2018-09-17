package bitcamp.java110.cms.server;

import java.util.HashMap;
import java.util.Map;

public class Request {
    String command;
    String appPath;
    String queryString;
    Map<String, String> paramMap = new HashMap<>();
    
    
    public Request(String command)
    {
        this.command=command;
        
        //명령어에서 QueryString을 분리한다.
        String[] values= command.split("\\?");
        this.appPath=values[0]; //ex)manager/detail
        //ex) manager/add?name=aaa&email=aaa@test.com&password=1111
        
        if(values.length>=2)
        {
            //ex) manager/detail?no=10   
            //?표로 인해서 manager/detail(0번배열) 과 no=10(1번배열)로 나눠져서 
            //values의 길이가 2개로 나눠진다면 즉, 물음표가 존재한다면
            queryString = values[1];//ex)no=10
            parseQueryString(queryString);
        }
    }


    private void parseQueryString(String qs) {
        String[] values = qs.split("&");
        for(String value : values)
        {
            String[] kv = value.split("=");
            paramMap.put(kv[0], kv[1]);
        }
    }
    
    public String getParameter(String name)
    {
        return this.paramMap.get(name);
    }


    public String getAppPath() {
        return this.appPath;
    }


    public String getCommand() {
        return this.command;
    }


    public String getQueryString() {
        return this.queryString;
    }
    
 
    
}
