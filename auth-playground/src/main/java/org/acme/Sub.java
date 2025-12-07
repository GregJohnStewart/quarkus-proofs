package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;


/**
 * Example JPA entity defined as a Panache Entity. An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 * <p>
 * This uses the active record pattern, you can also use the repository pattern instead: .
 * <p>
 * Usage (more example on the documentation)
 * <p>
 * {@code public void doSomething() { MyEntity entity1 = new MyEntity(); entity1.field = "field-1"; entity1.persist();
 * <p>
 * List<MyEntity> entities = MyEntity.listAll(); } }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sub {
	
	@NonNull
	@NotNull
	@Id
	private UUID id;
	
	@NotNull
	@NonNull
	private String secret;
}
