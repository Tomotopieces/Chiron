/**
 * 管理员界面配置js
 */

let $datasheet; // 数据表

/**
 * 初始化
 */
$(() => {
    // 数据初始化
    $datasheet = $('#datasheet');

    // 设置页面初始数据
    setCurrentUsername();
    generateByActiveId($('.active').attr('id'));
    generatePageButtonGroup('../../admin.user.do', 'getStudentCount', 'getStudentListByPage', fillStudentSheet);

    // 页面淡入效果
    $('#mainContainer').fadeIn('slow');
});

/**
 * 通过当前 tab id 来生成数据表和按钮组
 * 
 * @param {string} activeId 当前选中的 tab id
 */
function generateByActiveId(activeId) {
    switch (activeId) {
        case 'studentTab':
            generateDatasheet('../../admin.user.do', 'getStudentListByPage', fillStudentSheet);
            generatePageButtonGroup('../../admin.user.do', 'getStudentCount', 'getStudentListByPage', fillStudentSheet);
            return;
        case 'teacherTab':
            generateDatasheet('../../admin.user.do', 'getTeacherListByPage', fillTeacherSheet);
            generatePageButtonGroup('../../admin.user.do', 'getTeacherCount', 'getTeacherListByPage', fillTeacherSheet);
        case 'classTab':
            generateDatasheet('../../admin.class.do', 'getClassCount', fillClassSheet);
            generatePageButtonGroup('../../admin.class.do', 'getClassCount', 'getClassListByPage', fillClassSheet);
        case 'noticeTab':
        case 'messageTab':
    }
}

/**
 * 绑定 '添加' 按钮 事件
 */
