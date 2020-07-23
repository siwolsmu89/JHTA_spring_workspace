package kr.co.jhta.di.service;

public class KakaoTalkMessageSender implements MessageSender {
	
	private String username;
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	// 카톡으로 문자를 보내기 위한 연결
	// 연결/해제용 메소드는 반환값이나 매개변수가 없어야 한다.
	public void connect() {
		System.out.println(username + ", " + password + " 접속정보로 카카오톡 대용량 서비스에 연결됨...");
	}
	
	public void disconnect() {
		System.out.println(username + " 접속을 해제함...");
	}
	
	@Override
	public void send(String from, String to, String subject, String content) {
		System.out.println("카톡메세지를 보냄");
		System.out.println("카톡 발신자 : " + from);
		System.out.println("카톡 수신자 : " + to);
		System.out.println("카톡 제목 : " + subject);
		System.out.println("카톡 내용 : " + content);
		System.out.println("-------------------------------");
	}
}
