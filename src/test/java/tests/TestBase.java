package tests;

import manager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class TestBase {


   protected static AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m){
        logger.info("Start method -->"+m.getName() );
        logger.info( "==================================================================");
    }
    @AfterMethod(alwaysRun = true)
    public void endLogger(Method m){
        logger.info("End of method -->"+m.getName());
    }


    @BeforeSuite(alwaysRun = true)
    public void init() {
       app.start();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
       app.stop();
    }


    }



