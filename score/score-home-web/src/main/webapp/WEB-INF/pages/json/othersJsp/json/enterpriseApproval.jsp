<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="page" value="${page}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="size" value="${size}"></json:property>
    <json:property name="total" value="${total}"></json:property>
    <json:array name="data">
        <c:forEach items="${mapList}" var="enterpriseApproval">

            <json:object>


                <json:property name="id" value="${enterpriseApproval.id}"></json:property>

                <json:property name="name" value="${enterpriseApproval.name}"></json:property>

                <json:property name="img" value="${enterpriseApproval.img}"></json:property>

                <json:property name="title" value="${enterpriseApproval.title}"></json:property>

                <json:property name="scoreType" value="${enterpriseApproval.scoreType}"></json:property>

                <json:property name="updateAt" value="${enterpriseApproval.updateAt}"></json:property>

                <json:property name="score" value="${enterpriseApproval.score}"></json:property>

                <json:property name="status" value="${enterpriseApproval.status}"></json:property>


            </json:object>
            <%--<json:property name="applyId" value="${enterpriseApproval.applyId}"></json:property>--%>


            <%--<json:property name="content" value="${enterpriseApproval.content}"></json:property>--%>


            <%--<json:property name="picture" value="${enterpriseApproval.picture}"></json:property>--%>


            <%--<json:property name="approvalId" value="${enterpriseApproval.approvalId}"></json:property>--%>




            <%--<json:object>--%>
            <%--<json:property name="id" value="${enterpriseApproval.id}"></json:property>--%>


            <%--<json:property name="title" value="${enterpriseApproval.title}"></json:property>--%>


            <%--<json:property name="applyId" value="${enterpriseApproval.applyId}"></json:property>--%>


            <%--<json:property name="scoreType" value="${enterpriseApproval.scoreType}"></json:property>--%>


            <%--<json:property name="score" value="${enterpriseApproval.score}"></json:property>--%>


            <%--<json:property name="status" value="${enterpriseApproval.status}"></json:property>--%>


            <%--<json:property name="content" value="${enterpriseApproval.content}"></json:property>--%>


            <%--<json:property name="picture" value="${enterpriseApproval.picture}"></json:property>--%>


            <%--<json:property name="approvalId" value="${enterpriseApproval.approvalId}"></json:property>--%>


            <%--<json:property name="createAt" value="${enterpriseApproval.createAt}"></json:property>--%>


            <%--<json:property name="updateAt" value="${enterpriseApproval.updateAt}"></json:property>--%>


            <%--<json:property name="createBy" value="${enterpriseApproval.createBy}"></json:property>--%>


            <%--<json:property name="updateBy" value="${enterpriseApproval.updateBy}"></json:property>--%>


            <%--</json:object>--%>
        </c:forEach>
    </json:array>
    <%--<json:array name="">--%>
        <%--<json:array name="">--%>
            <%--<c:forEach items="${entryList}" var="entry">--%>
                <%--<c:forEach items="${entry}" var="staff">--%>
                    <%--<json:object>--%>
                        <%--<json:property name="id" value="${entry.get(1).id}"></json:property>--%>
                        <%--<json:property name="title" value="${entry.get(1).title}"></json:property>--%>
                        <%--<json:property name="applyId" value="${entry.get(1).applyId}"></json:property>--%>
                        <%--<json:property name="scoreType" value="${entry.get(1).scoreType}"></json:property>--%>
                        <%--<json:property name="score" value="${entry.get(1).score}"></json:property>--%>
                        <%--<json:property name="status" value="${entry.get(1).status}"></json:property>--%>
                        <%--<json:property name="content" value="${entry.get(1).content}"></json:property>--%>
                        <%--<json:property name="picture" value="${entry.get(1).picture}"></json:property>--%>
                        <%--<json:property name="approvalId" value="${entry.get(1).approvalId}"></json:property>--%>
                        <%--<json:property name="createAt" value="${entry.get(1).createAt}"></json:property>--%>
                        <%--<json:property name="updateAt" value="${entry.get(1).updateAt}"></json:property>--%>
                        <%--<json:property name="createBy" value="${entry.get(1).createBy}"></json:property>--%>
                        <%--<json:property name="updateBy" value="${entry.get(1).updateBy}"></json:property>--%>
                        <%--<json:property name="taskId" value="${entry.get(1).taskId}"></json:property>--%>
                    <%--</json:object>--%>

                    <%--<json:object>--%>
                        <%--<json:property name="id" value="${entry.get(0).id}"></json:property>--%>
                        <%--<json:property name="name" value="${entry.get(0).name}"></json:property>--%>
                        <%--<json:property name="img" value="${entry.get(0).img}"></json:property>--%>
                        <%--<json:property name="phone" value="${entry.get(0).phone}"></json:property>--%>
                        <%--<json:property name="pwd" value="${entry.get(0).pwd}"></json:property>--%>
                        <%--<json:property name="departmentId" value="${entry.get(0).departmentId}"></json:property>--%>
                        <%--<json:property name="departmentName" value="${entry.get(0).departmentName}"></json:property>--%>
                        <%--<json:property name="positionId" value="${entry.get(0).positionId}"></json:property>--%>
                        <%--<json:property name="iniScore" value="${entry.get(0).iniScore}"></json:property>--%>
                        <%--<json:property name="degreeScore" value="${entry.get(0).degreeScore}"></json:property>--%>
                        <%--<json:property name="honorScore" value="${entry.get(0).honorScore}"></json:property>--%>
                        <%--<json:property name="jopScore" value="${entry.get(0).jopScore}"></json:property>--%>
                        <%--<json:property name="specialityScore" value="${entry.get(0).specialityScore}"></json:property>--%>
                        <%--<json:property name="commendScore" value="${entry.get(0).commendScore}"></json:property>--%>
                        <%--<json:property name="baseScore" value="${entry.get(0).baseScore}"></json:property>--%>
                        <%--<json:property name="addScore" value="${entry.get(0).addScore}"></json:property>--%>
                        <%--<json:property name="subScore" value="${entry.get(0).subScore}"></json:property>--%>
                        <%--<json:property name="scoreSituation" value="${entry.get(0).scoreSituation}"></json:property>--%>
                        <%--<json:property name="totalScore" value="${entry.get(0).totalScore}"></json:property>--%>
                        <%--<json:property name="seniority" value="${entry.get(0).seniority}"></json:property>--%>
                        <%--<json:property name="star" value="${entry.get(0).star}"></json:property>--%>
                        <%--<json:property name="incumbency" value="${entry.get(0).incumbency}"></json:property>--%>
                        <%--<json:property name="sunScore" value="${entry.get(0).sunScore}"></json:property>--%>
                        <%--<json:property name="loveScore" value="${entry.get(0).loveScore}"></json:property>--%>
                        <%--<json:property name="approvalLogNum" value="${entry.get(0).approvalLogNum}"></json:property>--%>
                        <%--<json:property name="waitApprovalNum" value="${entry.get(0).waitApprovalNum}"></json:property>--%>
                        <%--<json:property name="myApprovalNum" value="${entry.get(0).myApprovalNum}"></json:property>--%>
                        <%--<json:property name="myCopyNum" value="${entry.get(0).myCopyNum}"></json:property>--%>
                        <%--<json:property name="ranking" value="${entry.get(0).ranking}"></json:property>--%>
                        <%--<json:property name="joinRank" value="${entry.get(0).joinRank}"></json:property>--%>
                        <%--<json:property name="entryAt" value="${entry.get(0).entryAt}"></json:property>--%>
                        <%--<json:property name="role" value="${entry.get(0).role}"></json:property>--%>
                        <%--<json:property name="createAt" value="${entry.get(0).createAt}"></json:property>--%>
                        <%--<json:property name="updateAt" value="${entry.get(0).updateAt}"></json:property>--%>
                        <%--<json:property name="createBy" value="${entry.get(0).createBy}"></json:property>--%>
                        <%--<json:property name="updateBy" value="${entry.get(0).updateBy}"></json:property>--%>
                        <%--<json:property name="positionName" value="${entry.get(0).positionName}"></json:property>--%>

                    <%--</json:object>--%>
                <%--</c:forEach>--%>
            <%--</c:forEach>--%>
        <%--</json:array>--%>
    <%--</json:array>--%>
</json:object>


