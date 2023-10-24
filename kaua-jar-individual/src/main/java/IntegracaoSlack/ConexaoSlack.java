package IntegracaoSlack;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

public class ConexaoSlack {
    private static String webHookUrl = "https://hooks.slack.com/services/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";
    private static String oAthuToken = "https://hooks.slack.com/services/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";
    private static String calnalSlack = "canal-alertas";

    public static void enviarMensagem(String mensagem) {
        try {
            StringBuilder msgbuilder = new StringBuilder();
            msgbuilder.append(mensagem);

            Payload payload = Payload.builder().channel(calnalSlack).text(msgbuilder.toString()).build();

            WebhookResponse webhookResponse = Slack.getInstance().send(webHookUrl, payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}