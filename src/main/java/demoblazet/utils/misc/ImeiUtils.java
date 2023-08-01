package demoblazet.utils.misc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class ImeiUtils {

    private static final Logger logger = LogManager.getLogger(ImeiUtils.class);


    private static void generateCheckDigit(String imei) {

        logger.info("IMEI check digit generator");

        if (imei.length() != 14) {

            logger.info("IMEI Length not 14 ,Please provide 14 digit IMEI");
        } else {

            int generatedCheckDigit = getCheckDigit(imei);

            logger.info("Check Digit " + generatedCheckDigit);

            logger.info("Complete IMEI number is " + imei + generatedCheckDigit);

        }
    }

    private static int getCheckDigit(String input) {

        int sum = 0;

        for (int counter = 13; counter >= 0; counter--) {
            String digitString = input.substring(counter, counter + 1);

            int digit = Integer.valueOf(digitString);

            if (counter % 2 == 0) {
                sum += digit;
            } else {
                sum += sumUpDigits(digit);
            }
        }

        sum *= 9;

        return sum % 10;
    }

    private static int sumUpDigits(int digit) {

        int sum = 0;
        digit *= 2;
        while (digit > 0) {

            sum += digit % 10;
            digit /= 10;
        }

        return sum;

    }

    public static String generateImei(String tac) {

        Random myRandom = new Random();
        StringBuilder imeiNumber = new StringBuilder(14);
        imeiNumber.append(tac);
        for (int counter = 0; counter < 6; counter++) {
            imeiNumber.append(1 + myRandom.nextInt(8));
        }
        int generatedCheckDigit = getCheckDigit(imeiNumber.toString());
        imeiNumber = imeiNumber.append(generatedCheckDigit);

        return imeiNumber.toString();
    }

    public static String generateRandomNumber(int size) {
        Random myRandom = new Random();
        StringBuilder randomNumber = new StringBuilder(size);
        for (int counter = 0; counter < size; counter++) {
            randomNumber.append(1 + myRandom.nextInt(8));
        }
        logger.info("Random Number::" + randomNumber.toString());
        return randomNumber.toString();
    }
}