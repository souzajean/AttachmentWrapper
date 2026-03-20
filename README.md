# 📎 AttachmentWrapper
## 🚀 SAP BTP Integration Suite (CPI) – Trabalhando com AttachmentWrapper

📌 Visão Geral

Este projeto demonstra, na prática, como construir um iFlow no SAP BTP Integration Suite utilizando conceitos avançados de integração.

O cenário implementado realiza a conversão de valores em USD para BRL, combinando dados de entrada com uma API externa de câmbio em tempo real.

<br>

![Fluxo](imagens/capa-linkedin.png)

---

📸 Caso de Uso Real

Esse tipo de cenário é comum em integrações corporativas onde:

É necessário enriquecer dados com informações externas

Processar dados em paralelo para otimizar performance

Consolidar múltiplas fontes em um único payload

---


# :building_construction: Arquitetura do iFlow

### :one: O fluxo foi desenvolvido no SAP Cloud Integration (CPI) seguindo as etapas abaixo.
<br><br>
### Criando Manage Security
![Fluxo](imagens/Screenshot_1.png)
<br><br><br>

### Criando o User Credentials
![Fluxo](imagens/Screenshot_2.png)

<br><br>

### Criando o User Credenials
![Fluxo](imagens/Screenshot_3.png)
```
GmailUser
```

<br><br>

### Criando o Integration Flow
![Fluxo](imagens/Screenshot_4.png)


<br><br>
:gear: Etapas da Integração

<br>

### :two:  Editar o Iflow

### Criando o Pacote
![Fluxo](imagens/Screenshot_5.png)
```
AttachementWrapperDEMO
```
<br>

### Criar nosso Integration Flow
![Fluxo](imagens/Screenshot_6.png)

<br>

### Criar nosso Repositorio do Integration Flow
![Fluxo](imagens/Screenshot_7.png)

<br>

### :three:  HTTPS Sender
### Adicionando o HTTPS
![Fluxo](imagens/Screenshot_8.png)

<br>


### Configurando o HTTPS
O fluxo é iniciado através de um endpoint HTTPS, permitindo que aplicações externas consultem o serviço.
![Fluxo](imagens/Screenshot_9.png)
```
Address: /attachment-demor
```
<br>

### :four:  JSON to XML Converter

<br>

### Adicionando o Groovy Script
![Fluxo](imagens/Screenshot_10.png)

<br>

### Renomeando o Groovy Script
![Fluxo](imagens/Screenshot_11.png)
```
AttachmentWrapper
```

<br>

### Criando nosso arquivo Groovy Script

![Fluxo](imagens/Screenshot_12.png)

<br>

### Adicionadno nosso script do Groovy Script
![Fluxo](imagens/Screenshot_13.png)
```
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
```
<br>

### Adicionando Mail
![Fluxo](imagens/Screenshot_14.png)

<br>

### Configurando o Mail Connection
![Fluxo](imagens/Screenshot_15.png)
```
Address: smtp.gmail.com
Credential Name: GmailUser
```
<br>

### Configurando o Mail Processing
![Fluxo](imagens/Screenshot_16.png)
```
Subject: SAP CPI Attachment
Mail Body:
<html>
  <body style="font-family: Arial;">
    <h2 style="color:#0a6ed1;">SAP CPI - Notificação</h2>
    <p>O arquivo foi gerado com sucesso.</p>
    <p><b>Verifique o anexo.</b></p>
  </body>
</html>

Body Mime Type: Text/HTML

Add Message Attachements: marcar
```

<br>

### Email Recebido com o anexo
![Fluxo](imagens/Screenshot_17.png)

<br>

### Anexo gerado pelo Groovy Script
![Fluxo](imagens/Screenshot_18.png)






<br>
<br>

---

## 📦 Exemplo prático – iFlow para baixar

📦 [Download do iFlow – Converter-USDxBRL](https://github.com/souzajean/Converter-USDxBRL/raw/main/Package/ConvertendoDollarparaReal.zip)



> O arquivo pode ser importado diretamente no SAP Integration Suite (CPI).

