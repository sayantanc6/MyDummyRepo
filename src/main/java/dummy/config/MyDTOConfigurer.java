package dummy.config;


import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;

import dummy.entity.EmployeeEntity;
import dummy.model.EmployeeModel;

public class MyDTOConfigurer extends BeanMappingBuilder {
	
	@Autowired
	DozerBeanMapper mapper;

	@Override
	protected void configure() {
		mapping(EmployeeEntity.class, EmployeeModel.class, TypeMappingOptions.wildcard(false));
	}

}
