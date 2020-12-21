/**
 * 管理员界面配置js
 */
let $active; // 选中的tab id
let $datasheet; // 数据表
let $tab; // 侧边栏项

/**
 * 初始化
 */
$(() => {
    // 数据初始化
    $active = $('.active');
    $datasheet = $('#datasheet');
    $tab = $('.tab');

    // 设置页面初始数据
    setCurrentUsername();
    generateDatasheetByActiveId();

    // 事件绑定
    $tab.on('click', event => {
        let $this = $(event.target);
        $tab.removeClass('active');
        $this.addClass('active');

        generateDatasheetByActiveId();
    });

    // 页面淡入效果
    $('#mainContainer').fadeIn('slow');
});

/**
 * 通过当前 tab id 来生成数据表和按钮组
 */
function generateDatasheetByActiveId() {
    switch ($('.active').attr('id')) {
        case 'studentTab':
            generateDatasheet('../../admin.user.do', 'getStudentListByPage', fillStudentSheet);
            generatePageButtonGroup('../../admin.user.do', 'getStudentCount', 'getStudentListByPage', fillStudentSheet);
            return;
        case 'teacherTab':
            generateDatasheet('../../admin.user.do', 'getTeacherListByPage', fillTeacherSheet);
            generatePageButtonGroup('../../admin.user.do', 'getTeacherCount', 'getTeacherListByPage', fillTeacherSheet);
            return;
        case 'classTab':
            generateDatasheet('../../admin.class.do', 'getClassListByPage', fillClassSheet);
            generatePageButtonGroup('../../admin.class.do', 'getClassCount', 'getClassListByPage', fillClassSheet);
            return;
        case 'noticeTab':
            generateDatasheet('../../admin.notice.do', 'getNoticeListByPage', fillNoticeSheet);
            generatePageButtonGroup('../../admin.notice.do', 'getNoticeCount', 'getNoticeListByPage', fillNoticeSheet);
            return;
        case 'messageTab':
            generateDatasheet('../../admin.message.do', 'getMessageListByPage', fillMessageSheet);
            generatePageButtonGroup('../../admin.message.do', 'getMessageCount', 'getMessageListByPage', fillMessageSheet);
            return;
    }
}

/**
 * 绑定 '添加' 按钮 事件
 */
