package otus.seryakov.myapp.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class TimedConfiguration {
   @Bean
   public TimedAspect timedAspect(MeterRegistry registry) {
      registry.config().commonTags("app", "myapp");
      return new TimedAspect(registry);
   }
}