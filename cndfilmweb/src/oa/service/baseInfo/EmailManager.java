package oa.service.baseInfo;

public interface EmailManager {
	
	//发送邮件
	void sendEmail(String userName, String userEmail, String message);
}
