let activeID, // 当前选中 tab 的 id
    $datasheet, // 数据表 jQuery对象
    $pageButtonGroup, // 分页按钮组
    currentPageNo = 1; // 当前页码

/**
 * 页面初始化
 */
$(() => {
    // 获取初始数据
    activeID = $('.active').attr('id');
    $datasheet = $('#datasheet');
    $pageButtonGroup = $('#pageButtonGroup');

    // 设置页面初始数据
    setCurrentUsername();
    initDatasheet();
    generatePageButtonGroup('../../admin.user.do', 'getStudentCount', 'getStudentListByPage', fillStudentSheet);

    // 事件绑定

    // 页面淡入效果
    $('#mainContainer').fadeIn('slow');
});

function initDatasheet() {
    $.post({
        url: '../../admin.user.do',
        data: {
            behavior: 'getStudentListByPage',
            pageNo: 1,
            pageSize: 5,
        },
        success: json => {
            let wrapper = JSON.parse(json);
            let lsit = JSON.parse(wrapper.data);
            if (wrapper.result) {
                fillStudentSheet(lsit);
            } else {
                Swal.fire({
                    icon: 'error',
                    title: '获取数据表失败'
                });
            }
        }
    });
}

/**
 * 表内填充学生数据
 * 
 * @param {User[]} datalist 学生数据表
 */
function fillStudentSheet(datalist) {
    $datasheet.empty(); // 清空现存数据
    let $ul = $('<ul></ul>'); // 重新设置无序列表

    // 表头
    let head =
        '<li class="datasheetHead">' +
        '<div class="col-md-2">学号</div>' +
        '<div class="col-md-2">姓名</div>' +
        '<div class="col-md-2">性别</div>' +
        '<div class="col-md-2">年龄</div>' +
        '<div class="col-md-2">班级</div>' +
        '<div class="col-md-1">操作</div>' +
        '<br>' +
        '</li>';
    $ul.append(head);

    // '添加'行
    let addRow =
        '<li class="datasheetRow">' +
        '<form id="addForm">' +
        '<input type="hidden" name="behavior" value="addStudent">' +
        '<input type="hidden" name="type" value="student">' +
        '<div class="col-md-2"><input id="username" name="username" type="text" size="10" placeholder="学号"></div>' +
        '<div class="col-md-2"><input id="name" name="name" type="text" size="10" placeholder="姓名"></div>' +
        '<div class="col-md-2">' +
        '<select id="sex" name="sex" style="width: 50px;">' +
        '<option value="男">男</option>' +
        '<option value="女">女</option>' +
        '</select>' +
        '</div>' +
        '<div class="col-md-2"><input id="age" name="age" type="text" size="10" placeholder="年龄"></div>' +
        '<div class="col-md-2">' +
        '<select name="class" id="class" style="width: 50px;">' +
        '<option value="1-A">1-A</option>' +
        '<option value="1-B">1-B</option>' +
        '<option value="1-C">1-C</option>' +
        '</select>' +
        '</div>' +
        '</form>' +
        '<div class="col-md-1">' +
        '<button id="addButton" type="button" class="operate btn btn-success">添加</button>' +
        '</div>' +
        '<br>' +
        '</li>';
    $ul.append(addRow);

    // 数据行
    console.log(datalist);
    for (let i = 0; i < datalist.length; i++) {
        let data = datalist[i];
        let row =
            '<li class="datasheetRow">' +
            '<div class="col-md-2">' + data.username + '</div>' +
            '<div class="col-md-2">' + data.name + '</div>' +
            '<div class="col-md-2">' + data.sex + '</div>' +
            '<div class="col-md-2">' + data.age + '</div>' +
            '<div class="col-md-2">' + data.class_id + '</div>' +
            '<div class="col-md-1">' +
            '<button type="button" class="operate btn btn-danger">删除</button>' +
            '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }

    $datasheet.append($ul);
}