package com.javers.history.tryer;

import java.util.List;
import java.util.UUID;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.commit.Commit;
import org.javers.core.diff.Change;
import org.javers.repository.jql.QueryBuilder;

import com.javers.history.tryer.connection.JaversConnection;
import com.javers.history.tryer.entity.Person;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		JaversConnection javersConnection = new JaversConnection();
		Javers javers = JaversBuilder.javers().registerJaversRepository(javersConnection.createJaversSqlRepository())
				.build();
		

		String id = UUID.randomUUID().toString();
		Person person1 = new Person(id, "person1");
		Commit commit = javers.commit("batuhan", person1);
		System.out.println(commit.getAuthor());
		List<Change> changes = javers.findChanges(QueryBuilder.byClass(Person.class)
                .withNewObjectChanges().build());

		changes.forEach(change -> System.out.println("- " + change));
	}
}
