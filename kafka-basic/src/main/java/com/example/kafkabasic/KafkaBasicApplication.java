package com.example.kafkabasic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.schema.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBinding(Processor.class)
public class KafkaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBasicApplication.class, args);
	}


	@Value("${spring.cloud.stream.kafka.binder.producer-properties.schema.registry.url}")
	private String endPoint;

	@Bean
	public SchemaRegistryClient schemaRegistryClient() {
		ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
		client.setEndpoint(endPoint);
		return client;
	}
}
