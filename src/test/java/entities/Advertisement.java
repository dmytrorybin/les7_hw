package entities;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

/**
 * Created by c246T on 02.03.2015.
 */
public class Advertisement {
    public String title = "";
    public String price = "";
    public String desc = "";
    public String photoFilePath = new File(System.getProperty("user.dir") + "/src/test/resources/IMG_8101.JPG").getAbsolutePath();
    public String name = "";
    public String email = "";
    public String phone = "";
    public String icq = "";
    public String skype = "";

    public Advertisement() { }

    public Advertisement(boolean correct) {
        if (correct) {
            title  = RandomStringUtils.randomAlphabetic(5).toLowerCase();
            price = RandomStringUtils.randomNumeric(3);
            desc = RandomStringUtils.randomAlphabetic(51).toLowerCase();
            name = RandomStringUtils.randomAlphabetic(5).toLowerCase();
            email = RandomStringUtils.randomAlphabetic(3).toLowerCase() + "@" + RandomStringUtils.randomAlphabetic(3).toLowerCase() + ".com";
            phone = "+" + RandomStringUtils.randomNumeric(12);
            icq = RandomStringUtils.randomNumeric(9);
            skype = RandomStringUtils.randomNumeric(9);
        }
        else
        {
            title  = RandomStringUtils.randomAlphabetic(2);
            price = "-1";
            desc = RandomStringUtils.randomAlphabetic(1);
            name = RandomStringUtils.randomAlphabetic(1);
            email = RandomStringUtils.randomAlphabetic(5);
            phone = RandomStringUtils.randomAlphabetic(12);
            icq = RandomStringUtils.randomAlphabetic(12);
            skype = RandomStringUtils.randomAlphabetic(12);
        }
    }
}
