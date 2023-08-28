package utils;

import pages.EmailYourEstimateModalForm;

public class SendCalculation {
    public static void sendCalculation(EmailYourEstimateModalForm modalForm, String email) {
        modalForm.enterEmailAddress(email);
        modalForm.clickSendEmailButton();
    }
}
