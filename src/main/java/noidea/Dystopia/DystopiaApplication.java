package noidea.Dystopia;

import noidea.Dystopia.db_reader.DbReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DystopiaApplication {

	public static void main(String[] args) {

		SpringApplication.run(DystopiaApplication.class, args);

		DbReader dbReader = new DbReader();
		dbReader.getMSG();


	}

}
