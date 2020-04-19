<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>场所页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">

    <link rel="stylesheet" href="${basePath}elementUI/theme-chalk/index.css">
    <script src="${basePath}js/vue.min.js"></script>
</head>
<body>
<div id="app">
    <!-- ----------------------code start------------------------ -->
    <div class="h_breadcrumb">
        <el-breadcrumb separator="/">
            <el-breadcrumb-item >首页</el-breadcrumb-item>
            <el-breadcrumb-item>首页轮播图</a></el-breadcrumb-item>
            <el-breadcrumb-item>轮播图管理</el-breadcrumb-item>
        </el-breadcrumb>
    </div>

    <div class="h_main">
        <div class="h_main_code" v-loading="pageLoading">
            <el-alert title="Tips" type="info" description="可对首页轮播图进行新增、修改及查看" show-icon></el-alert>
            <!-- 搜索条件 start -->
            <el-row :gutter="5" class="hMarginTop_20px" >
                <el-col :span="24">
                    <el-button icon="el-icon-plus" size="small" type="primary" @click="insertBanner('')">新增轮播图</el-button>
                </el-col>
            </el-row>
            <!-- 搜索条件 end -->

            <!-- 数据列表start -->
            <el-row :gutter="5"  class="hMarginTop_15px">
                <el-table :data="tableData" border size="small" style="width: 100%">
                    <el-table-column prop="bannerId" label="轮播图编号" width="200"></el-table-column>
                    <el-table-column prop="bannerName" label="轮播图名称" width="200"></el-table-column>
                    <el-table-column prop="bannerUrl" label="轮播图地址" width="350"></el-table-column>
                    <el-table-column prop="bannerJumpUrl" label="跳转地址" width="350"></el-table-column>
                    <el-table-column prop="createTime" label="创建时间"  :formatter="dateFormat" width="230"></el-table-column>
                    <el-table-column fixed="right" label="操作" >
                        <template slot-scope="scope">
                            <el-link type="primary"  size="small" icon="el-icon-iconName" @click="editBanner(scope.row.bannerId)" style="padding-right:10px;">编辑</el-link>
                            <el-link size="small" type="success" @click="delInfo(scope.row.bannerId)" style="padding-right:5px;">删除</el-link>
                        </template>
                    </el-table-column>
                </el-table>
            </el-row>
            <!-- 数据列表end -->

        </div>
    </div>

    <!-- ----------------------code end-------------------------- -->
</div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            pageLoading:true,//页面loading
            sel_linkName:"",
            tableData:${data_list}
        },
        mounted: function () {
            var self = this;
            setTimeout(function(){self.pageLoading = false;},500);
        },
        methods:{
            insertBanner:function(row){
                layer.open({
                    type: 2,
                    title: '新增轮播图',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['1000px', '460px'],
                    content:'${basePath}manage/banner/banner_info'
                });
            },
            editBanner:function(bannerId){
                layer.open({
                    type: 2,
                    title: '编辑轮播图',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['1000px', '460px'],
                    content:"${basePath}manage/banner/banner_info?bannerId="+bannerId
                });
            },
            //时间格式化
            dateFormat: function(row){
                var t=new Date(row.createTime);//row 表示一行数据, updateTime 表示要格式化的字段名称
                return t.getFullYear()+"-"+(t.getMonth()+1)+"-"+t.getDate()+" "+t.getHours()+":"+t.getMinutes()+":"+t.getSeconds();
            },
            delInfo:function (bannerId) {
                var self = this;
                this.$confirm('请确认是否删除该链接?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                var url = "${basePath}manage/banner/del_banner?bannerId="+bannerId;
                $.get(url, function (result) {
                    if (result.code == '200') {
                        self.$message({message: '删除成功',type: 'success'});
                        window.setTimeout(function () {
                            window.location.reload();
                        }, 1500);
                    } else {
                        self.$message.error('删除失败，请稍后再试');
                    }
                });
            });
            },

        }
    });
</script>
</html>