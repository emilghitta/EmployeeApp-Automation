package core;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestUtilities extends BaseTest {

    protected String uniqueIdentificator = alphaNumericValue(3);
    protected SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
    protected Date date = new Date();

    //Gives us the possibility to have soft asserts through our tests.
    protected SoftAssert softAssert = new SoftAssert();

    /*
        Method that helps us generate random alpha numeric values
     */
    protected static String alphaNumericValue(int count) {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int index = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(index));
        }
        return builder.toString();
    }

    /* Get screenshot utility method
     * It will eventually encode the outcome to Base64 in order to work with the Extent Report
     */
    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
        FileInputStream fileInputStream = null;
        String encodedBase64 = null;
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("src/test/java/resources/Reports/Screenshots/" + testCaseName + ".png");

        FileUtils.copyFile(srcFile,destination);

        try {
            fileInputStream =new FileInputStream(destination);
            byte[] bytes =new byte[(int)destination.length()];
            fileInputStream.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return "data:image/png;base64,"+encodedBase64;
    }
}