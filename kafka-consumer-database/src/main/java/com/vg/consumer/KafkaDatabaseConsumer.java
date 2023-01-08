package com.vg.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.vg.consumer.entity.WikimediaData;

@Service
public class KafkaDatabaseConsumer {
	
	private static final Logger logger  = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	@Autowired
	private WikimediaDataRepository wikimediaRepository ;
	
	public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaRepository) {
		this.wikimediaRepository = wikimediaRepository;
	}

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage){

        logger.info(String.format("Event message received -> %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        
        wikimediaData.setWikiEventData(eventMessage);

        wikimediaRepository.save(wikimediaData);
    }
}
