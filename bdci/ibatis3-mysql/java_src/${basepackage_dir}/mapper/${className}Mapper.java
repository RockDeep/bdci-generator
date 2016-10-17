<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.mapper;

<#include "/java_imports.include">

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.whtr.bdci.base.mapper.BaseMapper;

import ${basepackage}.entity.${className};


@Repository
public interface ${className}Mapper  extends BaseMapper<${className}>{
	
	public ${className} getByPk(
		<#list table.pkColumns as pkColumn>
			@Param("${pkColumn.columnNameFirstLower}")${pkColumn.javaType} ${pkColumn.columnNameFirstLower}<#if pkColumn_has_next>,</#if><#if !pkColumn_has_next>);</#if>
		</#list>

}
