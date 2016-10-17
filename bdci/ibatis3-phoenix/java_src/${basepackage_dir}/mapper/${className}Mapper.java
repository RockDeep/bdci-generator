<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.mapper;

<#include "/java_imports.include">

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.whtr.bdci.gw.etl.frame.mapper.BaseMapper;

import ${basepackage}.entity.${className};


@Repository
public interface ${className}Mapper  extends BaseMapper<${className}>{
	
	public ${className} getByPk(
		<#list table.pkColumns as pkColumn>
			@Param("${pkColumn.columnNameFirstLower}")${pkColumn.javaType} ${pkColumn.columnNameFirstLower}<#if pkColumn_has_next>,</#if><#if !pkColumn_has_next>);</#if>
		</#list>

	public List<${className}> getByRange(@Param("start") long start, @Param("length") long length);
}
