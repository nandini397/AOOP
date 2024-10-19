public class Main {
    public static void main(String[] args) {
        MessageService emailService = new EmailService();
        MessageService smsService = new SMSService();

        MyApplication app1 = new MyApplication(emailService);
        MyApplication app2 = new MyApplication(smsService);

        app1.processMessage("Hello via Email!");
        app2.processMessage("Hello via SMS!");
    }
}
