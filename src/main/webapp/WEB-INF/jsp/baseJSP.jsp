<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
//	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String basePath = path + "/";
%>
<c:set var="basePath" value="/"/>
<c:set var="bg_imgUpload" value="${basePath}images/bg_upLoadImg.png"/><!--上传默认背景图片-->
<c:set var="bg_imgUploadIng" value="${basePath}images/bg_upLoadImgIng.gif"/><!--上传中背景图片-->
<c:set var="bg_imgUploadErr" value="${basePath}images/bg_upLoadImgErr.png"/><!--上传出错背景图片-->
