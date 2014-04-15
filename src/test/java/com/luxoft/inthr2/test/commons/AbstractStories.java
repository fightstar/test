package com.luxoft.inthr2.test.commons;

import com.codeborne.selenide.junit.ScreenShooter;
import com.luxoft.inthr2.pages.EnvironmentConfiguration;
import com.luxoft.inthr2.utilities.db.DB;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.Rule;

import java.util.List;

import static org.jbehave.core.reporters.Format.*;

public abstract class AbstractStories extends JUnitStories {
    private Configuration configuration;
    private EnvironmentConfiguration config;
    protected Logger l = Logger.getLogger(AbstractStories.class);
    private  String application_url  = "http://localhost/IntHR2.Web/#";

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    protected EnvironmentConfiguration getEnvironmentConfiguration(){
        if(config == null){
            config = new EnvironmentConfiguration(application_url);
        }

        return config;
    }

    @BeforeStory
    public void beforeMethod() {

        //System.setProperty("jsse.enableSNIExtension", "false");
        l.info(application_url);
        l.info("new configuration init");
        //restoreDataBase();
        //setAdministratorUserRole();
    }

    @AfterStory
    public void afterMethod() {
        config.Dispose();
        l.info("Disposed");

        config = null;
        l.info("Configuration is null");
        //dropDataBase();

    }

    @Override
    public Configuration configuration() {
        if (configuration == null) {
            return new MostUsefulConfiguration()
                    .usePendingStepStrategy(new FailingUponPendingStep())
                    .useStoryLoader(new LoadFromClasspath(this.getClass()))
                    .useStoryReporterBuilder(
                            new StoryReporterBuilder()
                                    .withDefaultFormats()
                                    .withFormats(CONSOLE, TXT, HTML, XML));
        }
        return configuration;
    }

    public AbstractStories() {
        configuredEmbedder().embedderControls()
                .useStoryTimeoutInSecs(6000)
                .doIgnoreFailureInStories(false)
                .doIgnoreFailureInView(true);


    }

    protected List<String> storyPaths() {
        return null;
    }

    public void restoreDataBase() {
        l.info("Restoring Data Base...");
        DB db = new DB("jdbc:jtds:sqlserver://localhost:1433;", "sa", "!QAZ2wsx");

        db.executeUpdateQuery("IF OBJECT_ID('IntHR2.dbo.Employee') IS NULL\n" +
                "begin\n" +
                "CREATE DATABASE [IntHR2]\n" +
                "end\n" +
                "Use master\n" +
                "RESTORE DATABASE [IntHR2] FROM DISK = 'C:\\\\RestoreDatabase\\IntHR2.bak' WITH REPLACE");
        db.executeUpdateQuery("IF OBJECT_ID('IntHR2Audit.dbo.ClientAudit') IS NULL\n" +
                "begin\n" +
                "CREATE DATABASE [IntHR2Audit]\n" +
                "end\n" +
                "RESTORE DATABASE [IntHR2Audit] FROM DISK = 'C:\\\\RestoreDatabase\\IntHR2Audit.bak' WITH REPLACE");
        db.executeUpdateQuery("IF OBJECT_ID('Authorization.dbo.Permission') IS NULL\n" +
                "begin\n" +
                "CREATE DATABASE [Authorization]\n" +
                "end\n" +
                "RESTORE DATABASE [Authorization] FROM DISK = 'C:\\\\RestoreDatabase\\Authorization.bak' WITH REPLACE");
        db.executeUpdateQuery("IF OBJECT_ID('AuthorizationAudit.dbo.PermissionAudit') IS NULL\n" +
                "begin\n" +
                "CREATE DATABASE [AuthorizationAudit]\n" +
                "end\n" +
                "RESTORE DATABASE [AuthorizationAudit] FROM DISK = 'C:\\\\RestoreDatabase\\AuthorizationAudit.bak' WITH REPLACE");
        db.executeUpdateQuery("IF OBJECT_ID('UtilitiesLibrary.dbo.Entity') IS NULL\n" +
                "begin\n" +
                "CREATE DATABASE [UtilitiesLibrary]\n" +
                "end\n" +
                "RESTORE DATABASE [UtilitiesLibrary] FROM DISK = 'C:\\\\RestoreDatabase\\UtilitiesLibrary.bak' WITH REPLACE");
        db.executeUpdateQuery("IF OBJECT_ID('Workflow.dbo.Activity') IS NULL\n" +
                "begin\n" +
                "CREATE DATABASE [Workflow]\n" +
                "end\n" +
                "RESTORE DATABASE [Workflow] FROM DISK = 'C:\\\\RestoreDatabase\\Workflow.bak' WITH REPLACE");
        db.closeDBConnection();
        l.info("Data base was restored successfully!");
    }

    public void dropDataBase() {
        DB db = new DB("jdbc:jtds:sqlserver://localhost:1433;", "sa", "!QAZ2wsx");
        l.info("Dropping Data base...");
        db.executeUpdateQuery("USE master;\n" +
                "  ALTER DATABASE [IntHR2]\n" +
                "  SET SINGLE_USER WITH ROLLBACK IMMEDIATE \n" +
                "  DROP DATABASE [IntHR2];");
        db.executeUpdateQuery("USE master;\n" +
                "  ALTER DATABASE [IntHR2Audit]\n" +
                "  SET SINGLE_USER WITH ROLLBACK IMMEDIATE \n" +
                "  DROP DATABASE [IntHR2Audit];");
        db.executeUpdateQuery("USE master;\n" +
                "  ALTER DATABASE [Authorization]\n" +
                "  SET SINGLE_USER WITH ROLLBACK IMMEDIATE \n" +
                "  DROP DATABASE [Authorization];");
        db.executeUpdateQuery("USE master;\n" +
                "  ALTER DATABASE [AuthorizationAudit]\n" +
                "  SET SINGLE_USER WITH ROLLBACK IMMEDIATE \n" +
                "  DROP DATABASE [AuthorizationAudit];");
        db.executeUpdateQuery("USE master;\n" +
                "  ALTER DATABASE [UtilitiesLibrary]\n" +
                "  SET SINGLE_USER WITH ROLLBACK IMMEDIATE \n" +
                "  DROP DATABASE [UtilitiesLibrary];");
        db.executeUpdateQuery("USE master;\n" +
                "  ALTER DATABASE [Workflow]\n" +
                "  SET SINGLE_USER WITH ROLLBACK IMMEDIATE \n" +
                "  DROP DATABASE [Workflow];");
        db.closeDBConnection();
        l.info("Data base was dropped successfully!");

    }

    public void setAdministratorUserRole() {
        DB db = new DB("jdbc:jtds:sqlserver://localhost:1433;", "sa", "!QAZ2wsx");
        l.info("login as Administrator");
        db.executeUpdateQuery("insert into [Authorization].dbo.Permission(principalId, isDelegatedFrom, isDelegatedTo, roleId, periodstartDate, status, id, active)\n" +
                "       values((select id from [Authorization].dbo.Principal where name = 'kiev\\VShevchenko' and active = 1), 0, 0,\n" +
                "              (select id from [Authorization].dbo.BusinessRole where name = 'Administrator' and active = 1),\n" +
                "              '01/01/2001', 2, NEWID(), 1)");
        db.closeDBConnection();
    }
}

