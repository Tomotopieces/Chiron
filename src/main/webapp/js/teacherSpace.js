/**
 * 教师界面配置js
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

    // 判断旧密码与数据库是否一致
    $('#oldPassword').on('blur', () => {
        let $error = $('.error');
        $.post({
            url: '../../user.do',
            data: {
                behavior: 'passwordCheck',
                oldPassword: $('#oldPassword').val()
            },
            success: json => {
                let wrapper = JSON.parse(json);
                let data = JSON.parse(wrapper.data);
                if (wrapper.result) {
                    if(data){
                        $error.hide();
                    }else{
                        $error.show();
                    }
                }
            }
        });
    });

    // 判断新密码与确认密码是否一致
    let $confirmPassword = $('#confirmPassword');
    $confirmPassword.on('blur', () => {
        let newPassword = $('#newPassword').val(),
            confirmPassword = $confirmPassword.val(),
            $passwordError = $('.passwordError');
        if (newPassword == confirmPassword){
            $passwordError.hide();
        }else{
            $passwordError.show();
        }
    });

    // 修改密码
    let $submit = $('.submit');
    $submit.on('click', () => {
        $.post({
            url: '../../user.do',
            data: {
                behavior: 'resetPassword',
                oldPassword: $('#oldPassword').val(),
                newPassword: $('#newPassword').val()
            },
            success: json => {
                console.log(json);
                let wrapper = JSON.parse(json);
                // let data = JSON.parse(wrapper.data);
                if (wrapper.result) {
                    Swal.fire({
                        icon: 'success',
                        title: '修改成功',
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            }
        })
    });

    // 页面淡入效果
    $('#mainContainer').fadeIn('slow');
});

/**
 * 通过当前 tab id 来生成数据表和按钮组
 */
function generateDatasheetByActiveId() {
    switch ($('.active').attr('id')) {
        case 'assignHomeworkTab':
            generateDatasheet('../../teacher.do', 'getAssignedHomeworkListByPageAndTeacherId', fillAssignHomeworkSheet);
            generatePageButtonGroup('../../teacher.do', 'getAssignedHomeworkCountByTeacherId', 'getAssignedHomeworkListByPageAndTeacherId', fillAssignHomeworkSheet);
            return;
        case 'studentHomeworkTab':
            generateDatasheet('../../teacher.do', 'getSubmittedHomeworkListByPageAndTeacherId', fillHomeworkSheet);
            generatePageButtonGroup('../../teacher.do', 'getSubmittedHomeworkCountByTeacherId', 'getSubmittedHomeworkListByPageAndTeacherId', fillHomeworkSheet);
            return;
        case 'noticeTab':
            generateDatasheet('../../user.do', 'getNoticeListByPage', fillNoticeSheet);
            generatePageButtonGroup('../../user.do', 'getNoticeCount', 'getNoticeListByPage', fillNoticeSheet);
            return;
        case 'messageTab':
            generateDatasheet('../../user.do', 'getMessageListByPage', fillMessageSheet);
            generatePageButtonGroup('../../user.do', 'getMessageCount', 'getMessageListByPage', fillMessageSheet);
            return;
    }
}

/**
 * 绑定 '添加' 按钮 事件
 */
// function bindAddButtonEvent() {
//     $('#addButton').on('click', () => {
//         $.ajax({
//             url: '../../teacher.do',
//             data: $('#addForm').serialize(),
//             success: json => {
//                 console.log(json);
//                 let wrapper = JSON.parse(json);
//                 let data = JSON.parse(wrapper.data);
//                 if (wrapper.result) {
//                     Swal.fire({
//                         icon: 'success',
//                         title: '添加成功',
//                         showConfirmButton: false,
//                         timer: 1500
//                     }).then(result => {
//                         generateDatasheetByActiveId();
//                     });
//                 } else {
//                     Swal.fire({
//                         icon: 'error',
//                         title: data,
//                         showConfirmButton: false,
//                         timer: 1500
//                     });
//                 }
//             }
//         });
//     });
// }

/**
 * 绑定 '删除' 按钮 事件
 */
