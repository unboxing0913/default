package org.zerock.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration(classes={org.zerock.config.RootConfig.class,
							   org.zerock.config.SecurityConfig.class})
public class PasswordEncoderTests {
	
	@Setter(onMethod_= {@Autowired})
	private PasswordEncoder pwEncoder;
	
	@Test
	public void testEncode() {
		String str = "member";
		String enStr = pwEncoder.encode(str);
	
		//패스워드 인코딩 결과는 매번 조금씩 달라질수있습니다.
		//$2a$10$svl7r6K09vpGI3l7FZIOoed55S6lIGT0zjLAE0Gh9LYpxnsNIDxaO
		log.info(enStr);
	}

}
