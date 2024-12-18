package sharedData;

import helpers.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SharedData {

    public LoggerUtility loggerUtility = new LoggerUtility();
    public String testClassName;

    @BeforeMethod
    public void prepareEnvironment() {
        testClassName=this.getClass().getSimpleName();
        setUpDriver();
        loggerUtility.startTest(testClassName);
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result) {
        if(!result.isSuccess())
        {
            loggerUtility.errorLog(result.getThrowable().getMessage());
        }
        quitDriver();
        loggerUtility.finishTest(testClassName);
    }

}