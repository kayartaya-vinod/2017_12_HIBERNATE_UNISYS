package hibernate.training.utils;

import java.io.Serializable;
import java.util.Arrays;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class LoggingInterceptor extends EmptyInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

		System.out.println("New entity saved: " + entity + ", with id " + id);

		return super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {

		System.out.printf("Entity %s#%s changed from %s to %s\n", entity.getClass().getSimpleName(), id,
				Arrays.toString(previousState), Arrays.toString(currentState));

		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
	}
}