function bindAddButtonEvent() {
    $('#addButton').on('click', () => {
        $.ajax({
            url: 'admin.user.do',
            data: $(addForm).serialize(),
            success: json => {
                let wrapper = JSON.parse(json);
                // let data = JSON.parse(wrapper.data);
                if (wrapper.result) {
                    Swal.fire({
                        icon: 'success',
                        title: '添加成功',
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            }
        });
    });
}

function bindDeleteButtonEvent() {
    $('.deleteButton').on('click', event => {
        $this = $(event.target);
        console.log($this.parent());
    })
}

/**
 * 表内填充学生数据
 * 
 * @param {User[]} dataList 学生数据表
 */
function fillStudentSheet(dataList) {
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
        '<input type="hidden" name="behavior" value="addStudent">' + // behavior
        '<input type="hidden" name="type" value="student">' + // type
        '<div class="col-md-2"><input id="username" name="username" type="text" size="10" placeholder="学号"></div>' + // username
        '<div class="col-md-2"><input id="name" name="name" type="text" size="10" placeholder="姓名"></div>' + // name
        '<div class="col-md-2">' +
        '<select id="sex" name="sex" style="width: 50px;">' + // sex
        '<option value="男">男</option>' +
        '<option value="女">女</option>' +
        '</select>' +
        '</div>' +
        '<div class="col-md-2"><input id="age" name="age" type="text" size="10" placeholder="年龄"></div>' + // age
        '<div class="col-md-2">' +
        '<select name="class" id="class" style="width: 50px;">' + // class
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
    bindAddButtonEvent();

    // 数据行
    for (let i = 0; i < dataList.length; i++) {
        let data = dataList[i];

        let row =
            '<li class="datasheetRow">' +
            '<div class="userId" style="display: none;">' + data.id + '</div>' +
            '<div class="col-md-2">' + data.username + '</div>' +
            '<div class="col-md-2">' + data.name + '</div>' +
            '<div class="col-md-2">' + data.sex + '</div>' +
            '<div class="col-md-2">' + data.age + '</div>' +
            '<div class="className col-md-2">' + data.class_id + '</div>' +
            '<div class="col-md-1">' +
            '<button type="button" class="deleteButton operate btn btn-danger">删除</button>' +
            '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }
    
    $datasheet.append($ul);
    classIdToName(); // 将班级id替换为班级名
}

/**
 * 表内填充教师数据
 * 
 * @param {User[]} dataList 教师数据表
 */
function fillTeacherSheet(dataList) {
    $datasheet.empty(); // 清空现存数据
    let $ul = $('<ul></ul>'); // 重新设置无序列表

    // 表头
    let head =
        '<li class="datasheetHead">' +
        '<div class="col-md-2">教职工号</div>' +
        '<div class="col-md-3">姓名</div>' +
        '<div class="col-md-2">性别</div>' +
        '<div class="col-md-2">年龄</div>' +
        '<div class="col-md-2">操作</div>' +
        '<br>' +
        '</li>';
    $ul.append(head);

    // '添加'行
    let addRow =
        '<li class="datasheetRow">' +
        '<form id="addForm">' +
        '<input type="hidden" name="behavior" value="addStudent">' + // behavior
        '<input type="hidden" name="type" value="teacher">' + // type
        '<div class="col-md-2"><input id="username" name="username" type="text" size="10" placeholder="教职工号"></div>' + // username
        '<div class="col-md-3"><input id="name" name="name" type="text" size="10" placeholder="姓名"></div>' + // name
        '<div class="col-md-2">' +
        '<select id="sex" name="sex" style="width: 50px;">' + // sex
        '<option value="男">男</option>' +
        '<option value="女">女</option>' +
        '</select>' +
        '</div>' +
        '<div class="col-md-2"><input id="age" name="age" type="text" size="10" placeholder="年龄"></div>' + // age
        '</form>' +
        '<div class="col-md-2">' +
        '<button id="addButton" type="button" class="operate btn btn-success">添加</button>' +
        '</div>' +
        '<br>' +
        '</li>';
    $ul.append(addRow);
    bindAddButtonEvent();

    // 数据行
    for (let i = 0; i < dataList.length; i++) {
        let data = dataList[i];
        let row =
            '<li class="datasheetRow">' +
            '<div class="userId" style="display: none;">' + data.id + '</div>' +
            '<div class="col-md-2">' + data.username + '</div>' +
            '<div class="col-md-3">' + data.name + '</div>' +
            '<div class="col-md-2">' + data.sex + '</div>' +
            '<div class="col-md-2">' + data.age + '</div>' +
            '<div class="col-md-2">' +
            '<button type="button" class="operate btn btn-danger">删除</button>' +
            '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }

    $datasheet.append($ul);
}

/**
 * 表内填充教师数据
 * 
 * @param {User[]} dataList 教师数据表
 */
function fillClassSheet(dataList) {
    $datasheet.empty(); // 清空现存数据
    let $ul = $('<ul></ul>'); // 重新设置无序列表

    // 表头
    let head =
        '<li class="datasheetHead">' +
        '<div class="col-md-3">班级编号</div>' +
        '<div class="col-md-6">班级名称</div>' +
        '<div class="col-md-3">操作</div>' +
        '<br>' +
        '</li>';
    $ul.append(head);

    // '添加'行
    let addRow =
        '<li class="datasheetRow">' +
        '<form id="addForm">' +
        '<input type="hidden" name="behavior" value="addStudent">' + // behavior
        '<div class="col-md-3"><input id="classNo" name="classNo" type="text" size="10" placeholder="班级编号"></div>' + // classNo
        '<div class="col-md-6"><input id="className" name="className" type="text" size="10" placeholder="班级名称"></div>' + // classId
        '</form>' +
        '<div class="col-md-3">' +
        '<button id="addButton" type="button" class="operate btn btn-success">添加</button>' +
        '</div>' +
        '<br>' +
        '</li>';
    $ul.append(addRow);
    bindAddButtonEvent();

    // 数据行
    for (let i = 0; i < dataList.length; i++) {
        let data = dataList[i];
        let row =
            '<li class="datasheetRow">' +
            '<div class="classId" style="display: none;">' + data.id + '</div>' +
            '<div class="col-md-3">' + data.classNo + '</div>' +
            '<div class="col-md-6">' + data.className + '</div>' +
            '<div class="col-md-3">' +
            '<button type="button" class="operate btn btn-danger">删除</button>' +
            '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }

    $datasheet.append($ul);
}