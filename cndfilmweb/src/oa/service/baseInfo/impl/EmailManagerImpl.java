package oa.service.baseInfo.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import oa.model.table.Base_info;
import oa.service.BaseManager;
import oa.service.baseInfo.EmailManager;

public class EmailManagerImpl extends BaseManager implements EmailManager{
	
	private MailSender mailSender;
	
	//发送邮件
	public void sendEmail(String userName, String userEmail, String message){
		
		String receiveEmail = "";
		
		List<Base_info> res = baseInfoDao.findAll(null);
		Iterator<Base_info> it = res.iterator();
		if(it.hasNext()){
			Base_info data = (Base_info)it.next();
			if(data.getEmail()!=null){
				receiveEmail = data.getEmail();
			}
		}
		
		SimpleMailMessage mailMessage = new SimpleMailMessage(); 
		mailMessage.setTo(receiveEmail);	//接受者邮箱
		mailMessage.setFrom("xycd@cndfilm.com");//发送者邮箱
		mailMessage.setSubject("用户联系信息");				//主题  
		mailMessage.setText("用户名称："+userName+"\n 用户邮箱："+userEmail+"\n 信息："+message+"\n");			//邮件内容  
		try{
			mailSender.send(mailMessage);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
}
