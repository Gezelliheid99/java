<%--
  Created by IntelliJ IDEA.
  User: 98334
  Date: 2021/8/11
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNum > 1}">
        <a href="${requestScope.page.url}&pageNum=1">首页</a>
        <a href="${requestScope.page.url}&pageNum=${requestScope.page.pageNum-1}">上一页</a>
    </c:if>

    <%--页码输出开始--%>
    <c:choose>
        <%-- 情况1：如果总页码小于5页，页码范围是1-总页码 --%>
        <c:when test="${requestScope.page.pageNumTotal <= 5}">
            <c:set var="begin" value="${1}"></c:set>
            <c:set var="end" value="${requestScope.page.pageNumTotal}"></c:set>
        </c:when>
        <%-- 情况2：如果总页码大于5页，页码范围是1-总页码 --%>
        <c:when test="${requestScope.page.pageNumTotal > 5 }">
            <c:choose>
                <%--小情况1：当前页码为前三个的情况 总页码为1-5 --%>
                <c:when test="${requestScope.page.pageNum <= 3 }">
                    <c:set var="begin" value="${1}"></c:set>
                    <c:set var="end" value="${5}"></c:set>

                </c:when>
                <%--小情况2：页数为最后三个 页码范围为 总页码-4 - 总页码 --%>
                <c:when test="${requestScope.page.pageNum > requestScope.page.pageNumTotal -3 }">
                    <c:set var="begin" value="${requestScope.page.pageNumTotal-4 }"></c:set>
                    <c:set var="end" value="${requestScope.page.pageNumTotal}"></c:set>
                </c:when>
                <%--小情况3：中间的页数--%>
                <c:otherwise >
                    <c:set var="begin" value="${requestScope.page.pageNum -2 }"></c:set>
                    <c:set var="end" value="${requestScope.page.pageNum + 2 }"></c:set>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNum}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pageNum}">
            <a href="${requestScope.page.url}&pageNum=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%--页码输出结束--%>





    <c:if test="${requestScope.page.pageNum < requestScope.page.pageNumTotal}">
        <a href="${requestScope.page.url}&pageNum=${requestScope.page.pageNum+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNum=${requestScope.page.pageNumTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageNumTotal}页，${requestScope.page.pageCountTotal}条记录
    到第<input value="${param.pageNum}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">

    <script type="text/javascript">
        $(function(){

            $("#searchPageBtn").click(function (){
                var pageNum = $("#pn_input").val();
                if (pageNum < 1 || pageNum > ${requestScope.page.pageNumTotal}){
                    alert("输入页面超出范围，请重新输入！")
                }else {
                    location.href = "${pageScope.basePath}${requestScope.page.url}&pageNum="+pageNum;
                }

            })
        })
    </script>

</div>
