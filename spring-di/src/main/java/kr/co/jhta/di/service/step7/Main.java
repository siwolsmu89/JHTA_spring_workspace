package kr.co.jhta.di.service.step7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String conf = "kr/co/jhta/di/service/step7/context-step7.xml";
		
		ApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		EventNotificationServiceImpl eventNotificationServiceImpl = ctx.getBean("eventNotificationService", EventNotificationServiceImpl.class);
		
		eventNotificationServiceImpl.noticeEvent("장마시즌 주말에는 코딩을 해라", "주말 무료 코딩 교육 개강!");

	}

}
