<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">



                <json:property name="id" value="${manager.id}"></json:property>



                <json:property name="roleId" value="${manager.roleId}"></json:property>


                <json:property name="name" value="${manager.name}"></json:property>
                <%--<json:property name="phone" value="${manager.phone}"></json:property>--%>












                <%--<json:property name="nick" value="${manager.nick}"></json:property>--%>





                <%--<json:property name="pwd" value="${manager.pwd}"></json:property>--%>





                <%--<json:property name="region" value="${manager.region}"></json:property>--%>





                <%--<json:property name="company" value="${manager.company}"></json:property>--%>





                <%--<json:property name="type" value="${manager.type}"></json:property>--%>






           
	   
                    			
               
                    <%--<json:property name="status" value="${manager.status}"></json:property>--%>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${manager.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${manager.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${manager.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${manager.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


