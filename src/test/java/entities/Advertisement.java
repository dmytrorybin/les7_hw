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
   // public String photoFilePath = new File(PropertyLoader.loadProperty("project.path") + "src/test/resources/IMG_8101.JPG").getAbsolutePath();
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


//            title = "My first advert";
//            price = "100";
//            desc = "this is description for my first advert. It must be at least 50 characters long.";
//            name = "Jacky Jackson";
//            email = "email@mail.com";
//            phone = "+380119876543";
//            icq = "3535345345345";
//            skype = "324324234324";
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

//            title = "aaa";
//            price = "1";
//            desc = "less then 50 characters.";
//            name = "a";
//            email = "abc";
//            phone = "sdasd";
//            icq = "ads";
//            skype = "qwe";
        }
    }




//    public String setCorrectTitle() {
//        // return title = RandomStringUtils.randomAlphabetic(6);
//        return title = "My first advert";
//    }
//
//    public String setCorrectPrice(){
//        return price = "100";
//    }
//
//    public String setCorrectDescr(){
//        return desc = "this is description for my first advert. It must be at least 50 characters long.";
//    }
//
//    public String setCorrectUser(){
//        return name = "Jacky Jackson";
//    }
//
//    public String setCorrectEmail(){
//        return email = "email@mail.com";
//    }
//
//    public String setCorrectPhone(){
//        return phone = "+380119876543";
//    }
//
//    public String setCorrectICQ(){
//        return icq = "3535345345345";
//    }
//
//    public String setCorrectSkype(){
//        return skype = "324324234324";
//    }


//    public Advertisement(Boolean correct) {
//        if (correct) {
//            //...
//        } else {
//            title = "123";
//            email = "asd";
//        }
//    }
}
