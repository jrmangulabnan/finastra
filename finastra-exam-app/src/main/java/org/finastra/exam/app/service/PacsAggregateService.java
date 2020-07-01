package org.finastra.exam.app.service;

import java.util.Optional;

import org.finastra.exam.app.util.JaxbUnmarshaller;
import org.finastra.exam.integration.amq.AmqSender;
import org.finastra.exam.repository.PacsRepository;
import org.finastra.exam.repository.data.Pacs008;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 * This class will centralize all the service from integration and repository
 * project
 * 
 * @author jr mangulabnan
 *
 */
@Component
@Order(value = 1)
public class PacsAggregateService implements CommandLineRunner {

	@Autowired
	private PacsRepository pacsRepository;

	@Autowired
	private AmqSender amqSender;

	public void readFile(String file) {
		try {
			Pacs008 pacs008 = JaxbUnmarshaller.unmarshalPacs008(file);
			int[] result = pacsRepository.save(pacs008);
			
			if (result.length != 0) {
				amqSender.sendMessage(String.valueOf(pacsRepository.getTotalInterbankSettlementAmount()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run(String... args) throws Exception {
		if (Optional.of(args[0].toString()).isPresent()) {
			readFile(args[0].toString());
		} else {
			throw new Exception("Please add file location + filename");
		}
	}
}
