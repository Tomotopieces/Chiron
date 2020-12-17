/**
 * 切换 tab 工具函数
 */

$(() => {
    initDatasheetByActiveId($('.active').attr('id'));

});

function initDatasheetByActiveId(activeId) {
    switch (activeId) {
        case 'studentTab':
            initDatasheet('../../admin.user.do', 'getStudentListByPage', fillStudentSheet);
            return;
        case 'teacherTab':
            initDatasheet('../../admin.user.do', 'getTeacherListByPage', fillTeacherSheet);
        case 'classTab':
        case 'noticeTab':
        case 'messageTab':
    }
}

/**
 * 初始化数据表
 * 
 * @param {string} servlet Servlet
 * @param {string} behavior 动作, 返回一个数据数组
 * @param {function} fillFunction 数据填写函数
 */
function initDatasheet(servlet, behavior, fillFunction) {
    $.post({
        url: servlet,
        data: {
            behavior: behavior,
            pageNo: 1,
            pageSize: 5,
        },
        success: json => {
            let wrapper = JSON.parse(json);
            let lsit = JSON.parse(wrapper.data);
            if (wrapper.result) {
                fillFunction(lsit);
                setCrossColor();
            } else {
                Swal.fire({
                    icon: 'error',
                    title: '获取数据数组失败'
                });
            }
        }
    });
}