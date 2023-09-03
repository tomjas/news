package pl.mobilet.news;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class NewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}

	@Component
	public static class BaselineOnMigrateMigrationStrategy implements FlywayMigrationStrategy {

		@Override
		public void migrate(Flyway flyway) {
			flyway.migrate();
		}
	}

}
