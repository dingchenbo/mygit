<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${basePath}layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${basePath}layuiadmin/style/admin.css" media="all">

    <script src="${basePath}js/vue.min.js"></script>
    <title>首页</title>
    <style>
        .top_one_color {
            color: red
        }

        .top_two_color {
            color: gold
        }

        .top_three_color {
            color: limegreen
        }
    </style>
</head>
<body>
<div class="layui-fluid">
    <!-- ----------------------正文代码start---------------------- -->
    <div class="layui-row layui-col-space15">
        <!-- 顶部数据统计 start -->
        <div class="layui-col-sm6 layui-col-md3">
            <%--<div class="layui-card">
                <div class="layui-card-header">
                    营业额
                    <span class="layui-badge layui-bg-orange layuiadmin-badge">近一年</span>
                </div>
                <div class="layui-card-body layuiadmin-card-list">
                    <p class="layuiadmin-big-font" id="turnover">0</p>
                    <p>累计营业额 <span class="layuiadmin-span-color">0元 <i
                            class="layui-inline layui-icon layui-icon-dollar"></i></span></p>
                </div>
            </div>--%>
        </div>

        <!-- 顶部数据统计 end -->

        <!-- 折线图 start -->
        <!-- 折线图 end -->

    </div>
    <!-- ----------------------正文代码end---------------------- -->
</div>

<script src="${basePath}layuiadmin/layui/layui.js"></script>
<script src="${basePath}js/website/jquery-1.8.1.js"></script>
<script src="${basePath}js/echarts/echarts.common.min.js"></script>
<script src="${basePath}js/echarts/macarons.js"></script>
<script>
    layui.config({
        base: 'layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['jquery', 'index', 'form', 'upload'], function () {
        var $ = layui.jquery;
        var form = layui.form;//初始化form组件
        var upload = layui.upload;


    });

    function openServer() {
        layer.confirm('确定开启服务？', {offset: 't'}, function () {
            $.ajax({
                type: "get",
                url: '${basePath}aoto/manage/config/openEle',
                success: function (result) {
                    layer.msg("开启成功", {offset: 't'});
                    window.location.reload();
                }
            });
        });

    }

    function closeServer() {

        layer.confirm('确定关闭服务？', {offset: 't'}, function () {
            $.ajax({
                type: "get",
                url: '${basePath}aoto/manage/config/closeEle',
                success: function (result) {
                    layer.msg("关闭成功", {offset: 't'});
                    window.location.reload();
                }
            });
        });

    }

</script>
</body>
</html>