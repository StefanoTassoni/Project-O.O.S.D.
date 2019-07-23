package db.dao.dto;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;


import com.google.common.base.CaseFormat;

import controller.utils.StringUtils;

public abstract class BaseDTO {
	/**
	 * Trasforma l'oggetto corrente in una mappa, in cui la chiave è formatatta in snake-case 
	 * rispetto il nome della variabili di istanza dell'oggetto.
	 * @return
	 */
	public Map<String, Object> toMap() {
		Map<String, Object> hashSnakelize = new HashMap<String, Object>();
		Map<Object, Object> beanMap = new BeanMap(this);
		for(Object key: beanMap.keySet()) {
			Object value =  beanMap.get(key);
			//System.out.println("toMap key: " + key);
			//System.out.println("toMap value: " + value);
			if (value != null && !key.equals("class")) {
				hashSnakelize.put(StringUtils.snakelize(CaseFormat.LOWER_CAMEL, key.toString()), beanMap.get(key));
			}
		}
		return hashSnakelize;
	}
	
	/**
	 *
	 * Valorizza l'oggetto corrente tramite mappa, in cui il nome della variabile di istanza
	 * è formatata in camel-case rispetto la chiave della mappa
	 * @return
	 *
	 * @param map
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public void fillFromMap(Map<String, Object> map) throws ReflectiveOperationException{
		Map<String, Object> mapCamelize = new HashMap<String, Object>();
		for(Object key: map.keySet()) {
			Object value =  map.get(key);
			//System.out.println("fillFromMap key: " + key);
			//System.out.println("fillFromMap value: " + value);
			if (value != null) {
				mapCamelize.put(StringUtils.camelize(CaseFormat.UPPER_UNDERSCORE, key.toString()), map.get(key));
			}
		}
		BeanUtils.populate(this, mapCamelize);
	}
	
}
