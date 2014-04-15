package com.luxoft.inthr2.test.commons;

import com.luxoft.inthr2.pages.EnvironmentConfiguration;

public abstract class AbstractSteps  {
    private EnvironmentConfiguration config;
    public static String configString = "D:\\MY_PROJESTS\\TA_JBehave\\trunk\\TA_JBehave\\src\\main\\java\\com\\luxoft\\inthr2\\file.xml";
    private AbstractSteps(){

    }


    protected AbstractSteps(EnvironmentConfiguration config){
          this.config = config;
    }

    protected EnvironmentConfiguration getConfig(){
        return config;
    }
}