function bindDeleteButtonEvent() {
    $('.deleteButton').on('click', event => {
        $this = $(event.target);
        let id = $($this.parent().parent().children()[0]).text();
        $.post({
            url: '../../teacher.do',
            data: {
                homeworkId: id,
                behavior: 'deleteHomework'
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
 * 表内填充布置作业数据
 *
 * @param {Homework[]} dataList 布置作业数据表
 */
function fillAssignHomeworkSheet(dataList) {
    $datasheet.empty(); // 清空现存数据
    let $ul = $('<ul></ul>'); // 重新设置无序列表

    // 表头
    let head =
        '<li class="datasheetHead">' +
        '<div class="col-md-2">作业标题</div>' +
        '<div class="col-md-2">作业描述</div>' +
        '<div class="col-md-2">结束时间</div>' +
        '<div class="col-md-2">布置班级</div>' +
        '<div class="col-md-2">提交附件</div>' +
        '<div class="col-md-2">操作</div>' +
        '<br>' +
        '</li>';
    $ul.append(head);

    // '添加'行
    let addRow =
        '<li class="datasheetRow">' +
        '<form id="addForm" action="../../teacher.do" method="post">' +
        '<input type="hidden" name="behavior" value="assignHomework">' +
        '<div class="col-md-2"><input id="title" name="title" type="text" size="10" placeholder="作业标题"></div>' + // title
        '<div class="col-md-2"><input id="describe" name="describe" type="text" size="10" placeholder="作业描述"></div>' + // content
        '<div class="col-md-2"><input id="endTime" name="endTime" type="text" size="10" placeholder="结束时间"></div>' +
        '<div class="col-md-2"><input id="classId" name="classId" type="text" size="10" placeholder="班级ID"></div>' +
        '<div class="col-md-2"><input id="file" name="file" type="file" size="10"></div>' +
        '<div class="col-md-2">' +
        '<button id="addButton" type="submit" class="operate btn btn-success">添加</button>' +
        '</div>' +
        '</form>' +
        '<br>' +
        '</li>';
    $ul.append(addRow);

    // 数据行
    for (let i = 0; i < dataList.length; i++) {
        let data = dataList[i];
        let row =
            '<li class="datasheetRow">' +
            '<div class="assignHomeworkId" style="display: none;">' + data.id + '</div>' +
            '<div class="col-md-2">' + data.title + '</div>' +
            '<div class="col-md-2">' + data.describe + '</div>' +
            '<div class="col-md-2">' + data.end_time + '</div>' +
            '<div class="col-md-2">' + data.class_id + '</div>' +
            '<div class="col-md-2"><a herf="#">' + data.attachment_title + '</a></div>' +
            '<div class="col-md-2">' +
            '<button type="button" class="deleteButton operate btn btn-danger">删除</button>' +
            '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }

    $datasheet.append($ul);
    // bindAddButtonEvent('../../teacher.do'); // 绑定'添加'按钮事件
    bindDeleteButtonEvent('../../teacher.do', 'deleteHomework'); // 绑定'删除'按钮事件
}

/**
 * 表内填充学生提交作业数据
 *
 * @param {Homework[]} dataList 学生提交作业数据表
 */
function fillHomeworkSheet(dataList) {
    $datasheet.empty(); // 清空现存数据
    let $ul = $('<ul></ul>'); // 重新设置无序列表

    // 表头
    let head =
        '<li class="datasheetHead">' +
        '<div class="col-md-2">提交学生</div>' +
        '<div class="col-md-3">作业标题</div>' +
        '<div class="col-md-3">作业描述</div>' +
        '<div class="col-md-2">作业附件</div>' +
        '<div class="col-md-2">操作</div>' +
        '<br>' +
        '</li>';
    $ul.append(head);


    // 数据行
    for (let i = 0; i < dataList.length; i++) {
        let data = dataList[i];
        let button;
        if (data.status){
            button = '<button id="addButton" type="button" class="operate btn btn-success" disabled>评阅</button>';
        }else{
            button = '<button id="addButton" type="button" class="operate btn btn-success">评阅</button>';
        }
        let row =
            '<li class="datasheetRow">' +
            '<div class="classId" style="display: none;">' + data.id + '</div>' +
            '<div class="col-md-2">' + data.s_id + '</div>' +
            '<div class="col-md-3">' + data.title + '</div>' +
            '<div class="col-md-3">' + data.describe + '</div>' +
            '<div class="col-md-2"><a herf="#">' + data.attachment_title + '</a></div>' +
            '<div class="col-md-2">' +
            button +
            '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }
    $datasheet.append($ul);
    // studentIdToName();
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
        '<div class="col-md-8">公告内容</div>' +
        '<div class="col-md-2">创建时间</div>' +
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
            '<div class="col-md-8">' + data.content + '</div>' +
            '<div class="col-md-2">' + data.create_time + '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }

    $datasheet.append($ul);
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
        '<br>' +
        '</li>';
    $ul.append(head);

    // '添加'行
    let addRow =
        '<li class="datasheetRow">' +
        '<form id="addForm">' +
        '<input type="hidden" name="behavior" value="addMessage">' +
        '<div class="col-md-2"><input id="classNo" name="classNo" type="text" size="10" placeholder="标题"></div>' + // title
        '<div class="col-md-6"><input id="className" name="className" type="text" size="10" placeholder="留言内容"></div>' + // content
        '<div class="col-md-2"><input id="create_time" name="create_time" type="text" disabled size="10" placeholder="自动填写"></div>' +
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
            '<div class="classId" style="display: none;">' + data.id + '</div>' +
            '<div class="col-md-2">' + data.title + '</div>' +
            '<div class="col-md-6">' + data.content + '</div>' +
            '<div class="col-md-2">' + data.create_time + '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }

    $datasheet.append($ul);
}