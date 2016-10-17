# -*- coding: utf-8 -*-
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 

import json


class ${className}:

    def __init__(self, <#list table.compositeIdColumns as column>${column.sqlName}, </#list>
			<#list table.notPkColumns as column>
                ${column.sqlName}=None<#if column_has_next>,</#if>
			</#list>
                ):
	<#list table.compositeIdColumns as column>
        self.${column.sqlName} = ${column.sqlName}
	</#list>
	<#list table.notPkColumns as column>
        self.${column.sqlName} = ${column.sqlName}
	</#list>

    def get_java_dict(self):
        d = {
		<#list table.compositeIdColumns as column>
            '${column.columnNameLower}' : self.${column.sqlName},
		</#list>
		<#list table.notPkColumns as column>
            '${column.columnNameLower}' : self.${column.sqlName},
		</#list>
        }
        return d
    
    def get_json(self):
        return json.dumps(self.get_java_dict())
    
    def get_java_type(self):
        return '${basepackage}.entity.${className}'