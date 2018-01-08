<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, bannerimg-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>图片列表</title>
    <!--引入ueditor多图上传配置-->
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/editor/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/editor/ueditor/ueditor.all.js"></script>
    <style>
        ul{display: inline-block;width: 100%;margin: 0;padding: 0;}
        li{list-style-type: none;margin: 5px;padding: 0;}
    </style>
</head>

<body>
<div class="layui-container">
    <!--
        作者：yuton.yao@qq.com
        时间：2017-09-01
        描述：引入公共html
    -->
    <jsp:include page="inc.jsp"></jsp:include>
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <div class="x-nav layui-elem-quote">
						<span class="layui-breadcrumb">
             <a><cite><i class="layui-icon" style="line-height:25px">&#xe68e  </i>首页</cite></a>
              <a><cite>图片列表</cite></a>
            </span>
                <a class="layui-btn layui-btn-mini" style="line-height:1.0em;margin-top:1px;float:right"
                   href="${pageContext.request.contextPath}/admin/bannerimg/index" title="刷新">
                    <i class="layui-icon" style="line-height:25px">&#x1002</i></a>
            </div>
        </div>
        <button class="layui-btn layui-btn-normal" id="j_upload_img_btn" style="margin-right: 10px;float: right">多图上传</button>
        <%--<ul id="upload_img_wrap"></ul>--%>
        <textarea id="uploadEditor" style="display: none;"></textarea>
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <table class="layui-table"
                   lay-data="{height: 'full-110',even: true,url:'${pageContext.request.contextPath}/admin/bannerimg/list',limits:[10,30,50,100], limit: 10,page:true,id:'id'}"
                   lay-filter="bannerimg">
                <thead>
                <tr>
                    <!--<th lay-data="{checkbox:true, fixed: true}"></th>-->
                    <th lay-data="{field:'id',align:'center', width:60, sort: true}">ID</th>
                    <th lay-data="{field:'name', align:'center',width:200, sort: true}">名称</th>
                    <th lay-data="{field:'loadpath',align:'center', width:300, sort: true}">加载路径</th>
                    <th lay-data="{field:'createTime', align:'center',width:150, sort: true}">创建时间</th>
                    <th lay-data="{field:'xuhao', align:'center',width:80, sort: true}">排序</th>
                    <th lay-data="{width:200, align:'center', toolbar: '#toolBar'}">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<!--模板-->
<script type="text/html" id="loadpathTpl">
    <%--{{d.loadpath}}--%>http://layer.layui.com/images/tong.jpg
    <%--<div id="tong" hidden><img src="http://layer.layui.com/images/tong.jpg"></div>--%>
</script>
<div id="img" hidden style="height: auto;width: auto"><img src=""></div>
<script type="text/html" id="toolBar">
    <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="showImg">查看图片</a>
    <%--<a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="update">修改</a>--%>
    <a class="layui-btn layui-btn-warm layui-btn-mini" lay-event="delete">删除</a>
</script>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-3.1.0.min.js"></script>
<script>
    layui.use(['table', 'element', 'jquery'], function () {
        var table = layui.table,
            element = layui.element,
            $ = layui.jquery;

        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
        //监听工具条
        table.on('tool(bannerimg)', function (obj) {
            if (obj.event === 'showImg') {
                var url = obj.data.loadpath;
                alert(url)
                $("#img").find('img').attr("src", url);
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: 0,
                    area: '516px',
                    skin: 'layui-layer-nobg', //没有背景色
                    shadeClose: true,
                    content: $("#img")
                });
            }

            //此处需要完善
            if (obj.event === 'delete') {
                var id = obj.data.id;
                layer.confirm('您确定要删除该图片吗？', {
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    layer.closeAll();
                    $.post("${pageContext.request.contextPath}/admin/bannerimg/deleteById", {id: id}, function (data) {
                        if ("success" == data) {
                            //如果修改成功,则刷新页面
                            window.location.reload(); //刷新当前页面
                            layer.msg('删除成功!', {icon: 1});
                        }
                    }).error(function () {
                        layer.msg('删除失败!', {icon: 5});
                    });
                });
            }
        });

    });

    // 实例化编辑器，这里注意配置项隐藏编辑器并禁用默认的基础功能。
    var uploadEditor = UE.getEditor("uploadEditor", {
        isShow: false,
        focus: false,
        enableAutoSave: false,
        autoSyncData: false,
        autoFloatEnabled:false,
        wordCount: false,
        sourceEditor: null,
        scaleEnabled:true,
        toolbars: [["insertimage", "attachment"]]
    });

    // 监听多图上传和上传附件组件的插入动作
    uploadEditor.ready(function () {
        uploadEditor.addListener("beforeInsertImage", _beforeInsertImage);
        //uploadEditor.addListener("afterUpfile",_afterUpfile);
    });

    // 自定义按钮绑定触发多图上传和上传附件对话框事件
    document.getElementById('j_upload_img_btn').onclick = function () {
        var dialog = uploadEditor.getDialog("insertimage");
        dialog.title = '多图上传';
        dialog.render();
        dialog.open();
    };
    // 多图上传动作
    function _beforeInsertImage(t, result) {
        for(var i in result){
            var loadpath=result[i].src;
            var name=result[i].alt;
            //上传完成后写入数据库
            $.post("${pageContext.request.contextPath}/admin/bannerimg/insert", {loadpath: loadpath,name:name}, function (data) {
                if ("success" == data) {
                    //如果修改成功,则刷新页面
                    window.location.reload(); //刷新当前页面
                    layer.msg('上传成功!', {icon: 1});
                }
            })
        }
    }
</script>
</body>

</html>