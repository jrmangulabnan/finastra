package org.finastra.exam.integration.amq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class AmqSender {
	
	@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(final String message) {
        Map<String, Object> map = new HashMap<String, Object>(); 
        map.put("totalInterbankSettlementAmount", message);
		jmsTemplate.convertAndSend(message);
	}

}
