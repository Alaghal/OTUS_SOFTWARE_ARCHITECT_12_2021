package otus.seryakov.myapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.management.ManagementFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		ManagementFactory.getRuntimeMXBean().getInputArguments().forEach(log::info);
		System.getProperties().stringPropertyNames().forEach(v -> log.info("SYS: {} = {}", v, System.getProperty(v)));
		System.getenv().entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (ov, nv) -> ov, LinkedHashMap::new))
				.forEach((k, v) -> log.info("ENV: {} = {}", k, v));

		SpringApplication.run(MyappApplication.class, args);
	}

}
