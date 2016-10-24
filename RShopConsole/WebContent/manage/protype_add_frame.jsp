<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- adding node start -->
<script type="text/javascript" >

</script>

<div id="addNodeFrame" >
	<form>
    	<table style="text-align: left">
        	<tr>
            	<td>节点名称</td>
                <td style="text-align: left">
                	<input type="text" id="protype_name" />
                </td>
            </tr>
            <tr>
            	<td>节点code</td>
            	<td style="text-align: left">
            		<input type="text" id="protype_code" />
            	</td>
            </tr>
            <tr>
	            <td>父节点</td>
                <td style="text-align: left">
					<select id="add_protype_parent_protype" onchange="onProtypeSelectorSelect('add_protype_parent_protype')">
						<s:iterator value="base_protypes">
							<option value="protype_option_<s:property value='code' />"><s:property value="name"/></option>
						</s:iterator>
					</select>
					
                </td>
            </tr>
            <tr>
            	<td style="vertical-align: top">描述</td>
            	<td>
					<textarea rows="6" cols="60" id="protype_desc"></textarea>
				</td>
            </tr>
            <tr>
            	<td><input type="button" value="添加" onClick="tryAddProType()" /></td>
            </tr>
    	</table>
	</form>
</div>
<!-- adding node end -->