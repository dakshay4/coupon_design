INSERT INTO sms_template(message,type) values 
("Dear {first_name}, Thank you for registering. Our Representative will contact you shortly", "AGENT_REG_SMS");
INSERT INTO sms_provider(auth_key,provider_name,route,sender_id,status,url) values
(
	"337348ALzk2DHFZU5f2215f7P1",
	"msg91",
	"4",
	"DAKSXY",
	"ACTIVE",
	"https://api.msg91.com/api/sendhttp.php"
);