function bindAddButtonEvent(servlet) {
    $('#addButton').on('click', () => {
        $.ajax({
            url: servlet,
            data: $('#addForm').serialize(),
            success: json => {
                console.log(json);
                let wrapper = JSON.parse(json);
                let data = JSON.parse(wrapper.data);
                if (wrapper.result) {
                    Swal.fire({
                        icon: 'success',
                        title: '添加成功',
                        showConfirmButton: false,
                        timer: 1500
                    }).then(result => {
                        generateDatasheetByActiveId();
                    });
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: data,
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            }
        });
    });
}

/**
 * 绑定 '删除' 按钮 事件
 * 
 * @param {string} servlet Servlet
 * @param {string} behavior 动作
 */
function bindDeleteButtonEvent(servlet, behavior) {
    $('.deleteButton').on('click', event => {
        $this = $(event.target);
        let id = $($this.parent().parent().children()[0]).text();
        $.post({
            url: servlet,
            data: {
                id: id,
                behavior: behavior
            },
            success: json => {
                let wrapper = JSON.parse(json);
                if (wrapper.result) {
                    Swal.fire({
                        icon: 'success',
                        title: '删除成功',
                        showConfirmButton: false,
                        timer: 1500
                    }).then(result => {
                        generateDatasheetByActiveId();
                    });
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: '删除失败',
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            }
        })
    });
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
        '<input type="hidden" name="behavior" value="addUser">' + // behavior
        '<input type="hidden" name="type" value="2">' + // type
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
        '<select id="classSelector" name="class" style="width: 50px;"></select>' + // class
        '</div>' +
        '</form>' +
        '<div class="col-md-1">' +
        '<button id="addButton" type="button" class="operate btn btn-success">添加</button>' +
        '</div>' +
        '<br>' +
        '</li>';
    $ul.append(addRow);

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
    bindAddButtonEvent('../../admin.user.do'); // 绑定'添加'按钮事件
    bindDeleteButtonEvent('../../admin.user.do', 'removeUser'); // 绑定'删除'按钮事件
    fillClassSelector();
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
        '<input type="hidden" name="behavior" value="addUser">' + // behavior
        '<input type="hidden" name="type" value="1">' + // type
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
            '<button type="button" class="deleteButton operate btn btn-danger">删除</button>' +
            '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }
    
    $datasheet.append($ul);
    bindAddButtonEvent('../../admin.user.do'); // 绑定'添加'按钮事件
    bindDeleteButtonEvent('../../admin.user.do', 'removeUser'); // 绑定'删除'按钮事件
}

/**
 * 表内填充班级数据
 * 
 * @param {Clazz[]} dataList 班级数据表
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
        '<input type="hidden" name="behavior" value="addClass">' + // behavior
        '<div class="col-md-3"><input id="classNo" name="classNo" type="text" size="10" placeholder="班级编号"></div>' + // classNo
        '<div class="col-md-6"><input id="className" name="className" type="text" size="10" placeholder="班级名称"></div>' + // classId
        '</form>' +
        '<div class="col-md-3">' +
        '<button id="addButton" type="button" class="operate btn btn-success">添加</button>' +
        '</div>' +
        '<br>' +
        '</li>';
    $ul.append(addRow);

    // 数据行
    for (let i = 0; i < dataList.length; i++) {
        let data = dataList[i];
        let row =
            '<li class="datasheetRow">' +
            '<div class="classId" style="display: none;">' + data.id + '</div>' +
            '<div class="col-md-3">' + data.classNo + '</div>' +
            '<div class="col-md-6">' + data.className + '</div>' +
            '<div class="col-md-3">' +
            '<button type="button" class="deleteButton operate btn btn-danger">删除</button>' +
            '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }
    
    $datasheet.append($ul);
    bindAddButtonEvent('../../admin.class.do'); // 绑定'添加'按钮事件
    bindDeleteButtonEvent('../../admin.class.do', 'removeClass'); // 绑定'删除'按钮事件
}

/**
 * 表内填充公告数据
 *
 * @param {Notice[]} dataList 公告数据表
 */
function fillNoticeSheet(dataList) {
    $datasheet.empty(); // 清空现存数据
    let $ul = $('<ul></ul>'); // 重新设置无序列表

    // 表头
    let head =
        '<li class="datasheetHead">' +
        '<div class="col-md-2">标题</div>' +
        '<div class="col-md-6">公告内容</div>' +
        '<div class="col-md-2">创建时间</div>' +
        '<div class="col-md-2">操作</div>' +
        '<br>' +
        '</li>';
    $ul.append(head);

    // '添加'行
    let addRow =
        '<li class="datasheetRow">' +
        '<form id="addForm">' +
        '<input type="hidden" name="behavior" value="addNotice">' +
        '<div class="col-md-3"><input id="classNo" name="classNo" type="text" size="10" placeholder="标题"></div>' + // title
        '<div class="col-md-6"><input id="className" name="className" type="text" size="10" placeholder="公告内容"></div>' + // content
        '</form>' +
        '<div class="col-md-3">' +
        '<button id="addButton" type="button" class="operate btn btn-success">添加</button>' +
        '</div>' +
        '<br>' +
        '</li>';
    $ul.append(addRow);

    // 数据行
    for (let i = 0; i < dataList.length; i++) {
        let data = dataList[i];
        let row =
            '<li class="datasheetRow">' +
            '<div class="classId" style="display: none;">' + data.id + '</div>' +
            '<div class="col-md-2">' + data.title + '</div>' +
            '<div class="col-md-6">' + data.content + '</div>' +
            '<div class="col-md-2">' + data.create_time + '</div>' +
            '<div class="col-md-2">' +
            '<button type="button" class="deleteButton operate btn btn-danger">删除</button>' +
            '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }

    $datasheet.append($ul);
    bindAddButtonEvent('../../admin.class.do'); // 绑定'添加'按钮事件
    bindDeleteButtonEvent('../../admin.notice.do', 'removeNotice'); // 绑定'删除'按钮事件
}

/**
 * 表内填充留言数据
 *
 * @param {Message[]} dataList 留言数据表
 */
function fillMessageSheet(dataList) {
    $datasheet.empty(); // 清空现存数据
    let $ul = $('<ul></ul>'); // 重新设置无序列表

    // 表头
    let head =
        '<li class="datasheetHead">' +
        '<div class="col-md-2">标题</div>' +
        '<div class="col-md-6">留言内容</div>' +
        '<div class="col-md-2">发布时间</div>' +
        '<div class="col-md-2">操作</div>' +
        '<br>' +
        '</li>';
    $ul.append(head);

    // 数据行
    for (let i = 0; i < dataList.length; i++) {
        let data = dataList[i];
        let row =
            '<li class="datasheetRow">' +
            '<div class="classId" style="display: none;">' + data.id + '</div>' +
            '<div class="col-md-2">' + data.title + '</div>' +
            '<div class="col-md-6">' + data.content + '</div>' +
            '<div class="col-md-2">' + data.create_time + '</div>' +
            '<div class="col-md-2">' +
            '<button type="button" class="deleteButton operate btn btn-danger">删除</button>' +
            '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }
    
    $datasheet.append($ul);
    bindDeleteButtonEvent('../../admin.message.do', 'removeMessage'); // 绑定'删除'按钮事件
}