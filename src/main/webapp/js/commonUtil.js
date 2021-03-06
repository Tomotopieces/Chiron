/**
 * 设置当前用户名
 */
function setCurrentUsername() {
    $.post({
        url: '../../user.do',
        data: {
            behavior: 'getUser'
        },
        success: json => {
            let wrapper = JSON.parse(json);
            let user = JSON.parse(wrapper.data);
            if (wrapper.result) {
                $('#currentUsername').text(user.username);
            } else {
                Swal.fire({
                    icon: 'error',
                    title: '获取用户名失败'
                });
            }
        }
    });
}

/**
 * 通过 Servlet 与 behavior 获取并生成数据表
 * 
 * @param {string} servlet Servlet
 * @param {string} behavior 动作, 返回一个数据数组
 * @param {function} fillFunction 数据填写函数
 */
function generateDatasheet(servlet, behavior, fillFunction) {
    $.post({
        url: servlet,
        data: {
            behavior: behavior,
            pageNo: 1,
            pageSize: 5,
        },
        success: json => {
            let wrapper = JSON.parse(json);
            let list = JSON.parse(wrapper.data);
            if (wrapper.result) {
                fillFunction(list);
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

/**
 * 填充班级选择下拉框
 */
function fillClassSelector() {
    let $classSelector = $('#classSelector');
    $.post({
        url: '../../admin.class.do',
        data: {
            behavior: 'getClassList'
        },
        success: json => {
            let wrapper = JSON.parse(json);
            let data = JSON.parse(wrapper.data);
            if (wrapper.result) {
                for (let i = 0; i < data.length; i++) {
                    let clazz = data[i];
                    $clazz = $('<option></option>');
                    $clazz.attr('value', clazz.id);
                    $clazz.text(clazz.className);
                    $classSelector.append($clazz);
                }
            } else {
                Swal.fire({
                    icon: 'error',
                    title: '获取班级列表失败'
                });
            }
        }
    })
}

/**
 * 将班级id替换为班级名
 */
function classIdToName() {
    $('.className').map((index, element) => {
        let $element = $(element);
        let classId = $element.text();
        $.post({
            url: '../../admin.class.do',
            data: {
                behavior: 'getClassNameById',
                classId: classId
            },
            success: json => {
                let wrapper = JSON.parse(json);
                let data = JSON.parse(wrapper.data);
                if (wrapper.result) {
                    $element.text(data);
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: '获取班级名失败'
                    });
                }
            }
        });
    });
}

/**
 * 将学生id替换为学生名
 */
function studentIdToName() {
    $('.studentName').map((index, element) => {
        let $element = $(element);
        let studentId = $element.text();
        $.post({
            url: '../../student.do',
            data: {
                behavior: 'getClassNameById',
                studentId: studentId
            },
            success: json => {
                let wrapper = JSON.parse(json);
                let data = JSON.parse(wrapper.data);
                if (wrapper.result) {
                    $element.text(data);
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: '获取学生名失败'
                    });
                }
            }
        });
    });
}


