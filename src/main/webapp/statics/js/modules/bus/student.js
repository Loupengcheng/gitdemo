$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'bus/student/list',
        datatype: "json",
        colModel: [
            { label: '学生ID', name: 'id',width: 45, key: true },
            { label: '学生姓名', name: 'cname', width: 75 },
            { label: '性别', name: 'gender', width: 75,formatter: function(value, options, row){
                return value == "0" ? '男' : '女';
             }},
            { label: '年龄', name: 'age', width: 90 },
            { label: '学校', name: 'school', width: 100 },
            { label: '出生年月', name: 'birthday', width: 85}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});


var vm = new Vue({
    el:'#rrapp',
    data:{
        showList: true,
        title: null,
        student:{
            searchName:null
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add : function()
        {
            vm.showList = false;
            vm.title = "新增";
            vm.student={};
        },
        update: function()
        {
            var studentId = getSelectedRow();
            if(studentId == null){
                return ;
            }

            vm.showList = false;
            vm.title = "修改";

            vm.getStudent(studentId);

        },
        del : function()
        {
            var studentIds = getSelectedRows();
            if(studentIds == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "bus/student/delete",
                    contentType: "application/json",
                    data: JSON.stringify(studentIds),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getStudent : function(studentId)
        {
            $.get(baseURL + "bus/student/info/"+studentId, function(r){
                vm.student = r.student;
            });
        },
        saveOrUpdate : function()
        {
            var url = vm.student.id == null ? "bus/student/save" : "bus/student/update";
            $.ajax({
                type: "post",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.student),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'searchName': vm.student.searchName},
                page:page
            }).trigger("reloadGrid");
        }
    }
});
