import com.sap.gateway.ip.core.customdev.util.Message;
import com.sap.gateway.ip.core.customdev.util.AttachmentWrapper;
import javax.mail.util.ByteArrayDataSource;

def Message processData(Message message) {

    // Body da mensagem
    String body = message.getBody(String.class);

    // Conteúdo do attachment
    def content = "Arquivo gerado via CPI usando AttachmentWrapper";

    // Criando DataSource
    def attachmentDataSource = new ByteArrayDataSource(content.getBytes(), "text/plain");

    // 🔥 Novo padrão (recomendado)
    def attachment = new AttachmentWrapper(attachmentDataSource);

    // Adicionando attachment
    message.addAttachmentObject("arquivo.txt", attachment);

    return message;
}